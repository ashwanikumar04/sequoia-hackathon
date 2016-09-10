package com.aksm.android.common;

import android.app.Application;
import android.os.Build;

import com.aksm.android.BuildConfig;
import com.aksm.android.R;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.MaterialModule;

import in.ashwanik.retroclient.RetroClientServiceInitializer;

/**
 * Created by AshwaniK on 2/28/2016.
 */
public class BaseApplication extends Application {
    private static BaseApplication sInstance;
    int progressViewColor;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            progressViewColor = getResources().getColor(R.color.accent, null);
        } else {
            progressViewColor = getResources().getColor(R.color.accent);
        }
        Iconify
                .with(new MaterialModule());
        RetroClientServiceInitializer.getInstance().initialize(BuildConfig.SERVER_BASE_URL, getApplicationContext(), progressViewColor, true);
        RetroClientServiceInitializer.getInstance().setLogCategoryName("PlanOut");
    }


}
