package xin.rtime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.rtime.model.User;
import xin.rtime.service.UserService;

/**
*
*  Chapter 9 示例验证
*  
*/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter7Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter9ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Chapter9ApplicationTests.class);

    @Autowired
    private UserService userService;
    
    @Test
	public void test() {
        final User user = userService.saveOrUpdate(new User(5L, "u5", "p5"));
        log.info("[saveOrUpdate] - [{}]", user);
        final User user1 = userService.get(5L);
        log.info("[get] - [{}]", user1);
        userService.delete(5L);
	}
}
