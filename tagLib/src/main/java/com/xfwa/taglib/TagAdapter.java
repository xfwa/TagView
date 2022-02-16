package com.xfwa.taglib;

import android.view.View;

/**
 * create by xfwa on 2022/2/16
 * description:
 */
public abstract class TagAdapter {

    /**
     * 获取tagView的样式
     *
     * @return tagView的样式
     */
    public abstract View onCreateView(int position);

    /**
     * 获取tagView的数量
     *
     * @return tagView的数量
     */
    public abstract int getCount();

}
