package com.example.catchit;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PageViewAdapter extends FragmentPagerAdapter {

    public PageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new Fragment_list();
                break;
            case 1:
                fragment = new Fragment_about();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
