package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.repea.annotation.CacheLock;
import xin.rtime.repea.annotation.CacheParam;

/**
 * 
 *   示例20 ：
 *   
 *      Spring boot 防重校验[分布式]
 *      
 *   引入依赖：
 *   
 *		<dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-aop</artifactId>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-data-redis</artifactId>
 *	    </dependency>
 *
 *
 */
@RestController
@RequestMapping("/cacheBooks")
@SpringBootApplication
public class Chapter20Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter20Application.class, args);
	}
	

    @CacheLock(prefix = "cacheBooks")
    @GetMapping
    public String query(@CacheParam(name = "token") @RequestParam String token) {
        return "success - " + token;
    }

}
