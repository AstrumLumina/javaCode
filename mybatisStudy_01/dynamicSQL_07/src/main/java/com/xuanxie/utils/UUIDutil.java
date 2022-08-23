package com.xuanxie.utils;

import java.util.UUID;

public class UUIDutil {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return  UUID.randomUUID().toString().replaceAll("-","");
    }
}
