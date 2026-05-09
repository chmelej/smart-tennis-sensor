package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class PLTextView extends EditText {
    public PLTextView(Context context) {
        this(context, null);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setCursorVisible(false);
    }
}
