package com.game.snda.gameassistant.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoubaolin on 15/10/8.
 */
public class GuidePagerAdapter extends PagerAdapter {

    private final static String TAG = GuidePagerAdapter.class.getSimpleName();

    private List<RelativeLayout> mViewPagerList;

    public GuidePagerAdapter(List<RelativeLayout> mList) {
        if (mViewPagerList == null) {
            mViewPagerList = new ArrayList<>(0);
        }
        mViewPagerList = mList;
    }

    @Override
    public int getCount() {
        return mViewPagerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewPagerList.get(position));
        return mViewPagerList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewPagerList.get(position));
    }
}
