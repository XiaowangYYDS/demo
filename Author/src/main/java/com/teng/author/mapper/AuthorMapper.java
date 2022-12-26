package com.teng.author.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teng.author.domin.entity.Secret;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/12:53 Description:
 */
@Mapper
public interface AuthorMapper extends BaseMapper<Secret> {


    @Select("select * from secret where app_id=#{app_id}")
    Secret getByAppId(String app_id);
}
