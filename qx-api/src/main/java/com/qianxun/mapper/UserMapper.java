package com.qianxun.mapper;

import com.qianxun.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//告诉MyBatis这是一个操作数据库的Mapper
@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    @Select("select * from user")
    public List<User> getAllUser();

    //返回插入后自增的id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(name) values(#{name})")
    public int addUser(User user);

    @Update("update user set name = #{name} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int deleteUser(Integer id);
}
