package com.amy.cloud.amyclouduserserver.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/30 10:07
 */
@Data
public class User {
    @NotNull
    private String nickName;
    @NotNull
    private String mobile;
}
