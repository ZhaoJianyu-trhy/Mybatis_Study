package com.zjy.mapper;

import com.zjy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(@Param("id") int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(@Param("idd") int id);
}
