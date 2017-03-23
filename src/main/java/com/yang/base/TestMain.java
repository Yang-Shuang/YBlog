package com.yang.base;

import com.yang.bean.BlogListBean;

/**
 * Created by
 * YangShuang on 2017/3/23.
 */
public class TestMain {
    public static void main(String[] args){
        BlogListBean respose = new BlogListBean();
        respose.setErrorCode(101);
        respose.setErrorMsg("qqqqqqqq");
        respose.setTime(""+System.currentTimeMillis());
        respose.setA("aaaaaaaaaaaaaaaaa");
        try {
            respose.toJsonData();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
