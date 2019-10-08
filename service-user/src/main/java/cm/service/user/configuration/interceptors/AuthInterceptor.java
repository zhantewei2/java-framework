package cm.service.user.configuration.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/***
 * author: zhantewei
 * 校验 对接服务是否已注册。并设置服务相关信息
 * creation time:2019-09-16
 ****/
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
//    private FollowerService _follower;
//    private Setting _setting;
//    public AuthInterceptor(FollowerService _follower,Setting _setting){
//        this._follower=_follower;
//        this._setting=_setting;
//    }
//
//    @Override public boolean preHandle(
//            HttpServletRequest req,
//            HttpServletResponse res,
//            Object handle
//    ){
//        String subId=req.getHeader(_setting.getSubKey());
//        if(subId==null || subId.equals(""))throw new ReqBad("未授权请求");
//        RegisterService registerService=_follower.findOneRegisterService(subId);
//        req.setAttribute("follower",registerService);
//        return true;
//    }
}
