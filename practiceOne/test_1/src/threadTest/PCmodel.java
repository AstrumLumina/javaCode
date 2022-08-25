package threadTest;

public class PCmodel {//生产者，消费者模型
//利用缓冲区解决：管程法
    //消费者，产品，缓冲区
public static void main(String[] args) {
    SynContainer container=new SynContainer();

    Productor productor=new Productor(container);
    Consumer consumer=new Consumer(container);

    productor.start();
    consumer.start();
}

}
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100;) {
            container.push(new Chicken(i+1));
            System.out.println("生产了第"+(++i)+"只鸡");
        }
    }
}
class Consumer extends Thread{
    private SynContainer container;
    public Consumer(SynContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken=container.pop();
            System.out.println("              消费了第"+chicken.id+"只鸡");
        }
    }
}
//产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id=id;
    }
}
//缓冲区
class SynContainer{
    int productnum=0;
    Chicken[] chickens=new Chicken[10];

    //生产者操作
    public synchronized void push(Chicken chicken){
        //满了，等待消费
        if(productnum==chickens.length) try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //没满，放入产品
        chickens[productnum++]=chicken;
        //已有产品，通知消费
        this.notifyAll();
    }

    //消费者操作
    public synchronized Chicken pop(){
        //能消费则消费，否则等待
        if(productnum==0){
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费
        Chicken chicken=chickens[--productnum];
        //吃鸡后 通知生产
        this.notifyAll();

        return chicken ;
    }
}