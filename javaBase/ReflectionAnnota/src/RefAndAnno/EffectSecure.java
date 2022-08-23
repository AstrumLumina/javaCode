package RefAndAnno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EffectSecure {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        efecttest1();
        efecttest2();
        efecttest3();

    }
    //安全检测对效率的影响
    public static void efecttest1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException {//反射 解锁
        Class c1=Class.forName("RefAndAnno.Fortest");
        Fortest test=(Fortest) c1.newInstance();
        Method method=c1.getMethod("getId",null);
        method.setAccessible(true);

        long starttime =System.currentTimeMillis();
        for (long i = 0; i < 100_000_0000; i++) {
            method.invoke(test,null);
        }
        long endtime =System.currentTimeMillis();
        System.out.println((endtime-starttime)+"ms");

    }
    public static void efecttest2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {//反射 不解锁
        Class c1=Class.forName("RefAndAnno.Fortest");
        Fortest test=(Fortest) c1.newInstance();
        Method method=c1.getMethod("getId",null);
       // method.setAccessible(true);

        long starttime =System.currentTimeMillis();
        for (long i = 0; i < 100_000_0000; i++) {
            method.invoke(test,null);
        }
        long endtime =System.currentTimeMillis();
        System.out.println((endtime-starttime)+"ms");

    }
    public static void efecttest3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {//直接 调用
        Class c1=Class.forName("RefAndAnno.Fortest");
        Fortest test=(Fortest) c1.newInstance();

        long starttime =System.currentTimeMillis();
        for (long i = 0; i < 100_000_0000; i++) test.getId();
        long endtime =System.currentTimeMillis();
        System.out.println((endtime-starttime)+"ms");

    }
}
