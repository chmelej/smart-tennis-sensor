package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import p000.C1684ee;
import p000.C1727fs;
import p000.C1731fw;
import p000.C1763ha;
import p000.C1766hd;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: a */
    private static final int[] f3454a = {R.attr.checkMark};

    /* JADX INFO: renamed from: b */
    private final C1731fw f3455b;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        this.f3455b = new C1731fw(this);
        this.f3455b.m9295a(attributeSet, i);
        this.f3455b.m9290a();
        C1766hd c1766hdM9601a = C1766hd.m9601a(getContext(), attributeSet, f3454a, i, 0);
        setCheckMarkDrawable(c1766hdM9601a.m9605a(0));
        c1766hdM9601a.m9606a();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C1684ee.m8975b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3455b != null) {
            this.f3455b.m9294a(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3455b != null) {
            this.f3455b.m9290a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C1727fs.m9265a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }
}
