package com.teng.author.controller;

import com.teng.author.domin.ResponseResult;
import com.teng.author.domin.dto.SecretDto;
import com.teng.author.service.AuthorService;
import com.teng.author.util.RedisCache;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/12:51 Description:
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Resource
    private AuthorService authorService;

    @Resource
    private RedisCache redisCache;

    @PostMapping("/create")
    public ResponseResult createSecret(){

        ResponseResult result = authorService.create();
        return result;
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody SecretDto secretDto){
        ResponseResult result = authorService.login(secretDto);
        return result;
    }


}
