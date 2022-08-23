package RefAndAnno;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GenericRef {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method=GenericRef.class.getMethod("test1",Map.class,List.class);
        System.out.println(method);
        System.out.println("********************");

        Type[] genericParemeterTypes=method.getGenericParameterTypes();
        for (Type genericParameterType : genericParemeterTypes) {
            System.out.println(genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
                Type[] realtype=((ParameterizedType)genericParameterType).getActualTypeArguments();
                System.out.println("realtype:");
                for (Type type : realtype) {
                    System.out.println(type);
                }
                System.out.println("\n");
            }

        }

        System.out.println("********************************");
        Method method2=GenericRef.class.getMethod("test2",null);
        System.out.println(method2);
        Type returntype= method2.getGenericReturnType();
        System.out.println(returntype);
        if(returntype instanceof ParameterizedType){
            Type[] type=((ParameterizedType)returntype).getActualTypeArguments();
            for (Type realtype : type) {
                System.out.println("realtype"+realtype);
            }

        }

    }
    public void test1(Map<String,Fortest> map, List<Fortest> list){
        System.out.println("test1");
    }
    public Map<String,Fortest> test2(){
        System.out.println("test2");
        return null;
    }

}
