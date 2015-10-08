package com.game.snda.gameassistant;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zoubaolin on 15/9/28.
 */
@EActivity(R.layout.activity_splash)
public class SplashScreenActivity extends BaseActivity {

    private final static String TAG = SplashScreenActivity.class.getSimpleName();

    private static long DELAY_TIME = 3000L;

    @ViewById
    LinearLayout llSplashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TextUtils.isEmpty(baseSharePerf.hasGuideShow().get())) {
            Toast.makeText(SplashScreenActivity.this, "splash", Toast.LENGTH_SHORT).show();
        }
        SplashTime();
    }

    private void SplashTime() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(R.anim.activity_zoom_enter, R.anim.activity_zoom_exit);
                GuideActivity_.intent(SplashScreenActivity.this).start();
                baseSharePerf.edit().hasGuideShow().put("true").apply();
                finish();
            }
        }, DELAY_TIME);
    }

}
