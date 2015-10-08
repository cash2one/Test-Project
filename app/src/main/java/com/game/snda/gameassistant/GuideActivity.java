package com.game.snda.gameassistant;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoubaolin on 15/9/25.
 */

@EActivity(R.layout.activity_guide)
public class GuideActivity extends BaseActivity {
    private final static String TAG = BaseActivity.class.getSimpleName();

    @ViewById(R.id.vp_guide)
    ViewPager vp_guide;
    @ViewById(R.id.circlePageIndicator)
    CirclePageIndicator circlePageIndicator;
    @ViewById(R.id.iv_guide_view)
    ImageView guideImageView;
    @ViewById(R.id.tv_guide_view)
    TextView guideTextView;


    private List<View> guideView;
    private LayoutInflater inflater;

    @AfterViews
    void init() {
        Log.d(TAG, "zzz---init()");
        setActionBarText("Game Assistant");
        inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        initGuideViewLayout(inflater);
    }

    private void initGuideViewLayout(LayoutInflater inflater) {
        guideView = new ArrayList<>(0);
        View guide1 = inflater.inflate(R.layout.new_guide_layout, null);
        guideImageView.setImageResource(R.drawable.splash);
        guideImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        guideTextView.setVisibility(View.GONE);
        guideView.add(guide1);

        View guide2 = inflater.inflate(R.layout.new_guide_layout, null);
        guideImageView.setImageResource(R.drawable.txz_step5);
        guideImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        guideView.add(guide2);
    }
}
