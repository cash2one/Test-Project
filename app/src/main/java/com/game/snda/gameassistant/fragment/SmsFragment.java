package com.game.snda.gameassistant.fragment;

import com.game.snda.gameassistant.BaseFragment;
import com.game.snda.gameassistant.CommomView.BannerTextView;
import com.game.snda.gameassistant.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoubaolin on 15/10/9.
 */
@EFragment(R.layout.sms_frag_layout)
public class SmsFragment extends BaseFragment {

    private static final String TAG = SmsFragment.class.getSimpleName();
    private List<String> mList = new ArrayList<>();

    @ViewById(R.id.banner_text_view)
    BannerTextView bannerTextView;

    @AfterViews
    void init() {
        initData();
        bannerTextView.startLoopTextView(mList);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void initData() {
        mList.add("系统通知：注意查收邮件...");
        mList.add("紧急通知：台风今日来袭");
        mList.add("好消息：一大波福利正在靠近...");
    }
}
