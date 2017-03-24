package com.yang.operation;

import com.yang.bean.BlogListBean;
import com.yang.entity.BlogArticleEntity;
import com.yang.utils.CommonConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */


public class BlogListOperation extends BaseOperation{

    public void operation(HttpServletRequest request, HttpServletResponse response) {

        BlogListBean blogListBean = new BlogListBean();
        blogListBean.setErrorCode(CommonConfig.CODE.SUCCESS);
        blogListBean.setErrorMsg(CommonConfig.MSG.SUCCESS);
        BlogArticleEntity b = new BlogArticleEntity();
        b.setArticleId("46413611");
        b.setArticleTime("2015-06-08 15:43");
        b.setArticleTitle("Java泛型 类型变量的限定");
        b.setArticleContent("");
        ArrayList<BlogArticleEntity> blogListBeans = new ArrayList<BlogArticleEntity>();
        blogListBeans.add(b);
        blogListBean.setList(blogListBeans);

        returnThisMsg(response,blogListBean);
    }
}
