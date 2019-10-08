package cm.service.user.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity {
    private String _id;
    private String account;
    private String password;
    private String position;
}
