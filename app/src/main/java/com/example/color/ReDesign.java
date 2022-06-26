package com.example.color;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

public class ReDesign {
    public static void resizeImage(View view, int originWidth, int originHeight) {
        int pW = getDisplayInfo().widthPixels * originWidth / 1080;
        int pH = pW * originHeight / originWidth;
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = pW;
        params.height = pH;
    }

    public static DisplayMetrics getDisplayInfo() {
        return Resources.getSystem().getDisplayMetrics();
    }

}
