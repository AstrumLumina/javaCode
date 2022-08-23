package RefAndAnno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射的应用
public class RefApply {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //通过反射 动态创建对象
        //获得Class对象
        Class c1=Class.forName("RefAndAnno.Fortest");

        //构造一个对象
        //法1
        Fortest test= (Fortest) c1.newInstance();
        //本质调用无参构造
        System.out.println(test);

        //法2
        //通过构造器构造
        Constructor constructor=c1.getConstructor(String.class,int.class);
        Fortest test2= (Fortest) constructor.newInstance("小明",1);
        System.out.println(test2);

        //反射调用普通方法
        Method method=c1.getDeclaredMethod("addid",int.class);
        //得到方法后激活方法(需要传入该方法的对象和参数)
        method.setAccessible(true);//私有方法 解锁保护机制
        method.invoke(test2,2);
        System.out.println(test2);

        //反射操作属性
        Field name=c1.getDeclaredField("name");
        name.setAccessible(true);//关闭安全权限检测,默认打开  关闭可以减少检测的时间,提高效率
        name.set(test2,"小丽");
        System.out.println(test2);
    }

}
