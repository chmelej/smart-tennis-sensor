package cn.sharesdk.framework.p004b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.p004b.p005a.C0831c;
import cn.sharesdk.framework.p004b.p005a.C0833e;
import cn.sharesdk.framework.p004b.p006b.AbstractC0837c;
import cn.sharesdk.framework.p004b.p006b.C0836b;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.a */
/* JADX INFO: compiled from: EventManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C0828a {

    /* JADX INFO: renamed from: a */
    private static C0828a f5566a;

    /* JADX INFO: renamed from: b */
    private C0842c f5567b;

    /* JADX INFO: renamed from: c */
    private DeviceHelper f5568c;

    /* JADX INFO: renamed from: d */
    private C0833e f5569d;

    /* JADX INFO: renamed from: e */
    private boolean f5570e;

    /* JADX INFO: renamed from: a */
    public static C0828a m5995a(Context context, String str) {
        if (f5566a == null) {
            f5566a = new C0828a(context, str);
        }
        return f5566a;
    }

    private C0828a(Context context, String str) {
        this.f5567b = new C0842c(context, str);
        this.f5569d = C0833e.m6025a(context);
        this.f5568c = DeviceHelper.getInstance(context);
    }

    /* JADX INFO: renamed from: a */
    public void m6007a() {
        try {
            String networkType = this.f5568c.getNetworkType();
            if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType)) {
                long jLongValue = this.f5569d.m6048h().longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(jLongValue);
                int i = calendar.get(5);
                calendar.setTimeInMillis(jCurrentTimeMillis);
                int i2 = calendar.get(5);
                if (jCurrentTimeMillis - jLongValue >= 86400000 || i != i2) {
                    HashMap<String, Object> mapM6069a = this.f5567b.m6069a();
                    this.f5569d.m6033a(mapM6069a.containsKey("res") ? "true".equals(String.valueOf(mapM6069a.get("res"))) : true);
                    if (mapM6069a == null || mapM6069a.size() <= 0) {
                        return;
                    }
                    this.f5569d.m6034b(System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6012b() {
        HashMap map;
        HashMap map2;
        try {
            String networkType = this.f5568c.getNetworkType();
            if ("none".equals(networkType) || TextUtils.isEmpty(networkType) || !this.f5569d.m6047g()) {
                return;
            }
            this.f5569d.m6027a(System.currentTimeMillis());
            HashMap<String, Object> mapM6079c = this.f5567b.m6079c();
            if (mapM6079c.containsKey(NotificationCompat.CATEGORY_STATUS) && ResHelper.parseInt(String.valueOf(mapM6079c.get(NotificationCompat.CATEGORY_STATUS))) == -200) {
                C0851d.m6195a().m8609d((String) mapM6079c.get("error"), new Object[0]);
                return;
            }
            if (mapM6079c.containsKey("timestamp")) {
                this.f5569d.m6030a("service_time", Long.valueOf(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(mapM6079c.get("timestamp")))));
            }
            if (mapM6079c.containsKey("switchs") && (map2 = (HashMap) mapM6079c.get("switchs")) != null) {
                String strValueOf = String.valueOf(map2.get("device"));
                String strValueOf2 = String.valueOf(map2.get("share"));
                String strValueOf3 = String.valueOf(map2.get("auth"));
                String strValueOf4 = String.valueOf(map2.get("backflow"));
                this.f5569d.m6035b(strValueOf);
                this.f5569d.m6040d(strValueOf2);
                this.f5569d.m6038c(strValueOf3);
                this.f5569d.m6028a(strValueOf4);
            }
            if (!mapM6079c.containsKey("serpaths") || (map = (HashMap) mapM6079c.get("serpaths")) == null) {
                return;
            }
            String strValueOf5 = String.valueOf(map.get("defhost"));
            String strValueOf6 = String.valueOf(map.get("defport"));
            if (!TextUtils.isEmpty(strValueOf5) && !TextUtils.isEmpty(strValueOf6)) {
                this.f5567b.m6072a("http://" + strValueOf5 + ":" + strValueOf6);
            }
            HashMap<String, String> map3 = new HashMap<>();
            if (map.containsKey("assigns")) {
                HashMap map4 = (HashMap) map.get("assigns");
                if (map4 != null && map4.size() != 0) {
                    for (String str : map4.keySet()) {
                        HashMap map5 = (HashMap) map4.get(str);
                        String strValueOf7 = String.valueOf(map5.get("host"));
                        String strValueOf8 = String.valueOf(map5.get("port"));
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strValueOf7) && !TextUtils.isEmpty(strValueOf8)) {
                            map3.put(str, "http://" + strValueOf7 + ":" + strValueOf8);
                        }
                    }
                    this.f5567b.m6074a(map3);
                    return;
                }
                this.f5567b.m6074a((HashMap<String, String>) null);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6010a(boolean z) {
        this.f5570e = z;
    }

    /* JADX INFO: renamed from: a */
    public void m6008a(AbstractC0837c abstractC0837c) {
        try {
            if (this.f5569d.m6047g()) {
                if (abstractC0837c instanceof C0836b) {
                    m5999a((C0836b) abstractC0837c);
                } else if (abstractC0837c instanceof C0840f) {
                    m6000a((C0840f) abstractC0837c);
                }
                if (!this.f5569d.m6037b()) {
                    abstractC0837c.f5603m = null;
                }
                long jM6026a = this.f5569d.m6026a();
                if (jM6026a == 0) {
                    jM6026a = this.f5567b.m6076b();
                }
                abstractC0837c.f5595e = System.currentTimeMillis() - jM6026a;
                this.f5567b.m6071a(abstractC0837c);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5999a(C0836b c0836b) {
        boolean zM6039c = this.f5569d.m6039c();
        String str = c0836b.f5593c;
        if (zM6039c && !TextUtils.isEmpty(str)) {
            c0836b.f5593c = Data.Base64AES(str, c0836b.f5596f.substring(0, 16));
        } else {
            c0836b.f5594d = null;
            c0836b.f5593c = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6000a(C0840f c0840f) throws IOException {
        int iM6042e = this.f5569d.m6042e();
        boolean zM6039c = this.f5569d.m6039c();
        C0840f.a aVar = c0840f.f5617d;
        if (iM6042e == 1 || (iM6042e == 0 && this.f5570e)) {
            int size = (aVar == null || aVar.f5624e == null) ? 0 : aVar.f5624e.size();
            for (int i = 0; i < size; i++) {
                String strM5997a = m5997a(aVar.f5624e.get(i), EnumC0834b.FINISH_SHARE);
                if (!TextUtils.isEmpty(strM5997a)) {
                    aVar.f5623d.add(strM5997a);
                }
            }
            int size2 = (aVar == null || aVar.f5625f == null) ? 0 : aVar.f5625f.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strM5996a = m5996a(aVar.f5625f.get(i2), EnumC0834b.FINISH_SHARE);
                if (!TextUtils.isEmpty(strM5996a)) {
                    aVar.f5623d.add(strM5996a);
                }
            }
        } else {
            c0840f.f5617d = null;
        }
        if (zM6039c) {
            return;
        }
        c0840f.f5618n = null;
    }

    /* JADX INFO: renamed from: a */
    private String m5997a(String str, EnumC0834b enumC0834b) throws IOException {
        int iCeil;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        String networkType = this.f5568c.getNetworkType();
        if ("none".equals(networkType) || TextUtils.isEmpty(networkType)) {
            return null;
        }
        Bitmap.CompressFormat bmpFormat = BitmapHelper.getBmpFormat(str);
        float f = enumC0834b == EnumC0834b.BEFORE_SHARE ? 600.0f : 200.0f;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i >= i2 && i2 > f) {
            iCeil = (int) Math.ceil(options.outHeight / f);
        } else if (i < i2 && i > f) {
            iCeil = (int) Math.ceil(options.outWidth / f);
        } else {
            return m6002c(str);
        }
        if (iCeil <= 0) {
            iCeil = 1;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = iCeil;
        options2.inPurgeable = true;
        options2.inInputShareable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options2);
        bitmapDecodeFile.getHeight();
        bitmapDecodeFile.getWidth();
        File fileCreateTempFile = File.createTempFile("bm_tmp2", "." + bmpFormat.name().toLowerCase());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        bitmapDecodeFile.compress(bmpFormat, 80, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return m6002c(fileCreateTempFile.getAbsolutePath());
    }

    /* JADX INFO: renamed from: c */
    private String m6002c(String str) {
        HashMap<String, Object> mapM6077b = this.f5567b.m6077b(str);
        if (mapM6077b != null && mapM6077b.size() > 0 && mapM6077b.containsKey(NotificationCompat.CATEGORY_STATUS) && ResHelper.parseInt(String.valueOf(mapM6077b.get(NotificationCompat.CATEGORY_STATUS))) == 200 && mapM6077b.containsKey("url")) {
            return (String) mapM6077b.get("url");
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private String m5996a(Bitmap bitmap, EnumC0834b enumC0834b) throws IOException {
        File fileCreateTempFile = File.createTempFile("bm_tmp", ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return m5997a(fileCreateTempFile.getAbsolutePath(), enumC0834b);
    }

    /* JADX INFO: renamed from: c */
    public void m6013c() {
        boolean zM6001a;
        try {
            String networkType = this.f5568c.getNetworkType();
            if ("none".equals(networkType) || TextUtils.isEmpty(networkType) || !this.f5569d.m6047g()) {
                return;
            }
            ArrayList<C0831c> arrayListM6082e = this.f5567b.m6082e();
            for (int i = 0; i < arrayListM6082e.size(); i++) {
                C0831c c0831c = arrayListM6082e.get(i);
                if (c0831c.f5575b.size() == 1) {
                    zM6001a = m6001a(c0831c.f5574a, false);
                } else {
                    zM6001a = m6001a(m6003d(c0831c.f5574a), true);
                }
                if (zM6001a) {
                    this.f5567b.m6073a(c0831c.f5575b);
                }
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: d */
    private String m6003d(String str) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = byteArrayInputStream.read(bArr, 0, 1024);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m6001a(String str, boolean z) {
        return this.f5567b.m6075a(str, z);
    }

    /* JADX INFO: renamed from: a */
    public String m6006a(String str, int i, boolean z, String str2) {
        String strM5998a;
        try {
            if (this.f5569d.m6047g() && this.f5569d.m6041d()) {
                String networkType = this.f5568c.getNetworkType();
                if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType)) {
                    if (z && (strM5998a = m5998a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i, str2)) != null && !strM5998a.equals(str)) {
                        return strM5998a;
                    }
                    String strM5998a2 = m5998a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i, str2);
                    if (strM5998a2 != null) {
                        if (!strM5998a2.equals(str)) {
                            return strM5998a2;
                        }
                    }
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return str;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m5998a(String str, String str2, int i, String str3) {
        HashMap<String, Object> mapM6070a;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern patternCompile = Pattern.compile(str2);
        Matcher matcher = patternCompile.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (strGroup != null && strGroup.length() > 0) {
                arrayList.add(strGroup);
            }
        }
        if (arrayList.size() == 0 || (mapM6070a = this.f5567b.m6070a(str, arrayList, i, str3)) == null || mapM6070a.size() <= 0 || !mapM6070a.containsKey("data")) {
            return str;
        }
        ArrayList<HashMap> arrayList2 = (ArrayList) mapM6070a.get("data");
        HashMap map = new HashMap();
        for (HashMap map2 : arrayList2) {
            map.put(String.valueOf(map2.get("source")), String.valueOf(map2.get("surl")));
        }
        Matcher matcher2 = patternCompile.matcher(str);
        StringBuilder sb = new StringBuilder();
        int iEnd = 0;
        while (matcher2.find()) {
            sb.append(str.substring(iEnd, matcher2.start()));
            sb.append((String) map.get(matcher2.group()));
            iEnd = matcher2.end();
        }
        sb.append(str.substring(iEnd, str.length()));
        String string = sb.toString();
        C0851d.m6195a().m8615i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", string);
        return string;
    }

    /* JADX INFO: renamed from: a */
    public String m6005a(String str) {
        if (!this.f5569d.m6047g()) {
            return null;
        }
        try {
            return m5997a(str, EnumC0834b.BEFORE_SHARE);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public String m6004a(Bitmap bitmap) {
        if (!this.f5569d.m6047g()) {
            return null;
        }
        try {
            return m5996a(bitmap, EnumC0834b.BEFORE_SHARE);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public HashMap<String, Object> m6014d() {
        try {
            return this.f5567b.m6083f();
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return new HashMap<>();
        }
    }

    /* JADX INFO: renamed from: e */
    public HashMap<String, Object> m6015e() {
        if (!this.f5569d.m6047g() && this.f5569d.m6050i()) {
            return new HashMap<>();
        }
        try {
            HashMap<String, Object> mapM6081d = this.f5567b.m6081d();
            this.f5569d.m6036b(true);
            return mapM6081d;
        } catch (Throwable th) {
            this.f5569d.m6036b(false);
            C0851d.m6195a().m8610d(th);
            return new HashMap<>();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6009a(HashMap<String, Object> map) {
        try {
            this.f5567b.m6078b(map);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6011b(String str) {
        try {
            return this.f5567b.m6080c(str);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return new HashMap<>();
        }
    }
}
