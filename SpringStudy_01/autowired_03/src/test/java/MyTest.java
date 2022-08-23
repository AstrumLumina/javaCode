import com.xuanxie.pojo.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @org.junit.Test
    public void PersongTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        person.getDog().sout();
        person.getCat().shout();
    }


    @org.junit.Test
    public void PersongAutowireTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person2", Person.class);
        person.getDog().sout();
        person.getCat().shout();
    }

    @Test
    public void annotationAutowired(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person4", Person.class);
        person.getDog().sout();
        person.getCat().shout();
    }
}
