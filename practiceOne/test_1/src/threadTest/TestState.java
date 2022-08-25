package threadTest;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        //lamda 表达式创建内部类
        Thread thread=new Thread(()->{
            try{
                for(int i=0;i<101;++i){
                    System.out.println("线程正在被执行！"+i);
                    Thread.sleep(100);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        //观察状态
        Thread.State state=thread.getState();
        System.out.println(state);//NEW 新生
        //观察启动后
        thread.start();
        System.out.println(thread.getState());//RUN 运行

        //监测状态
        try{
            while(state!=Thread.State.TERMINATED){//不是结束状态
                state=thread.getState();
                System.out.println(state);//打印状态
                Thread.sleep(100);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

}
