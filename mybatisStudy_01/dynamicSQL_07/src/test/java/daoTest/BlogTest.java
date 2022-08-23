package daoTest;

import com.xuanxie.dao.BlogMapper;
import com.xuanxie.pojo.Blog;
import com.xuanxie.utils.MybatisUtils;
import com.xuanxie.utils.UUIDutil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogTest {
    @Test
    public void insertTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog(UUIDutil.getUUID(),"我的博客标题","小丽",new Date(),120);
        mapper.addBlog(blog);

        blog = new Blog(UUIDutil.getUUID(),"字符查找","小化",new Date(),220);
        mapper.addBlog(blog);

        blog = new Blog(UUIDutil.getUUID(),"解决报错问题","小华",new Date(),420);
        mapper.addBlog(blog);

        blog = new Blog(UUIDutil.getUUID(),"git语法","小智",new Date(),220);
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void dynamicSqlTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        List<Blog> blogs = mapper.queryBlogDynamic(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("+++++++++++++++++++++++++++++");
        hashMap.put("views",(Integer)160);
        blogs = mapper.queryBlogDynamic(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("+++++++++++++++++++++++++++++");
        hashMap.put("author","小");
        blogs = mapper.queryBlogDynamic(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("+++++++++++++++++++++++++++++");
        hashMap.put("title","git");
        blogs = mapper.queryBlogDynamic(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void chooseTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        List<Blog> blogs = mapper.querryBlogChoose(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("+++++++++++++++ 二   ++++++++++++++");
        hashMap.put("author","小");
        blogs = mapper.querryBlogChoose(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("+++++++++++++++  三  ++++++++++++++");
        hashMap.put("title","git");
        blogs = mapper.querryBlogChoose(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        int update = mapper.update(new Blog("4628134595e84bdca3d3f998d9d7e590", null, "小慧", null, 0));
        sqlSession.commit();
        sqlSession.close();
    }


}
