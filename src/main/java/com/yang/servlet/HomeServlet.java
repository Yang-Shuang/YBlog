package com.yang.servlet;

import com.yang.base.BaseServlet;
import com.yang.operation.BaseOperation;
import com.yang.utils.CommonConfig;
import com.yang.utils.ResponseUtils;
import com.yang.utils.UrlConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */
public class HomeServlet extends BaseServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        UrlConfig.initUrlMap();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResponseUtils.sendErrorMsgJson(resp,CommonConfig.CODE.ERROR_UNSUPPORT_METHOD,CommonConfig.MSG.ERROR_UNSUPPORT_METHOD);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(getContent(req));
        operation(req,resp);
    }

    private void operation(HttpServletRequest request,HttpServletResponse response){
        String requestMethod = request.getRequestURI();

        try {
            Class c = UrlConfig.mUrlMap.get(requestMethod);
            if(c == null) ResponseUtils.sendErrorMsgJson(response,CommonConfig.CODE.ERROR_NO_CLASS,CommonConfig.MSG.ERROR_NO_CLASS);
            BaseOperation operation = (BaseOperation) UrlConfig.mUrlMap.get(requestMethod).newInstance();
            operation.operation(request,response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String getContent(HttpServletRequest request){
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jb.toString();
    }


}
