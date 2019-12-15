package com.example.alwaysbfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewPasswordActivity extends AppCompatActivity {

    EditText phoneNumber;
    EditText newPassword;
    EditText newPasswordAgain;
    Button   done_button;
    ImageView logo_with_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_password);

        find_view_by_id();
        goLoginPage();
    }

    public void find_view_by_id(){

        phoneNumber      = findViewById(R.id.phoneNumber);
        newPassword      = findViewById(R.id.newPassword);
        newPasswordAgain = findViewById(R.id.new_password_again);
        done_button      = findViewById(R.id.doneButton);


    }

    public void goLoginPage(){

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNo     = phoneNumber.getText().toString();
                String newpassw    = newPassword.getText().toString();
                String newpasswagain = newPasswordAgain.getText().toString();

                if(TextUtils.isEmpty(phoneNo)){

                    Toast.makeText(NewPasswordActivity.this, "Şifreniz 8 karakter veya üstü olmalı..!", Toast.LENGTH_SHORT).show();

                }

                else{

                    Intent intent = new Intent(NewPasswordActivity.this,MainActivity.class);
                    startActivity(intent);

                }







            }
        });

    }
}
