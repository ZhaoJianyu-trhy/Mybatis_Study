import com.zjy.mapper.UserMapper;
import com.zjy.pojo.User;
import com.zjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
//        mapper.updateUser(new User(2, "小娟", "123123"));
        sqlSession.clearCache();
        User user1 = mapper.selectUserById(1);
        System.out.println(user);
        System.out.println(user == user1);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        User user1 = mapper.selectUserById(1);
        System.out.println(user);
        System.out.println(user == user1);
        sqlSession.close();
    }
}
