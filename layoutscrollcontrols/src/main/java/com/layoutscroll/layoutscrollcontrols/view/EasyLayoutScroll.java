package com.layoutscroll.layoutscrollcontrols.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;

import com.layoutscroll.layoutscrollcontrols.R;

import java.util.List;

/**
 * @name zk
 * @class name：{@link EasyLayoutScroll}  自定义布局上下滚动器
 * @time 2017-11-23 上午 11:29
 */

public class EasyLayoutScroll extends ViewFlipper {

    /**
     * 默认切换间隔时间
     */
    private int mInterval = 1000;

    /**
     * 动画执行时间
     */
    private int mDuration = 2000;

    /**
     * 是否设置默认动画渐变效果
     */
    private boolean mGradient = true;

    private EasyLayoutListener.OnItemClickListener onItemClickListener;


    /**
     * 条目点击监听器
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(EasyLayoutListener.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public EasyLayoutScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }


    /**
     * 初始化参数
     *
     * @param context
     * @param attrs
     * @param i
     */
    private void init(Context context, AttributeSet attrs, int i) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EasyLayoutScroll, i, 0);
        //设置切换间隔时间
        mInterval = ta.getInteger(R.styleable.EasyLayoutScroll_interval, this.mInterval);
        //设置动画执行时间
        mDuration = ta.getInteger(R.styleable.EasyLayoutScroll_duration, this.mDuration);
        //设置是否动画渐变效果
        mGradient = ta.getBoolean(R.styleable.EasyLayoutScroll_gradient, this.mGradient);
        initAnimation();
    }


    /**
     * 初始化动画
     */
    private void initAnimation() {
        //入场渐变
        AlphaAnimation animationIn = new AlphaAnimation(0.0F, 1.0F);
        animationIn.setDuration((long) mDuration);

        //出场渐变
        AlphaAnimation animationOut = new AlphaAnimation(1.0F, 0.0F);
        animationOut.setDuration((long) mDuration);

        //设置动画执行
        TranslateAnimation translateAnimationIn = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        TranslateAnimation translateAnimationOut = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
        translateAnimationIn.setDuration((long) this.mDuration);
        translateAnimationOut.setDuration((long) this.mDuration);


        AnimationSet animationInSet = new AnimationSet(false);
        animationInSet.addAnimation(translateAnimationIn);
        AnimationSet animationOutSet = new AnimationSet(false);
        animationOutSet.addAnimation(translateAnimationOut);

        if (mGradient) {
            animationInSet.addAnimation(animationIn);
            animationOutSet.addAnimation(animationOut);
        }

        this.setInAnimation(animationInSet);
        this.setOutAnimation(animationOutSet);
    }


    int i = 0;

    /**
     * 设置动态多布局
     */
    public void setEasyViews(final List<View> views) {
        i = 0;
        if (views != null && views.size() > 0) {
            removeAllViews();
            for (i = 0; i < views.size(); i++) {
                //设置点击标记
                views.get(i).setTag(i);
                views.get(i).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onItemClickListener != null) {
                            //取出view标记
                            int onClickPos = (int) view.getTag();
                            onItemClickListener.onItemClick(onClickPos, views.get(onClickPos));
                        }
                    }
                });
                addView(views.get(i));
            }
        }
    }


    /**
     * 停止滚动
     */
    public void stopScroll() {
        stopFlipping();
    }


    /**
     * 开始滚动
     */
    public void startScroll() {
        startFlipping();
    }


}
