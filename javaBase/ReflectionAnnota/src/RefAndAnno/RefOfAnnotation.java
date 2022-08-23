package RefAndAnno;

import java.lang.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RefOfAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       Class c1=Class.forName("RefAndAnno.ToAnnotaMy");
       //ͨ��������ע��
       Annotation[] annotations= c1.getAnnotations(); 
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //���ע���value��ֵ
        TestAnnota classannota= (TestAnnota)c1.getAnnotation(TestAnnota.class);
        System.out.println(classannota);
        String value=classannota.value();
        System.out.println(value);
        
        //�����ָ����ע��
        Field f=c1.getDeclaredField("name");
        ValAnnota annota=f.getAnnotation(ValAnnota.class);
        System.out.println(annota.name());
        System.out.println(annota.type());          
        System.out.println(annota.length());        

          //�����û����ݿ�,���Ը������ݿ��Զ�������
    }
}

//������ע��
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface TestAnnota{
    String value();
}
//*************************
//���Ե�ע��
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