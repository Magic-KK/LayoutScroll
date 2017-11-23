package com.layoutscroll.layoutscrollcontrols.view;

import android.view.View;

/**
 * @name zk
 * @class name：接口
 * @time 2017-11-23 下午 2:14
 */

public class EasyLayoutListener {

    /**
     * 条目点击监听器
     */
    public interface OnItemClickListener {

        /**
         * @param pos  条目索引
         * @param view view
         */
        void onItemClick(int pos, View view);
    }

}
