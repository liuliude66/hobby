package com.forum.base.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forum.jobs.baseview.R;

/**
 * 2018/6/26.
 */

public class TopBarView extends RelativeLayout {

    private TextView mLeftTv, mTitleTv, mRightTv;

    private String leftTxt, titleTxt, rightTxt;

    public TopBarView(Context context) {
        this(context, null);
    }

    public TopBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBarView);
        leftTxt = ta.getString(R.styleable.TopBarView_textLeft);
        titleTxt = ta.getString(R.styleable.TopBarView_textTitle);
        rightTxt = ta.getString(R.styleable.TopBarView_textRight);
        ta.recycle();

        View layout = inflate(context, R.layout.bar_top,null);
        mLeftTv = layout.findViewById(R.id.tv_tpb_left);
        mTitleTv = layout.findViewById(R.id.tv_tpb_title);
        mRightTv = layout.findViewById(R.id.tv_tpb_right);

        mLeftTv.setText(leftTxt);
        mTitleTv.setText(titleTxt);
        mRightTv.setText(rightTxt);
    }

    public TextView getLeftView() {
        return mLeftTv;
    }

    public TextView getRightView() {
        return mRightTv;
    }

    public TextView getTitleView() {
        return mTitleTv;
    }
}
