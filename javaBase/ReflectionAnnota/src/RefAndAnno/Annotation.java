package RefAndAnno;

import java.lang.annotation.*;

public class Annotation {//ע�� @***
    //��Ҫ����ע��1.@override
    //2.@depreacated
    //3.@SupperssWarnning("all")//������,������򷽷�
    //����������"all" "unchecked" "depractiong"

    //****************************************
    //Ԫע�� ��������ע��
    //@Target    //����ע���ʹ�÷�Χ
    //@Retention  //��ʾע�Ᵽ�浽ʲô����
    //@document ��SOURCE<CLASS<RUNTIME) //ע����Ա�������Javadoc��
    //@inherited //������Լ̳и����ע��

    //ʹ���Զ���ע��***********************************
    @MyAnnotation(grade=1)
    public void test(){

    }
}

//����Ԫע��

//�Զ���һ��ע��
//@Target(value= {ElementType.METHOD,ElementType.TYPE})//�޶���ע��ֻ��
// �ڷ����Ϻ�����ʹ��
@Target(value= ElementType.METHOD)//�޶���ע��ֻ���ڷ�����ʹ��
@Retention(value= RetentionPolicy.RUNTIME)//������ʱ�Լ�֮ǰ�Ķ���Ч
@Documented//���Էŵ�Javadoc
@Inherited//���Ա��̳е�
/*public *//*�Ƿ���Ҫpublicͬ��Ĺ���*/@interface MyAnnotation{//�Զ��̳�Annotation
    //ע��Ĳ���������������+����������
    String name() default "";//default ����Ĭ��ֵ������ʹ���Ǳ��봫��
    int age() default 0;
    int id() default -1;//-1 ��ʾ���ܲ�����
    String[] school() default {"whut","zhongkeda"};
    int grade();

}
//��ע��ֻ��һ����Աʱ�����Խ���Ա����Ϊvalue������ʹ�ø�ֵʱ
//ֱ��дֵ��ʡ�ԡ�������=��

