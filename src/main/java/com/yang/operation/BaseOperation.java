package com.yang.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */
public abstract class BaseOperation {

   public abstract void operation(HttpServletRequest request, HttpServletResponse response);
}
