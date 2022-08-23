package RefAndAnno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//�����Ӧ��
public class RefApply {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //ͨ������ ��̬��������
        //���Class����
        Class c1=Class.forName("RefAndAnno.Fortest");

        //����һ������
        //��1
        Fortest test= (Fortest) c1.newInstance();
        //���ʵ����޲ι���
        System.out.println(test);

        //��2
        //ͨ������������
        Constructor constructor=c1.getConstructor(String.class,int.class);
        Fortest test2= (Fortest) constructor.newInstance("С��",1);
        System.out.println(test2);

        //���������ͨ����
        Method method=c1.getDeclaredMethod("addid",int.class);
        //�õ������󼤻��(��Ҫ����÷����Ķ���Ͳ���)
        method.setAccessible(true);//˽�з��� ������������
        method.invoke(test2,2);
        System.out.println(test2);

        //�����������
        Field name=c1.getDeclaredField("name");
        name.setAccessible(true);//�رհ�ȫȨ�޼��,Ĭ�ϴ�  �رտ��Լ��ټ���ʱ��,���Ч��
        name.set(test2,"С��");
        System.out.println(test2);
    }

}
