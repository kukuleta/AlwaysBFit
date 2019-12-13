package com.example.alwaysbfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChooseProgramActivity extends AppCompatActivity {

    TextView welcoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_program);

        welcoming = findViewById(R.id.welcoming);

        Intent intent = getIntent();

        String username = "Welcome    " + intent.getStringExtra("name");
        welcoming.setText(username);
    }
}
