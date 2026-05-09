package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.coollang.tennis.base.MyApplication;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: renamed from: jy */
/* JADX INFO: compiled from: DataHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class HandlerC1841jy extends Handler {

    /* JADX INFO: renamed from: a */
    int f10840a;

    /* JADX INFO: renamed from: b */
    private boolean f10841b;

    /* JADX INFO: renamed from: c */
    private Gson f10842c;

    /* JADX INFO: renamed from: d */
    private C1874ld f10843d;

    /* JADX INFO: renamed from: e */
    private String f10844e;

    /* JADX INFO: renamed from: f */
    private SimpleDateFormat f10845f;

    public HandlerC1841jy(Looper looper) {
        super(looper);
        this.f10841b = false;
        this.f10844e = "";
        this.f10845f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        this.f10840a = 0;
        this.f10842c = new Gson();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        byte[] bArr = (byte[]) message.obj;
        this.f10843d = new C1874ld();
        this.f10844e = C1902me.m10480a(C1914mm.m10554a());
        if (bArr.length == 20 && bArr[0] == -88 && C1893lw.m10442a(bArr)) {
            switch (bArr[1]) {
                case 37:
                    C1893lw.m10456d(bArr);
                    this.f10841b = true;
                    C1900mc.m10473a("MATCH_DATA_25", "返回正常");
                    if (bArr[2] == 1) {
                        C1900mc.m10473a("MATCH_DATA_25", " 处理详情数据");
                        m10048a(bArr);
                    } else if (bArr[2] == 2) {
                        this.f10840a = 0;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10048a(byte[] bArr) {
        long jM10454b = C1893lw.m10454b(bArr[11], bArr[12], bArr[13], bArr[14]) - ((long) C1912mk.m10541c());
        C1900mc.m10474b("Timestamp", jM10454b + "=====");
        C1900mc.m10473a("验证------", "返回的详情条数=" + this.f10840a);
        this.f10840a = this.f10840a + 1;
        C1856km.m10109a().m10113a(String.valueOf(this.f10844e), String.valueOf(jM10454b), String.format("%02X", Byte.valueOf(bArr[3])), String.valueOf(C1893lw.m10453b(bArr[4], bArr[5])), String.valueOf(C1893lw.m10453b(bArr[8], bArr[9])), String.valueOf(C1893lw.m10453b(bArr[6], bArr[7])), bArr[10] == 1 ? "1" : "0", String.valueOf(C1893lw.m10453b(bArr[17], bArr[18])), "0", MyApplication.m7738a().f7406g, String.valueOf(C1893lw.m10452b(bArr[16])));
    }
}
