package com.teng.author.domin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/13:06 Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secret {

    private String appId;

    private String appSecret;

    //角色
    private String role;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //秘钥状态（0 表示启用，1表示禁用）
    private String status;
}
