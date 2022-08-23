package RefAndAnno;

public class Reflection {
    //object中有一个getclass方法
    //Class 本身也是一个类,有一个静态方法forName()

    public static void main(String[] args) throws ClassNotFoundException {
        //测试通过反射获取对象
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
        //一个类只有一个.class 文件,同一个类创建的对象是相同的
        //一个类在内存中只存在Class 对象
        //一个类被加载后,类的整个结构被封装在Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());

        //获得对象后可以使用该对象方法
        System.out.println("*****************");
        System.out.println(c1.getName());

        //反射获取对象的方法集
        System.out.println("=============================");
        User user1=new Students();
        System.out.println("这个人是 " + user1.name);
        //方式1: 通过对象获得
        Class  ref1=user1.getClass();
        System.out.println(ref1.hashCode());
        //方式2: forName()方法获得
        Class  ref2=Class.forName( "RefAndAnno.Students");
        System.out.println(ref2.hashCode());
        //方式3:通过 类名.classshu 属性获得
        Class<?> ref3=Students.class;
        System.out.println(ref3.hashCode());
        //方式四 内置基本类型的包装类都有一个Type属性,可以依次获得
        Class ref4=Integer.TYPE;
        System.out.println(ref4);
        System.out.println(ref4.getName());
        System.out.println(ref4.hashCode());

        System.out.println("********************");
        //获取父类的类型
        Class ref5=ref1.getSuperclass();
        System.out.println(ref5);



    }
}
//定义一个实体类:pojo,entity
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
       this.name="学生";
   }
}
class Teacher extends User{
    public Teacher (){
        this.name="老师";
    }

}