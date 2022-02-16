package com.xfwa.taglib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * create by xfwa on 2022/2/16
 * description:
 */
public class TagView extends LinearLayout {
    private TagAdapter tagAdapter;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(HORIZONTAL);
    }

    /**
     * 设置tagView的方向，没有设置的话默认是横向摆放
     *
     * @param orientation Pass {@link #HORIZONTAL} or {@link #VERTICAL}. Default
     *                    value is {@link #HORIZONTAL}.
     */
    public void setTagOrientation(int orientation) {
        this.setOrientation(orientation);
    }

    /**
     * 设置tagLayout的适配器
     *
     * @param tagAdapter tagAdapter
     */
    public void setAdapter(TagAdapter tagAdapter) {
        this.tagAdapter = tagAdapter;
        if (tagAdapter == null) {
            throw new RuntimeException(this.getClass().getSimpleName() + "is null");
        }

        if (this.getChildCount() > 0) {
            this.removeAllViews();
        }

        //拿到tagView的数量
        int count = tagAdapter.getCount();

        for (int i = 0; i < count; i++) {
            //每个tagView的样式
            View view = tagAdapter.onCreateView(i);
            this.addView(view);
        }
    }

    /**
     * 获取TagView的数量
     *
     * @return TagView的数量
     */
    public int getItemCount() {
        return tagAdapter == null ? 0 : tagAdapter.getCount();
    }


}
