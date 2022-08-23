package springcloud.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixMointorServlet {
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean hystrixRegisterBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        hystrixRegisterBean.addUrlMappings("/actuator/hystrix.stream");
        return hystrixRegisterBean;
    }
}
