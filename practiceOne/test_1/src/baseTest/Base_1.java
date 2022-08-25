package baseTest;

import java.util.Scanner;

public class Base_1 {
    public static void main(String[] args) {
        test();
    }
     static void  test() {
        Scanner scaner=new Scanner(System.in);
        String filename=scaner.next();
         System.out.println(filename);
        while(scaner.hasNextInt()){
           // String str=scaner.next();
            int a=scaner.nextInt();
            System.out.println(a);
        }
        scaner.close();

    }
}
