package com.yang.base;

import com.yang.bean.BlogListBean;
import com.yang.entity.BlogArticleEntity;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */
public class TestDataServer {

    public static final String[] title = {"WebSocket浅析","把《图解密码技术读薄》","Android 6.0 SSL","Android使用Socket对大文件进行加密传输","记录日志的原则","Retrofit+Rxjava+OkHttp链式封装","一张酷图帮你收集所有git命令"};

    public static ArrayList<BlogArticleEntity> getBlogListData(int count){
        ArrayList<BlogArticleEntity> beans = new ArrayList<BlogArticleEntity>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd hh:mm", Locale.getDefault());
        for (int i = 0;i < count ; i++){
            BlogArticleEntity bean = new BlogArticleEntity();
            bean.setArticleTitle(title[new Random().nextInt(title.length)]);
            bean.setArticleTime(format.format(new Date(System.currentTimeMillis())));
            beans.add(bean);
        }
        return beans;
    }
}
