package com.bonjour.demo.test.common.utils;

import io.swagger.annotations.ApiModel;

import java.util.UUID;

/**
 * @authur tc
 * @date 2021/11/19 16:59
 */
@ApiModel("UUID工具类")
public class UuidUtil {

    /**
     * 生成UUID
     * @return
     */
    public static String getUUIDUpCase() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return uuid;
    }

    /**
     * 生成UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
