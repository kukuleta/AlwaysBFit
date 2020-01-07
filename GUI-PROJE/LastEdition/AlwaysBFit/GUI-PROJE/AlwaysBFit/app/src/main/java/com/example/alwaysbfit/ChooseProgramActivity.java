package com.example.alwaysbfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChooseProgramActivity extends AppCompatActivity {

    private FirebaseAuth fauth;
    private FirebaseAuth.AuthStateListener authstate;
    TextView welcoming;
    TextView exercise_details;
    Button lose_weights;
    Button gain_muscles;
    Button cardio;
    Button sign_out_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_program);


        finding_view_by_id();
        welcoming_message();
        goLoseWeightsPage();
        goGainMusclesPage();
        goCardioPage();
        goExerciseDetailsPage();
        fauth = FirebaseAuth.getInstance();
        authstate = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user==null){

                    startActivity(new Intent(ChooseProgramActivity.this,MainActivity.class));
                    finish();


                }
            }

        };
        sign_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fauth.signOut();
                startActivity(new Intent(ChooseProgramActivity.this,MainActivity.class));
                finish();


            }
        });

    }


    public void finding_view_by_id(){

        lose_weights = findViewById(R.id.lose_weights_button);
        gain_muscles = findViewById(R.id.gain_muscles_button);
        cardio       = findViewById(R.id.cardio_button);
        welcoming    = findViewById(R.id.welcoming);
        sign_out_button = findViewById(R.id.signOut);
        exercise_details = findViewById(R.id.exercise_details);

    }

    public void goLoseWeightsPage(){

        lose_weights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseProgramActivity.this,Lose_weights_tabbed.class);
                startActivity(intent);
            }
        });

    }

    public void goGainMusclesPage(){

        gain_muscles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseProgramActivity.this,Gain_muscles_tabbed.class);
                startActivity(intent);



            }
        });
    }

    public void goCardioPage(){

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ChooseProgramActivity.this,Gain_Strength_tabbed.class));


            }
        });

    }

    public void welcoming_message(){

        Intent intent = getIntent();
        String username = "Welcome    " + intent.getStringExtra("name");
        welcoming.setText(username);
    }

    public void goExerciseDetailsPage(){

        exercise_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ChooseProgramActivity.this,ExercisesMain.class));
            }
        });

    }

}
