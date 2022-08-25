package threadTest.ThreRunnable;

public class ConcurrencyTest implements Runnable {

    private int ticketnum=10;
    private int count=0;
    @Override
    public void run() {
        while(ticketnum>0){
            System.out.println(Thread.currentThread().getName()+"抢到了第几"+ticketnum+"张票");
            --ticketnum;
            ++count;
            try{
                Thread.sleep(300);
            }catch(InterruptedException exception){
                System.out.println("Sleep error！");
                exception.printStackTrace();
            }
        }
        System.out.println("count= "+count);
    }

    public static void main(String[] args) {
        ConcurrencyTest play1=new ConcurrencyTest();
       // threadTest.ThreRunnable.ConcurrencyTest play2=new threadTest.ThreRunnable.ConcurrencyTest();
       // threadTest.ThreRunnable.ConcurrencyTest play3=new threadTest.ThreRunnable.ConcurrencyTest();

        new Thread(play1,"小明").start();
        new Thread(play1,"小丽").start();
        new Thread(play1,"大壮").start();
    }
}
