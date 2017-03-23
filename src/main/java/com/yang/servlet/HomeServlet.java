package com.yang.servlet;

import com.yang.base.BaseServlet;
import com.yang.operation.BaseOperation;

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

    private static final int CODE_SUCCESS = 101;
    private static final int CODE_CLASS_NOT_FOUND = 102;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        operation(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void operation(HttpServletRequest request,HttpServletResponse response){
        String requestMethod = request.getServletPath().substring(1,request.getServletPath().length());

        String className = BaseOperation.class.getPackage()+"."+ requestMethod.substring(0,1).toUpperCase() + requestMethod.substring(1)+"Operation";

        try {
            Class<BaseOperation> operationClass = (Class<BaseOperation>) Class.forName(className);
            BaseOperation operation = operationClass.newInstance();
            operation.operation(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void returnNoClassFound(HttpServletResponse response){
        try {
            PrintWriter writer = setJsonContentType(response).getWriter();
            writer.print("");
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
