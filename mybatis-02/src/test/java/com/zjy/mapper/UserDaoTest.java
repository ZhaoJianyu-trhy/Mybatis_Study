package com.zjy.mapper;

import com.zjy.pojo.User;
import com.zjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User u : userList) System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info：进入了testLog4j");
        logger.debug("info：进入了testLog4j");
        logger.error("error：进入了testLog4j");
    }

    @Test
    public void test分页() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserByLimit(new HashMap<String, Integer>() {{
            put("startIndex", 0);
            put("pageSize", 2);
        }});
        for (User u : user) {
            System.out.println(u);
        }
    }
}
