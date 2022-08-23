import com.xuanxie.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void aopTest01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //反射是使用接口实现的,所以要强制转为接口类才能使用 aop
        UserService uerService =
                (UserService) context.getBean("userServiceImpl");
        uerService.addUser();
        uerService.deleteUser();
        uerService.selectUser();
        uerService.updateUser();

    }
}
