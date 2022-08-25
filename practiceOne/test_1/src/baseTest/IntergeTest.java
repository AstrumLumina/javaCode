package baseTest;

public class IntergeTest {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(a==127);
        /*-128~127之间的数来自Interge常量池,不在此范围的在堆里新建对象
        Boolean也来自Boolean缓存，只有false和true两个值
        除了Float和Double类外，都有缓存（都是-128~127）;
         */
        System.out.println(c==128);
    }

}
