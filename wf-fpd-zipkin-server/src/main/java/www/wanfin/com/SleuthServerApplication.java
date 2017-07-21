package www.wanfin.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication  
@EnableZipkinStreamServer 
public class SleuthServerApplication {
	  public static void main(String[] args) {  
	        SpringApplication.run(SleuthServerApplication.class,args);  
	    }  
}
