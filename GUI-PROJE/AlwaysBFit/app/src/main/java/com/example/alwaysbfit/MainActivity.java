package com.example.alwaysbfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button   login_button;
    TextView forget_your_password;
    TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username             = findViewById(R.id.username);
        password             = findViewById(R.id.password);
        forget_your_password = findViewById(R.id.forgetPassword);
        register             = findViewById(R.id.register);

        login_button         = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(MainActivity.this,ChooseProgramActivity.class);
                intent.putExtra("name",username.getText().toString());
                startActivity(intent);

            }
        });


    }





}
