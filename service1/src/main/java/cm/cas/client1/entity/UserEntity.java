package cm.cas.client1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserEntity {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    private String account;
    private String password;
    private String salt;
    private String lockMark;
    private String validMark;
    private Long createdBy;
    private Long updatedBy;
    @JsonFormat(pattern="YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdDate;
    @JsonFormat(pattern="YYYY-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updatedDate;
}
