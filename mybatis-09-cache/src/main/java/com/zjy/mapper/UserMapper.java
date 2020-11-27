package com.zjy.mapper;

import com.zjy.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserById(@Param("id") int id);

    int updateUser(User user);
}
