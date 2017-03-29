package com.yang.operation;

import com.yang.base.TestDataServer;
import com.yang.bean.BlogListBean;
import com.yang.entity.BlogArticleEntity;
import com.yang.utils.CommonConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */


public class BlogListOperation extends BaseOperation{

    public void operation(HttpServletRequest request, HttpServletResponse response) {

        BlogListBean blogListBean = new BlogListBean();
        blogListBean.setErrorCode(CommonConfig.CODE.SUCCESS);
        blogListBean.setErrorMsg(CommonConfig.MSG.SUCCESS);

        ArrayList<BlogArticleEntity> blogListBeans = TestDataServer.getBlogListData(20);

        blogListBean.setList(blogListBeans);
        response.setHeader("s","s1");
        returnThisMsg(response,blogListBean);
    }
}
