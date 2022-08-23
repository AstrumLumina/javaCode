import com.xuanxie.pojo.Hellow;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HellowTest {

    @Test
    public void hellowTest(){
        //获取上下文对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //我们的对象现在再spring中管理,我们要使用直接去里面去取就行了
        Hellow hellow = (Hellow) context.getBean("hellow");
        System.out.println(hellow.toString());
    }
}
