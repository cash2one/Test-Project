package com.game.snda.gameassistant;

import android.graphics.drawable.StateListDrawable;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoubaolin on 15/10/9.
 */
@EActivity(R.layout.main_activity)
public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<StateListDrawable> drawablesList = new ArrayList<>();

    @ViewById(android.R.id.tabhost)
    MyFragmentTabHost tabHost;

    @AfterViews
    void init() {
        createDrawableState();
        tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
        tabHost.addTab(tabHost.newTabSpec("Sina").setIndicator(createTab("新浪", drawablesList.get(0))),
                SinaFragment_.class, null);
        tabHost.addTab(tabHost.newTabSpec("Sms").setIndicator(createTab("短信", drawablesList.get(1))),
                SmsFragment_.class, null);
        tabHost.addTab(tabHost.newTabSpec("Tencent").setIndicator(createTab("腾讯", drawablesList.get(2))),
                TencentFragment_.class, null);
        tabHost.addTab(tabHost.newTabSpec("Wechat").setIndicator(createTab("微信", drawablesList.get(3))),
                WechatFragment_.class, null);


    }

    private View createTab(String title, StateListDrawable drawable) {
        View tabView = this.getLayoutInflater().inflate(R.layout.tab_item_layout, tabHost, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        tabView.setLayoutParams(layoutParams);
        TextView tabTitle = (TextView) tabView.findViewById(R.id.tab_title);
        tabTitle.setText(title);
        ImageView tabImage = (ImageView) tabView.findViewById(R.id.tab_image);
        tabImage.setImageDrawable(drawable);
        return tabView;
    }

    private List<StateListDrawable> createDrawableState() {
        StateListDrawable sinaDrawable = new StateListDrawable();
        StateListDrawable smsDrawable = new StateListDrawable();
        StateListDrawable tencentDrawable = new StateListDrawable();
        StateListDrawable wechatDrawable = new StateListDrawable();
        // no focus state
        sinaDrawable.addState(new int[]{-android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sina_off));
        sinaDrawable.addState(new int[]{-android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sina_on));
        // focus state
        sinaDrawable.addState(new int[]{android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sina_on));
        sinaDrawable.addState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sina_on));
        // press
        sinaDrawable.addState(new int[]{android.R.attr.state_selected, android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sina_on));
        sinaDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sina_on));
        drawablesList.add(sinaDrawable);

        smsDrawable.addState(new int[]{-android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sms_off));
        smsDrawable.addState(new int[]{-android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sms_on));
        // focus state
        smsDrawable.addState(new int[]{android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sms_on));
        smsDrawable.addState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sms_on));
        // press
        smsDrawable.addState(new int[]{android.R.attr.state_selected, android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sms_on));
        smsDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.sms_on));
        drawablesList.add(smsDrawable);

        tencentDrawable.addState(new int[]{-android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.tx_off));
        tencentDrawable.addState(new int[]{-android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.tx_on));
        // focus state
        tencentDrawable.addState(new int[]{android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.tx_on));
        tencentDrawable.addState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.tx_on));
        // press
        tencentDrawable.addState(new int[]{android.R.attr.state_selected, android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.tx_on));
        tencentDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.tx_on));
        drawablesList.add(tencentDrawable);

        wechatDrawable.addState(new int[]{-android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.wechat_off));
        wechatDrawable.addState(new int[]{-android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.wechat_on));
        // focus state
        wechatDrawable.addState(new int[]{android.R.attr.state_focused, -android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.wechat_on));
        wechatDrawable.addState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected, -android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.wechat_on));
        // press
        wechatDrawable.addState(new int[]{android.R.attr.state_selected, android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.wechat_on));
        wechatDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.wechat_on));
        drawablesList.add(wechatDrawable);

        return drawablesList;
    }

}
