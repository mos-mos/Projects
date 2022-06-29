package com.construction.utils;

import java.util.UUID;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
public class UUIDUtils {

    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
