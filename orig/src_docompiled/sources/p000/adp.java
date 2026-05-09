package p000;

import android.content.Context;
import android.os.Environment;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: UTDIdTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adp extends agz {

    /* JADX INFO: renamed from: a */
    private static final Pattern f441a = Pattern.compile("UTDID\">([^<]+)");

    /* JADX INFO: renamed from: b */
    private Context f442b;

    public adp(Context context) {
        super(MsgConstant.KEY_UTDID);
        this.f442b = context;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        try {
            return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.f442b);
        } catch (Exception unused) {
            return m393b();
        }
    }

    /* JADX INFO: renamed from: b */
    private String m393b() {
        File fileM395c = m395c();
        if (fileM395c == null || !fileM395c.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileM395c);
            try {
                return m394b(aev.m756a(fileInputStream));
            } finally {
                aev.m764c(fileInputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private String m394b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f441a.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private File m395c() {
        if (aeu.m723a(this.f442b, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
