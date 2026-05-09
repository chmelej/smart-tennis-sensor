package p000;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: it */
/* JADX INFO: compiled from: CustomDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class ProgressDialogC1809it extends ProgressDialog {

    /* JADX INFO: renamed from: a */
    public static TextView f10365a;

    /* JADX INFO: renamed from: b */
    private boolean f10366b;

    public ProgressDialogC1809it(Context context, boolean z) {
        super(context, R.style.Loading_Dialog);
        this.f10366b = z;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m9828a(getContext());
    }

    /* JADX INFO: renamed from: a */
    private void m9828a(Context context) {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.layout_progress_dialog);
        f10365a = (TextView) findViewById(R.id.progress);
        if (!this.f10366b) {
            f10365a.setVisibility(8);
        } else {
            f10365a.setVisibility(0);
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = C1895ly.m10460a(context, 160.0f);
        attributes.height = C1895ly.m10460a(context, 160.0f);
        getWindow().setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
