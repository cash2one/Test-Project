package com.game.snda.gameassistant.widget;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;

import java.util.LinkedList;

/**
 * Created by zoubaolin on 15/10/9.
 */
public class MyFragmentTabHost extends FragmentTabHost {

    private static final String TAG = MyFragmentTabHost.class.getSimpleName();

    private LinkedList<Integer> mTabIndexStack = new LinkedList<>();

    public MyFragmentTabHost(Context context) {
        super(context);
    }

    public MyFragmentTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentTab(int index) {
        int location = mTabIndexStack.indexOf(index);
        if (location > 0) {
            mTabIndexStack.remove(location);
        }
        if (getTabWidget() != null) {
            mTabIndexStack.add(index);
        }
        super.setCurrentTab(index);
    }

    public boolean onBackPressed() {
        if (mTabIndexStack.size() > 0) {
            int location = mTabIndexStack.size() - 1;
            mTabIndexStack.remove(location);
            if (mTabIndexStack.size() > 0) {
                int index = mTabIndexStack.get(mTabIndexStack.size() - 1);
                super.setCurrentTab(index);
                return true;
            }
        }
        return false;
    }
}
