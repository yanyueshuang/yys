package com.itheruan.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 序列化json
 * @author 11137
 *
 */
public class JsonUtil {
    //序列化json对象
    public static void writeValue(Object obj, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(obj);
        //设置响应编码
        response.setContentType("application/json;charset=utf8");
        //发送给客户端
        mapper.writeValue(response.getWriter(), obj);
    }
}
