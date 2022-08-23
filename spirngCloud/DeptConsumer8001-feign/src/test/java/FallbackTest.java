import com.xuanxie.springcloud.pojo.Dept;
import com.xuanxie.springcloud.service.DeptClienService;
import com.xuanxie.springcloud.service.DeptServiceCallback;
import com.xuanxie.springcloud.service.DeptServiceFallbackFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@ComponentScans(@ComponentScan(basePackages ={"com.xuanxie.springcloud.config", "com.xuanxie.springcloud.service"}))
//@SpringBootApplication(scanBasePackages = {"com.xuanxie.springcloud", "com.xuanxie.springcloud.service"})
public class FallbackTest {

    public void setDeptServiceFallbackFactory(DeptServiceFallbackFactory deptServiceFallbackFactory) {
        this.deptServiceFallbackFactory = deptServiceFallbackFactory;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
   // @Value("getDeptServiceFallbackFactory")
    private DeptServiceFallbackFactory deptServiceFallbackFactory;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DeptServiceCallback deptServiceCallback;

    /*此处为什么无法注入??????
    * */

    @Test
    public void contextLoads() {
        System.out.println("==========================");
        System.out.println(restTemplate);
        System.out.println(deptServiceFallbackFactory);
        System.out.println(deptServiceCallback);
        DeptClienService deptClienService = deptServiceFallbackFactory.create(null);
        //System.out.println(deptClienService.delDeptById(1));
        System.out.println("=========================");
    }

}
