package springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard  //开启dashboard监控
public class HystrixServiceDashboard6001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceDashboard6001.class);
    }
}
