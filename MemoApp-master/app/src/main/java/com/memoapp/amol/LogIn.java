package com.memoapp.amol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {
    Button b1, b2;
    TextView t1, t2;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.btnLogin);
        b2 = findViewById(R.id.btnLinkToRegisterScreen);
        t1 = findViewById(R.id.email);
        t2 = findViewById(R.id.password);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
    }

    public void login(View v) {

        if (!Pattern.matches("^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$", email.getText().toString().trim())) {
            Toast.makeText(this, "Enter valid Email", Toast.LENGTH_SHORT).show();
        } else if (!Pattern.matches("^([a-zA-Z0-9@*#]{8,15})$", pass.getText().toString())) {
            Toast.makeText(this, "Enter valid Password", Toast.LENGTH_SHORT).show();
        } else if (t1.getText().toString().trim().equals("amol@gmail.com") && t2.getText().toString().trim().equals("Amol@123")) {
            Intent i = new Intent(this, Memo.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
        }
    }

    public void toRegister(View v) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }
}
