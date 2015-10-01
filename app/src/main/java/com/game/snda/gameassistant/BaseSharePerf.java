package com.game.snda.gameassistant;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by zoubaolin on 15/9/28.
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface BaseSharePerf {

    String hasGuideShow();
}
