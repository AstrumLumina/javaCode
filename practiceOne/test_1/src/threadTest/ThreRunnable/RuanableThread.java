package threadTest.ThreRunnable;

public class RuanableThread implements Runnable{
    public void run(){
        for(int i=100;i>0;--i){
            System.out.println("now i is "+i);
        }
    }
    public static void main(String[] args){
        RuanableThread test=new RuanableThread();
        Thread thread=new Thread(test);
        thread.start();
        int jjj=200;
        while(jjj>0){
            System.out.println("jjj = "+jjj);
            --jjj;
        }
    }

}
