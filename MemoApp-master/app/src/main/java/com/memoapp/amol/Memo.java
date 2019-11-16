package com.memoapp.amol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Memo extends AppCompatActivity {
    FloatingActionButton b;
    RecyclerView r1;
    String title[], body[];
    MemoAdapter ma;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        b = findViewById(R.id.fab);
        r1 = findViewById(R.id.Recycler);
        title = getResources().getStringArray(R.array.title);
        body = getResources().getStringArray(R.array.body);
        ma = new MemoAdapter(this, title, body);
        r1.setAdapter(ma);
        r1.setLayoutManager(new LinearLayoutManager(this));
//        if (savedInstanceState != null) {
//            Bundle b1 = getIntent().getExtras();
//            String s1 = b1.getString("title");
//            Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
//        }

    }

    public void createMemo(View v) {
        Intent i = new Intent(this, MemoCreate.class);
        startActivity(i);
    }


}
