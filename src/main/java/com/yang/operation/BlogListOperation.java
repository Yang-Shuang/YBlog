package com.yang.operation;

import com.yang.bean.BlogListBean;
import com.yang.utils.CommonConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */


public class BlogListOperation extends BaseOperation{

    public void operation(HttpServletRequest request, HttpServletResponse response) {

        BlogListBean blogListBean = new BlogListBean();
        blogListBean.setErrorCode(CommonConfig.CODE.SUCCESS);
        blogListBean.setErrorMsg(CommonConfig.MSG.SUCCESS);
        blogListBean.setTime(""+System.currentTimeMillis());

        returnThisMsg(response,blogListBean);
    }
}
