package RefAndAnno;

import java.lang.annotation.ElementType;

public class Reflection2 {
    //���е��඼��Class
    //����void��,�ӿ���,ע����,Class��...
    public static void main(String[] args) {
        //����
        Class c1=Object.class;//��
        Class c2=Comparable.class;//�ӿ�
        Class c3=String[].class;//һά����
        Class c4=int[][].class;//��ά����
        Class c5=Override.class;//ע��
        Class c6= ElementType.class;//ö��
        Class c7=Integer.class;//������������
        Class c8=void.class;//void ����
        Class c9=Class.class;//Class ��

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
        //ͬά����ֻҪԪ������һ��,����ͬһ��Class
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
