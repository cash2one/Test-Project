package com.game.snda.gameassistant;

import android.support.v4.view.ViewPager;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zoubaolin on 15/9/25.
 */

@EActivity(R.layout.activity_guide)
public class GuideActivity extends BaseActivity {
    private final static String TAG = BaseActivity.class.getSimpleName();

    @ViewById(R.id.vp_guide)
    ViewPager vp_guide;

    @AfterViews
    void init() {
        Log.d(TAG, "zzz---init()");
        setActionBarText("Game Assistant");
    }

}
