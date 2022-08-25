package threadTest.threadLock;

public class Deadlock {
    //死锁测试
    //当多个线程互相持着对方所需要的资源导致形成僵局
    public static void main(String[] args) throws InterruptedException {
        MakeUpTool  girl1=new MakeUpTool(true,"小红");
        MakeUpTool  girl2=new MakeUpTool(false,"小丽");

        new Thread(girl1).start();
        //Thread.sleep(10);
        new Thread(girl2).start();
    }

}
class Mirror{

}
class Lipstick{

}
class MakeUpTool implements Runnable{
    //静态的化妆工具， 只有一份
    //不同化妆对象使用的是同一个化妆工具，锁住的是同一个东西
    static Mirror mirror;
    static Lipstick lipstick;
    static{
        mirror = new Mirror();
        lipstick=new Lipstick();
    }
    boolean order;
    String name;
    public MakeUpTool(boolean order,String name) {
        this.name=name;
        this.order=order;
    }
    @Override
    public void run() {
        if(order){
            synchronized(mirror){
                System.out.println(name+"在使用镜子");
                synchronized(lipstick){
                    System.out.println(name+"在使用口红");
                }
            }
        }else{
            synchronized(lipstick){
                System.out.println(name+"在使用口红");
                synchronized(mirror){
                    System.out.println(name+"在使用镜子");
                }
            }
        }
    }
}
//总结
/*
产生死锁的四个必要条件
1.互斥；一个资源只能被一个进程使用
2.请求与保持条件：一个进程因请求资源而阻塞，对方以获得的资源保持不放
3.不剥夺条件：请求以获得的资源在未使用完前不能被强行剥夺
4.循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系
*/
