package xin.rtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.prop.MyProperties1;
import xin.rtime.prop.MyProperties2;

/**
 *  示例2：
 *  
 *    springboot中注入属性配置
 *    
 *    依赖：
 *    <dependency>
 *    	<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-configuration-processor</artifactId>
 *    	<optional>true</optional>
 *	  </dependency>
 *    
 *        1.自定义属性配置
 *           application.properties中定义自定义属性
 *           1.1 通过@Value("${xxxx.xxxx}") 注入至属性中
 *           1.2 定义属性class  [参考MyProperties1]
 *           @Component
 *			 @ConfigurationProperties(prefix = "my1")
 *  
 *        2.自信定义文件配置  [参考 MyProperties2]
 *        	 比如：xxx.properties
 *           @Component
 *           @PropertySource("classpath:my2.properties")   -- 指定自定义的配置文件
 *           @ConfigurationProperties(prefix = "my2")
 *           
 */
@RestController
@SpringBootApplication
public class Chapter2Application {

	private final MyProperties1 properties1;
	
	private final MyProperties2 properties2;
	
	@Value("${my3.age}")
	private int age;
	
	@Value("${my3.name}")
	private String name;
	
	@Autowired
	public Chapter2Application(MyProperties1 properties1, MyProperties2 properties2) {
		this.properties1 = properties1;
		this.properties2 = properties2;
	}

    @GetMapping("/properties1")
    public String properties1() {
        return properties1.toString();
    }
    
    @GetMapping("/properties2")
    public String properties2() {
        return properties2.toString();
    }
    
    @GetMapping("/properties3")
    public String properties3() {
    	StringBuilder builder = new StringBuilder();
		builder.append("MyProperties3 [age=");
		builder.append(age);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
    }

	public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }

}