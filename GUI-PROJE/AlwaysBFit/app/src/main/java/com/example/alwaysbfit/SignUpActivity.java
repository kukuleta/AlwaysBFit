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
    EditText Email;
    EditText Password;
    Button   register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        fAuth = FirebaseAuth.getInstance();
        Email        = findViewById(R.id.email);
        Password     = findViewById(R.id.password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email     = Email.getText().toString().trim();
                String password     = Password.getText().toString();

                if (isValidEmail(email))
                {
                    fAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "Non-valid credentials", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }});
                }
                  else{
                Toast.makeText(SignUpActivity.this, "Non-valid email", Toast.LENGTH_SHORT).show();
            }

            }
        });
    }

    /*Checks if given email is valid or not according to criteria.
     * Criteria : E-Mail can be made up of lowercase,uppercase,digits and followed by the sign @ and domain adress.
     * Input: String: i.e ismaildenizli@posta.mu.edu.tr
     * Output: Boolean: Validity of e-mail adress.
     * */
    public boolean isValidEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return (email.matches(emailPattern));
    }

    /*Checks if given input is valid or not according to criteria.
     * Criteria : User should provide a input rather than empty value.
     * Input: String: Username : kukuleta
     * Output: Boolean: Validity of input.
     * */
    public boolean isEntryEmpty(String input)
    {
        if(input==""){
            return true;
        }
        return false;
    }

    /*Checks if given input is valid or not according to criteria.
     * Criteria : Password should contain at least one uppercase letter,lowercase letter and digit. It also have to consist of at least eight characters.
     * Input: String: Username : oguzhanA17
     * Output: Boolean: Validity of input.
     * */
    public boolean is_password_valid(String password)
    {
        String password_pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?<=.{8,})";
        return (password.matches(password_pattern));
    }
}
