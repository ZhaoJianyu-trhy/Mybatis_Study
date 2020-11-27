package com.zjy;

import com.zjy.mapper.UserMapper;
import com.zjy.pojo.User;
import com.zjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MapperTest {
    @Test
    public void testAnno() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAnno1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(8);
        System.out.println(user);
    }

    @Test
    public void testAnno2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User("苏荃", "123123"));
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAnno3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1, "小宇", "123123"));
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAnno4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(3);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
