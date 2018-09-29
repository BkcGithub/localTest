package Redis.SimpleRateLimiter;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllow(String userId, String actionKey, int period, int maxCount) {

        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTimes = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        pipeline.zadd(key, nowTimes, "" + nowTimes);
        pipeline.zremrangeByScore(key, 0, nowTimes - period * 1000);
        Response<Long> count = pipeline.zcard(key);
        pipeline.exec();
        try {
            pipeline.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count.get() <= maxCount;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.del("user:17"));
        /*SimpleRateLimiter simpleRateLimiter = new SimpleRateLimiter(jedis);

        for (int i = 0; i < 60; i ++) {
            boolean flag = simpleRateLimiter.isActionAllow("705981", "login", 60, 10);
            System.out.println(flag);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/


    }
}
