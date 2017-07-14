package www.wanfin.com.feign.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;
import feign.Retryer;

@Configuration
public class FeginConfig {
    @Bean
    public Retryer feginRetryer(){
        Retryer retryer = new Retryer.Default(100, TimeUnit.SECONDS.toMillis(10), 1);
        return retryer;
    }
    @Bean
    public Request.Options feginOption(){
        Request.Options option = new Request.Options(7000,7000);
        return option;
    }
}