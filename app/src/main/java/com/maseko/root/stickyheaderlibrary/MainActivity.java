package com.maseko.root.stickyheaderlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    ArrayList<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        linearLayoutManager = new LinearLayoutManagerWithSmoothScroller(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));

        createPersonList();

        PersonAdapter personAdapter = new PersonAdapter(this, people);
        recyclerView.setAdapter(personAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Common.RESULT_CODE){
            if (resultCode == Activity.RESULT_OK){
                String group_character_clikced = data.getStringExtra("result");
                int position = Common.findPositionWithName(group_character_clikced, people);
                recyclerView.smoothScrollToPosition(position);
            }

        }
    }

    public void createPersonList(){
        people = Common.getPeopleGroup();
        people = Common.sortList(people);
        people = Common.addAlphabets(people);
    }
}
