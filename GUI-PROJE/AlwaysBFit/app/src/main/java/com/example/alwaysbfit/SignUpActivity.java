package com.example.alwaysbfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth fAuth;
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
        fAuth = FirebaseAuth.getInstance();
        fullname     = findViewById(R.id.fullName);
        username     = findViewById(R.id.username);
        email        = findViewById(R.id.email);
        password     = findViewById(R.id.password);
        phone_number = findViewById(R.id.phone);
        height       = findViewById(R.id.height);
        weight       = findViewById(R.id.weight);
        register     = findViewById(R.id.register_button);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullnamee = fullname.getText().toString();
                String userName  = username.getText().toString();
                String eMail     = email.getText().toString();
                String passw     = password.getText().toString();
                String phoneN    = phone_number.getText().toString();
                String heightt   = height.getText().toString();
                String weightt   = weight.getText().toString();

                String[] inputs = {fullnamee,userName,eMail,passw,phoneN,heightt,weightt};

                for(int i=0;i<inputs.length;i++) {

                    if (TextUtils.isEmpty(inputs[i])) {

                        Toast.makeText(SignUpActivity.this, "Lütfen boş alan bırakmayınız..!", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    fAuth.createUserWithEmailAndPassword(eMail, passw)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "Non-valid credentials", Toast.LENGTH_SHORT).show();
                                    } else {
                                        goLoginPage();
                                    }
                                }
                            });
                }
            }
        });


    }


    public void goLoginPage(){

                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);

    }
}
