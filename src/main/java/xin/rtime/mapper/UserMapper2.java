package xin.rtime.mapper;

import org.apache.ibatis.annotations.Mapper;

import tk.mybatis.mapper.common.BaseMapper;
import xin.rtime.model.User3;

/**
 * 
 *   Chapter7的Mapper示例
 *   
 */
@Mapper
public interface UserMapper2 extends BaseMapper<User3>{

    /**
     * 根据用户名统计（TODO 假设它是一个很复杂的SQL）
     *
     * @param username 用户名
     * @return 统计结果
     */
    int countByUsername(String username);
    
}
