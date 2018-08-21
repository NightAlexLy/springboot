package xin.rtime;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import xin.rtime.model.UserCache;

/**
*
*  Chapter 8 示例验证
*  
*/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter7Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter8ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Chapter8ApplicationTests.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void get() {
        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );
        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "battcn:user:1";
        redisCacheTemplate.opsForValue().set(key, new UserCache(1L, "u1", "pa"));
        // TODO 对应 String（字符串）
        final UserCache user = (UserCache) redisCacheTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", user);
    }
}
