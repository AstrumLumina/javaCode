package threadTest;

public class VieldTest {
//线程礼让测试
    //注意礼让不一定成功，由cpu决定
public static void main(String[] args) {
    MyVield myyield=new MyVield();

    new Thread(myyield,"小明").start();
    new Thread(myyield,"小红").start();
}


}
class MyVield implements Runnable{
    @Override
    public void run() {
        System.out.println("线程 开始 执行 "+Thread.currentThread().getName());
        Thread.yield();//线程礼让
        System.out.println("线程执行 结束 "+Thread.currentThread().getName());
    }
}