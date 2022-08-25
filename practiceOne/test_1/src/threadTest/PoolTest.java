package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {
//线程池的使用（可以提高效率）
public static void main(String[] args) {
    //创建服务和线程池
    ExecutorService service= Executors.newFixedThreadPool(5);//参数为该池最大可容纳多少个线程
    //执行线程
    service.execute(new Mythread());
    service.execute(new Mythread());
    service.execute(new Mythread());
    service.execute(new Mythread());

    //关闭线程
    service.shutdown();
}

}
class Mythread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 线程正在被执行");
    }
}