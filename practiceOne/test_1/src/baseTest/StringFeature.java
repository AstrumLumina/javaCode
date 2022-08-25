package baseTest;//import org.openjdk.jol.vm.VM;

public class StringFeature {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a + b;
        final String d = "ab";
        String e = new String("ab");
        String f = "ab";

        System.out.println("\n\n***********************");
        System.out.println(c== d);
        System.out.println(c== e);
        System.out.println(c== f);
        System.out.println(d== c);
        System.out.println(d== f);
        System.out.println(e == f);
        System.out.println("*******************************************");
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println(s1==s2);



    }
}
