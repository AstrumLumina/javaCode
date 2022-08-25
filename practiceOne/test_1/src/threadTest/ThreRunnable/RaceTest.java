package threadTest.ThreRunnable;

public class RaceTest implements Runnable {
    private String winner;
    public void run(){
        for(int i=0;i<=100;){
            if(winner!=null){
                System.out.println(Thread.currentThread().getName()+" 输了 ");
                break;
            }
            try{
                if(Thread.currentThread().getName()=="乌龟"){
                    Thread.sleep(10);
                }else{
                    if(i%50==0){
                        Thread.sleep(1000);
                    }
                }
                //  ++i;
                System.out.println(Thread.currentThread().getName()+" 跑了 "+(++i)+" 米了");
                if(i==100){
                    winner=Thread.currentThread().getName();
                    System.out.println(winner+" 赢了");
                    break;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args){
        RaceTest race=new RaceTest();

        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }


}
