package xin.rtime;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import xin.rtime.validator.annotation.DateTime;
import xin.rtime.validator.annotation.model.Groups;
import xin.rtime.validator.model.Book;

/**
 * 
 *   示例18 ：
 *   
 *      Spring boot 数据校验
 *      
 *   引入依赖：
 *   
 *       <dependency>
 *        <groupId>org.springframework.boot</groupId>
 *        <artifactId>spring-boot-starter-web</artifactId>
 *    	 </dependency>
 *
 */
@Controller
@SpringBootApplication
public class Chapter18Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter18Application.class, args);
	}

	@GetMapping("/validator1")
    public String validator1(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间") String name) {
        return "success";
    }

    @GetMapping("/validator2")
    public String validator2(@Validated Book book) {
        return "success";
    }
    
    @GetMapping("/validator3")
    public String validator3(@DateTime(message = "您输入的格式错误，正确的格式为：{format}", format = "yyyy-MM-dd HH:mm") String date) {
        return "success";
    }
    
    @GetMapping("/validator4")
    public String validator4(@Validated(value = Groups.Default.class) Book book) {
        return "insert";
    }

    @GetMapping("/validator5")
    public String validator5(@Validated(value = {Groups.Default.class, Groups.Update.class}) Book book) {
        return "update";
    }
    
}
