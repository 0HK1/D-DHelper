package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;

public class DpToDxAdapter implements UnitConverter {
    private final DpToDx adaptee;

    public DpToDxAdapter(DpToDx adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int convert(Activity activity, int value) {
        return adaptee.ConverterDpToPx(activity, value);
    }

}
