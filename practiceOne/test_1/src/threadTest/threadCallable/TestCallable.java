package threadTest.threadCallable;

import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {//继承接口（指定返回类型）
    //重写call方法（有上面指定的放回类型）
    private int restthings=100;
    public Boolean call(){
        int i=100;
        while(restthings>0){
            System.out.println("多线程测试 "+Thread.currentThread().getName()+"正在处理剩余的第 "+restthings+" 事情");
            --restthings;
        }
        System.out.println("结束 事情已经全部处理完了");
        return true;
    }

    //多线程的执行
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable test=new TestCallable();
        //创建执行服务（申请池）
        ExecutorService ser= Executors.newFixedThreadPool(3);

        //提交服务（执行）
        Future<Boolean> t1=ser.submit(test);//有返回值
        Future<Boolean> t2=ser.submit(test);
        Future<Boolean> t3=ser.submit(test);

        boolean toprin=t1.get();
        System.out.println(toprin);
        //结束服务
        ser.shutdownNow();
    }
}
//*/