import com.xuanxie.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
    @Test
    public void diTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());
    }
}
/*
* Student{
* name='xuanxie',
* address=Address{address='湖南'},
*  books=[红楼梦, 水浒传, 西游记, 三国演义],
* hobbys=[看电影, 听音乐, 敲代码, 学算法],
*  card={身份证=123456789012345678,
* 学号=1234643784239, 班级=31324},
* games=[LOL, COC, BOB, 王者],
* wife='null',
* info={性别=男, 专业=计算机, 学校=whut}
* }
 */