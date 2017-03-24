package com.yang.bean;

import com.yang.base.BaseBean;
import com.yang.entity.BlogArticleEntity;

import java.util.ArrayList;

/**
 * Created by YangShuang
 * eon 2017/3/23.
 */
public class BlogListBean extends BaseBean{


    private ArrayList<BlogArticleEntity> list;

    public ArrayList<BlogArticleEntity> getList() {
        return list;
    }

    public void setList(ArrayList<BlogArticleEntity> list) {
        this.list = list;
    }

}
