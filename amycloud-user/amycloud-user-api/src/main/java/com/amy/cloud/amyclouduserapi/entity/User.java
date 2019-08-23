package com.amy.cloud.amyclouduserapi.entity;

import lombok.Data;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/23 11:11
 */
@Data
public class User {

    private Integer userId;
    private String mobile;
    private String realName;
    private String nickName;
}
