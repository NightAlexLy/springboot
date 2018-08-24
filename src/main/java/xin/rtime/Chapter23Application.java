package xin.rtime;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.limiter.annotation.Limit;

/**
 * 
 *   示例23 ：
 *   
 *      Spring boot 限流
 *      
 *   引入依赖：
 *   
 *   
 *		<!-- 默认就内嵌了Tomcat 容器，如需要更换容器也极其简单-->
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-aop</artifactId>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-web</artifactId>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-data-redis</artifactId>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>com.google.guava</groupId>
 *	        <artifactId>guava</artifactId>
 *	        <version>21.0</version>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.apache.commons</groupId>
 *	        <artifactId>commons-lang3</artifactId>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-test</artifactId>
 *	    </dependency>
 *
 *
 */
@RestController
@RequestMapping("/limiterTest")
@SpringBootApplication
public class Chapter23Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter23Application.class, args);
	}
	
	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    @Limit(key = "test", period = 100, count = 10)
    @GetMapping
    public int testLimiter() {
        // 意味著 100S 内最多允許訪問10次
        return ATOMIC_INTEGER.incrementAndGet();
    }
	
}
