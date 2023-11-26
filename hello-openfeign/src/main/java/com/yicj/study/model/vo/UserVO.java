package com.yicj.study.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * UserVO
 * </p>
 *
 * @author yicj
 * @since 2023年11月26日 19:02
 */
@Data
public class UserVO implements Serializable {

    private String id ;

    private String username ;

    private String address ;

    private String company ;

    private String job ;

    private String partnerId ;
}
