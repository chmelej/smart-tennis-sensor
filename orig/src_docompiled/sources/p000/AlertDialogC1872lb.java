package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: lb */
/* JADX INFO: compiled from: SetHeadDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialogC1872lb extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private TextView f11059a;

    /* JADX INFO: renamed from: b */
    private TextView f11060b;

    /* JADX INFO: renamed from: c */
    private Button f11061c;

    /* JADX INFO: renamed from: d */
    private a f11062d;

    /* JADX INFO: renamed from: e */
    private String f11063e;

    /* JADX INFO: renamed from: lb$a */
    /* JADX INFO: compiled from: SetHeadDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7024a();

        /* JADX INFO: renamed from: b */
        void mo7025b();
    }

    public AlertDialogC1872lb(Context context, String str, a aVar) {
        super(context, R.style.CommonDialog);
        this.f11062d = aVar;
        this.f11063e = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_set_head);
        this.f11059a = (TextView) findViewById(R.id.tv_local);
        this.f11060b = (TextView) findViewById(R.id.tv_camera);
        this.f11061c = (Button) findViewById(R.id.btn_cancle);
        this.f11059a.setOnClickListener(this);
        this.f11060b.setOnClickListener(this);
        this.f11061c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancle) {
            dismiss();
            return;
        }
        if (id == R.id.tv_camera) {
            this.f11062d.mo7025b();
            dismiss();
        } else {
            if (id != R.id.tv_local) {
                return;
            }
            this.f11062d.mo7024a();
            dismiss();
        }
    }
}
