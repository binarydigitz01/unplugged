package com.devsprint.unplugged;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.google.android.material.color.DynamicColors;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    ViewPager2 myViewPager2;
    private ScreenSlidePagerAdapter screenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager2 = findViewById(R.id.view_pager);
        screenAdapter = new ScreenSlidePagerAdapter(this);
        myViewPager2.setAdapter(screenAdapter);


        // Hiding the status bar
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        private static final int NUM_PAGES = 3;
        private ArrayList<Fragment> screens;
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
            screens = new ArrayList<Fragment>();
            screens.add(new HomeFragment());
            screens.add(new AppDrawerFragment());
            screens.add(new PersonalSpaceFragment());
        }

        // TODO Add More Screens Over here
        @Override
        public Fragment createFragment(int position) {
            return screens.get(position);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

}