package RefAndAnno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获取类的运行时信息
public class Reflect3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Person person=new Person("wsw",1);
        Class c1=person.getClass();
        Class c2=Class.forName("RefAndAnno.Person");

        System.out.println(c1.getName());//获得包名和类名
        System.out.println(c1.getSimpleName());//获得类名

        //获取类的属性
        Field[] fields=c1.getFields();//获得public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("***********************");
        fields=c1.getDeclaredFields();//获得所所有属性
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取指定属性的值
        Field name=c1.getDeclaredField("name");
        System.out.println(name);
        System.out.println("****************************");
        //获取类的方法
        Method[] methods=c1.getMethods();//父类和自己的公共的方法
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*****************************");
        methods=c1.getDeclaredMethods();//本类定义的所有方法
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*************");
        //获得指定的方法
        Method method=c1.getMethod("getId",null);//第二各参数以便获得重载的函数
        System.out.println(method);
        method=c1.getDeclaredMethod("addid",Integer.TYPE);
        System.out.println(method);
        System.out.println("==========================");
        //获得全部的构造器
        Constructor[] constructor = c1.getConstructors();
        for (Constructor constructor1 : constructor) {
            System.out.println(constructor1);
        }
        //获得指定的构造器
        System.out.println("***************");
        Constructor constru=c1.getDeclaredConstructor(String.class,int.class);
        System.out.println(constru);

    }
}

class Person{
    int id;
    String name;
    public Person(){}
    public Person(String name,int id){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return id;
    }
    private void addid(int unit){
        ++id;
    }
}