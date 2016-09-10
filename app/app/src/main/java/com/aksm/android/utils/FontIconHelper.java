package com.aksm.android.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.aksm.android.R;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.MaterialIcons;



public class FontIconHelper {

    public static Drawable getFontDrawable(Context activity, MaterialIcons icon) {
        return getFontDrawable(activity, icon, R.color.white);
    }


    public static Drawable getFontDrawable(Context activity, MaterialIcons icon, int color) {
        return new IconDrawable(activity, icon)
                .colorRes(color)
                .actionBarSize();
    }

    public static Drawable getFontDrawable(Context activity, MaterialIcons icon, int sizeDp, int color) {
        return new IconDrawable(activity, icon)
                .colorRes(color)
                .sizeDp(sizeDp);
    }
}
