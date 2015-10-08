package com.game.snda.gameassistant;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game.snda.gameassistant.adapter.GuidePagerAdapter;
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
    ViewPager viewPager;
    @ViewById(R.id.circlePageIndicator)
    CirclePageIndicator circlePageIndicator;

    private GuidePagerAdapter pagerAdapter;
    private List<RelativeLayout> guideView;
    private LayoutInflater inflater;
    private TextView stepGuideTextView;

    @AfterViews
    void init() {
        Log.d(TAG, "zzz---init()");
        setActionBarText("Game Assistant");
        inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        initGuideViewLayout(inflater);
    }

    private void initGuideViewLayout(LayoutInflater inflater) {
        guideView = new ArrayList<>(0);
        RelativeLayout guide1 = (RelativeLayout) inflater.inflate(R.layout.new_guide_layout, null);
        ((ImageView) guide1.findViewById(R.id.iv_guide_view)).setImageResource(R.drawable.splash);
        ((TextView) guide1.findViewById(R.id.tv_guide_view)).setVisibility(View.GONE);
        guideView.add(guide1);

        RelativeLayout guide2 = (RelativeLayout) inflater.inflate(R.layout.new_guide_layout, null);
        ((ImageView) guide2.findViewById(R.id.iv_guide_view)).setImageResource(R.drawable.txz_step5);
        stepGuideTextView = (TextView)guide2.findViewById(R.id.tv_guide_view);
        stepGuideTextView.setVisibility(View.VISIBLE);
        guideView.add(guide2);

        stepGuideTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GuideActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

        pagerAdapter = new GuidePagerAdapter(guideView);
        viewPager.setAdapter(pagerAdapter);
        circlePageIndicator.setViewPager(viewPager, 0);
//        circlePageIndicator.setBackgroundColor(0xFFCCCCCC);
//        circlePageIndicator.setRadius(10 * density);
        circlePageIndicator.setPageColor(0x880000FF);
        circlePageIndicator.setFillColor(0xFF888888);
        circlePageIndicator.setStrokeColor(0xFF000000);
    }
}
