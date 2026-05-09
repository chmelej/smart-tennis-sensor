package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: kw */
/* JADX INFO: compiled from: SaveImageDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialogC1866kw extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private TextView f11011a;

    /* JADX INFO: renamed from: b */
    private Button f11012b;

    /* JADX INFO: renamed from: c */
    private a f11013c;

    /* JADX INFO: renamed from: d */
    private String f11014d;

    /* JADX INFO: renamed from: kw$a */
    /* JADX INFO: compiled from: SaveImageDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7303a();
    }

    public AlertDialogC1866kw(Context context, String str, a aVar) {
        super(context, R.style.CommonDialog);
        this.f11013c = aVar;
        this.f11014d = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_save_image);
        this.f11011a = (TextView) findViewById(R.id.tv_local);
        this.f11012b = (Button) findViewById(R.id.btn_cancle);
        this.f11011a.setOnClickListener(this);
        this.f11012b.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancle) {
            dismiss();
        } else {
            if (id != R.id.tv_local) {
                return;
            }
            this.f11013c.mo7303a();
            dismiss();
        }
    }
}
