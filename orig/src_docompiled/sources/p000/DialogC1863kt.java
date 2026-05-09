package p000;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: kt */
/* JADX INFO: compiled from: ModifyDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1863kt extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private Context f10948a;

    /* JADX INFO: renamed from: b */
    private a f10949b;

    /* JADX INFO: renamed from: c */
    private Button f10950c;

    /* JADX INFO: renamed from: d */
    private EditText f10951d;

    /* JADX INFO: renamed from: kt$a */
    /* JADX INFO: compiled from: ModifyDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7936a(String str);
    }

    public DialogC1863kt(Context context, a aVar) {
        super(context);
        this.f10948a = context;
        this.f10949b = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_modify);
        this.f10950c = (Button) findViewById(R.id.yes);
        this.f10951d = (EditText) findViewById(R.id.newName);
        this.f10950c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.yes) {
            return;
        }
        this.f10949b.mo7936a(this.f10951d.getText().toString().trim());
        dismiss();
        this.f10951d.clearFocus();
    }
}
