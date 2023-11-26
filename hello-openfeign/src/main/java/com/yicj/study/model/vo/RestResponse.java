package com.yicj.study.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * RestResponse
 * </p>
 *
 * @author yicj
 * @since 2023年11月26日 19:09
 */
@Data
public class RestResponse <T> implements Serializable {

    private String code ;

    private String message ;

    private T data ;

    public static <T> RestResponse<T> success(T data){
        RestResponse<T> response = new RestResponse<>() ;
        response.setData(data);
        return response ;
    }
}
