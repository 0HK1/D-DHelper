package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.ucsal.braodireito.R;

public class TextButtonValue {
    private TextView valueText;
    public View ValueText(Activity activity){
        DpToDx converter = new DpToDx();
        valueText = new TextView(activity);
        valueText.setText("");
        valueText.setMinWidth(converter.ConverterDpToPx(activity, 56));
        valueText.setMinHeight(converter.ConverterDpToPx(activity, 40));
        valueText.setGravity(Gravity.CENTER);
        valueText.setBackgroundResource(R.drawable.button_dice_value);
        valueText.setTextColor(ContextCompat.getColor(activity, R.color.black));
        FrameLayout.LayoutParams valueParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        valueParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
        valueParams.setMarginEnd(converter.ConverterDpToPx(activity, 16));
        valueText.setLayoutParams(valueParams);
        return valueText;
    }

    public void SetValueText(String string){
        valueText.setText(string);
    }
}
