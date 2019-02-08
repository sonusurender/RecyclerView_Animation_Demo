package com.recyclerview_animation_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView_Adapter adapter;
    private static RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);//find id of radio group
        setUpToolbar();
        setUpRecyclerView();
        onRadioButtonSelected();
    }

    //set up toolbar
    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //Set up recycler view with 20 items
    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
            arrayList.add("ITEM " + i);

        adapter = new RecyclerView_Adapter(MainActivity.this, arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recycler view

    }

    //on radio button selection listener
    private void onRadioButtonSelected() {
        // Implementing checked change listener on radio group
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Finding ID/Position of radio group child
                int pos = radio_group.indexOfChild(findViewById(checkedId));
                adapter.changeActionType(pos);//Change position in adapter class by passing current radio button position

            }

        });
    }

}
