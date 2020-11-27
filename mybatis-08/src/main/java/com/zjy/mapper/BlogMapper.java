package com.zjy.mapper;

import com.zjy.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> selectForEach(Map map);

    int insertBlog(Blog blog);

    List<Blog> selectBlogIf(Map map);

    List<Blog> selectWhen(Map map);

    List<Blog> selectAll();

    int updateBlog(Map map);
}
