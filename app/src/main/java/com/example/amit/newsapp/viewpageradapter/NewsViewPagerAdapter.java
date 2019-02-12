package com.example.amit.newsapp.viewpageradapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.amit.newsapp.fragment.IndianExpressFragment;
import com.example.amit.newsapp.fragment.PIBNewsFragment;
import com.example.amit.newsapp.fragment.TheHinduFragment;

public class NewsViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragmentPageAdapter;
    public NewsViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentPageAdapter = new Fragment[]{new TheHinduFragment(),
                new IndianExpressFragment(), new PIBNewsFragment()};
    }

    @Override
    public Fragment getItem(int aPosition) {
        return  mFragmentPageAdapter[aPosition];
    }

    @Override
    public int getCount() {
        return mFragmentPageAdapter.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int aPosition) {
        String[] lPageTittle = new String[]{"The Hindu", "Indian Express", "Pib News"};
        return lPageTittle[aPosition];
    }
}
