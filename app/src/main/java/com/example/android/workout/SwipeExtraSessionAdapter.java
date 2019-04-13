package com.example.android.workout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by Laurent Lee on 8/9/2017.
 */

public class SwipeExtraSessionAdapter extends FragmentPagerAdapter {
    private String[] fragments = {"Session One", "Session Two", "Session Three", "Session Four", "Session Five"};
    private ArrayList<Integer> sessionOneList, sessionTwoList, sessionThreeList, sessionFourList, sessionFiveList;

    public SwipeExtraSessionAdapter(FragmentManager fm, ArrayList<Integer> sOne, ArrayList<Integer> sTwo, ArrayList<Integer> sThree, ArrayList<Integer> sFour, ArrayList<Integer> sFive){
        super(fm);
        sessionOneList = sOne;
        sessionTwoList = sTwo;
        sessionThreeList = sThree;
        sessionFourList = sFour;
        sessionFiveList = sFive;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return Session.newInstance(sessionOneList);
        }
        else if (position==1){
            return Session.newInstance(sessionTwoList);
        }
        else if(position==2){
            return Session.newInstance(sessionThreeList);
        }
        else if(position==3){
            return Session.newInstance(sessionFourList);
        }
        else{
            return Session.newInstance(sessionFiveList);
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return fragments[position];
    }
}
