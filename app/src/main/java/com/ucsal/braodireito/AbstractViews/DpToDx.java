package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.util.TypedValue;

public class DpToDx {
    public int ConverterDpToPx(Activity activity, int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                activity.getResources().getDisplayMetrics()
        );
    }
}
