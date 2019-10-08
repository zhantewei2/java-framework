package cm.service.user.controller.mainController.params;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ParamLogin {
    @NotBlank
    @Length(min=5)
    private String account;

    @NotBlank
    @Length(min=5)
    private String password;
}
