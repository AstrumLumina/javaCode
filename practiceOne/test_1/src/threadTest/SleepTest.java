package threadTest;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.text.SimpleDateFormet;

public class SleepTest {
    //模拟延时能能放大冲突，让线程安全的问题更容易被发现
    //例子看以前的多线程的例子

    //获取系统时间,模拟计时
    public static void main(String[] args) {
        //打印实时时间（实现类似钟表功能）
        Date start;//=new Date(System.currentTimeMillis());
        while(true){
            try{
                start=new Date(System.currentTimeMillis());
                //无效清屏操作
                //System.out.print(String.format("\\033[%dA",8));
                //Runtime.getRuntime().exec("cls");
                //退格模拟清屏操作
                System.out.print("\b\b\b\b\b\b\b\b.");
                System.out.print(new SimpleDateFormat("HH:mm:ss").format(start));
                Thread.sleep(999);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        /*
        //计时
        int num=10;
        System.out.println("计时开始");
        while(num>0){
            try{
                Thread.sleep(1000);//1秒
                --num;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("10已经到了，计时结束");
        */
    }
}
