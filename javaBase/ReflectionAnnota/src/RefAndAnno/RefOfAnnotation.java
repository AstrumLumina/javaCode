package RefAndAnno;

import java.lang.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RefOfAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       Class c1=Class.forName("RefAndAnno.ToAnnotaMy");
       //通过反射获得注解
       Annotation[] annotations= c1.getAnnotations(); 
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的value的值
        TestAnnota classannota= (TestAnnota)c1.getAnnotation(TestAnnota.class);
        System.out.println(classannota);
        String value=classannota.value();
        System.out.println(value);
        
        //获得类指定的注解
        Field f=c1.getDeclaredField("name");
        ValAnnota annota=f.getAnnotation(ValAnnota.class);
        System.out.println(annota.name());
        System.out.println(annota.type());          
        System.out.println(annota.length());        

          //以上用户数据库,可以根据数据库自动建立表
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface TestAnnota{
    String value();
}
//*************************
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface ValAnnota{
    String name();
    String type();
    int length();
}

@TestAnnota("db_student")
class ToAnnotaMy{

    @ValAnnota(name="stu_id",type="int",length=10)
    private int id;
    @ValAnnota(name="stu_age",type="int",length=10)
    private int age;
    @ValAnnota(name="stu_name",type="String",length=30)
    private String name;

    public ToAnnotaMy(int id, int age,String name) {
        this.age = age;
        this.id=id;
        this.name=name;
    }
    public ToAnnotaMy() {
    }

    public String name() {
        return name;
    }

    public ToAnnotaMy setName(String name) {
        this.name = name;
        return this;
    }
}