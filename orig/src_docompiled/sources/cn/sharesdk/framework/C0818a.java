package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.p004b.C0843d;
import cn.sharesdk.framework.p004b.p006b.C0836b;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import org.litepal.util.Const;

/* JADX INFO: renamed from: cn.sharesdk.framework.a */
/* JADX INFO: compiled from: InnerPlatformActionListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C0818a implements PlatformActionListener {

    /* JADX INFO: renamed from: a */
    private PlatformActionListener f5527a;

    /* JADX INFO: renamed from: b */
    private HashMap<Platform, Platform.ShareParams> f5528b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m5953a(int i, Platform platform) {
    }

    C0818a() {
    }

    /* JADX INFO: renamed from: a */
    void m5961a(PlatformActionListener platformActionListener) {
        this.f5527a = platformActionListener;
    }

    /* JADX INFO: renamed from: a */
    PlatformActionListener m5958a() {
        return this.f5527a;
    }

    /* JADX INFO: renamed from: a */
    public void m5960a(Platform platform, Platform.ShareParams shareParams) {
        this.f5528b.put(platform, shareParams);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i, Throwable th) {
        if (this.f5527a != null) {
            this.f5527a.onError(platform, i, th);
            this.f5527a = null;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
        if (platform instanceof CustomPlatform) {
            if (this.f5527a != null) {
                this.f5527a.onComplete(platform, i, map);
                this.f5527a = null;
                return;
            }
            return;
        }
        if (i == 1) {
            m5954a(platform, i, map);
            return;
        }
        if (i == 9) {
            m5957b(platform, i, map);
        } else if (this.f5527a != null) {
            this.f5527a.onComplete(platform, i, map);
            if ("Wechat".equals(platform.getName())) {
                return;
            }
            this.f5527a = null;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i) {
        if (this.f5527a != null) {
            this.f5527a.onCancel(platform, i);
            this.f5527a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5954a(Platform platform, final int i, final HashMap<String, Object> map) {
        final PlatformActionListener platformActionListener = this.f5527a;
        this.f5527a = new PlatformActionListener() { // from class: cn.sharesdk.framework.a.1
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i2, HashMap<String, Object> map2) {
                C0818a.this.f5527a = platformActionListener;
                if (C0818a.this.f5527a != null) {
                    C0818a.this.f5527a.onComplete(platform2, i, map);
                    if (!"Wechat".equals(platform2.getName())) {
                        C0818a.this.f5527a = null;
                    }
                }
                C0836b c0836b = new C0836b();
                c0836b.f5591a = platform2.getPlatformId();
                c0836b.f5592b = "TencentWeibo".equals(platform2.getName()) ? platform2.getDb().get(Const.TableSchema.COLUMN_NAME) : platform2.getDb().getUserId();
                c0836b.f5593c = new Hashon().fromHashMap(map2);
                c0836b.f5594d = C0818a.this.m5950a(platform2);
                C0843d c0843dM6084a = C0843d.m6084a(platform2.getContext(), c0836b.f5597g);
                if (c0843dM6084a != null) {
                    c0843dM6084a.m6091a(c0836b);
                }
                C0818a.this.m5953a(1, platform2);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i2, Throwable th) {
                C0851d.m6195a().m8622w(th);
                C0818a.this.f5527a = platformActionListener;
                if (C0818a.this.f5527a != null) {
                    C0818a.this.f5527a.onComplete(platform2, i, map);
                    C0818a.this.f5527a = null;
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i2) {
                C0818a.this.f5527a = platformActionListener;
                if (C0818a.this.f5527a != null) {
                    C0818a.this.f5527a.onComplete(platform2, i, map);
                    C0818a.this.f5527a = null;
                }
            }
        };
        platform.showUser(null);
    }

    /* JADX INFO: renamed from: b */
    private void m5957b(Platform platform, int i, HashMap<String, Object> map) {
        HashMap<String, Object> map2;
        Platform.ShareParams shareParamsRemove = this.f5528b.remove(platform);
        if (map != null) {
            shareParamsRemove = (Platform.ShareParams) map.remove("ShareParams");
        }
        try {
            map2 = (HashMap) map.clone();
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            map2 = map;
        }
        if (shareParamsRemove != null) {
            C0840f c0840f = new C0840f();
            c0840f.f5619o = shareParamsRemove.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                Platform platform2 = ShareSDK.getPlatform("Wechat");
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get(Const.TableSchema.COLUMN_NAME);
            }
            c0840f.f5615b = userId;
            c0840f.f5614a = platform.getPlatformId();
            C0840f.a aVarFilterShareContent = platform.filterShareContent(shareParamsRemove, map2);
            if (aVarFilterShareContent != null) {
                c0840f.f5616c = aVarFilterShareContent.f5620a;
                c0840f.f5617d = aVarFilterShareContent;
            }
            c0840f.f5618n = m5956b(platform);
            C0843d c0843dM6084a = C0843d.m6084a(platform.getContext(), c0840f.f5597g);
            if (c0843dM6084a != null) {
                c0843dM6084a.m6091a(c0840f);
            }
        }
        if (this.f5527a != null) {
            try {
                this.f5527a.onComplete(platform, i, map);
                this.f5527a = null;
            } catch (Throwable th2) {
                C0851d.m6195a().m8610d(th2);
            }
        }
        m5953a(9, platform);
    }

    /* JADX INFO: renamed from: a */
    void m5959a(Platform platform, final int i, final Object obj) {
        final PlatformActionListener platformActionListener = this.f5527a;
        this.f5527a = new PlatformActionListener() { // from class: cn.sharesdk.framework.a.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i2, Throwable th) {
                C0818a.this.f5527a = platformActionListener;
                if (C0818a.this.f5527a != null) {
                    C0818a.this.f5527a.onError(platform2, i2, th);
                    C0818a.this.f5527a = null;
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i2, HashMap<String, Object> map) {
                C0818a.this.f5527a = platformActionListener;
                platform2.afterRegister(i, obj);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i2) {
                C0818a.this.f5527a = platformActionListener;
                if (C0818a.this.f5527a != null) {
                    C0818a.this.f5527a.onCancel(platform2, i);
                    C0818a.this.f5527a = null;
                }
            }
        };
        platform.doAuthorize(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public String m5950a(Platform platform) {
        try {
            return m5951a(platform.getDb(), new String[]{"nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private String m5956b(Platform platform) {
        Platform platform2;
        PlatformDb db = platform.getDb();
        if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db.getUserGender()) && (platform2 = ShareSDK.getPlatform("Wechat")) != null) {
            db = platform2.getDb();
        }
        try {
            return m5951a(db, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m5951a(PlatformDb platformDb, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            if (i > 0) {
                sb2.append('|');
                sb.append('|');
            }
            i++;
            String str2 = platformDb.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb2.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        C0851d.m6195a().m8615i("======UserData: " + sb.toString(), new Object[0]);
        return sb2.toString();
    }
}
