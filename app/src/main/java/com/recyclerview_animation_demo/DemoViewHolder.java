package com.recyclerview_animation_demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SONU on 23/05/16.
 */
public class DemoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private RecyclerView_OnClickListener.OnClickListener onClickListener;

    public TextView title;

    public DemoViewHolder(View view) {
        super(view);
        this.title = (TextView) view.findViewById(R.id.row_item_text);
        this.title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // set custom listener
        if (onClickListener != null) {
            onClickListener.OnItemClick(v, getAdapterPosition());

        }
    }

    // Setter for listener
    public void setClickListener(
            RecyclerView_OnClickListener.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}