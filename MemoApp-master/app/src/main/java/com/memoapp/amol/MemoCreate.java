package com.memoapp.amol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MemoCreate extends AppCompatActivity {
    EditText e1, e2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        e1 = findViewById(R.id.memoTitle);
        e2 = findViewById(R.id.body);
    }

    public void create(View v) {
        Intent i = new Intent(this, Memo.class);
        i.putExtra("title", e1.getText().toString());
        i.putExtra("body", e2.getText().toString());
        startActivity(i);
    }
}
