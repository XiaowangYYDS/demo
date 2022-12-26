package com.teng.author.util;

import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/15:24 Description:
 */
public class BeanCopyUtil {

    public static <V> V singleBeanCopy(Object source, Class<V> clazz){
        V result = null;
        try {
            result = clazz.newInstance();
            BeanUtils.copyProperties(source,result);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
