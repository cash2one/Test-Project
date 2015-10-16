package com.game.snda.gameassistant;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by zoubaolin on 15/9/28.
 */
public class BaseApplication extends Application {

    public final static String TAG = BaseApplication.class.getSimpleName();
    public static float density;
    public static int densityDpi;
    public static float scaleDensity;

    @Override
    public void onCreate() {
        super.onCreate();
        // ImageLoader初始化
        getScreenDensity();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 1).threadPoolSize(2)
                .memoryCache(new WeakMemoryCache())
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheExtraOptions(480, 800)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheSize(20 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs()
                .build();
    }

    /**
     * 获取手机屏幕参数
     */
    private void getScreenDensity() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        density = metrics.density;
        densityDpi = metrics.densityDpi;
        scaleDensity = metrics.scaledDensity;
        Log.d(TAG, "zzz---getScreenDensity()---density = " + density + "---densityDpi = " + densityDpi + "---scaleDensity = " + scaleDensity);
    }

    /**
     * 获取手机设备唯一标识
     * @param context
     */
    private void getPhoneInfo(Context context) {
        final String tmDevice, tmSerial, androidID;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        tmDevice = telephonyManager.getDeviceId();
        tmSerial = telephonyManager.getSimSerialNumber();
        androidID = android.provider.Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d(TAG, "zzz---getScreenDensity()---tmDevice = " + tmDevice + "---tmSerial = " + tmSerial + "---androidID = " + androidID);
    }
}
