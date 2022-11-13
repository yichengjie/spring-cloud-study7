package com.yicj.web.interceptor;


import com.yicj.web.exception.AppException;
import com.yicj.web.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler{

    @ResponseBody
    @ExceptionHandler(value = AppException.class)
    public RestResponse<?> handlerException(AppException e, HttpServletResponse response){
        log.error("自定义业务异常： {}" , e.getMessage(), e);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return RestResponse.fail(e.getCode(), e.getMessage()) ;
    }
}
