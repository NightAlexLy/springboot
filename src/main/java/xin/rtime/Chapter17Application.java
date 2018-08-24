package xin.rtime;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.rtime.exception.CustomException;

/**
 * 
 *   示例17 ：
 *   
 *      Spring boot 全局异常
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
public class Chapter17Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter17Application.class, args);
	}

	@GetMapping("/test1")
	public String test1() {
	    // TODO 这里只是模拟异常，假设业务处理的时候出现错误了，或者空指针了等等...
        System.out.println(10 / 0);
	    return "test1";
	}
	
	/**
	 * 采用try-catch的方式，手动捕获异常信息，然后返回对应的结果集，相信很多人都看到过类似的代码（如：封装成Result对象）；
	 * 该方法虽然间接性的解决错误暴露的问题，同样的弊端也很明显，增加了大量的代码量，当异常过多的情况下对应的catch层愈发的多了起来
	 * ，很难管理这些业务异常和错误码之间的匹配，所以最好的方法就是通过简单配置全局掌控….
	 * @return
	 */
	@ResponseBody
	@GetMapping("/test2")
	public Map<String,String> test2() {
		Map<String, String> result = new HashMap<>(16);
	    // TODO 直接捕获所有代码块，然后在 cache
	    try {
	        System.out.println(10 / 0);
	        result.put("code", "200");
	        result.put("data", "具体返回的结果集");
	    } catch (Exception e) {
	        result.put("code", "500");
	        result.put("message", "请求错误");
	    }
	    return result;
	}

	@GetMapping("/test3")
    public String test3(Integer num) {
        // TODO 演示需要，实际上参数是否为空通过 @RequestParam(required = true)  就可以控制
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        int i = 10 / num;
        return "result:" + i;
    }
}
