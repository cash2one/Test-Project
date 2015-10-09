package com.game.snda.gameassistant;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.game.snda.gameassistant.fragment.SinaFragment_;
import com.game.snda.gameassistant.fragment.SmsFragment_;
import com.game.snda.gameassistant.fragment.TencentFragment_;
import com.game.snda.gameassistant.fragment.WechatFragment_;
import com.game.snda.gameassistant.widget.MyFragmentTabHost;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zoubaolin on 15/10/9.
 */
@EActivity(R.layout.main_activity)
public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @ViewById(android.R.id.tabhost)
    MyFragmentTabHost tabHost;

    @AfterViews
    void init() {
        tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
        tabHost.addTab(tabHost.newTabSpec("Sina").setIndicator(createTab("新浪", R.drawable.sina_on)),
                SinaFragment_.class, null);
        tabHost.addTab(tabHost.newTabSpec("Sms").setIndicator(createTab("短信", R.drawable.sms_on)),
                SmsFragment_.class, null);
        tabHost.addTab(tabHost.newTabSpec("Tencent").setIndicator(createTab("腾讯", R.drawable.tx_on)),
                TencentFragment_.class, null);
        tabHost.addTab(tabHost.newTabSpec("Wechat").setIndicator(createTab("微信", R.drawable.wechat_on)),
                WechatFragment_.class, null);


    }

    private View createTab(String title, int imageId) {
        View tabView = this.getLayoutInflater().inflate(R.layout.tab_item_layout, tabHost, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        tabView.setLayoutParams(layoutParams);
        TextView tabTitle = (TextView) tabView.findViewById(R.id.tab_title);
        tabTitle.setText(title);
        ImageView tabImage = (ImageView) tabView.findViewById(R.id.tab_image);
        tabImage.setImageResource(imageId);
        return tabView;
    }

}
