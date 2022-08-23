//import threadTest.Threadthread.ThreadTest;

public class appApplicaton {
    public static void main(String[] args){
        //*****************************命令行测试
        /*
        for(String partemetName:args){
            System.out.println("参数："+partemetName);
        }
        */
        //*********************************************
        //文档注释 javadoc
        /**
         * @auther wzw
         * @version 1.0
         */

       /*
        {
            baseTest.Father father;
//  final baseTest.Son son;//final 修饰 防止 son 指向内容的变化
            baseTest.Son son;
            baseTest.Son sontwo;
            father = new baseTest.Father();
            son=new baseTest.Son();
            son.test();
            sontwo=new baseTest.Son();//java
            son =sontwo;//Java 中声明的变量 若为引用 且没有特别的修饰 则其指向时可变的
            son.test();
            father.test();
            baseTest.Father basefather=new baseTest.Son();
            basefather.test();
//*****************************************************
            // basefather.testtwo();//不是从父类继承来的 虚函数 父类的引用找不到该方法 false
            ((baseTest.Son)basefather).testtwo();//强制转化后才可以调用
            son.testtwo();
            //father.testtwo();//baseTest.Father 中没有这个方法，false

        }
        */

  //******************************************************测试其他类 leetcode
        //baseTest.maxArear.test();//测试maxArear类
       // baseTest.GameSolution.test(); //测试跳跃游戏类
       // baseTest.RegualrExperrsion.test();

        //********************************测试多线程
        /*
        ThreadTest mutilThread=new ThreadTest();

        //mutilThread.run(); //run()按先后顺序执行
        mutilThread.start();//随机执行，多线程的，由cpu调度
        for(int i=500;i>0;--i){
            System.out.println("This is main method ! and i="+i);
        }
        System.out.println("*****************************");
        try {
            mutilThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String str="abscd";
        System.out.println(str.substring(0,1));
        */
    }
}
