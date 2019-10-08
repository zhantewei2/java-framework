package cm.service.user;


import cm.service.user.configuration.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        exclude ={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class}
)
@EnableSwagger2
@EnableEurekaClient
public class CasClient1App implements CommandLineRunner{
    public static void main(String[] args){
        SpringApplication.run(CasClient1App.class,args);
    }
    @Autowired
    private Setting setting;
    public void run(String... args){
        System.out.println("running .........");
        System.out.println(setting.getMongodbPwd());
    }
}
