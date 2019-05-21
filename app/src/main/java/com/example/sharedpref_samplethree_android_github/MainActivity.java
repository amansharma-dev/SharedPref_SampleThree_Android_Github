package com.example.sharedpref_samplethree_android_github;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2500;
    private ImageView splashImage;
    private PreferencesManager preferencesManager;

    private ConstraintLayout constraintLayout;
    private ViewPager viewPager;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashImage = findViewById(R.id.imageView_splash);
        constraintLayout = findViewById(R.id.onboard_layout);
        viewPager = findViewById(R.id.viewpager_onboard);
        button = findViewById(R.id.button_onboard);

        preferencesManager = new PreferencesManager(this);

        if(preferencesManager.FirstLaunch()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    splashImage.setVisibility(View.GONE);
                    constraintLayout.setVisibility(View.VISIBLE);
                    setUpOnBoardImages();
                }
            },SPLASH_TIME_OUT);
        }
        else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    launchHomeActivity();
                }
            },SPLASH_TIME_OUT);
        }
    }

    private void setUpOnBoardImages(){
        OnBoardImages_PagerAdapter onBoardImages_pagerAdapter = new OnBoardImages_PagerAdapter(this);
        viewPager.setAdapter(onBoardImages_pagerAdapter);

        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            if(i!=2){
                button.setVisibility(View.GONE);
            }
            else{
                button.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    public void launchHomeActivity(){
        preferencesManager.setFirstLaunch(false);
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void letsGoBtn(View view){
        launchHomeActivity();
    }
}
