package com.game.snda.gameassistant.fragment;

import android.os.Bundle;
import android.util.Log;

import com.game.snda.gameassistant.BaseFragment;
import com.game.snda.gameassistant.R;

import org.androidannotations.annotations.EFragment;

/**
 * Created by zoubaolin on 15/10/9.
 */
@EFragment(R.layout.tencent_frag_layout)
public class TencentFragment extends BaseFragment {

    private static final String TAG = TencentFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()...");
        super.onCreate(savedInstanceState);
    }
}
