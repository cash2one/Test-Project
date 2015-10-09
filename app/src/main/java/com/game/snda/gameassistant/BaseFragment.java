package com.game.snda.gameassistant;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by zoubaolin on 15/10/9.
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    @Override
    public void onResume() {
        Log.d(TAG, "onResume()...");
        super.onResume();
    }
}
