package cm.service.user.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.cm.pro.HttpException.HandleException;

@ControllerAdvice
public class ExceptionHandle extends HandleException{
}
