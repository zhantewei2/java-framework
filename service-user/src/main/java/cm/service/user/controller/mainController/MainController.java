package cm.service.user.controller.mainController;


import cm.service.user.controller.mainController.params.ParamLogin;
import cm.service.user.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping("/auth")
@Api("auth")
public class MainController{
    @Autowired
    private AuthService _auth;

    @ApiOperation("login")
    @PostMapping("/login")
    public void login(
            @RequestBody ParamLogin params,
            BindingResult bindingResult
    ){
//        ZTWMethod.ValCheck(bindingResult);

    }
}
