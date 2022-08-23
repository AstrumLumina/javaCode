package RefAndAnno;

import java.lang.annotation.ElementType;

public class Reflection2 {
    //所有的类都有Class
    //包括void类,接口类,注解类,Class类...
    public static void main(String[] args) {
        //测试
        Class c1=Object.class;//类
        Class c2=Comparable.class;//接口
        Class c3=String[].class;//一维数组
        Class c4=int[][].class;//二维数组
        Class c5=Override.class;//注解
        Class c6= ElementType.class;//枚举
        Class c7=Integer.class;//基本数据类型
        Class c8=void.class;//void 类型
        Class c9=Class.class;//Class 类

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println("********************");
        //同维数组只要元素类型一样,就是同一个Class
        int[] a=new int[10];
        int[][] b=new int[10][10];
        int[] c=new int[5];
        Byte[] d=new Byte[10];

        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(c.getClass());
        System.out.println(d.getClass());
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
        System.out.println(c.getClass().hashCode());
        System.out.println(d.getClass().hashCode());

    }
}
