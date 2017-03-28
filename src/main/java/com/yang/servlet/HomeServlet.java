package com.yang.servlet;

import com.yang.base.BaseBean;
import com.yang.base.BaseServlet;
import com.yang.operation.BaseOperation;
import com.yang.utils.CommonConfig;
import com.yang.utils.UrlConfig;
import net.sf.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        operation(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        operation(req,resp);
    }

    private void operation(HttpServletRequest request,HttpServletResponse response){
        String requestMethod = request.getRequestURI();

        try {
            Class c = UrlConfig.mUrlMap.get(requestMethod);
            if(c == null)returnNoClassFound(response);
            BaseOperation operation = (BaseOperation) UrlConfig.mUrlMap.get(requestMethod).newInstance();
            operation.operation(request,response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void returnNoClassFound(HttpServletResponse response){
        try {
            PrintWriter writer = setJsonContentType(response).getWriter();
            BaseBean baseBean = new BaseBean(CommonConfig.CODE.ERROR_NO_CLASS,CommonConfig.MSG.ERROR_NO_CLASS);
            writer.print(JSONObject.fromObject(baseBean).toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpServletResponse setJsonContentType(HttpServletResponse response){
        response.setContentType("text/javascript");
        return response;
    }
}
