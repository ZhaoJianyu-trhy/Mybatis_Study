import com.zjy.mapper.BlogMapper;
import com.zjy.pojo.Blog;
import com.zjy.utils.IDUtils;
import com.zjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.insertBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Java");
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring");
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务");
        mapper.insertBlog(blog);

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "Java");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.selectBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
//        map.put("title", "Java");
        map.put("author", "狂神说");
        map.put("views", "1000");
        List<Blog> blogs = mapper.selectWhen(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("author", "小赵");
        map.put("title", "深入理解Java虚拟机");
        map.put("views", 3);
        map.put("id", "ba313206a0d0498380e2e65c7ea80a6d");
        mapper.updateBlog(map);
        List<Blog> blogs = mapper.selectAll();
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void testForEach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);
        List<Blog> blogs = mapper.selectForEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }
}
