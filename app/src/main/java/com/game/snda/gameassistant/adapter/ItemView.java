package com.game.snda.gameassistant.adapter;

import org.androidannotations.api.view.HasViews;

/**
 * Created by zoubaolin on 15/10/22.
 */
public interface ItemView<T> extends HasViews {
    void bind(T item);
}
