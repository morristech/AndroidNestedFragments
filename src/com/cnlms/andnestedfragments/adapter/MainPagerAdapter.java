package com.cnlms.andnestedfragments.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.cnlms.andnestedfragments.ui.fragments.FragParent;
import com.cnlms.andnestedfragments.ui.fragments.FragWrapper;

/**
 * Author: Can Elmas <can.elmas@pozitron.com>
 * Date: 1/14/13 11:15 AM
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_OF_PAGE = 2;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return position == 0 ?
                FragParent.getInstance() :
                FragWrapper.getInstance();

    }

    @Override
    public int getCount() {
        return NUM_OF_PAGE;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return position == 0 ? "A" : "B";

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        super.destroyItem(container, position, object);

        ((Fragment) object).getChildFragmentManager()
                .beginTransaction()
                .remove(((Fragment) object))
                .commit();

    }
}