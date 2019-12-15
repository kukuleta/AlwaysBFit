package com.example.alwaysbfit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button   login_button;
    TextView forget_your_password;
    TextView register;
    ProgressBar progressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username             = findViewById(R.id.username);
        password             = findViewById(R.id.password);
        forget_your_password = findViewById(R.id.forget_your_passw);
        register             = findViewById(R.id.register);
        login_button         = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progressBar2);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName = username.getText().toString();
                String passw    = password.getText().toString();

                if(TextUtils.isEmpty(userName)){

                    Toast.makeText(MainActivity.this, "Lütfen geçerli kullanıcı adı giriniz...!", Toast.LENGTH_SHORT).show();

                }

                else if(password.length()<8){

                    Toast.makeText(MainActivity.this, "Şifreniz 8 karakter veya üstü olmalı..!", Toast.LENGTH_SHORT).show();

                }

                else{
                    GoChooseProgramPage();
                    progressBar.setVisibility(View.VISIBLE);

                }

            }
        });


        forget_your_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GoNewPasswordPage();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GoSignUpRegister();
            }
        });



    }


    public void GoChooseProgramPage(){

        Intent intent = new Intent(MainActivity.this,ChooseProgramActivity.class);
        intent.putExtra("name",username.getText().toString());
        startActivity(intent);

    }

    public void GoNewPasswordPage(){

        Intent intent = new Intent(MainActivity.this,NewPasswordActivity.class);
        startActivity(intent);
    }

    public void GoSignUpRegister(){

        Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}
