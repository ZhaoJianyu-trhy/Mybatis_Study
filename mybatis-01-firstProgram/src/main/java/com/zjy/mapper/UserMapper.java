package com.zjy.mapper;

import com.zjy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(@Param("value") String name);

    List<User> getUserList();

    User getUserById(@Param("id") int id);

    //使用Map的形式去传参数
    int addUser(Map<String, Object> map);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(@Param("idd") int id);
}
