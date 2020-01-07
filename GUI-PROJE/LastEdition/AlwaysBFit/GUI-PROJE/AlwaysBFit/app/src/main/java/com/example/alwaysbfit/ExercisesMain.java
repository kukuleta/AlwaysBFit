package com.example.alwaysbfit;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ExercisesMain extends AppCompatActivity implements  ExerciseFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_main);
    }

    @Override
    public void exerciseSelector(Exercise item) {


        int display_mode = getResources().getConfiguration().orientation;

        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {

            Intent intent = new Intent(this, ExerciseDetailActivity.class);
            intent.putExtra("movie", (Parcelable) item);
            startActivity(intent);
        }else {
            ExerciseDetailFragment df = (ExerciseDetailFragment) getSupportFragmentManager().findFragmentByTag("details");

            if (df ==  null) {
                FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                df = ExerciseDetailFragment.newInstance(item);
                fts.add(R.id.container, df, "details");
                fts.commit();
            }else {

                df.setMovie(item, findViewById(R.id.container));
            }
        }

    }
}
