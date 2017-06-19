package com.duongame.viewpagerexample2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    private class PagerAdapter extends FragmentStatePagerAdapter {
        // Tab Titles
        private String tabtitles[] = new String[] { "Tab1", "Tab2", "Tab3", "Tab4", "Tab5" };

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 해당하는 page의 Fragment를 생성합니다.
            return PageFragment.create(position);
        }

        @Override
        public int getCount() {
            return 5;  // 총 5개의 page를 보여줍니다.
        }

        // PageTabStrip
        @Override
        public CharSequence getPageTitle(int position) {
            return tabtitles[position];
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }

}