package com.example.tagview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xfwa.taglib.TagAdapter;
import com.xfwa.taglib.TagView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final List<String> testData = new ArrayList<>();

    {
        testData.add("德玛西亚皇子");
        testData.add("瑞文");
        testData.add("德莱文");
        testData.add("德莱厄斯");
        testData.add("法外狂徒张三");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TagView tagView = this.findViewById(R.id.tag_view);
        tagView.setAdapter(new TagAdapter() {
            @Override
            public View onCreateView(int position) {
                return getView(position);
            }

            @Override
            public int getCount() {
                return testData == null ? 0 : testData.size();
            }
        });
    }

    private TextView getView(int position) {
        TextView textView = new TextView(this);
        textView.setPadding(dp2px(5), dp2px(2), dp2px(5), dp2px(2));
        textView.setIncludeFontPadding(false);
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_goods_flag));
        textView.setTextColor(Color.parseColor("#FE4824"));
        textView.setTextSize(15);
        textView.setGravity(Gravity.CENTER);
        String tag = testData.get(position);
        textView.setText(tag);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.rightMargin = sp2px(5);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static int sp2px(final float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}