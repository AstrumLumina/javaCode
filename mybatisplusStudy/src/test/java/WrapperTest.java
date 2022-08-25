import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xuanxie.MybatisplusStudy;
import com.xuanxie.mapper.UserMapper;
import com.xuanxie.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisplusStudy.class)
public class WrapperTest { //动态拼接sql语句进行条件查询
    @Autowired
    private UserMapper userMapper;

    @Test
    public void queryWrapperTest(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .isNotNull("name")
                .ge(true,"id",1);//ge: >=
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void queryWrapperTest2(){
        User user = userMapper.selectOne(new UpdateWrapper<User>().eq("id", 1));
        System.out.println(user);
        List<User> users = userMapper.selectList(new QueryWrapper<User>().between("age", 10, 35));
        users.forEach(System.out::println);
    }
    @Test
    public void queryWrapperTest3(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .notLike("name","u")
                .likeRight("name","T");//左右指的是百分号的在拼接在参数的什么位置
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void queryWrapperTest4(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByAsc("age");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void queryWrapperTest5(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("id","select id from user where id <4");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println); users.forEach(System.out::println);
    }

}
