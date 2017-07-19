package Redis;

/**
 * Created by bkc on 2017/6/21.
 */
public class RedisClient {
    //切片客户端
   /* private static ShardedJedis sharedJedis;
    //切片连接池
    private static ShardedJedisPool shardedJedisPool;

    public RedisClient() {
        initShardedPoll();
        sharedJedis = shardedJedisPool.getResource();
    }

    private static void initShardedPoll() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(2);
        jedisPoolConfig.setMaxWaitMillis(10);
        jedisPoolConfig.setTestOnBorrow(false);

        //slave链接，这里实现了集群的功能，配置多个redis服务实现请求的分配进行负载均衡
        List<JedisShardInfo> infoList = new ArrayList<JedisShardInfo>();
        infoList.add(new JedisShardInfo("127.0.0.1"));
        //infoList.add(new JedisShardInfo("172.16.20.107"));
        //infoList.add(new JedisShardInfo("172.16.7.92"));
        shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, infoList);
    }

    public static void show () {
        Redis.Redis.RedisClient redisClient = new Redis.Redis.RedisClient();
        sharedJedis.lpush("sortedList","3", "6", "7", "9", "2", "1");
        sharedJedis.sort("sortedList");

        sharedJedis.lrange("sortedList", 0, -1);
    }

    public static void main(String[] args) {
        initShardedPoll();
        show();

    }*/
}
