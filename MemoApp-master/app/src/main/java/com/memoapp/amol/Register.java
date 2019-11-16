package com.memoapp.amol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    Button b1, b2;
    EditText name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        b1 = findViewById(R.id.btnRegister);
        b2 = findViewById(R.id.btnLinkToLoginScreen);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void toLogin(View v) {
        Intent i = new Intent(this, LogIn.class);
        startActivity(i);
    }

    public void register(View view) {
        if (!Pattern.matches("^[A-Za-z]+$", name.getText().toString().trim())) {
            Toast.makeText(this, "Enter valid Full Name", Toast.LENGTH_SHORT).show();
        } else if (!Pattern.matches("^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$", email.getText().toString().trim())) {
            Toast.makeText(this, "Enter valid Email", Toast.LENGTH_SHORT).show();
        } else if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})", password.getText().toString())) {
            Toast.makeText(this, "Enter valid Password", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");

            myRef.setValue("Hello, World!");
        }


    }
}
