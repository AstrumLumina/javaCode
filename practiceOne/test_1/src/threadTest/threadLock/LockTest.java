package threadTest.threadLock;

import java.util.concurrent.locks.ReentrantLock;

//lock与synchronized类似，但只能锁代码块
//lock需要自己控制，麻烦但调用效率更高
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        SellTick sellticket=new SellTick(15);
        Thread t1= new Thread(sellticket);
        t1.start();
       // new Thread(sellticket).start();
        new Thread(sellticket).start();

        /*
        t1.join();
        System.out.println("还剩多少张票"+sellticket.ticketnum);
         */
    }

}
class SellTick implements Runnable{
    int ticketnum;
    private final ReentrantLock lock=new ReentrantLock();
    public SellTick(int ticketnum) {
        this.ticketnum = ticketnum;
    }
    @Override
    public void run() {
        while(true){
            lock.lock();
            if(ticketnum<=0){
                lock.unlock();//此出易忘记释放锁导致程序阻塞
                //因此有关lock自动锁的最好使用上锁后使用try{}catch(){}finally{lock.unlock()}语句来保证一定释放锁
                break;
            }
            System.out.println(Thread.currentThread().getName()+"正在买第 "+ticketnum+" 张票");
            --ticketnum;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}