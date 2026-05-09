package cn.sharesdk.tencent.p007qq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qq.e */
/* JADX INFO: compiled from: ShareActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0879e extends FakeActivity {

    /* JADX INFO: renamed from: a */
    private Platform f5791a;

    /* JADX INFO: renamed from: b */
    private String f5792b;

    /* JADX INFO: renamed from: c */
    private PlatformActionListener f5793c;

    /* JADX INFO: renamed from: a */
    public void m6333a(Platform platform, PlatformActionListener platformActionListener) {
        this.f5791a = platform;
        this.f5793c = platformActionListener;
    }

    /* JADX INFO: renamed from: a */
    public void m6334a(String str) {
        this.f5792b = "tencent" + str;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [cn.sharesdk.tencent.qq.e$1] */
    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        Bundle extras = this.activity.getIntent().getExtras();
        final String string = extras.getString("title");
        final String string2 = extras.getString("titleUrl");
        final String string3 = extras.getString("summary");
        final String string4 = extras.getString("imageUrl");
        final String string5 = extras.getString("musicUrl");
        final String appName = DeviceHelper.getInstance(this.activity).getAppName();
        final String string6 = extras.getString("appId");
        final int i = extras.getInt("hidden");
        String string7 = extras.getString("imagePath");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string2) && ((TextUtils.isEmpty(string7) || !new File(string7).exists()) && !TextUtils.isEmpty(string4))) {
            new Thread() { // from class: cn.sharesdk.tencent.qq.e.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String strDownloadBitmap;
                    try {
                        try {
                            strDownloadBitmap = BitmapHelper.downloadBitmap(C0879e.this.activity, string4);
                        } catch (Throwable th) {
                            C0851d.m6195a().m8610d(th);
                            strDownloadBitmap = null;
                        }
                        C0879e.this.m6330a(string, string2, string3, string4, strDownloadBitmap, string5, appName, string6, i);
                    } catch (Throwable th2) {
                        C0851d.m6195a().m8610d(th2);
                    }
                }
            }.start();
        } else {
            m6330a(string, string2, string3, string4, string7, string5, appName, string6, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6330a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        String strM6332b = m6332b(str, str2, str3, str4, str5, str6, str7, str8, i);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(strM6332b));
        try {
            int[] iArrM6331a = m6331a();
            C0878d c0878d = new C0878d();
            c0878d.m6327a(this.f5792b);
            c0878d.m6326a(this.f5791a, this.f5793c);
            FakeActivity.registerExecutor(this.f5792b, c0878d);
            if (iArrM6331a.length <= 1 || (iArrM6331a[0] < 4 && iArrM6331a[1] < 6)) {
                intent.putExtra("key_request_code", 0);
            }
            intent.putExtra("pkg_name", this.activity.getPackageName());
            this.activity.startActivityForResult(intent, 0);
        } catch (Throwable th) {
            this.activity.finish();
            if (this.f5793c != null) {
                this.f5793c.onError(this.f5791a, 9, th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private String m6332b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        String str9;
        String str10 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news";
        if (!TextUtils.isEmpty(str4)) {
            str10 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news&image_url=" + Base64.encodeToString(str4.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str5)) {
            str10 = str10 + "&file_data=" + Base64.encodeToString(str5.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str)) {
            str10 = str10 + "&title=" + Base64.encodeToString(str.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str10 = str10 + "&description=" + Base64.encodeToString(str3.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str7)) {
            if (str7.length() > 20) {
                str7 = str7.substring(0, 20) + "...";
            }
            str10 = str10 + "&app_name=" + Base64.encodeToString(str7.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str8)) {
            str10 = str10 + "&share_id=" + str8;
        }
        if (!TextUtils.isEmpty(str2)) {
            str10 = str10 + "&url=" + Base64.encodeToString(str2.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str10 = str10 + "&share_qq_ext_str=" + Base64.encodeToString(str3.getBytes(), 2);
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str5)) {
            str9 = str10 + "&req_type=" + Base64.encodeToString("5".getBytes(), 2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            str9 = str10 + "&req_type=" + Base64.encodeToString("6".getBytes(), 2);
        } else if (!TextUtils.isEmpty(str6)) {
            str9 = (str10 + "&req_type=" + Base64.encodeToString("2".getBytes(), 2)) + "&audioUrl=" + Base64.encodeToString(str6.getBytes(), 2);
        } else {
            str9 = str10 + "&req_type=" + Base64.encodeToString("1".getBytes(), 2);
        }
        return str9 + "&cflag=" + Base64.encodeToString((i == 1 ? "10" : "00").getBytes(), 2);
    }

    /* JADX INFO: renamed from: a */
    private int[] m6331a() {
        String str;
        try {
            str = this.f5791a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            str = "0";
        }
        String[] strArrSplit = str.split("\\.");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < iArr.length; i++) {
            try {
                iArr[i] = ResHelper.parseInt(strArrSplit[i]);
            } catch (Throwable th2) {
                C0851d.m6195a().m8610d(th2);
                iArr[i] = 0;
            }
        }
        return iArr;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        finish();
    }
}
