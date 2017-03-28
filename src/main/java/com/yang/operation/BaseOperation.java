package com.yang.operation;

import com.yang.base.BaseBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */
public abstract class BaseOperation {


   public BaseOperation(){}

   public abstract void operation(HttpServletRequest request, HttpServletResponse response);

   protected void returnThisMsg(HttpServletResponse response, BaseBean baseBean){
      response.setContentType("text/plain;charset=utf-8");
      try {
         PrintWriter writer = response.getWriter();
         writer.print(JSONObject.fromObject(baseBean).toString());
         writer.flush();
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   protected void returnThisMsg(String contentType,HttpServletResponse response, BaseBean baseBean){
      response.setContentType(contentType);
   }
}