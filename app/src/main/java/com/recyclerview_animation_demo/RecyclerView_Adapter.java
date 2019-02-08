package com.recyclerview_animation_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.recyclerview_animation_demo.RecyclerView_OnClickListener.OnClickListener;

import java.util.ArrayList;

/**
 * Created by SONU on 23/05/16.
 */
public class RecyclerView_Adapter extends
        RecyclerView.Adapter<DemoViewHolder> {

    // recycler view adapter
    private ArrayList<String> arrayList;
    private Context context;

    private int clickType = 0;//Variable for changing action type on item click

    public RecyclerView_Adapter(Context context,
                                ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // This method will inflate the custom layout and return as view holder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.list_item_row, viewGroup, false);
        return new DemoViewHolder(mainGroup);

    }

    @Override
    public void onBindViewHolder(DemoViewHolder demoViewHolder, int i) {

        demoViewHolder.title.setBackgroundColor(GenerateRandom_Color.generateRandomColor());//setting background color of text view
        demoViewHolder.title.setText(arrayList.get(i));//set Text

        // Implement click listener over layout
        demoViewHolder.setClickListener(new OnClickListener() {

            @Override
            public void OnItemClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.row_item_text:
                        //On click type call respective method
                        switch (clickType) {
                            case 0:
                                addItem(position);
                                break;
                            case 1:
                                deleteItem(position);
                                break;
                            case 2:
                                changeItem(position);
                                break;
                        }

                        break;

                }
            }

        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    //Method to change current action type
    public void changeActionType(int position) {
        clickType = position;
    }


    //Delete item and notify item
    private void deleteItem(int position) {
        arrayList.remove(position);//remove from list
        notifyItemRemoved(position);//notify recycler view about item deletion
        Toast.makeText(context, "Item deleted successfully.", Toast.LENGTH_SHORT).show();//Toast
    }

    //Add item and notify item
    private void addItem(int position) {
        arrayList.add(position, "NEW ITEM " + position);//add item to list on selected position
        notifyItemInserted(position);//notify recycler view about item insertion
        Toast.makeText(context, "Item added successfully.", Toast.LENGTH_SHORT).show();//Toast
    }

    //Change item and notify item
    private void changeItem(int position) {
        arrayList.set(position, "ITEM CHANGE " + position);//changing item name for selected position
        notifyItemChanged(position);//notify recycler view about item change
        Toast.makeText(context, "Item changed successfully.", Toast.LENGTH_SHORT).show();//Toast
    }
}
