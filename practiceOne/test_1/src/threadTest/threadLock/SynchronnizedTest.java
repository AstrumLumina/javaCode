package threadTest.threadLock;

public class SynchronnizedTest {//锁预防线程安全
    //可以锁方法-----同步方法
    //也可以锁代码块-----同步块
    public static void main(String[] args) {
        Account familyaccout=new Account("家庭账户",10000);
        Drawing mydraw=new Drawing(familyaccout,500,"我");
        Drawing girlfrienddraw=new Drawing(familyaccout,700,"girlfriend");
        mydraw.start();
        girlfrienddraw.start();
    }
}
class Account{
    String cardname;
    double money;
    public Account(String name,double money){
        this.cardname=name;
        this.money=money;
    }
}
class Drawing extends Thread{
    Account account;
    double drawingmoney;
    double nowmoney;

    public Drawing(Account account,double drawingmoney,String name){
        super(name);
        this.account=account;
        this.drawingmoney=drawingmoney;
        this.nowmoney=0;
    }
    @Override
    /*
     public synchronized void run() {
        //此时仍然错误  :synchronized 同步方法默认锁的是this,同步的是对象本身
        //Synchronized方法锁（也叫对象锁）
        // 1.修饰在方法上，多个线程调用同一个对象的同步方法会阻塞，调用不同对象的同步方法不会阻塞
        //此处两个不同的Drawing对象操作同一个account对象，所以不会阻塞
        //同步块指定锁的对象,如下格式
        //更改后的方法见下面

        //synchronized(this){
        //}
        if(account.money<drawingmoney){
        System.out.println("余额不足！");
          }else{
        try {
            Thread.sleep(1000);//模拟延时，放大问题
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawingmoney;
        nowmoney+=drawingmoney;
        drawingmoney=0;
        System.out.println("取钱成功 "+this.getName()+" 现在有"+nowmoney+"  "+account.cardname+"账户还剩余"+account.money+"钱");
    }
     */
    public synchronized void run() {
        synchronized(account){//操作的是同一个accout对象，故故可以锁住
            if(account.money<drawingmoney){
                System.out.println("余额不足！");
            }else{
                try {
                    Thread.sleep(1000);//模拟延时，放大问题
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.money-=drawingmoney;
                nowmoney+=drawingmoney;
                drawingmoney=0;
                System.out.println("取钱成功 "+this.getName()+" 现在有"+nowmoney+"  "+account.cardname+"账户还剩余"+account.money+"钱");
            }
        }
    }
}