package com.game.snda.gameassistant.CommomView;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoubaolin on 15/10/23.
 */
public class BannerTextView extends TextSwitcher implements ViewSwitcher.ViewFactory{

    private final static String TAG = BannerTextView.class.getSimpleName();
    private final static int SWITCH_TEXT = 10000;
    private final static int POST_DELAY_TIME = 1000 * 3;
    private Context mContext;
    private List<String> mTextViewData = new ArrayList<>();

    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SWITCH_TEXT:
                    setSwitchText(msg.arg1);
                    if (msg.arg1 >= msg.arg2 - 1) {
                        msg.arg1 = 0;
                    } else {
                        msg.arg1 ++;
                    }
                    Message message = obtainMessage();
                    message.what = msg.what;
                    message.arg1 = msg.arg1;
                    sendMessageDelayed(message, POST_DELAY_TIME);
                    break;
                default:
                    break;
            }
        }
    };

    public BannerTextView(Context context) {
        super(context, null);
    }

    public BannerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setFactory(this);
    }

    private void setSwitchText(int position) {
        setText(mTextViewData.get(position));
    }

    /**
     * 生成显示文字的TextView(设置TextView各种属性)
     *
     * @return View
     */
    @Override
    public View makeView() {
        TextView textView = new TextView(mContext);
        textView.setTextSize(18);//设置文字大小
        textView.setTextColor(Color.RED);
        return textView;
    }

    public void startLoopTextView(List<String> loopData) {
        mTextViewData = loopData;
        int count = loopData.size();
        switch (count) {
            case 0: // 直接返回
                break;
            case 1: // 不进行循环显示
                setText(loopData.get(0));
                break;
            default:
                setText(loopData.get(0));
                Message message = new Message();
                message.arg1 = 1; // 此处设置1是显示下一段文字
                message.arg2 = count; // 传递List的大小
                message.what = SWITCH_TEXT;
                mHandler.sendMessageDelayed(message, POST_DELAY_TIME);
                break;
        }
    }

    public void removeHandlerMessage() {
        if (mHandler != null) {
            mHandler.removeMessages(SWITCH_TEXT);
        }
    }
}
