package com.yicj.web.response;

import com.yicj.web.constants.CommonConstants;
import lombok.Data;

@Data
public class RestResponse<T> {

    private String code ;

    private String message ;

    private T data ;

    public static <T> RestResponse<T> success(T data){
        RestResponse<T> response = new RestResponse<>() ;
        response.setCode(CommonConstants.SUCCESS_CODE);
        response.setData(data);
        return response;
    }

    public static <T> RestResponse<T> fail(String message){
        return fail(CommonConstants.FAIL_CODE,message) ;
    }

    public static <T> RestResponse<T> fail(String code, String message){
        RestResponse<T> response = new RestResponse<>() ;
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
