package com.teng.author.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teng.author.domin.ResponseResult;
import com.teng.author.domin.dto.SecretDto;
import com.teng.author.domin.entity.Secret;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/12:52 Description:
 */
public interface AuthorService extends IService<Secret> {
    ResponseResult create();

    ResponseResult login(SecretDto secretDto);
}
