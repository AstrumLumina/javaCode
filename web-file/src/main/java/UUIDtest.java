import java.util.UUID;

public class UUIDtest {
    public static void main(String[] args) {
        //uuid是一个系统,用于产生一个不同的随机序列号
        String uuidPath = UUID.randomUUID().toString();
        System.out.println(uuidPath);
    }
}