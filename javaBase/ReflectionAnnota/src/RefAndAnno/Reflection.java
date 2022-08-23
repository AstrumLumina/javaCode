package RefAndAnno;

public class Reflection {
    //object����һ��getclass����
    //Class ����Ҳ��һ����,��һ����̬����forName()

    public static void main(String[] args) throws ClassNotFoundException {
        //����ͨ�������ȡ����
        Class<?> aclass=Class.forName("RefAndAnno.User");

        Class c1=Class.forName("RefAndAnno.User");
        Class c2=Class.forName("RefAndAnno.User");
        Class c3=Class.forName("RefAndAnno.User");
        Class c4=Class.forName("RefAndAnno.User");
        Class c5=Class.forName("RefAndAnno.User");
        System.out.println("****************");
        System.out.println(c1);
        System.out.println(aclass);
        System.out.println("**************");
        //һ����ֻ��һ��.class �ļ�,ͬһ���ഴ���Ķ�������ͬ��
        //һ�������ڴ���ֻ����Class ����
        //һ���౻���غ�,��������ṹ����װ��Class������
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());

        //��ö�������ʹ�øö��󷽷�
        System.out.println("*****************");
        System.out.println(c1.getName());

        //�����ȡ����ķ�����
        System.out.println("=============================");
        User user1=new Students();
        System.out.println("������� " + user1.name);
        //��ʽ1: ͨ��������
        Class  ref1=user1.getClass();
        System.out.println(ref1.hashCode());
        //��ʽ2: forName()�������
        Class  ref2=Class.forName( "RefAndAnno.Students");
        System.out.println(ref2.hashCode());
        //��ʽ3:ͨ�� ����.classshu ���Ի��
        Class<?> ref3=Students.class;
        System.out.println(ref3.hashCode());
        //��ʽ�� ���û������͵İ�װ�඼��һ��Type����,�������λ��
        Class ref4=Integer.TYPE;
        System.out.println(ref4);
        System.out.println(ref4.getName());
        System.out.println(ref4.hashCode());

        System.out.println("********************");
        //��ȡ���������
        Class ref5=ref1.getSuperclass();
        System.out.println(ref5);



    }
}
//����һ��ʵ����:pojo,entity
class User{
    String name;
    int id;
    int age;
    public User(){}
    public User(String name,int id,int age){
        this.name=name;
        this.id=id;
        this.age=age;
    }
    public void setName(String name ){
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
class Students extends User{
   public Students(){
       this.name="ѧ��";
   }
}
class Teacher extends User{
    public Teacher (){
        this.name="��ʦ";
    }

}