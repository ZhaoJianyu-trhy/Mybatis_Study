package com.zjy.mapper;

import com.zjy.pojo.User;
import com.zjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User u :userList) System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 增删改需要提交事务
     */
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User("tt", "123123"));
        //提交事务
        sqlSession.commit();
        List<User> userList = mapper.getUserList();
        for (User u :userList) System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void test修改用户() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5, "文谦", "123123"));
        //提交事务
        sqlSession.commit();
        List<User> userList = mapper.getUserList();
        for (User u :userList) System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void test删除用户() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        //提交事务
        sqlSession.commit();
        List<User> userList = mapper.getUserList();
        for (User u :userList) System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void testMap添加用户() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new HashMap<String, Object>() {{put("userName", "双儿"); put("passWord", "123123");}});
        //提交事务
        sqlSession.commit();
        List<User> userList = mapper.getUserList();
        for (User u :userList) System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void testMap模糊查询() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("小%");
        for (User u :userList) System.out.println(u);
        sqlSession.close();
    }
}
