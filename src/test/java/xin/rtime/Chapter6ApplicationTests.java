package xin.rtime;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.rtime.mapper.UserMapper;
import xin.rtime.model.User3;

/**
 * 
 *  chapter6 示例验证
 *
 */
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter6ApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter6ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Chapter6ApplicationTests.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() throws Exception {
        final int row1 = userMapper.insert(new User3("u1", "p1"));
        log.info("[添加结果] - [{}]", row1);
        final int row2 = userMapper.insert(new User3("u2", "p2"));
        log.info("[添加结果] - [{}]", row2);
        final int row3 = userMapper.insert(new User3("u1", "p3"));
        log.info("[添加结果] - [{}]", row3);
        final List<User3> u1 = userMapper.findByUsername("u1");
        log.info("[根据用户名查询] - [{}]", u1);
    }

}
