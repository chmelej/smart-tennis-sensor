package p000;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: kr */
/* JADX INFO: compiled from: FirstConnectDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1861kr extends Dialog {

    /* JADX INFO: renamed from: a */
    private ImageView f10938a;

    /* JADX INFO: renamed from: b */
    private TextView f10939b;

    public DialogC1861kr(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_first_connect);
        this.f10938a = (ImageView) findViewById(R.id.img_close);
        this.f10939b = (TextView) findViewById(R.id.tv_first_connect_content);
        this.f10939b.setText(C1914mm.m10557b(R.string.first_connect_content));
        this.f10938a.setOnClickListener(new View.OnClickListener() { // from class: kr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1861kr.this.dismiss();
            }
        });
    }
}
