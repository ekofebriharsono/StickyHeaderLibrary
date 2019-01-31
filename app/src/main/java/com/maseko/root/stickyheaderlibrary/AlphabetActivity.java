package com.maseko.root.stickyheaderlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AlphabetActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        recyclerView = findViewById(R.id.recycleview);
        AlphabetAdabter alphabetAdabter = new AlphabetAdabter();
        alphabetAdabter.setiOnAlphabetClickListener(new IOnAlphabetClickListener() {
            @Override
            public void onAlphabetCLickListener(String alphabet, int position) {
                if (position != -1){
                    Intent intent = new Intent();
                    intent.putExtra("result",alphabet);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(alphabetAdabter);

    }
}
