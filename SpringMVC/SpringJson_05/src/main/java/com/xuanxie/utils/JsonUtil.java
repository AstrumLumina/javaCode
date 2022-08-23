package com.xuanxie.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtil {
    public static String getJson(Object object,String datePatter) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePatter);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper.writeValueAsString(object);
    }
    public static String getJson(Object object) throws JsonProcessingException {
        String defaultDateFormat="yyyy-MM-dd HH:mm:ss";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultDateFormat);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper.writeValueAsString(object);
    }

}
