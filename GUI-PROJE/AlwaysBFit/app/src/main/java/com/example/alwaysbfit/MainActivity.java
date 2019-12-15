package com.example.alwaysbfit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button   login_button;
    TextView forget_your_password;
    TextView register;
    ProgressBar progressBar;
    private FirebaseAuth fAuth;
    private static final int RC_SIGN_IN = 1001;



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
        fAuth = FirebaseAuth.getInstance();
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString();
                final String passw = password.getText().toString();

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(MainActivity.this, "Lütfen geçerli kullanıcı adı giriniz...!", Toast.LENGTH_SHORT).show();
                    return;
                }


                else if(password.length()<8){


                    Toast.makeText(MainActivity.this, "Şifreniz 8 karakter veya üstü olmalı..!", Toast.LENGTH_SHORT).show();
                    return;


                }

                fAuth.signInWithEmailAndPassword(email, passw)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(MainActivity.this, ChooseProgramActivity.class));
                                } else {
                                    Log.e("Giriş hatalı gerçekleşti.Tekrar Deneyin", task.getException().getMessage());
                                }
                            }
                        });
            }});



            forget_your_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewPasswordActivity.class));
                /*GoNewPasswordPage();*/

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                /*GoSignUpRegister();*/
            }
        });



    }

    /*public void signInIntent() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build());

        // Create and launch sign-in intent

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                //What to do if sign-in failed should be included here.
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }*(
     */
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
