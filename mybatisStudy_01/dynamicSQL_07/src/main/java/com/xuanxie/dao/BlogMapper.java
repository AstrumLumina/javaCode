package com.xuanxie.dao;

import com.xuanxie.pojo.Blog;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")//抑制警告
public interface BlogMapper {
     int addBlog(Blog blog);
     List<Blog> queryBlogDynamic(Map map);
     List<Blog> querryBlogChoose(Map map);
     int update(Blog blog);
}
