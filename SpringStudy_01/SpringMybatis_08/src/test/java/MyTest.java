import com.xuanxie.mapper.UserMapper;
import com.xuanxie.mapper.UserMapperImpl;
import com.xuanxie.mapper.UserMapperImpl2;
import com.xuanxie.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void springMybatisStudy(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapperImpl");
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void springMyabtisTwo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapperImpl2");
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void transation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapperImpl");
        User user = new User(7, "肖明", "123456");
        userMapper.addUser2(user);
        userMapper.deleteUser(1);

    }
}
