package threadTest;

public class DaemonTest {
    public static void main(String[] args) {
        CircleRubbish circlerubbish=new CircleRubbish();
        Thread rubbishthread=new Thread(circlerubbish);
        rubbishthread.setDaemon(true);//默认为用户线程，设置为守护线程
        rubbishthread.start();
        new Thread(()->{
            for(int i=0;i<1001;++i){
                System.out.println("now is "+i);
            }
        }).start();
    }

}
class CircleRubbish implements Runnable{
    @Override
    public void run (){
        try{
            while(true) {//守护线程当用户线程结束后会自动退出
                Thread.sleep(1);
                System.out.println("正在回收垃圾");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



}
