package threadTest;

public class TestPriority {

    public static void main(String[] args){
        MyPriority mypriority =new MyPriority();

        //建立线程
        Thread tre1=new Thread(mypriority);
        Thread tre2=new Thread(mypriority);
        Thread tre3=new Thread(mypriority);
        Thread tre4=new Thread(mypriority);

        //启动线程前设置优先级(1~10),否则运行时抛出异常
        //默认优先级是5
        //优先级越高，不一定就先执行，要看cpu如何调度
        tre1.setPriority(1);
        tre2.setPriority(4);
        tre3.setPriority(Thread.MAX_PRIORITY);
        //tre4.setPriority(2);

        //启动线程 观察执行顺序

        //主线程的优先级（默认为5）
        Thread.currentThread().setPriority(1);//更改主线程的优先级
        System.out.println(Thread.currentThread().getPriority() );
        tre1.start();
        tre2.start();
        tre3.start();
        System.out.println(Thread.currentThread().getPriority() );
        tre4.start();
        System.out.println(Thread.currentThread().getPriority() );

    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"的优先级是\\>:"+Thread.currentThread().getPriority());
    }
}
