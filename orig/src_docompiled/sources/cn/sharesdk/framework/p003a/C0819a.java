package cn.sharesdk.framework.p003a;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;

/* JADX INFO: renamed from: cn.sharesdk.framework.a.a */
/* JADX INFO: compiled from: SSDKNetworkHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0819a extends NetworkHelper {

    /* JADX INFO: renamed from: a */
    private static C0819a f5537a;

    private C0819a() {
    }

    /* JADX INFO: renamed from: a */
    public static C0819a m5962a() {
        if (f5537a == null) {
            f5537a = new C0819a();
        }
        return f5537a;
    }

    /* JADX INFO: renamed from: a */
    public String m5967a(String str, ArrayList<KVPair<String>> arrayList, String str2, int i) {
        return m5968a(str, arrayList, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null, str2, i);
    }

    /* JADX INFO: renamed from: a */
    public String m5968a(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m5963a(str2, i);
        return super.httpGet(str, arrayList, arrayList2, networkTimeOut);
    }

    /* JADX INFO: renamed from: b */
    public String m5971b(String str, ArrayList<KVPair<String>> arrayList, String str2, int i) {
        return m5964a(str, arrayList, null, str2, i);
    }

    /* JADX INFO: renamed from: a */
    public String m5964a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, String str2, int i) {
        return m5966a(str, arrayList, kVPair, (ArrayList<KVPair<String>>) null, str2, i);
    }

    /* JADX INFO: renamed from: a */
    public String m5966a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, String str2, int i) {
        return m5965a(str, arrayList, kVPair, arrayList2, null, str2, i);
    }

    /* JADX INFO: renamed from: a */
    public String m5965a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m5963a(str2, i);
        return super.httpPost(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    /* JADX INFO: renamed from: b */
    public String m5970b(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m5963a(str2, i);
        return super.httpPut(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    /* JADX INFO: renamed from: a */
    public void m5969a(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, String str2, int i) throws Throwable {
        m5963a(str2, i);
        super.rawPost(str, arrayList, hTTPPart, rawNetworkCallback, (NetworkHelper.NetworkTimeOut) null);
    }

    /* JADX INFO: renamed from: b */
    public String m5972b(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m5963a(str2, i);
        return super.jsonPost(str, arrayList, arrayList2, networkTimeOut);
    }

    /* JADX INFO: renamed from: a */
    private void m5963a(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        ShareSDK.logApiEvent(str, i);
    }
}
