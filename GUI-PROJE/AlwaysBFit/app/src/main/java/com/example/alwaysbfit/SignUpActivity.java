package com.example.alwaysbfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText fullname;
    EditText username;
    EditText email;
    EditText password;
    EditText phone_number;
    EditText height;
    EditText weight;
    Button   register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        fullname     = findViewById(R.id.fullName);
        username     = findViewById(R.id.username);
        email        = findViewById(R.id.email);
        password     = findViewById(R.id.password);
        phone_number = findViewById(R.id.phoneNumber);
        height       = findViewById(R.id.height);
        weight       = findViewById(R.id.weight);
        register     = findViewById(R.id.register_button);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });

    }
}
