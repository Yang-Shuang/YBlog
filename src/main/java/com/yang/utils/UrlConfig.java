package com.yang.utils;

import com.yang.operation.BlogListOperation;

import java.util.HashMap;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */
public class UrlConfig {
    public static final HashMap<String,Class> mUrlMap = new HashMap<String, Class>();

    public static void initUrlMap(){
        mUrlMap.put("/yblog/getList", BlogListOperation.class);//获取文章列表
    }
}
