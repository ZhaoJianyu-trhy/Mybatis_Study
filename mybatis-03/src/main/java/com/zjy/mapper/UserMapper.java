package com.zjy.mapper;

import com.zjy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(@Param("id") int id);
}
