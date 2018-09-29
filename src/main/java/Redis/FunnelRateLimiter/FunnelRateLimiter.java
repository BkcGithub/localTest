package Redis.FunnelRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class FunnelRateLimiter {
    static class Funnel {
        int capacity; // 漏斗容量
        float leakingRate;// 漏嘴流水速率
        int leftQuota;// 漏斗剩余空间
        long leakingTs; //上一次漏水时间

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTimes = System.currentTimeMillis();
            long deltaTimes = nowTimes - leakingTs;
            int deltaQuota = (int) (deltaTimes * leakingRate);
            if (deltaQuota < 0) { //间隔时间太长，整数数字过大溢出
                this.leftQuota = this.capacity;
                this.leakingTs = nowTimes;
                return;
            }
            if (deltaQuota < 1) { //腾出的空间太小，最小单位是1
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTimes;
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quata) {
            makeSpace();
            if (this.leftQuota >= quata) {
                this.leftQuota -= quata;
                return true;
            }
            return false;

        }
    }


    private Map<String, Funnel> funnelMap = new HashMap<String, Funnel>();

    public boolean isActionALlow(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s%s", userId, actionKey);
        Funnel funnel = funnelMap.get(key);

        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnelMap.put(key, funnel);
        }
        return funnel.watering(1);
    }

    public static void main(String[] args) {
        FunnelRateLimiter funnelRateLimiter = new FunnelRateLimiter();

        for (int i = 0; i < 1000; i++) {
            System.out.println(funnelRateLimiter.isActionALlow("705981", "login", 100, 1.5f));
        }

    }



}
