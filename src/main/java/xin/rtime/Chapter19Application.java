package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.repea.annotation.LocalLock;

/**
 * 
 *   示例19 ：
 *   
 *      Spring boot 防重校验[本地]
 *      
 *   引入依赖：
 *   
 *		<dependency>
 *		    <groupId>org.springframework.boot</groupId>
 *		    <artifactId>spring-boot-starter-aop</artifactId>
 *		</dependency>
 *		<dependency>
 *		    <groupId>com.google.guava</groupId>
 *		    <artifactId>guava</artifactId>
 *		    <version>21.0</version>
 *		</dependency>
 *
 *
 */
@RestController
@RequestMapping("/repeaBooks")
@SpringBootApplication
public class Chapter19Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter19Application.class, args);
	}

	@LocalLock(key = "book:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "success - " + token;
    }
}
