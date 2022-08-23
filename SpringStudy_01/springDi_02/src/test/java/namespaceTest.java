import com.xuanxie.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class namespaceTest {
    @Test
    public void namespaceTest(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("userBean.xml");
        User userP = context.getBean("userP", User.class);
        System.out.println(userP);

        User userC = context.getBean("userC", User.class);
        System.out.println(userC);

    }
}
