package cm.cas.client1.configuration;

import cm.cas.client1.configuration.interceptors.AuthInterceptor;
import org.cm.pro.StaticServer.StaticServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private Setting _setting;

    @Override
    public void addInterceptors(
            InterceptorRegistry registry
    ){
//        用户校验
//        registry.addInterceptor(new AuthInterceptor(_follower,_setting)).addPathPatterns(
//                Arrays.asList("/cas/**","/user/**","/follower/unregisteredService","/follower/updateRegisteredService")
//        );

        /***
         * author: zhantewei
         * 静态文件托管
         * creation time:2019-09-24
         ****/
//        StaticServer staticServer=new StaticServer();
//        staticServer.setHandleUrl("/static");
//        staticServer.setHandlePath(_setting.getStaticDir());
//        staticServer.setCallbackFile("index.html");
//        staticServer.setUseNotModify(true);
//
//        registry.addInterceptor(new HandlerInterceptor() {
//            @Override
//            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//                return staticServer.run(request,response);
//            }
//        }).addPathPatterns("/static/**");
    }
}
