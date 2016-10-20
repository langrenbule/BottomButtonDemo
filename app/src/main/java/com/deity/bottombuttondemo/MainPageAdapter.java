package com.deity.bottombuttondemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Deity on 2016/10/20.
 */

public class MainPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<Fragment> mFragments){
        this.mFragments = mFragments;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        if (null==mFragments) return 0;
        return mFragments.size();
    }
}
