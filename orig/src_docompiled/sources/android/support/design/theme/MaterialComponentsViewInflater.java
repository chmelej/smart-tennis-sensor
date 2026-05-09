package android.support.design.theme;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatViewInflater
    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }
}
