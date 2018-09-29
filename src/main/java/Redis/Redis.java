package Redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * Created by bkc on 2017/6/20.
 */
public class Redis {
    public static void main(String[] args) {

        //172.16.20.107
        //172.16.7.92


        Jedis jedis = new Jedis("127.0.0.1", 6379);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            String type = jedis.type(key);
            System.out.println(type + "--" + key);
            if ("string".equals(type)) {
                System.out.println(jedis.get(key));
            } else if ("list".equals(jedis.type(key))) {
                System.out.println(jedis.lrange(key, 0, -1));
            }
            System.out.println();
        }
        //jedis.auth("bkc137302");
        /*System.out.println(jedis.ping());
        jedis.set("bkc", "bkc");

        System.out.println(jedis.exists("bkc"));
        System.out.println(jedis.get("bkc"));
        System.out.println(jedis.type("bkc"));

        System.out.println(jedis.expire("bkc", 10));

        for (int i = 0; i < 11; i++) {
            System.out.println(jedis.exists("bkc"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        /*
        *//**//*
        System.out.println();
        jedis.setex("bkc", 5, "bkcValue");
        System.out.println(jedis.exists("bkc"));
        System.out.println(jedis.dbSize());
        System.out.println(jedis.keys("*"));


        jedis.hset("bkc1", "field1", "field1-value");
        System.out.println(jedis.hget("bkc1", "field1"));


        Map<String, String> map = new HashMap<String, String>();
        map.put("bkcKey1", "bkcValue1");
        map.put("bkcKey2", "bkcValue2");
        jedis.hmset("bkc2", map);

        System.out.println(jedis.hmget("bkc2", "bkcKey1", "bkcKey2"));
        System.out.println(jedis.hexists("bkc2", "bkcKey1"));
        System.out.println(jedis.hkeys("bkc2"));
        System.out.println(jedis.hvals("bkc2"));
        System.out.println(jedis.hgetAll("bkc2"));

        jedis.lpush("key1", "key1Value1");
        jedis.lpush("key1", "key1Value2");
        jedis.lpush("key1", "key1Value3");

        System.out.println(jedis.lrange("key1", 0, -1));
        System.out.println(jedis.llen("key1"));*/

        /*jedis.flushDB();
        jedis.lpush("sortedList", "3", "6", "7", "9", "2", "1");
        SortingParams sortingParams = new SortingParams();
        sortingParams.desc();
        sortingParams.limit(0, 3);
        sortingParams.alpha();
        System.out.println(jedis.llen("sortedList"));
        System.out.println(jedis.lrange("sortedList", 0, -1));
        System.out.println(jedis.sort("sortedList", sortingParams));



        jedis.flushDB();

        System.out.println("==========向集合中添加元素==========");
        jedis.sadd("eleSet", "e1", "e2", "e3", "e4", "e5", "e6");
        jedis.sadd("eleSet", "e1");
        jedis.sadd("eleSet", "e6");
        System.out.println(jedis.smembers("eleSet"));

        System.out.println(jedis.sismember("eleSet", "1"));
        System.out.println(jedis.sismember("eleSet", "e1"));

        System.out.println("将eleSet1中删除e1并存入eleSet3中："
            +jedis.smove("eleSet1", "eleSet3", "e1"));


        jedis.flushDB();

        System.out.println("==========redis hash==========");
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        jedis.hmset("hash1", map);

        jedis.hset("hash1", "key5", "value5");

        System.out.println(jedis.hgetAll("hash1"));

        System.out.println(jedis.hkeys("hash1"));

        System.out.println(jedis.hvals("hash1"));

        System.out.println(jedis.hincrBy("hash1", "key6", 6));

        System.out.println(jedis.hgetAll("hash1"));

        System.out.println(jedis.hincrBy("hash1", "key6", 6));

        System.out.println(jedis.hdel("hash1", "key2"));

        System.out.println(jedis.hgetAll("hash1"));

        System.out.println(jedis.hlen("hash1"));

        System.out.println(jedis.hexists("hash1", "key2"));

        System.out.println(jedis.hget("hash1","key3"));*/


        /*jedis.flushDB();

        jedis.hset("user1", "name", "name1");
        jedis.hset("user11", "name", "name2");
        jedis.hset("user12", "name", "name3");
        jedis.hset("user13", "name", "name4");

        jedis.lpush("m1", "11");
        jedis.lpush("m1","12");
        jedis.lpush("m1","13");
        jedis.lpush("m1","14");
        SortingParams sortingParameters = new SortingParams();

        sortingParameters.get("user*->name");

        System.out.println(jedis.sort("m1", sortingParameters));*/


        /*jedis.lpush("userList", "11");
        jedis.lpush("userList", "12");
        jedis.lpush("userList", "13");
        jedis.lpush("userList", "14");
        jedis.lpush("userList", "15");

        jedis.hset("user:11","name","name11");
        jedis.hset("user:12","name","name12");
        jedis.hset("user:13","name","name13");
        jedis.hset("user:14","name","name14");
        jedis.hset("user:15","name","name15");
        jedis.hset("user:16","name","name16");
        jedis.hset("user:17","name","name17");
        jedis.hset("user:18","name","name18");

        jedis.hset("user:11","address","address11");
        jedis.hset("user:12","address","address12");
        jedis.hset("user:13","address","address13");
        jedis.hset("user:14","address","address14");
        jedis.hset("user:15","address","address15");
        jedis.hset("user:16","address","address16");
        jedis.hset("user:17","address","address17");
        jedis.hset("user:18","address","address18");


        SortingParams sortingParams = new SortingParams();

        sortingParams.get("user:*->name");
        sortingParams.get("user:*->address");

        System.out.println(jedis.sort("userList", sortingParams));*/



    }
}
