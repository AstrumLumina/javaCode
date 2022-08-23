package RefAndAnno;

import java.lang.annotation.*;

public class Annotation {//注解 @***
    //主要内置注解1.@override
    //2.@depreacated
    //3.@SupperssWarnning("all")//带参数,用于类或方法
    //常见参数："all" "unchecked" "depractiong"

    //****************************************
    //元注解 解释其他注解
    //@Target    //描述注解的使用范围
    //@Retention  //表示注解保存到什么级别
    //@document （SOURCE<CLASS<RUNTIME) //注解可以被包含到Javadoc上
    //@inherited //子类可以继承父类的注解

    //使用自定义注解***********************************
    @MyAnnotation(grade=1)
    public void test(){

    }
}

//测试元注解

//自定义一个注解
//@Target(value= {ElementType.METHOD,ElementType.TYPE})//限定该注解只能
// 在方法上和类上使用
@Target(value= ElementType.METHOD)//限定该注解只能在方法上使用
@Retention(value= RetentionPolicy.RUNTIME)//在运行时以及之前的都有效
@Documented//可以放到Javadoc
@Inherited//可以被继承的
/*public *//*是否需要public同类的规则*/@interface MyAnnotation{//自动继承Annotation
    //注解的参数：参数的类型+参数名（）
    String name() default "";//default 定义默认值，否则使用是必须传参
    int age() default 0;
    int id() default -1;//-1 表示可能不存在
    String[] school() default {"whut","zhongkeda"};
    int grade();

}
//当注解只有一个成员时，可以将成员命名为value，而在使用赋值时
//直接写值，省略“变量名=”

