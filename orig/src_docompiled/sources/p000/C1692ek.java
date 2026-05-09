package p000;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* JADX INFO: renamed from: ek */
/* JADX INFO: compiled from: AllCapsTransformationMethod.java */
/* JADX INFO: loaded from: classes.dex */
public class C1692ek implements TransformationMethod {

    /* JADX INFO: renamed from: a */
    private Locale f9608a;

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public C1692ek(Context context) {
        this.f9608a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f9608a);
        }
        return null;
    }
}
