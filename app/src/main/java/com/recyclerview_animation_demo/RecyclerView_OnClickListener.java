package com.recyclerview_animation_demo;

import android.view.View;

/**
 * Created by SONU on 23/05/16.
 */
public interface RecyclerView_OnClickListener {
    /** Interface for Item Click over Recycler View Items **/
    public interface OnClickListener {
        public void OnItemClick(View view, int position);
    }
}
