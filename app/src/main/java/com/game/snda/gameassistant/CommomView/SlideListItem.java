package com.game.snda.gameassistant.CommomView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.snda.gameassistant.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zoubaolin on 15/10/22.
 */
@EViewGroup(R.layout.slide_item_layout)
public class SlideListItem extends FrameLayout implements View.OnClickListener{

    private final static String TAG = SlideListItem.class.getSimpleName();

    @ViewById(R.id.wrap_container)
    FrameLayout wrapContainer;
    @ViewById(R.id.menu_container)
    RelativeLayout wrapMenuContainer;
    @ViewById(R.id.tv_delete_menu)
    TextView deleteMsgMenu;
    @ViewById(R.id.tv_unread_menu)
    TextView unReadMsgMenu;
    @ViewById(R.id.tv_top_menu)
    TextView topMsgMenu;
    @ViewById(R.id.item_container)
    RelativeLayout wrapItemContainer;
    @ViewById(R.id.iv_user_icon)
    ImageView userIcon;
    @ViewById(R.id.tv_message_title)
    TextView messageTitle;
    @ViewById(R.id.tv_message_content)
    TextView messageContent;
    @ViewById(R.id.tv_message_timestamp)
    TextView messageTimeStamp;

    private int menuTotalLength;
    private int mLastX;
    private int mTouchSlop = 0;
    private VelocityTracker velocityTracker = null;

    public SlideListItem(Context context) {
        super(context, null);
    }

    public SlideListItem(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SlideListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Log.d(TAG, "zzz---mTouchSlop = " + mTouchSlop);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        return super.dispatchDragEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastX = (int)ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int x = (int)ev.getX();
                if (Math.abs(x - mLastX) > mTouchSlop) { // 拦截touchEvent事件，交给自己的onTouchEvent处理
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (velocityTracker == null)
            velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        return super.onDragEvent(event);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.tv_delete_menu:
                // 删除消息
                break;
            case R.id.tv_unread_menu:
                // 将消息标记为未读
                break;
            case R.id.tv_top_menu:
                // 将消息置顶
                break;
            default:
                break;
        }
    }
}
