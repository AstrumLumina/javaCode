import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuanxie.MybatisplusStudy;
import com.xuanxie.mapper.UserMapper;
import com.xuanxie.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//测试类无法注入bean ,添加如下两个注解
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = 你的springboot启动类名.class)

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisplusStudy.class)
public class MybatisStudyTest {
    @Autowired
    private UserMapper userMapper;

    @Test
   public void mybatisplusTest(){
        System.out.println("=======================");
        System.out.println(userMapper);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    //插入测试
    @Test
    public void insertTest(){
        User user = new User();
        user.setAge(21)
               // .setId(6)
                .setEmail("42323@qq.com")
                .setName("xuanxie");
        System.out.println(userMapper.insert(user));
    }

    //更新测试
    @Test
    public void updateTest(){
        User user = new User()
                .setId(1562422079847043074L)
                .setAge(11)
                .setName("khh")
                .setEmail("fsdfds@mm.cmo");
        System.out.println(userMapper.updateById(user));
    }

    //查询用户
    @Test
    public void selectTest(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    //乐观锁测试
    @Test
    public void optimisticLock(){
        User user1 =userMapper.selectById(1L);
        user1.setAge(21)
              .setEmail("42323@qq.com")
              .setName("xuanxie");
        User user2 =userMapper.selectById(1L);
        user2.setAge(12)
             .setEmail("00000@qq.com")
             .setName("xuanyi");
        System.out.println(userMapper.updateById(user1)); //成功
        System.out.println(userMapper.updateById(user2)); //失败
    }


    //测试批量查询  in语句
    @Test
    public void selectByBatchIdsTest(){
        for (User user : userMapper.selectBatchIds(Arrays.asList(1, 2, 3))) {
            System.out.println(user);
        }
    }

    //map条件查询  map汇总全部条件,全部满足才会被选中
    @Test
    public void selectByMapTest(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",3);
        map.put("name","xuanxie");
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }

    //分页查询测试
    @Test
    public void pageTest(){
        Page<User> pageLimit=new Page<>(2,3);//查询第几页,每页的大小
        System.out.println("===============");
        Page<User> page = userMapper.selectPage(pageLimit, null);
        System.out.println("当前页有 "+page.getTotal()+" 条数据");//得到的是数据库种所有的数据
        System.out.println("============");
        List<User> users = page.getRecords();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("=========");
    }


    //删除逻辑测试
    @Test
    public void deleteByIdTest(){
        System.out.println(userMapper.deleteById(1L));
    }

}
