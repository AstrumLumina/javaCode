package threadTest;

public class PCtest2 {
    public static void main(String[] args) {
        TV tv=new TV();
        Watcher watcher=new Watcher(tv);
        Player player=new Player(tv);
        watcher.start();
        player.start();
    }
}

class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }
    public void run (){
        for (int i = 0; i < 50; i++) {
            tv.watch();
        }
    }
}
class Player  extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv=tv;
    }
    public void run(){
        for (int i = 0; i < 50; i++) {
            Integer j=i;
            tv.play(j.toString());
        }
    }
}

class TV{
    //演员生产
    //观众消费
    String voice;
    boolean flag=true;//利用此标志通信，true没有表演了
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+voice);
        this.voice=voice;
        this.flag=!this.flag;
        this.notifyAll();
    }
    public synchronized void watch(){
        if(flag){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("观看了"+voice);
        this.flag=!this.flag;
        this.notifyAll();
    }
}