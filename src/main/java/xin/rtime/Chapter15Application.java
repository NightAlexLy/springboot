package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 
 *   示例15 ：
 *   
 *      Spring boot 自带Spring Task Demo
 *      
 *      
 *   引入依赖：
 *   
 *       <dependency>
 *        <groupId>org.springframework.boot</groupId>
 *        <artifactId>spring-boot-starter-web</artifactId>
 *    	 </dependency>
 *
 *         
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Chapter15Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter15Application.class, args);
	}
	
	/**
	 * 
	 * No task executor bean found for async processing: no bean of type TaskExecutor and no bean named 'taskExecutor' either
     * 很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
   @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
	
}
