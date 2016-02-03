package com.example.ningning.msetscoutapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * PagerAdapter: Represents each page (Auto, Teleop, Post) as a fragment,
 *               and situates them as tabs.
 * Created by Shannon on 1/29/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    // number of tabs
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }

    @Override
    public Fragment getItem(int position) {
        // first tab is the home tab. Displays that fragment
        if (position == 0) {
            return new Autonomous();
        }
        // next tab is the Manual tab. Displays that fragment
        if (position == 1) {
            return new Teleop();
        }
        // next tab is the Manual tab. Displays that fragment
        else {
            return new PostMatch();
        }

    }
}