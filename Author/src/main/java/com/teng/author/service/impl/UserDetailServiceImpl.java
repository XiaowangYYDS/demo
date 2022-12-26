package com.teng.author.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.teng.author.domin.entity.LoginUser;
import com.teng.author.domin.entity.Secret;
import com.teng.author.enums.AppHttpCodeEnum;
import com.teng.author.exception.SystemException;
import com.teng.author.mapper.AuthorMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/17:48 Description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private AuthorMapper authorMapper;

    @Override
    public UserDetails loadUserByUsername(String app_id) throws UsernameNotFoundException {
        LambdaQueryWrapper<Secret> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Secret::getAppId,app_id);
        Secret secret = authorMapper.getByAppId(app_id);

        if (Objects.isNull(secret)){
            throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
        }

        // TODO: 2022/12/26 查询当前权限
        return new LoginUser(secret);
    }
}
