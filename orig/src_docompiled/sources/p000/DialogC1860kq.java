package p000;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: kq */
/* JADX INFO: compiled from: ClearData.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1860kq extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private Button f10929a;

    /* JADX INFO: renamed from: b */
    private Button f10930b;

    /* JADX INFO: renamed from: c */
    private int f10931c;

    /* JADX INFO: renamed from: d */
    private TextView f10932d;

    /* JADX INFO: renamed from: e */
    private Context f10933e;

    /* JADX INFO: renamed from: f */
    private a f10934f;

    /* JADX INFO: renamed from: g */
    private String f10935g;

    /* JADX INFO: renamed from: h */
    private String f10936h;

    /* JADX INFO: renamed from: i */
    private String f10937i;

    /* JADX INFO: renamed from: kq$a */
    /* JADX INFO: compiled from: ClearData.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo6888a();

        /* JADX INFO: renamed from: b */
        void mo6889b();
    }

    public DialogC1860kq(int i, Context context, a aVar) {
        super(context, R.style.dialog_Translucent);
        this.f10931c = 0;
        this.f10934f = aVar;
        this.f10931c = i;
        this.f10933e = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_clear_data);
        this.f10929a = (Button) findViewById(R.id.yes);
        this.f10930b = (Button) findViewById(R.id.no);
        this.f10932d = (TextView) findViewById(R.id.title);
        this.f10929a.setOnClickListener(this);
        this.f10930b.setOnClickListener(this);
        switch (this.f10931c) {
            case 2:
                this.f10932d.setText(this.f10933e.getString(R.string.sport_list_text1));
                break;
            case 3:
                this.f10932d.setText(this.f10933e.getString(R.string.sport_list_text2));
                break;
            case 4:
                this.f10932d.setText(this.f10933e.getString(R.string.sport_list_text3));
                break;
            case 5:
                this.f10932d.setText(this.f10933e.getString(R.string.sport_list_text5));
                break;
            case 6:
                this.f10932d.setText(this.f10933e.getString(R.string.no_wifi_notice));
                this.f10929a.setText(C1914mm.m10557b(R.string.cancel));
                this.f10930b.setText(C1914mm.m10557b(R.string.continue_watch));
                break;
            case 7:
                this.f10932d.setText(R.string.delete_today_sport);
                if (this.f10935g != null && !this.f10935g.isEmpty()) {
                    this.f10932d.setText(this.f10935g);
                }
                if (this.f10936h != null && !this.f10936h.isEmpty()) {
                    this.f10929a.setText(this.f10936h);
                }
                if (this.f10937i != null && !this.f10937i.isEmpty()) {
                    this.f10930b.setText(this.f10937i);
                    break;
                }
                break;
            case 8:
                this.f10932d.setText("确定删除视频？");
                break;
            case 9:
                this.f10932d.setText("是否放弃此视频？");
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10129a(String str) {
        this.f10935g = str;
    }

    /* JADX INFO: renamed from: b */
    public void m10130b(String str) {
        this.f10936h = str;
    }

    /* JADX INFO: renamed from: c */
    public void m10131c(String str) {
        this.f10937i = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.no) {
            this.f10934f.mo6888a();
            dismiss();
        } else {
            if (id != R.id.yes) {
                return;
            }
            this.f10934f.mo6889b();
            dismiss();
        }
    }
}
