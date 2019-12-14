package com.example.alwaysbfit;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.alwaysbfit.ui.main.SectionsPagerAdapter;

public class Gain_muscles_tabbed extends AppCompatActivity {

    private static final String TAG = "Gain_muscles_tabbed";
    private SectionsPagerAdapter mSectionPageAdapter ;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weights_tabbed);
        Log.d(TAG,"onCreate : Starting.");

        mSectionPageAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }
    private void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GainMusclesTab1Fragment(),"DAY 1");
        adapter.addFragment(new GainMusclesTab2Fragment(),"DAY 2");
        adapter.addFragment(new GainMusclesTab3Fragment(),"DAY 3");
        viewPager.setAdapter(adapter);
    }
}