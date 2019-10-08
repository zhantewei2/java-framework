package cm.service.user.configuration;

import lombok.extern.slf4j.Slf4j;
import org.cm.pro.Thread.ZTWThreadFixed;
import org.cm.pro.utils.ZTWAES;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ImportResource("classpath:beans.xml")
public class BeanConfiguration {
    @PostConstruct
    public void beanInitHook(){ }

    private ZTWAES _aes;
    private Setting setting;

    public BeanConfiguration() throws Exception{
        setting=new Setting();
        setting.init();
        _aes=new ZTWAES(setting.getAESKey(),setting.getAESIv());
    }
    /***
     * author: zhantewei
     * aes加解密
     * creation time:2019-09-16
     ****/
    @Bean(value="aes")
    public ZTWAES aes(){
        return _aes;
    }
    /***
     * author: zhantewei
     * 固定20线程做为 request 调用
     * creation time:2019-09-17
     ****/
    @Bean(value="reqThreadPool")
    public ZTWThreadFixed reqThreadPool(){
        return new ZTWThreadFixed(setting.getReqThreadPoolCount());
    }

    /***
     * author: zhantewei
     * mongo connect
     * creation time:2019-09-30
     ****/
//    @Bean(value="cmMongo")
//    public MongodConnection mongodConnection(){
//        return new MongodConnection(
//                setting.getMongodbHost(),
//                setting.getMongodbDatabase(),
//                setting.getMongodbPort(),
//                setting.getMongodbAccount(),
//                setting.getMongodbPwd()
//        );
//    }
}
