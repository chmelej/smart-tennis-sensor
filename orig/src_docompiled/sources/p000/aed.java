package p000;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;
import p000.afc;
import p000.afp;

/* JADX INFO: compiled from: Sender.java */
/* JADX INFO: loaded from: classes.dex */
public class aed {

    /* JADX INFO: renamed from: d */
    private static Context f507d;

    /* JADX INFO: renamed from: a */
    private adi f508a;

    /* JADX INFO: renamed from: b */
    private adk f509b;

    /* JADX INFO: renamed from: e */
    private aef f511e;

    /* JADX INFO: renamed from: f */
    private ady f512f;

    /* JADX INFO: renamed from: g */
    private JSONObject f513g;

    /* JADX INFO: renamed from: i */
    private boolean f515i;

    /* JADX INFO: renamed from: c */
    private final int f510c = 1;

    /* JADX INFO: renamed from: h */
    private boolean f514h = false;

    public aed(Context context, aef aefVar) {
        this.f508a = adi.m343a(context);
        this.f509b = adk.m357a(context);
        f507d = context;
        this.f511e = aefVar;
        this.f512f = new ady(context);
        this.f512f.m452a(this.f511e);
    }

    /* JADX INFO: renamed from: a */
    public void m469a(JSONObject jSONObject) {
        this.f513g = jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public void m470a(boolean z) {
        this.f514h = z;
    }

    /* JADX INFO: renamed from: b */
    public void m471b(boolean z) {
        this.f515i = z;
    }

    /* JADX INFO: renamed from: a */
    public void m468a(aea aeaVar) {
        this.f509b.m364a(aeaVar);
    }

    /* JADX INFO: renamed from: a */
    public void m467a() {
        try {
            if (this.f513g != null) {
                m466c();
            } else {
                m463b();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private void m463b() {
        afc.m806a(f507d).m818g().m820a(new afc.InterfaceC0084b() { // from class: aed.1
            @Override // p000.afc.InterfaceC0084b
            /* JADX INFO: renamed from: a */
            public void mo472a(File file) {
            }

            @Override // p000.afc.InterfaceC0084b
            /* JADX INFO: renamed from: b */
            public boolean mo473b(File file) throws Throwable {
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            byte[] bArrM763b = aev.m763b(fileInputStream2);
                            aev.m764c(fileInputStream2);
                            byte[] bArrM453a = aed.this.f512f.m453a(bArrM763b);
                            return aed.this.f515i || (bArrM453a == null ? 1 : aed.this.m461a(bArrM453a)) != 1;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            aev.m764c(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused) {
                    return false;
                }
            }

            @Override // p000.afc.InterfaceC0084b
            /* JADX INFO: renamed from: c */
            public void mo474c(File file) {
                aed.this.f511e.m492j();
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m466c() {
        adf adfVarM332b;
        try {
            this.f508a.m347a();
            try {
                String strEncodeToString = Base64.encodeToString(new afj().m842a(this.f508a.m349b()), 0);
                if (!TextUtils.isEmpty(strEncodeToString)) {
                    JSONObject jSONObject = this.f513g.getJSONObject(MsgConstant.KEY_HEADER);
                    jSONObject.put("id_tracking", strEncodeToString);
                    this.f513g.put(MsgConstant.KEY_HEADER, jSONObject);
                }
            } catch (Exception unused) {
            }
            byte[] bytes = String.valueOf(this.f513g).getBytes();
            if (bytes == null || aes.m706a(f507d, bytes)) {
                return;
            }
            if (!this.f514h) {
                adfVarM332b = adf.m329a(f507d, acz.m287a(f507d), bytes);
            } else {
                adfVarM332b = adf.m332b(f507d, acz.m287a(f507d), bytes);
            }
            byte[] bArrM341c = adfVarM332b.m341c();
            afc.m806a(f507d).m816e();
            byte[] bArrM453a = this.f512f.m453a(bArrM341c);
            switch (bArrM453a == null ? 1 : m461a(bArrM453a)) {
                case 1:
                    if (!this.f515i) {
                        afc.m806a(f507d).m811a(bArrM341c);
                    }
                    break;
                case 2:
                    this.f508a.m350c();
                    this.f511e.m492j();
                    break;
                case 3:
                    this.f511e.m492j();
                    break;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m461a(byte[] bArr) {
        aep aepVar = new aep();
        try {
            new afh(new afp.C0087a()).m841a(aepVar, bArr);
            if (aepVar.f651a == 1) {
                this.f509b.m367b(aepVar.m642d());
                this.f509b.m369d();
            }
            aex.m774b("send log:" + aepVar.m638b());
        } catch (Throwable unused) {
        }
        return aepVar.f651a == 1 ? 2 : 3;
    }
}
