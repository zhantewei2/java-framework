package cm.cas.client1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CasClient1App {
    public static void main(String[] args){
        SpringApplication.run(CasClient1App.class,args);
    }
}
