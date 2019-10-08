package cm.service.user.configuration;


import lombok.Getter;
import lombok.Setter;
import org.cm.pro.utils.ZTWMethod;

import java.util.Map;

@Setter
@Getter
public class Setting {
    //全局 aes 加密key
    private String AESKey;
    // aes iv
    private String AESIv;
    // request 线程池 固定线程数
    private int ReqThreadPoolCount;
    // mongodb
    private String mongodbHost;
    private String mongodbDatabase;
    private Integer mongodbPort;
    private String mongodbAccount;
    private String mongodbPwd;

    public void init() throws Exception{
        ZTWMethod.loadJson(this,"/setting.json");
    }
}
