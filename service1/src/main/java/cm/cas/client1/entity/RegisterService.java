package cm.cas.client1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@ApiModel(value="registerService",description = "注册的服务")
public class RegisterService {
    @JsonIgnore
    private String id;

    @ApiModelProperty("注册的服务名")
    private String name;
    @ApiModelProperty("注销TGT时，需要被回调的接口地址")
    private String logoutUrl;

    private Integer enabled;


    @JsonFormat(timezone="GMT+8",pattern="YYYY/MM/dd HH:mm:ss")
    private Date createDate;

    @JsonFormat(timezone="GMT+8",pattern = "YYYY/MM/dd HH:mm:ss")
    private Date updateDate;
}
