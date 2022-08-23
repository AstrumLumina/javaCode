package RefAndAnno;

public class TestLoad {
    public static void main(String[] args)  {
        {;
            //类加载过程*******************************
            //类加载后会缓存一段时间,也可能被回收
    /*
    1.加载:将class文件加载到内存中,并将这些静态数据转换成运行是数据结构,然后生成一个java.lang.Class对象
    2.链接:将Java二进制代码合并到运行状态
      a.验证:确保类加载信息符合规范,没有安全问题
      b.准备:在方法区为类的静态变量分配内存并默认初始化
      c.解析:符号引用变为地址引用
    3.初始化
    执行类构造器(将类变量的初始化语句合并后产生)
    若父类未加载,则先加载父类
    保证线程安全
     */

            //*********************************************8
            //何时发生类的初始化
    /*
     启动虚拟机是mian所在类
     new对象时,调用类的静态方法和成员(除了final常量)
     反射调用时
     子类初始化时初始化父类
     */
            //不初始化
    /*
    1.子类调用父类的静态变量
    2.数组定义类的引用
    3.常量的引用(在链接阶段就在类的常量池中了)
     */
//类的加载器*************************
    /*
    1.引导类加载器(无法直接获取)(rtjar)  核心,c/c++编写 负责核心库
    2.扩张加载器(ext)/APP加载器
    3.系统加载器.java.class.path
    4.自定义加载器

     */
        }
        //获取系统类加载器
        ClassLoader systemload=ClassLoader.getSystemClassLoader();
        System.out.println(systemload);
        //获取系统加载器的父类--------扩展类类加载器
        ClassLoader parent=systemload.getParent();
        System.out.println(parent);
        //获取扩展类加载器的父类------引导类/根 加载器 ---不可获得,返回null
        ClassLoader pparent=parent.getParent();
        System.out.println(pparent);

//双亲委派机制 保护机制:若自己写了各和系统一样的包,会使用系统的包
        //查看当前类的加载器
        ClassLoader loader= null;
        try {
            loader = Class.forName("RefAndAnno.TestLoad").getClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loader);
        //查看内置类的加载器
        try {
            loader = Class.forName("java.lang.Object").getClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loader);

        //获取吧系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
