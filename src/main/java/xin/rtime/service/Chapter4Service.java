package xin.rtime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import xin.rtime.model.User;

/**
 * 示例4的服务
 * 	关于JDBCTemplate比较简单，直接简单暴力的CRUD-SQL操作
 */
@Service
public class Chapter4Service {

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public Chapter4Service(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<User> queryUsers() {
        // 查询所有用户
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(User.class));
    }

    public User getUser(Long id) {
        // 根据主键ID查询
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public int delUser(Long id) {
        // 根据主键ID删除用户信息
        String sql = "DELETE FROM t_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int addUser(User user) {
        // 添加用户
        String sql = "insert into t_user(username, password) values(?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    public int editUser(Long id, User user) {
        // 根据主键ID修改用户信息
        String sql = "UPDATE t_user SET username = ? ,password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), id);
    }
	
}
