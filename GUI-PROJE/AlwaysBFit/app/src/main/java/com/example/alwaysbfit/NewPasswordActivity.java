package com.example.alwaysbfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

        phoneNumber      = findViewById(R.id.phoneNumber);
        newPassword      = findViewById(R.id.email);
        newPasswordAgain = findViewById(R.id.email);
        done_button      = findViewById(R.id.doneButton);

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewPasswordActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}
