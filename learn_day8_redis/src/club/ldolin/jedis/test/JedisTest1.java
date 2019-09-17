package club.ldolin.jedis.test;

import club.ldolin.jedis.util.JedisToolUtils;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis测试类
 */
public class JedisTest1 {
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("127.0.0.1",6379);  //不写为默认值localhost，6379
        //2.操作
        jedis.set("username","zhang");
        //3.关闭连接
        jedis.close();
    }


    /**
     * jedis连接池的使用
     */
    @Test
    public void test2(){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("hehe","haha");
        //4.关闭，归还到连接池
        jedis.close();
    }


    /**
     * jedis连接池工具类的使用
     */
    @Test
    public void test3(){
        //1.通过连接池工具类
        Jedis jedis = JedisToolUtils.getJedis();
        //2.使用
        jedis.set("hello","world");
        //3.关闭，归还到连接池
        jedis.close();
    }
}
