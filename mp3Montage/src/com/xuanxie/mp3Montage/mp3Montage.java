package com.xuanxie.mp3Montage;

import java.io.*;
import java.util.Scanner;

/**
 * 音乐剪切和拼接（音乐串烧）
 */


public class mp3Montage {
    public static void main(String[] args) {
        attention();
        int option=-1;
        Scanner scanner=new Scanner(System.in);
        do{
            menu();
            option=scanner.nextInt();
            switch (option){
                case 0:
                    System.out.println("退出");break;
                case 1:
                    System.out.println("   1. 从一首音乐的截取一部分为新音乐");
                    function_1();
                    break;
                case 2:
                    System.out.println("2. 将两手歌曲合并为一首歌曲");
                    System.out.println(" **********  选项:  ***********");
                    function_2();
                    break;
                case 3:
                    System.out.println("3.从一首歌曲中选取两部分合为一首新歌");
                    System.out.println(" **********  选项:  ***********");
                    function_3();
                    break;
                case 4:
                    System.out.println("4.提示帮助");
                    attention();
                    break;
                default:
                    System.out.println(" 错误输入!!,请重新输入\n\n");
                    break;
            }
        }while(option!=0);

        scanner.close();
       /* //第一段:   0~3:50 (230s)  第二段:   4:36( 276s)  ~结尾
        //第一段:   0~3:37 (231s)  第二段:   4:36( 276s)  ~结尾
        montageMusic_3("D:\\practiceOne\\test_1\\src\\musicFile\\testfile1.mp3",
                "D:\\practiceOne\\test_1\\src\\musicFile\\newMusic2.mp3",
                0,217f,276f,274,320);*/
    }
    public static void function_1(){
        int option=-1;
        String resourceFile=null;
        String outFile=null;
        float startTime=0;
        float endTime=0;
        int bits=320;

        Scanner scanner=new Scanner(System.in);
        do{
           //菜单：
            System.out.println(" **********  选项:  ***********");
            System.out.println(" 1.音乐资源文件          2.音乐输出文件");
            System.out.println(" "+resourceFile+"   　　　"+outFile);
            System.out.println(" 3.开始时间             4.结束时间");
            System.out.println(" "+startTime+"　　　　"+endTime);
            System.out.println(" 5.比特率               6.开始剪辑");
            System.out.println(" "+bits);
            System.out.println(" 0.退出");
            System.out.println("*******************************");
            System.out.print("请输入您的选择:");
            option=scanner.nextInt();
            //处理选择
            switch (option){
                case 0:
                    System.out.println("返回");break;
                case 1:
                    System.out.println("1.请输入资源文件名");
                    System.out.println("(要输入文件后缀（。MP3）；若文件不在程序目录下，请输入文件路径名；）");
                    if(scanner.hasNext())
                    resourceFile=scanner.next();
                    break;
                case 2:
                    System.out.println("2.请输入输出文件名");
                    System.out.println("(要输入文件后缀（。MP3）；请确保文件不重名，以避免覆盖其他文件；请输入文件路径名，若只输入文件名，则生成文件在程序目录下；）");
                    outFile=scanner.next();
                    break;
                case 3:
                    System.out.println("3.请输入开始时间（以秒为单位，可以为小数）");
                    startTime=scanner.nextFloat();
                    break;
                case 4:
                    System.out.println("4.请输入结束时间（以秒为单位，可以为小数）");
                    endTime=scanner.nextFloat();
                    break;
                case 5:
                    System.out.println("5.请输入比特率（单位： kpbs ,可以查看音乐文件属性；默认为 320）");
                   bits=scanner.nextInt();
                    break;
                case 6:
                    System.out.println("6.开始剪辑");
                    System.out.println("  此程序不存在安全检查，请你在确认一遍输入数据是否有误，以避免造成未知错误！！！！");
                    System.out.println("");
                    System.out.print("您确人要开始剪辑吗（1：是  其他：否) :");
                    option=scanner.nextInt();
                    if(option==1){
                        montageMusic(resourceFile,outFile, startTime, endTime,bits);
                        System.out.println("剪辑完成！\n\n");
                        option=0;
                    }else{
                        System.out.println("取消剪辑，继续输入\n\n");
                        option=-1;
                        break;
                    }
                default:
                    System.out.println(" 错误输入!!,请重新输入\n\n");
                    break;
            }
        }while(option!=0);
    }

    public static void function_2(){
        int option=-1;
        String resourceFile=null;
        String resourceFlle_2=null;
        String outFile=null;

        Scanner scanner=new Scanner(System.in);
        do{
            //菜单：
            System.out.println(" **********  选项:  ***********");
            System.out.println(" 1.音乐资源文件1         2.音乐资源文件2");
            System.out.println(" "+resourceFile+"   　　　"+resourceFlle_2);
            System.out.println(" 3.音乐输出文件          4.开始合并音乐 ");
            System.out.println(" "+outFile);
            System.out.println(" 0.返回");
            System.out.println("*******************************");
            System.out.print("请输入您的选择:");
            option=scanner.nextInt();

            //处理选择
            switch (option){
                case 0:
                    System.out.println("返回");break;
                case 1:
                    System.out.println("1.请输入资源文件1名");
                    System.out.println("(要输入文件后缀（。MP3）；此音乐放到合并后的前一段；若文件不在程序目录下，请输入文件路径名；）");
                    resourceFile=scanner.next();
                    break;
                case 2:
                    System.out.println("2.请输入资源文件名");
                    System.out.println("(要输入文件后缀（。MP3）；此音乐放到合并后的后一段；若文件不在程序目录下，请输入文件路径名；）");
                    resourceFlle_2=scanner.next();
                    break;
                case 3:
                    System.out.println("3.音乐输出文件");
                    System.out.println("(要输入文件后缀（。MP3）；请确保文件不重名，以避免覆盖其他文件；请输入文件路径名，若只输入文件名，则生成文件在程序目录下；）");
                    outFile=scanner.next();
                    break;
                case 4:
                    System.out.println("4.开始合并");
                    System.out.println("\n   此程序不存在安全检查，请你在确认一遍输入数据是否有误，以避免造成未知错误！！！！\n");
                    System.out.print("您确人要开始合并吗（1：是  其他：否)　：");
                    option=scanner.nextInt();
                    if(option==1){
                        montageMusic_2(resourceFile,resourceFlle_2,outFile);
                        System.out.println("合并完成！\n\n");
                        option=0;
                    }else{
                        System.out.println("取消合并，继续输入\n\n");
                        option=-1;
                        break;
                    }
                default:
                    System.out.println(" 错误输入!!,请重新输入\n\n");
                    break;
            }
        }while(option!=0);

    }
    public static void function_3(){
        int option=-1;
        String resourceFile=null;
        String outFile=null;
        float startTime=0;
        float endTime=0;
        float startTime2=0;
        float endTime2=0;
        int bits=320;

        Scanner scanner=new Scanner(System.in);
        do{
            //菜单：
            System.out.println(" **********  选项:  ***********");
            System.out.println(" 1.音乐资源文件          2.音乐输出文件");
            System.out.println(" "+resourceFile+"   　　　"+outFile);
            System.out.println(" 3.第一段开始时间         4.第一段结束时间");
            System.out.println(" "+startTime+"　　　　"+endTime);
            System.out.println(" 5.第二段开始时间         6.第二段结束时间");
            System.out.println(" "+startTime2+"　　　　"+endTime2);
            System.out.println(" 7.比特率               8.开始剪辑");
            System.out.println(" "+bits);
            System.out.println(" 0.退出");
            System.out.println("*******************************");
            System.out.print("请输入您的选择:");
            option=scanner.nextInt();

            //处理选择
            switch (option){
                case 0:
                    System.out.println("返回");break;
                case 1:
                    System.out.println("1.请输入资源文件名");
                    System.out.println("(要输入文件后缀（。MP3）；若文件不在程序目录下，请输入文件路径名；）");
                    resourceFile=scanner.next();
                    break;
                case 2:
                    System.out.println("2.请输入输出文件名");
                    System.out.println("(要输入文件后缀（。MP3）；请确保文件不重名，以避免覆盖其他文件；请输入文件路径名，若只输入文件名，则生成文件在程序目录下；）");
                    outFile=scanner.next();
                    break;
                case 3:
                    System.out.println("3.请输入第一段开始时间（以秒为单位，可以为小数）");
                    startTime=scanner.nextFloat();
                    break;
                case 4:
                    System.out.println("4.请输入第一段结束时间（以秒为单位，可以为小数）");
                    endTime=scanner.nextFloat();
                    break;
                case 5:
                    System.out.println("5.请输入第二段开始时间（以秒为单位，可以为小数）");
                    startTime2=scanner.nextFloat();
                    break;
                case 6:
                    System.out.println("6.请输入第二段结束时间（以秒为单位，可以为小数）");
                    endTime2=scanner.nextFloat();
                    break;
                case 7:
                    System.out.println("7.请输入比特率（单位： kpbs ,可以查看音乐文件属性；默认为 320）");
                    bits=scanner.nextInt();
                    break;
                case 8:
                    System.out.println("8.开始剪辑");
                    System.out.println("  此程序不存在安全检查，请你在确认一遍输入数据是否有误，以避免造成未知错误！！！！");
                    System.out.println("");
                    System.out.print("您确人要开始剪辑吗（1：是  其他：否）：");
                    option=scanner.nextInt();
                    if(option==1){
                        montageMusic_3(resourceFile,outFile,startTime,endTime,startTime2,endTime2,bits);
                        System.out.println("剪辑完成！\n\n");
                        option=0;
                    }else{
                        System.out.println("取消剪辑，继续输入\n\n");
                        option=-1;
                        break;
                    }
                default:
                    System.out.println(" 错误输入!!,请重新输入\n\n");
                    break;
            }
        }while(option!=0);
    }
    public static void attention(){
        System.out.println("**************   mp3音乐剪辑    ********");
        System.out.println("提示: 1.本程序是为 MP3 音乐剪辑开发的程序,对于其他的格式的音乐,视频等可能会出现问题");
        System.out.println("     2.使用本程序最好使用完全路径名，除非文件在程序目录下");
        System.out.println("     3.输出文件名最好确保不与现有文件重名，避免原来的文件被覆盖二丢失");
        System.out.println("     4.功能三截取的音乐不能有重叠，若有重叠，自动合并为一段");
        System.out.println("     5.若输入的时间段大于音乐本身时间，则忽略，只截取有效部分4");
        System.out.println("************************************\n");
    }
public static void menu(){
    System.out.println("**************  选择菜单     *********");
    System.out.println(" 0.退出");
    System.out.println(" 1. 从一首音乐的截取一部分为新音乐");
    System.out.println(" 2. 将两手歌曲合并为一首歌曲");
    System.out.println(" 3.从一首歌曲中选取两部分合为一首新歌");
    System.out.println(" 4.提示帮助");
    System.out.println("***************************************");
    System.out.println("请输入您的选择:");
}

    public static void montageMusic_2(String resouceFileName1,String resourceFileName2,String outFileName){/*合并两个音乐*/
        try {
            BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(new File(resouceFileName1)));
            BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(new File(resourceFileName2)));
            //缓冲字节输出流（true表示可以在流的后面追加数据，而不是覆盖！！）
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(outFileName)));

            byte[] b1= new byte[256];
            int len1 = 0;
            while((len1 = bis1.read(b1))!=-1){
                bos.write(b1);
            }
            System.out.println("第一部分合并完成！");

            while((len1 = bis1.read(b1))!=-1){
                bos.write(b1);
            }
            System.out.println("第二部分合并完成！");

            //关闭资源
            bis1.close();
            bis2.close();
            bos.close();
            System.out.println("音乐剪辑完成!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

                                     //资源文件,输出文件,开始时间,结束时间,开始时间2,结束时间2,比特率
    public static void montageMusic_3(String resouceFile,String outFile,float startTime,float endTime,float startTime_2,float endTime_2,int bits){/*从一个音乐中截取两部分位一个新音乐*/
        try {
            BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(new File(resouceFile)));
            //缓冲字节输出流（true表示可以在流的后面追加数据，而不是覆盖！！）
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(outFile)));
            int readTotal=0;
            int start1=(int)startTime*1024*bits/8;
            int start2=(int)startTime_2*1024*bits/8;
            int end1=(int)endTime*1024*bits/8;
            int end2=(int)endTime_2*1024*bits/8;

            {//用于 debuge
                System.out.println("start1: "+start1);
                System.out.println("end1: "+end1);
                System.out.println("start2: "+start2);
            }

            byte[] b1= new byte[256];
            int len1 = 0;
            while((len1 = bis1.read(b1))!=-1){
                readTotal+=len1;   //累积tatol
                if(readTotal<start1 ){  //tatol小于起始值则跳出本次循环
                    continue;
                }
                bos.write(b1);   //写入的都是在我们预先指定的字节范围之内
                if(readTotal>=end1 ){  //当tatol的值超过预先设定的范围，则立刻刷新bos流对象，并结束循环
                    break;
                }
            }
            System.out.println("第一部分剪切完成！");
            System.out.println("realEnd1: "+readTotal);

            while((len1 = bis1.read(b1))!=-1){
                readTotal+=len1;   //累积tatol
                if(readTotal<start2 ){  //tatol小于起始值则跳出本次循环
                    continue;
                }
                bos.write(b1);
                if(readTotal>=end2 ){
                    break;
                }
            }
            bis1.close();
            bos.close();
            System.out.println("音乐剪辑完成!!");
            System.out.println("realEnd2/readTotal: "+readTotal);//用于调试

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void montageMusic(String resouceFile,String outFile,float startTime,float endTime,int bits){/*剪取音乐的一段,保存位新文件*/
        try {
            FileInputStream resourceInputStream=new FileInputStream(new File(resouceFile));
            File out = new File(outFile);
            BufferedOutputStream bos;
            try (BufferedInputStream bis1 = new BufferedInputStream(resourceInputStream)) {
                //缓冲字节输出流（true表示可以在流的后面追加数据，而不是覆盖！！）
                bos = new BufferedOutputStream(new FileOutputStream(out, false));//真则在后面添加内容  假则覆盖原来的内容
                int readTotal = 0;
                int start = (int) startTime * 1024 * bits / 8;
                int end = (int) endTime * 1024 * bits / 8;

                byte[] b1 = new byte[256];
                int len1 = 0;
                while ((len1 = bis1.read(b1)) != -1) {
                    readTotal += len1;   //累积tatol
                    if (readTotal < start) {  //tatol小于起始值则跳出本次循环
                        continue;
                    }
                    bos.write(b1);   //写入的都是在我们预先指定的字节范围之内
                    if (readTotal >= end) {  //当tatol的值超过预先设定的范围，则立刻刷新bos流对象，并结束循环
                        break;
                    }
                }

                resourceInputStream.close();
                bis1.close();
                bos.close();
                System.out.println("音乐截取完成!!!");
            }
            bos.close();
            System.out.println("剪辑完成!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
