package p000;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: Envelope.java */
/* JADX INFO: loaded from: classes.dex */
public class adf {

    /* JADX INFO: renamed from: e */
    private String f392e;

    /* JADX INFO: renamed from: j */
    private int f397j;

    /* JADX INFO: renamed from: k */
    private int f398k;

    /* JADX INFO: renamed from: l */
    private byte[] f399l;

    /* JADX INFO: renamed from: m */
    private byte[] f400m;

    /* JADX INFO: renamed from: a */
    private final byte[] f388a = {0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b */
    private final int f389b = 1;

    /* JADX INFO: renamed from: c */
    private final int f390c = 0;

    /* JADX INFO: renamed from: d */
    private String f391d = "1.0";

    /* JADX INFO: renamed from: f */
    private byte[] f393f = null;

    /* JADX INFO: renamed from: g */
    private byte[] f394g = null;

    /* JADX INFO: renamed from: h */
    private byte[] f395h = null;

    /* JADX INFO: renamed from: i */
    private int f396i = 0;

    /* JADX INFO: renamed from: n */
    private boolean f401n = false;

    private adf(byte[] bArr, String str, byte[] bArr2) throws Exception {
        this.f392e = null;
        this.f397j = 0;
        this.f398k = 0;
        this.f399l = null;
        this.f400m = null;
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.f392e = str;
        this.f398k = bArr.length;
        this.f399l = aet.m714a(bArr);
        this.f397j = (int) (System.currentTimeMillis() / 1000);
        this.f400m = bArr2;
    }

    /* JADX INFO: renamed from: a */
    public static String m330a(Context context) {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        if (sharedPreferencesM454a == null) {
            return null;
        }
        return sharedPreferencesM454a.getString("signature", null);
    }

    /* JADX INFO: renamed from: a */
    public void m337a(String str) {
        this.f393f = aes.m707a(str);
    }

    /* JADX INFO: renamed from: a */
    public String m335a() {
        return aes.m705a(this.f393f);
    }

    /* JADX INFO: renamed from: a */
    public void m336a(int i) {
        this.f396i = i;
    }

    /* JADX INFO: renamed from: a */
    public void m338a(boolean z) {
        this.f401n = z;
    }

    /* JADX INFO: renamed from: a */
    public static adf m329a(Context context, String str, byte[] bArr) {
        try {
            String strM742n = aeu.m742n(context);
            String strM728c = aeu.m728c(context);
            SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
            String string = sharedPreferencesM454a.getString("signature", null);
            int i = sharedPreferencesM454a.getInt("serial", 1);
            adf adfVar = new adf(bArr, str, (strM728c + strM742n).getBytes());
            adfVar.m337a(string);
            adfVar.m336a(i);
            adfVar.m339b();
            sharedPreferencesM454a.edit().putInt("serial", i + 1).putString("signature", adfVar.m335a()).commit();
            adfVar.m340b(context);
            return adfVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static adf m332b(Context context, String str, byte[] bArr) {
        try {
            String strM742n = aeu.m742n(context);
            String strM728c = aeu.m728c(context);
            SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
            String string = sharedPreferencesM454a.getString("signature", null);
            int i = sharedPreferencesM454a.getInt("serial", 1);
            adf adfVar = new adf(bArr, str, (strM728c + strM742n).getBytes());
            adfVar.m338a(true);
            adfVar.m337a(string);
            adfVar.m336a(i);
            adfVar.m339b();
            sharedPreferencesM454a.edit().putInt("serial", i + 1).putString("signature", adfVar.m335a()).commit();
            adfVar.m340b(context);
            return adfVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m339b() {
        if (this.f393f == null) {
            this.f393f = m333d();
        }
        if (this.f401n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f393f, 1, bArr, 0, 16);
                this.f399l = aes.m708a(this.f399l, bArr);
            } catch (Exception unused) {
            }
        }
        this.f394g = m331a(this.f393f, this.f397j);
        this.f395h = m334e();
    }

    /* JADX INFO: renamed from: a */
    private byte[] m331a(byte[] bArr, int i) {
        byte[] bArrM710b = aes.m710b(this.f400m);
        byte[] bArrM710b2 = aes.m710b(this.f399l);
        int length = bArrM710b.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr2[i3] = bArrM710b2[i2];
            bArr2[i3 + 1] = bArrM710b[i2];
        }
        for (int i4 = 0; i4 < 2; i4++) {
            bArr2[i4] = bArr[i4];
            bArr2[(bArr2.length - i4) - 1] = bArr[(bArr.length - i4) - 1];
        }
        byte[] bArr3 = {(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            bArr2[i5] = (byte) (bArr2[i5] ^ bArr3[i5 % 4]);
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: d */
    private byte[] m333d() {
        return m331a(this.f388a, (int) (System.currentTimeMillis() / 1000));
    }

    /* JADX INFO: renamed from: e */
    private byte[] m334e() {
        return aes.m710b((aes.m705a(this.f393f) + this.f396i + this.f397j + this.f398k + aes.m705a(this.f394g)).getBytes());
    }

    /* JADX INFO: renamed from: c */
    public byte[] m341c() {
        aeq aeqVar = new aeq();
        aeqVar.m664a(this.f391d);
        aeqVar.m670b(this.f392e);
        aeqVar.m674c(aes.m705a(this.f393f));
        aeqVar.m663a(this.f396i);
        aeqVar.m669b(this.f397j);
        aeqVar.m673c(this.f398k);
        aeqVar.m666a(this.f399l);
        aeqVar.m677d(this.f401n ? 1 : 0);
        aeqVar.m678d(aes.m705a(this.f394g));
        aeqVar.m681e(aes.m705a(this.f395h));
        try {
            return new afj().m842a(aeqVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m340b(Context context) {
        String str = this.f392e;
        String strM385e = adk.m357a(context).m366b().m385e(null);
        String strM705a = aes.m705a(this.f393f);
        byte[] bArr = new byte[16];
        System.arraycopy(this.f393f, 2, bArr, 0, 16);
        String strM705a2 = aes.m705a(aes.m710b(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (strM385e != null) {
                jSONObject.put("umid", strM385e);
            }
            jSONObject.put("signature", strM705a);
            jSONObject.put("checksum", strM705a2);
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            aev.m759a(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", str);
            jSONObject2.put("channel", acz.m289b(context));
            if (strM385e != null) {
                jSONObject2.put("umid", aev.m762b(strM385e));
            }
            aev.m759a(new File(context.getFilesDir(), "exid.dat"), jSONObject2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public String toString() {
        return String.format("version : %s\n", this.f391d) + String.format("address : %s\n", this.f392e) + String.format("signature : %s\n", aes.m705a(this.f393f)) + String.format("serial : %s\n", Integer.valueOf(this.f396i)) + String.format("timestamp : %d\n", Integer.valueOf(this.f397j)) + String.format("length : %d\n", Integer.valueOf(this.f398k)) + String.format("guid : %s\n", aes.m705a(this.f394g)) + String.format("checksum : %s ", aes.m705a(this.f395h)) + String.format("codex : %d", Integer.valueOf(this.f401n ? 1 : 0));
    }
}
