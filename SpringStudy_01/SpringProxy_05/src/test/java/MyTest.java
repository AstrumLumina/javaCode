import com.xuanxie.dao.UerDapImpl;
import com.xuanxie.dao.UserDao;
import com.xuanxie.proxy01.ProxyInvocationHander;

public class MyTest {
    public static void main(String[] args) {
        ProxyInvocationHander proxyInvocationHander = new ProxyInvocationHander();
        UerDapImpl uerDap = new UerDapImpl();
        UserDao proxy = (UserDao) proxyInvocationHander.setTarget(uerDap).getProxy();
        proxy.addUser();
        proxy.deleteUser();
        proxy.queryUser();
        proxy.updateUser();
    }
}
