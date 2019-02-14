package com.example.amit.newsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.amit.newsapp.R;
import com.example.amit.newsapp.viewpageradapter.NewsViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    public final String Tag = "MainActivity";
    public NewsViewPagerAdapter mNViewPagerAdapter;
    /*public FloatingActionButton mFab;
    public FloatingActionButton mFab1;
    public FloatingActionButton mFab2;
    public FloatingActionButton mFab3;
    public Animation show_fab_1;
    public Animation hide_fab_1;
    public Animation show_fab_2;
    public Animation hide_fab_2;
    public Animation show_fab_3;
    public Animation hide_fab_3;

    public boolean isFabExpanded = false;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_main);
        ViewPager lViewPager = findViewById(R.id.view_pager);
        mNViewPagerAdapter = new NewsViewPagerAdapter(getSupportFragmentManager());
        lViewPager.setAdapter(mNViewPagerAdapter);

        TabLayout lTabLayout = (TabLayout) findViewById(R.id.new_tab_layout);
        lTabLayout.setupWithViewPager(lViewPager);
        lTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.daynight_bottombar));
        Toolbar lToolbar = findViewById(R.id.toolbar);

        lToolbar.setTitle("@News Stuff");
        lToolbar.setLogo(R.drawable.news);
//        setSupportActionBar(lToolbar);

       /* mFab = findViewById(R.id.fab);
        mFab1 = findViewById(R.id.fab_1);
        mFab2 = findViewById(R.id.fab_2);
        mFab3 = findViewById(R.id.fab_3);

        show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
        hide_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_hide);
        show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);
        hide_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_hide);*/

      /* mFab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.w("MainActivity", "click on Fab: ");
               if (!isFabExpanded){
                   openExpandFab();
                   isFabExpanded = true;
               }else {
                   closeFabInvisible();
                   isFabExpanded = false;
               }
           }
       });

       mFab1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.w(Tag,"OnClick Fa1");
               Fragment lIntelligenceFragment = new IndianExpressFragment();

               FragmentTransaction lFrahmentTransaction = getSupportFragmentManager().beginTransaction();
               lFrahmentTransaction.setCustomAnimations(
                        R.anim.slide_up, R.anim.slide_down, R.anim.slide_up, R.anim.slide_down);
               lFrahmentTransaction.replace(R.id.activity_main_layout, lIntelligenceFragment);
               lFrahmentTransaction.addToBackStack(lIntelligenceFragment.getTag());
               lFrahmentTransaction.commit();
           }
       });*/
    }

    /*public final void openExpandFab(){
        //Floating Action Button 1
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mFab1.getLayoutParams();
        layoutParams.leftMargin += (int) (mFab1.getWidth() * 1.7);
        Log.w(Tag,"Fab Margin: "+layoutParams.leftMargin);
        layoutParams.bottomMargin += (int) (mFab1.getHeight() * 1.5);
        Log.w(Tag,"Fab Margin: "+layoutParams.bottomMargin);
        mFab1.setLayoutParams(layoutParams);
        mFab1.startAnimation(show_fab_1);
        mFab1.setClickable(true);

        //Floating Action Button 2
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) mFab2.getLayoutParams();
        layoutParams2.rightMargin += (int) (mFab2.getWidth() * 1.7);
        layoutParams2.bottomMargin += (int) (mFab2.getHeight() * 1.5);
        mFab2.setLayoutParams(layoutParams2);
        mFab2.startAnimation(show_fab_2);
        mFab2.setClickable(true);

        //Floating Action Button 3
        final FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) mFab3.getLayoutParams();
        layoutParams3.topMargin += (int) (mFab3.getWidth() * 0.25);
        layoutParams3.bottomMargin += (int) (mFab3.getHeight() * 2.7);
        mFab3.setLayoutParams(layoutParams3);
        mFab3.startAnimation(show_fab_3);
        mFab3.setClickable(true);
    }

    public final void closeFabInvisible(){
        //Floating Action Button 1
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mFab1.getLayoutParams();
        layoutParams.leftMargin -= (int) (mFab1.getWidth() * 1.5);
        layoutParams.bottomMargin -= (int) (mFab1.getHeight() * 1.5);
        mFab1.setLayoutParams(layoutParams);
        mFab1.startAnimation(hide_fab_1);
        mFab1.setClickable(false);

        //Floating Action Button 2
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) mFab2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (mFab2.getWidth() * 1.5);
        layoutParams2.bottomMargin -= (int) (mFab2.getHeight() * 1.5);
        mFab2.setLayoutParams(layoutParams2);
        mFab2.startAnimation(hide_fab_2);
        mFab2.setClickable(false);

        //Floating Action Button 3
        final FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) mFab3.getLayoutParams();
        layoutParams3.topMargin -= (int) (mFab3.getWidth() * 0.25);
        layoutParams3.bottomMargin -= (int) (mFab3.getHeight() * 2.7);
        mFab3.setLayoutParams(layoutParams3);
        mFab3.startAnimation(hide_fab_3);
        mFab3.setClickable(false);
    }*/
}
