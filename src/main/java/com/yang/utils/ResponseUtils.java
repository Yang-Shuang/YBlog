package com.yang.utils;

import com.yang.base.BaseBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YangShuang
 * on 2017/3/29.
 */
public class ResponseUtils {

    public static void sendMsg(HttpServletResponse response,String msg){
        try {
            response.setContentType("text/plain;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendErrorMsgJson(HttpServletResponse response,String code, String msg){
        BaseBean baseBean = new BaseBean(code,msg);
        sendMsg(response,JSONObject.fromObject(baseBean).toString());
    }
}
