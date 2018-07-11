package com.forum.base.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forum.jobs.baseview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 2018/6/26.
 */

public class BottomBarView extends RelativeLayout {

    public TextView mNav1Tv, mNav2Tv, mNav3Tv, mNav4Tv, mNav5Tv;

    private String nav1Txt, nav2Txt, nav3Txt, nav4Txt, nav5Txt;

    private List<TextView> mNavTvs;

    public BottomBarView(Context context) {
        this(context, null);
    }

    public BottomBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BottomBarView);
        nav1Txt = ta.getString(R.styleable.BottomBarView_textNav1);
        nav2Txt = ta.getString(R.styleable.BottomBarView_textNav2);
        nav3Txt = ta.getString(R.styleable.BottomBarView_textNav3);
        nav4Txt = ta.getString(R.styleable.BottomBarView_textNav4);
        nav5Txt = ta.getString(R.styleable.BottomBarView_textNav5);
        ta.recycle();

        View layout = inflate(context, R.layout.bar_bottom,this);
        mNav1Tv = layout.findViewById(R.id.tv_nav1);
        mNav2Tv = layout.findViewById(R.id.tv_nav2);
        mNav3Tv = layout.findViewById(R.id.tv_nav3);
        mNav4Tv = layout.findViewById(R.id.tv_nav4);
        mNav5Tv = layout.findViewById(R.id.tv_nav5);

        mNav1Tv.setText(nav1Txt);
        mNav2Tv.setText(nav2Txt);
        mNav3Tv.setText(nav3Txt);
        mNav4Tv.setText(nav4Txt);
        mNav5Tv.setText(nav5Txt);

        mNavTvs = new ArrayList<>();
        mNavTvs.add(mNav1Tv);
        mNavTvs.add(mNav2Tv);
        mNavTvs.add(mNav3Tv);
        mNavTvs.add(mNav4Tv);
        mNavTvs.add(mNav5Tv);
    }

    public void setCurrent(int index){
        for (TextView tv : mNavTvs) {
            tv.setTextColor(getResources().getColor(R.color.tvGray));
        }
        mNavTvs.get(index).setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
