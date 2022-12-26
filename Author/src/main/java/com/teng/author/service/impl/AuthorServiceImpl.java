package com.teng.author.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teng.author.domin.ResponseResult;
import com.teng.author.domin.dto.SecretDto;
import com.teng.author.domin.entity.LoginUser;
import com.teng.author.domin.entity.Secret;
import com.teng.author.enums.AppHttpCodeEnum;
import com.teng.author.exception.SystemException;
import com.teng.author.mapper.AuthorMapper;
import com.teng.author.service.AuthorService;
import com.teng.author.util.AppUtils;
import com.teng.author.util.BeanCopyUtil;
import com.teng.author.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/12:52 Description:
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper,Secret> implements AuthorService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult create() {
        //生成appId
        String appId = AppUtils.getAppId();
        //生成appSecret
        String appSecret = AppUtils.getAppSecret(appId);
        Secret secret = new Secret();

        secret.setAppId(appId);
        secret.setAppSecret(appSecret);
        //存入数据库
        save(secret);
        //返回appId和appSecret
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("app_id",appId);
        resultMap.put("app_secret",appSecret);
        return ResponseResult.okResult(resultMap);
    }

    @Override
    public ResponseResult login(SecretDto secretDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secretDto.getApp_id(), secretDto.getApp_secret());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String app_id = loginUser.getSecret().getAppId();
        String jwt = JwtUtil.createJWT(app_id);
        return ResponseResult.okResult(jwt);
    }
}
