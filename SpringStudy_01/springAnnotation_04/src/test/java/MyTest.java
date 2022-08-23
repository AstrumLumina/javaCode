import com.xuanxie.appConfig.MyConfig;
import com.xuanxie.pojo.Person;
import com.xuanxie.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


    @Test
    public void annotationTest(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.getName());
    }

    @Test
    public void configrationTest(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("getPerson", Person.class);
        System.out.println(person);


    }
}
