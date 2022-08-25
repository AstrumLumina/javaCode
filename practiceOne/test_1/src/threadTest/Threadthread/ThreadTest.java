package threadTest.Threadthread;

public class ThreadTest extends Thread {
    //继承Thred 重run方法， 调用start（）方法
    public void run() {
        for (int i = 100; i > 0; --i) {
            System.out.println("This is run() resolvution! Now is "+i);
            System.out.println();
        }
    }
}
