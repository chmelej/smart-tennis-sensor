package cn.sharesdk.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import cn.sharesdk.framework.p004b.C0828a;
import cn.sharesdk.framework.p004b.C0843d;
import cn.sharesdk.framework.p004b.p006b.C0835a;
import cn.sharesdk.framework.p004b.p006b.C0838d;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import dalvik.system.DexFile;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: cn.sharesdk.framework.e */
/* JADX INFO: compiled from: ShareSDKCore.java */
/* JADX INFO: loaded from: classes.dex */
public class C0846e {

    /* JADX INFO: renamed from: a */
    private static boolean f5670a = true;

    /* JADX INFO: renamed from: b */
    private Context f5671b;

    /* JADX INFO: renamed from: c */
    private String f5672c;

    /* JADX INFO: renamed from: a */
    public void m6134a(C0847f c0847f) {
    }

    /* JADX INFO: renamed from: c */
    public String m6139c() {
        return "2.8.0";
    }

    public C0846e(Context context, String str) {
        this.f5671b = context;
        this.f5672c = str;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<Platform> m6130a() {
        ArrayList<Platform> arrayListM6123a;
        if (f5670a) {
            arrayListM6123a = m6125e();
        } else {
            PackageInfo packageInfoM6124d = m6124d();
            if (packageInfoM6124d == null) {
                return null;
            }
            arrayListM6123a = m6123a(packageInfoM6124d);
        }
        m6136a(arrayListM6123a);
        return arrayListM6123a;
    }

    /* JADX INFO: renamed from: d */
    private PackageInfo m6124d() {
        try {
            PackageManager packageManager = this.f5671b.getPackageManager();
            String packageName = this.f5671b.getPackageName();
            for (PackageInfo packageInfo : (List) ReflectHelper.invokeInstanceMethod(packageManager, "getInstalledPackages", 8192)) {
                if (packageName.equals(packageInfo.packageName)) {
                    return packageInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private ArrayList<Platform> m6123a(PackageInfo packageInfo) {
        ArrayList<Platform> arrayList = new ArrayList<>();
        try {
            DexFile dexFile = new DexFile(packageInfo.applicationInfo.sourceDir);
            Enumeration<String> enumerationEntries = dexFile.entries();
            try {
                dexFile.close();
            } catch (Throwable th) {
                C0851d.m6195a().m8622w(th);
            }
            while (enumerationEntries != null && enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (strNextElement.startsWith("cn.sharesdk") && !strNextElement.contains("$")) {
                    try {
                        Class<?> cls = Class.forName(strNextElement);
                        if (cls != null && Platform.class.isAssignableFrom(cls) && !CustomPlatform.class.isAssignableFrom(cls)) {
                            Constructor<?> constructor = cls.getConstructor(Context.class);
                            constructor.setAccessible(true);
                            arrayList.add((Platform) constructor.newInstance(this.f5671b));
                        }
                    } catch (Throwable th2) {
                        C0851d.m6195a().m8622w(th2);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th3) {
            C0851d.m6195a().m8622w(th3);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    private ArrayList<Platform> m6125e() {
        ArrayList<Platform> arrayList = new ArrayList<>();
        for (String str : new String[]{"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.alipay.friends.Alipay", "cn.sharesdk.alipay.moments.AlipayMoments"}) {
            try {
                Constructor<?> constructor = Class.forName(str).getConstructor(Context.class);
                constructor.setAccessible(true);
                arrayList.add((Platform) constructor.newInstance(this.f5671b));
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public void m6136a(ArrayList<Platform> arrayList) {
        if (arrayList == null) {
            return;
        }
        Collections.sort(arrayList, new Comparator<Platform>() { // from class: cn.sharesdk.framework.e.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Platform platform, Platform platform2) {
                if (platform.getSortId() != platform2.getSortId()) {
                    return platform.getSortId() - platform2.getSortId();
                }
                return platform.getPlatformId() - platform2.getPlatformId();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m6133a(Handler handler, boolean z, int i) {
        C0843d c0843dM6084a = C0843d.m6084a(this.f5671b, this.f5672c);
        if (c0843dM6084a != null) {
            c0843dM6084a.m6090a(handler);
            c0843dM6084a.m6092a(z);
            c0843dM6084a.m6089a(i);
            c0843dM6084a.startThread();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6138b() {
        C0843d c0843dM6084a = C0843d.m6084a(this.f5671b, this.f5672c);
        if (c0843dM6084a != null) {
            c0843dM6084a.stopThread();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6132a(int i, Platform platform) {
        C0838d c0838d = new C0838d();
        switch (i) {
            case 1:
                c0838d.f5606a = "SHARESDK_ENTER_SHAREMENU";
                break;
            case 2:
                c0838d.f5606a = "SHARESDK_CANCEL_SHAREMENU";
                break;
            case 3:
                c0838d.f5606a = "SHARESDK_EDIT_SHARE";
                break;
            case 4:
                c0838d.f5606a = "SHARESDK_FAILED_SHARE";
                break;
            case 5:
                c0838d.f5606a = "SHARESDK_CANCEL_SHARE";
                break;
        }
        if (platform != null) {
            c0838d.f5607b = platform.getPlatformId();
        }
        C0843d c0843dM6084a = C0843d.m6084a(this.f5671b, this.f5672c);
        if (c0843dM6084a != null) {
            c0843dM6084a.m6091a(c0838d);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6135a(String str, int i) {
        C0843d c0843dM6084a = C0843d.m6084a(this.f5671b, this.f5672c);
        if (c0843dM6084a == null) {
            return;
        }
        C0835a c0835a = new C0835a();
        c0835a.f5588b = str;
        c0835a.f5587a = i;
        c0843dM6084a.m6091a(c0835a);
    }

    /* JADX INFO: renamed from: a */
    public String m6126a(int i, String str, HashMap<Integer, HashMap<String, Object>> map) {
        Object obj;
        HashMap<String, Object> map2 = map.get(Integer.valueOf(i));
        if (map2 == null || (obj = map2.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6137a(HashMap<String, Object> map, HashMap<Integer, HashMap<String, Object>> map2) {
        ArrayList<HashMap<String, Object>> arrayList;
        int i;
        if (map == null || map.size() <= 0 || (arrayList = (ArrayList) map.get("fakelist")) == null) {
            return false;
        }
        EventRecorder.addBegin("ShareSDK", "parseDevInfo");
        for (HashMap<String, Object> map3 : arrayList) {
            if (map3 != null) {
                try {
                    i = ResHelper.parseInt(String.valueOf(map3.get("snsplat")));
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                    i = -1;
                }
                if (i != -1) {
                    map2.put(Integer.valueOf(i), map3);
                }
            }
        }
        EventRecorder.addEnd("ShareSDK", "parseDevInfo");
        return true;
    }

    /* JADX INFO: renamed from: a */
    public String m6129a(String str, boolean z, int i, String str2) {
        return C0828a.m5995a(this.f5671b, this.f5672c).m6006a(str, i, z, str2);
    }

    /* JADX INFO: renamed from: a */
    public String m6128a(String str) {
        return C0828a.m5995a(this.f5671b, this.f5672c).m6005a(str);
    }

    /* JADX INFO: renamed from: a */
    public String m6127a(Bitmap bitmap) {
        return C0828a.m5995a(this.f5671b, this.f5672c).m6004a(bitmap);
    }

    /* JADX INFO: renamed from: a */
    public void m6131a(int i, int i2, HashMap<Integer, HashMap<String, Object>> map) {
        map.put(Integer.valueOf(i2), map.get(Integer.valueOf(i)));
    }
}
