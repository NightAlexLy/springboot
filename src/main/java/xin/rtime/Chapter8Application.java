package xin.rtime;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.model.UserCache;

/**
 * 
 *   示例8 ：
 *   
 *      Spring boot 与  Lettuce - redis 集成
 *      
 *      
 *   引入依赖：
 *   
 *   	<dependency>
 *    		<groupId>org.springframework.boot</groupId>
 *    		<artifactId>spring-boot-starter-data-redis</artifactId>
 *		</dependency>
 *		<dependency>
 *    		<groupId>org.apache.commons</groupId>
 *    		<artifactId>commons-pool2</artifactId>
 *		</dependency>
 *
 *
 *   Lettuce 和 Jedis 的都是连接Redis Server的客户端程序。
 *   Jedis在实现上是直连redis server，多线程环境下非线程安全，除非使用连接池，为每个Jedis实例增加物理连接。
 *   Lettuce基于Netty的连接实例（StatefulRedisConnection），可以在多个线程间并发访问，且线程安全，满足多线程环境下的并发访问，同时它是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。
 *
 *   下列的就是Redis其它类型所对应的操作方式：
 *
 *			opsForValue： 对应 String（字符串）
 *			opsForZSet： 对应 ZSet（有序集合）
 *			opsForHash： 对应 Hash（哈希）
 *			opsForList： 对应 List（列表）
 *			opsForSet： 对应 Set（集合）
 *			opsForGeo： 对应 GEO（地理位置）
 *
 *   思考：
 *     
 *     通过redis-sentinel连接？
 *     通过redis-cluster连接？
 *     分片？
 *     序列化？
 *   
 */
@RestController
@SpringBootApplication
@RequestMapping("/cache")
public class Chapter8Application {
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;
	
	@GetMapping("/get")
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	@GetMapping("/set")
	public void set(String key,String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}
	
	@GetMapping("/getObj/{key}")
	public UserCache getObject(@PathVariable String key) {
		return (UserCache)redisCacheTemplate.opsForValue().get(key);
	}
	
	@PostMapping("/setObj/{key}")
	public void setObject(@PathVariable String key,@RequestBody UserCache cache) {
		redisCacheTemplate.opsForValue().set(key,cache);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter8Application.class, args);
	}
}
