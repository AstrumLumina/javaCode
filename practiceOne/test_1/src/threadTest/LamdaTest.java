package threadTest;

// lamda 表达式可以简化匿名内部类的创建
public class LamdaTest {
    public static void main(String[] args) {
        //正常写法
        class Ilike implements OutLike{
             public void prinlike(String like) {
                System.out.println("I like " + like);
            }
        }
        OutLike ilike=new Ilike();
        ilike.prinlike("Banner");

        //根据 lamda 表达式规则化简后
        OutLike helike=(String like)->{
            System.out.println("He like "+like);
        };
        helike.prinlike("Orange");
        //继续简化
        OutLike shelike=(like)->{
            System.out.println("She like "+like);
        };
        shelike.prinlike("Potato");
        //继续简化  去参数的括号
        OutLike girlike=like->{
            System.out.println("Girl like "+like);
        };
        girlike.prinlike("Boy");
    }
}

interface OutLike{
    void prinlike(String like);
}