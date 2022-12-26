package com.teng.author.domin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/17:22 Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretDto {

    private String app_id;
    private String app_secret;
}
