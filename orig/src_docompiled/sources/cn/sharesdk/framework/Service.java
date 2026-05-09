package cn.sharesdk.framework;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Service {

    /* JADX INFO: renamed from: a */
    private Context f5521a;

    /* JADX INFO: renamed from: b */
    private String f5522b;

    protected abstract int getServiceVersionInt();

    public abstract String getServiceVersionName();

    public void onBind() {
    }

    public void onUnbind() {
    }

    /* JADX INFO: renamed from: a */
    void m5935a(Context context) {
        this.f5521a = context;
    }

    public Context getContext() {
        return this.f5521a;
    }

    /* JADX INFO: renamed from: a */
    void m5936a(String str) {
        this.f5522b = str;
    }

    public String getAppKey() {
        return this.f5522b;
    }

    public String getDeviceKey() {
        return DeviceHelper.getInstance(this.f5521a).getDeviceKey();
    }

    public static abstract class ServiceEvent {
        private final int PLATFORM = 1;
        protected Service service;

        public ServiceEvent(Service service) {
            this.service = service;
        }

        protected HashMap<String, Object> toMap() {
            HashMap<String, Object> map = new HashMap<>();
            DeviceHelper deviceHelper = DeviceHelper.getInstance(this.service.f5521a);
            map.put("deviceid", deviceHelper.getDeviceKey());
            map.put("appkey", this.service.getAppKey());
            map.put("apppkg", deviceHelper.getPackageName());
            map.put("appver", Integer.valueOf(deviceHelper.getAppVersion()));
            map.put("sdkver", Integer.valueOf(this.service.getServiceVersionInt()));
            map.put("plat", 1);
            map.put("networktype", deviceHelper.getDetailNetworkTypeForStatic());
            map.put("deviceData", deviceHelper.getDeviceDataNotAES());
            return map;
        }

        public final String toString() {
            return new Hashon().fromHashMap(toMap());
        }

        protected HashMap<String, Object> filterShareContent(int i, Platform.ShareParams shareParams, HashMap<String, Object> map) {
            C0840f.a aVarFilterShareContent = ShareSDK.getPlatform(ShareSDK.platformIdToName(i)).filterShareContent(shareParams, map);
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("shareID", aVarFilterShareContent.f5620a);
            map2.put("shareContent", new Hashon().fromJson(aVarFilterShareContent.toString()));
            C0851d.m6195a().m8615i("filterShareContent ==>>%s", map2);
            return map2;
        }
    }
}
