package threadTest;

public class JoinTest implements Runnable{
    public void run(){
        int num=200;
        while(num>0){
            System.out.println("Now num is "+num);
            --num;
        }
    }
    public static void main(String[] args){
        JoinTest jointest=new JoinTest();
        Thread thread=new Thread(jointest);
        thread.start();

        for(int i=50;i>0;--i){
            if(i==30){
                try {
                    thread.join();//插队 等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("      Now Main is "+i);
        }
    }
}
