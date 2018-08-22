package xin.rtime;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot 
 * 
 * 	 1.helloo world
 *   2.查看spring初始化为我们提供了哪些bean、
 *   
 *   依赖：
 *   
 *   	<dependency>
 *			<groupId>org.springframework.boot</groupId>
 *			<artifactId>spring-boot-starter-web</artifactId>
 *		</dependency>
 *   
 */
@SpringBootApplication
@RestController
@RequestMapping("/chapter1")
public class Chapter1Application {

    @GetMapping("/demo1")
    public String demo1() {
        return "run time";
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        // 目的是
        return args -> {
            System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}