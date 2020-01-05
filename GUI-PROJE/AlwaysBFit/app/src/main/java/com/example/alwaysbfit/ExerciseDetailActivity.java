package com.example.alwaysbfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ExerciseDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        Exercise exercise = (Exercise) getIntent().getSerializableExtra("exercise");

        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        ExerciseDetailFragment df = ExerciseDetailFragment.newInstance(exercise);

        fts.add(R.id.container,df);
        fts.commit();
    }
}
