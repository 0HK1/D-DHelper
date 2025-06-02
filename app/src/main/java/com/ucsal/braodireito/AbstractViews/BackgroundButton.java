package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ucsal.braodireito.R;

public class BackgroundButton {
    public View Background(Activity activity){
        ImageView backgroundImage = new ImageView(activity);
        backgroundImage.setImageResource(R.drawable.button_dice_background);
        backgroundImage.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );
        backgroundImage.setLayoutParams(imageParams);
        return backgroundImage;
    }

}
