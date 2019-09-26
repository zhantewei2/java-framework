package cm.cas.client1.configuration;


import lombok.Getter;
import lombok.Setter;
import org.cm.pro.utils.ZTWMethod;

import java.util.Map;

@Setter
@Getter
public class Setting {
    //tgt在redis 中的过期时间
    private int TGTExpires;
    private String TGTKey;
    //全局 aes 加密key
    private String AESKey;
    // aes iv
    private String AESIv;
    // request 线程池 固定线程数
    private int ReqThreadPoolCount;
    // 密码盐 相关数据
    private Map<String,?> salt;
    // 所有数据操作的ID
    private Long managerId;
    //follower ticket key
    private String subKey;
    // 三种tgt过期时间
    private Map<String,Integer> expires;
    //静态文件 dir
    private String staticDir;

    public void setManagerId(String managerId){
        this.managerId=Long.valueOf(managerId);
    }

    public void init() throws Exception{
        ZTWMethod.loadJson(this,"/setting.json");
    }
}
