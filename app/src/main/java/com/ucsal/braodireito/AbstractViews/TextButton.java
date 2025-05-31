package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.ucsal.braodireito.R;

public class TextButton {
    public View Text(Activity activity, int StringTitle){
        DpToDx converter = new DpToDx();
        TextView titleText = new TextView(activity);
        titleText.setText(activity.getString(StringTitle));
        titleText.setTextSize(36);
        titleText.setTextColor(ContextCompat.getColor(activity, R.color.black));
        Typeface typeface = ResourcesCompat.getFont(activity, R.font.jim_nightshade);
        if (typeface != null) {
            titleText.setTypeface(typeface);
        }
        FrameLayout.LayoutParams titleParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        titleParams.gravity = Gravity.START | Gravity.CENTER_VERTICAL;
        titleParams.setMarginStart(converter.ConverterDpToPx(activity, 12));
        titleText.setLayoutParams(titleParams);
        return titleText;
    }
}
