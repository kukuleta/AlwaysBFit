package com.example.alwaysbfit;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.alwaysbfit.ui.main.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Gain_muscles_tabbed extends AppCompatActivity {

    private static final String TAG = "Gain_muscles_tabbed";
    private SectionsPagerAdapter mSectionPageAdapter ;
    private ViewPager mViewPager;
    private FirebaseAuth fauth;
    private FirebaseAuth.AuthStateListener authstate;
    Button sign_out_button = findViewById(R.id.signOut);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        Log.d(TAG,"onCreate : Starting.");

        mSectionPageAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        sign_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fauth.signOut();
                startActivity(new Intent(Gain_muscles_tabbed.this,MainActivity.class));
                finish();


            }
        });


    }
    private void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GainMusclesTab1Fragment(),"DAY 1");
        adapter.addFragment(new GainMusclesTab2Fragment(),"DAY 2");
        adapter.addFragment(new GainMusclesTab3Fragment(),"DAY 3");
        viewPager.setAdapter(adapter);
    }
}