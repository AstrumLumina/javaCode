package RefAndAnno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//��ȡ�������ʱ��Ϣ
public class Reflect3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Person person=new Person("wsw",1);
        Class c1=person.getClass();
        Class c2=Class.forName("RefAndAnno.Person");

        System.out.println(c1.getName());//��ð���������
        System.out.println(c1.getSimpleName());//�������

        //��ȡ�������
        Field[] fields=c1.getFields();//���public����
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("***********************");
        fields=c1.getDeclaredFields();//�������������
        for (Field field : fields) {
            System.out.println(field);
        }
        //��ȡָ�����Ե�ֵ
        Field name=c1.getDeclaredField("name");
        System.out.println(name);
        System.out.println("****************************");
        //��ȡ��ķ���
        Method[] methods=c1.getMethods();//������Լ��Ĺ����ķ���
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*****************************");
        methods=c1.getDeclaredMethods();//���ඨ������з���
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*************");
        //���ָ���ķ���
        Method method=c1.getMethod("getId",null);//�ڶ��������Ա������صĺ���
        System.out.println(method);
        method=c1.getDeclaredMethod("addid",Integer.TYPE);
        System.out.println(method);
        System.out.println("==========================");
        //���ȫ���Ĺ�����
        Constructor[] constructor = c1.getConstructors();
        for (Constructor constructor1 : constructor) {
            System.out.println(constructor1);
        }
        //���ָ���Ĺ�����
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