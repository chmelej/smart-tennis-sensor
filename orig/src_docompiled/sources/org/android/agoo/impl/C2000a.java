package org.android.agoo.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import org.android.agoo.service.ElectionReceiverService;
import org.json.JSONObject;
import p000.ahx;
import p000.ahz;
import p000.aid;
import p000.ais;
import p000.aiv;
import p000.apo;
import p000.apu;
import p000.aqz;
import p000.arb;
import p000.arf;
import p000.arg;
import p000.arj;

/* JADX INFO: renamed from: org.android.agoo.impl.a */
/* JADX INFO: compiled from: ElectionService.java */
/* JADX INFO: loaded from: classes.dex */
final class C2000a {

    /* JADX INFO: renamed from: c */
    private static String f12022c = null;

    /* JADX INFO: renamed from: d */
    private static String f12023d = "";

    /* JADX INFO: renamed from: e */
    private static Map<String, String> f12024e;

    /* JADX INFO: renamed from: f */
    private static Context f12025f;

    /* JADX INFO: renamed from: h */
    private static Handler f12027h;

    /* JADX INFO: renamed from: a */
    private static final aqz f12020a = new arf();

    /* JADX INFO: renamed from: b */
    private static final Random f12021b = new Random();

    /* JADX INFO: renamed from: g */
    private static HandlerThread f12026g = new HandlerThread("electionService-thread");

    C2000a() {
    }

    static {
        f12026g.start();
        f12027h = new Handler(f12026g.getLooper(), new b());
    }

    /* JADX INFO: renamed from: b */
    private static int m11001b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return Math.abs((packageInfo.versionName + "." + packageInfo.versionCode).hashCode());
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m10990a(PackageInfo packageInfo) {
        try {
            return Math.abs((packageInfo.versionName + "." + packageInfo.versionCode).hashCode());
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    static final void m10995a(Context context, Class<?> cls) {
        try {
            m11009d(context);
            if (cls != null) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), 1, 1);
            }
        } catch (Throwable th) {
            aiv.m1416b("ElectionService", "registerApp", th);
        }
    }

    /* JADX INFO: renamed from: c */
    private static final long m11007c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 2);
            if (Build.VERSION.SDK_INT >= 9) {
                return packageInfo.lastUpdateTime;
            }
            return -1L;
        } catch (Throwable th) {
            aiv.m1421d("ElectionService", "registerApp", th);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: b */
    private static final long m11002b(PackageInfo packageInfo) {
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                return packageInfo.lastUpdateTime;
            }
            return -1L;
        } catch (Throwable th) {
            aiv.m1421d("ElectionService", "registerApp", th);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: d */
    private static final void m11009d(Context context) {
        ContentResolver contentResolver;
        try {
            String strM11011f = m11011f(context);
            String packageName = context.getPackageName();
            String strM4898k = apo.m4898k(context);
            if (TextUtils.isEmpty(strM11011f) || TextUtils.isEmpty(strM4898k) || TextUtils.isEmpty(packageName) || (contentResolver = context.getContentResolver()) == null) {
                return;
            }
            a aVar = new a();
            aVar.m11018b(apu.m4922a());
            aVar.m11016a(m11007c(context));
            aVar.m11015a(m11001b(context));
            aVar.m11019b(apu.m4936f(context));
            String str = String.format("org.agoo.android.packs_v1.%s", strM4898k);
            String string = Settings.System.getString(contentResolver, str);
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(string)) {
                try {
                    String strM1289b = ahz.m1289b(strM11011f, string, 2);
                    if (TextUtils.isEmpty(strM1289b)) {
                        aiv.m1422e("ElectionService", "registerApp[" + string + "][aes decrypt failed]");
                    } else {
                        jSONObject = new JSONObject(strM1289b);
                    }
                } catch (Throwable th) {
                    aiv.m1421d("ElectionService", "registerApp", th);
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put(packageName, aVar);
            aiv.m1418c("ElectionService", "registerApp save[" + jSONObject.toString() + "]");
            Settings.System.putString(contentResolver, str, ahz.m1283a(strM11011f, jSONObject.toString(), 2));
        } catch (Throwable th2) {
            aiv.m1421d("ElectionService", "registerApp", th2);
            arj.m5272a().m5274a(context, "get_CurrentSudo", "get_CurrentSudo", "exp=" + th2.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    static void m11005b(Context context, Class<?> cls) {
        if (context != null) {
            try {
                m11010e(context);
                if (cls != null) {
                    PackageManager packageManager = context.getPackageManager();
                    ComponentName componentName = new ComponentName(context, cls);
                    aiv.m1418c("ElectionService", "unRegisterApp[" + componentName.toString() + "]");
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                }
            } catch (Throwable th) {
                aiv.m1416b("ElectionService", "unRegisterApp", th);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m11010e(Context context) {
        ContentResolver contentResolver;
        try {
            String strM11011f = m11011f(context);
            String packageName = context.getPackageName();
            String strM4898k = apo.m4898k(context);
            if (TextUtils.isEmpty(strM11011f) || TextUtils.isEmpty(strM4898k) || TextUtils.isEmpty(packageName) || (contentResolver = context.getContentResolver()) == null) {
                return;
            }
            String str = String.format("org.agoo.android.packs_v1.%s", strM4898k);
            String string = Settings.System.getString(contentResolver, str);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String strM1289b = ahz.m1289b(strM11011f, string, 2);
            if (TextUtils.isEmpty(strM1289b)) {
                return;
            }
            aiv.m1418c("ElectionService", "unRegister old appInfo[" + strM1289b + "]");
            JSONObject jSONObject = new JSONObject(strM1289b);
            jSONObject.remove(packageName);
            aiv.m1418c("ElectionService", "unRegister save[" + jSONObject.toString() + "]");
            Settings.System.putString(context.getContentResolver(), str, ahz.m1283a(strM11011f, jSONObject.toString(), 2));
        } catch (Throwable th) {
            aiv.m1421d("ElectionService", "Exception", th);
            arj.m5272a().m5274a(context, "get_CurrentSudo", "get_CurrentSudo", "exp=" + th.toString());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:285|51|(4:53|291|54|(2:345|56)(4:57|288|58|(9:347|103|277|104|333|105|106|132|351)(2:63|(13:279|65|66|271|67|321|68|69|315|70|342|71|350)(8:343|89|273|90|(7:92|93|293|94|95|281|96)(1:99)|116|132|351))))(2:344|112)|113|114|319|115|116|132|351) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02b6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02b7, code lost:
    
        r10 = r0;
        r9 = "activityInfo==null";
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02bb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02bc, code lost:
    
        r9 = "activityInfo==null";
        r3 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0429 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x035b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:353:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m10996a(android.content.Context r26, java.lang.String r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.impl.C2000a.m10996a(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    private static void m10997a(Context context, String str, String str2, long j, Map<String, Long> map, d dVar, d dVar2, String str3) {
        String str4;
        String str5;
        String str6;
        if (dVar != null) {
            try {
                if (!dVar.m11029b()) {
                    str4 = (dVar2 == null && dVar2.m11029b()) ? "y" : "n";
                }
            } catch (Throwable th) {
                ais.m1393d(context, "n", th.toString());
                return;
            }
        } else {
            if (dVar2 == null) {
            }
        }
        String strM4892f = apo.m4892f(context);
        if (dVar != null && !dVar.m11029b()) {
            str5 = "remoteRet=" + dVar.m11025a() + "-->remoteFailed=" + dVar.m11029b() + "-->remoteSudoPack=" + dVar.m11032d() + "-->source=" + dVar.m11030c();
            str6 = null;
        } else if (dVar2 == null || dVar2.m11029b()) {
            str5 = null;
            str6 = null;
        } else {
            str6 = "LocalRet=" + dVar2.m11025a() + "-->localFailed=" + dVar2.m11029b() + "-->localSudoPack=" + dVar2.m11032d() + "-->source=" + dVar2.m11030c();
            str5 = null;
        }
        String string = (map == null || map.isEmpty()) ? null : map.toString();
        String str7 = TextUtils.isEmpty(null) ? f12024e.get("electionFailed") : null;
        String str8 = f12024e.get("lock");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("utdid=" + ais.m1388c(context));
        stringBuffer.append("-->");
        stringBuffer.append("deviceId=" + strM4892f);
        stringBuffer.append("-->");
        stringBuffer.append("appkey=" + apu.m4936f(context));
        stringBuffer.append("-->");
        stringBuffer.append("startTime=" + ahx.m1279a(j));
        stringBuffer.append("-->");
        stringBuffer.append("ret=" + str4);
        stringBuffer.append("-->");
        stringBuffer.append("fail_reasons=" + ((String) null));
        stringBuffer.append("-->");
        stringBuffer.append("currentPackage=" + context.getPackageName());
        stringBuffer.append("-->");
        stringBuffer.append("packsMap=" + string);
        stringBuffer.append("-->");
        stringBuffer.append("lastsudo=" + str);
        stringBuffer.append("-->");
        stringBuffer.append("currentsudo=" + str2);
        stringBuffer.append("-->");
        stringBuffer.append("finishtime=" + ahx.m1279a(System.currentTimeMillis()));
        stringBuffer.append("-->");
        stringBuffer.append("errorMapString=" + str7);
        stringBuffer.append("-->");
        stringBuffer.append("lock=" + str8);
        stringBuffer.append("-->");
        stringBuffer.append("errorStr=" + str3);
        stringBuffer.append("-->");
        stringBuffer.append("sdkVersion=" + apu.m4922a());
        stringBuffer.append("-->");
        stringBuffer.append("remoteInfo=" + str5);
        stringBuffer.append("-->");
        stringBuffer.append("localInfo=" + str6);
        stringBuffer.append("-->");
        stringBuffer.append("election");
        ais.m1393d(context, str4, stringBuffer.toString());
    }

    /* JADX INFO: renamed from: a */
    private static d m10994a(Context context, Map<String, Long> map) {
        long j;
        d dVar = new d();
        if (apu.m4943m(context) && m11012g(context)) {
            aiv.m1418c("ElectionService", "election application packs[" + map.toString() + "]");
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.channel.vote");
            arbVar.m5234d("7.0");
            arbVar.m5229b(apu.m4938h(context));
            arbVar.m5224a(apu.m4942l(context));
            arbVar.m5225a("vote_factors", new JSONObject(map).toString());
            arg argVarMo5185a = f12020a.mo5185a(context, arbVar);
            if (argVarMo5185a == null) {
                return null;
            }
            if (!aid.m1307a(argVarMo5185a.m5253a(), argVarMo5185a.m5264f())) {
                dVar.m11026a("[checkHttpOK failed]");
                dVar.m11027a(argVarMo5185a.m5259b());
                f12024e.put("electionFailed", "[checkHttpOK failed]");
                aiv.m1418c("ElectionService", "register--->[failed]");
                return dVar;
            }
            if (argVarMo5185a.m5259b()) {
                aiv.m1418c("ElectionService", "remoteElection--->[result:" + argVarMo5185a.m5260c() + "]");
                try {
                    JSONObject jSONObject = new JSONObject(argVarMo5185a.m5260c());
                    aiv.m1418c("ElectionService", "remoteElection--->[result11:" + jSONObject.toString() + "]");
                    if (jSONObject != null) {
                        String string = jSONObject.getString("sudo_pack");
                        aiv.m1418c("ElectionService", "remoteElection--->[sudo_pack:" + string + "]");
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                j = Long.parseLong(jSONObject.getString("time_out"));
                            } catch (Throwable unused) {
                                j = -1;
                            }
                            dVar.m11031c(string);
                            dVar.m11027a(argVarMo5185a.m5259b());
                            dVar.m11028b("remoteElection");
                            m10998a(context, map, string, j, "remote");
                        } else {
                            dVar.m11027a(false);
                            dVar.m11028b("remoteElection");
                            dVar.m11026a("sudoPack is null");
                        }
                        return dVar;
                    }
                } catch (Throwable th) {
                    dVar.m11028b("remoteElection");
                    dVar.m11026a(th.toString());
                    dVar.m11027a(false);
                    f12024e.put("electionFailed", th.toString());
                    aiv.m1421d("ElectionService", "remoteElection", th);
                    return dVar;
                }
            }
            dVar.m11028b("remoteElection");
            dVar.m11027a(false);
            return dVar;
        }
        dVar.m11028b("remoteElection");
        dVar.m11027a(false);
        dVar.m11026a("no register info");
        return dVar;
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.a$d */
    /* JADX INFO: compiled from: ElectionService.java */
    static final class d {

        /* JADX INFO: renamed from: a */
        private String f12036a;

        /* JADX INFO: renamed from: b */
        private boolean f12037b;

        /* JADX INFO: renamed from: c */
        private String f12038c;

        /* JADX INFO: renamed from: d */
        private String f12039d;

        d() {
        }

        /* JADX INFO: renamed from: a */
        public String m11025a() {
            return this.f12036a;
        }

        /* JADX INFO: renamed from: a */
        public void m11026a(String str) {
            this.f12036a = str;
        }

        /* JADX INFO: renamed from: b */
        public boolean m11029b() {
            return this.f12037b;
        }

        /* JADX INFO: renamed from: a */
        public void m11027a(boolean z) {
            this.f12037b = z;
        }

        /* JADX INFO: renamed from: c */
        public String m11030c() {
            return this.f12038c;
        }

        /* JADX INFO: renamed from: b */
        public void m11028b(String str) {
            this.f12038c = str;
        }

        /* JADX INFO: renamed from: d */
        public String m11032d() {
            return this.f12039d;
        }

        /* JADX INFO: renamed from: c */
        public void m11031c(String str) {
            this.f12039d = str;
        }
    }

    /* JADX INFO: renamed from: b */
    private static d m11004b(Context context, Map<String, Long> map) {
        d dVar = new d();
        if (map == null || map.size() <= 0) {
            aiv.m1422e("ElectionService", "localElection failed [null == packMap || 0 >= packMap.size()]");
            dVar.m11028b("localElection");
            dVar.m11026a("[null == packMap || 0 >= packMap.size()");
            dVar.m11027a(false);
            return dVar;
        }
        long j = -1;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String key = entry.getKey();
            long jLongValue = entry.getValue().longValue();
            if (jLongValue > j) {
                arrayList.clear();
                j = jLongValue;
            }
            if (jLongValue == j) {
                arrayList.add(key);
            }
        }
        String packageName = (String) arrayList.get(f12021b.nextInt(10000) % arrayList.size());
        if (TextUtils.isEmpty(packageName)) {
            dVar.m11028b("localElection");
            dVar.m11031c(packageName);
            dVar.m11027a(true);
            packageName = context.getPackageName();
            aiv.m1418c("ElectionService", "sudoPack==currentPack[:" + packageName + "]");
        }
        m10998a(context, map, packageName, -1L, "local");
        return dVar;
    }

    /* JADX INFO: renamed from: a */
    private static final void m10998a(Context context, Map<String, Long> map, String str, long j, String str2) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String strM10992a = m10992a(context);
        if (!TextUtils.isEmpty(strM10992a)) {
            aiv.m1418c("ElectionService", "noticeElectionResult[lastSudoPack:" + strM10992a + "]");
        }
        aiv.m1418c("ElectionService", "noticeElectionResult[sudoPack:" + str + "][timeout:" + j + "][electionSource:" + str2 + "]");
        f12023d = str;
        m11006b(context, str);
        Intent intent = new Intent();
        intent.putExtra("election_result", str);
        intent.putExtra("election_source", str2);
        intent.putExtra("election_timeout", j);
        intent.setAction("org.agoo.android.intent.action.ELECTION_RESULT_V4");
        intent.setFlags(32);
        intent.addCategory(apo.m4898k(context));
        intent.setPackage(str);
        if (!TextUtils.isEmpty(f12022c)) {
            intent.putExtra("eventId", f12022c);
        }
        f12025f = context;
        apo.m4891e(context, false);
        context.sendBroadcast(intent);
        m10999a(str, intent);
        aiv.m1418c("ElectionService", "lastSudoPack=" + strM10992a);
        aiv.m1418c("ElectionService", "!TextUtils.isEmpty(lastSudoPack)=" + (TextUtils.isEmpty(strM10992a) ^ true));
        aiv.m1418c("ElectionService", "!TextUtils.equals(currentSudoPack, lastSudoPack)=" + (TextUtils.equals(str, strM10992a) ^ true));
        if (TextUtils.isEmpty(strM10992a) || TextUtils.equals(str, strM10992a)) {
            return;
        }
        aiv.m1418c("ElectionService", "noticeElectionResult[lastSudoPack:" + strM10992a + "]stop");
        Intent intent2 = new Intent();
        intent2.putExtra("election_result", str);
        intent2.putExtra("election_source", str2);
        intent2.putExtra("election_timeout", j);
        intent2.setAction("org.agoo.android.intent.action.ELECTION_RESULT_V4");
        intent2.setFlags(32);
        intent2.addCategory(apo.m4898k(context));
        intent2.setPackage(strM10992a);
        context.sendBroadcast(intent2);
        m10999a(strM10992a, intent2);
    }

    /* JADX INFO: renamed from: a */
    private static void m10999a(String str, Intent intent) {
        try {
            f12027h.post(new e(str, intent));
        } catch (Throwable th) {
            Log.e("ElectionService", "noticeElectionBindService error >>", th);
        }
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.a$e */
    /* JADX INFO: compiled from: ElectionService.java */
    static class e implements Runnable {

        /* JADX INFO: renamed from: a */
        private String f12040a;

        /* JADX INFO: renamed from: b */
        private Intent f12041b;

        public e(String str, Intent intent) {
            this.f12040a = str;
            this.f12041b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBindService;
            Intent intent = new Intent();
            Log.d("ElectionService", "this election sudupack:" + this.f12040a + ",action=" + this.f12041b.getAction());
            intent.setAction(this.f12041b.getAction());
            intent.putExtras(this.f12041b.getExtras());
            intent.setFlags(this.f12041b.getFlags());
            intent.setPackage(this.f12041b.getPackage());
            intent.addCategory(apo.m4898k(C2000a.f12025f));
            Log.d("ElectionService", "start to service...");
            try {
                c cVar = new c(intent);
                Intent intent2 = new Intent("org.android.agoo.client.ElectionReceiverService");
                Log.d("ElectionService", "this message pack:" + this.f12040a);
                intent2.setPackage(this.f12040a);
                zBindService = C2000a.f12025f.bindService(intent2, cVar, 17);
            } catch (Exception e) {
                Log.d("ElectionService", "ElectionConnection,bindService error,e=" + e);
                zBindService = false;
            }
            Log.d("ElectionService", "start service ret:" + zBindService);
        }
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.a$c */
    /* JADX INFO: compiled from: ElectionService.java */
    static class c implements ServiceConnection {

        /* JADX INFO: renamed from: a */
        private Intent f12032a;

        /* JADX INFO: renamed from: b */
        private ElectionReceiverService f12033b;

        /* JADX INFO: renamed from: c */
        private ServiceConnection f12034c = this;

        public c(Intent intent) {
            this.f12032a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("ElectionService", "MessageConnection disConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("ElectionService", "ElectionConnection conneted:" + componentName);
            this.f12033b = ElectionReceiverService.Stub.asInterface(iBinder);
            Log.d("ElectionService", "onConnected current tid:" + Thread.currentThread().getId());
            Log.d("ElectionService", "ElectionConnection sent:" + this.f12032a);
            if (this.f12033b != null) {
                C2000a.f12027h.post(new Runnable() { // from class: org.android.agoo.impl.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                Log.d("ElectionService", "onConnected running tid:" + Thread.currentThread().getId());
                                c.this.f12033b.sendElectionResult(c.this.f12032a);
                            } catch (Throwable th) {
                                Log.e("ElectionService", "send error", th);
                            }
                        } finally {
                            C2000a.f12025f.unbindService(c.this.f12034c);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private static final String m11011f(Context context) {
        String strM1388c = ais.m1388c(context);
        if (!TextUtils.isEmpty(strM1388c)) {
            return strM1388c;
        }
        aiv.m1418c("ElectionService", "getPassword[utdid==null]");
        return "17984173941739471471917341";
    }

    /* JADX INFO: renamed from: b */
    private static final void m11006b(Context context, String str) {
        try {
            String str2 = String.format("org.agoo.android.sudo.%s", apo.m4898k(context));
            String strM11011f = m11011f(context);
            if (TextUtils.isEmpty(strM11011f) || TextUtils.isEmpty(str)) {
                return;
            }
            Settings.System.putString(context.getContentResolver(), str2, ahz.m1283a(strM11011f, str, 2));
        } catch (Throwable th) {
            Log.e("ElectionService", "setCurrentSudo", th);
            arj.m5272a().m5274a(context, "set_CurrentSudo", "set_CurrentSudo", "exp=" + th.toString());
        }
    }

    /* JADX INFO: renamed from: c */
    private static final boolean m11008c(Context context, String str) {
        return m11000a(context, str, -1);
    }

    /* JADX INFO: renamed from: a */
    private static final boolean m11000a(Context context, String str, int i) {
        return m10993a(context, str, null, i) != null;
    }

    /* JADX INFO: renamed from: a */
    private static final a m10993a(Context context, String str, String str2, int i) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo;
        JSONObject jSONObject;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (i == -1) {
                try {
                    int i2 = packageManager.getApplicationInfo(context.getPackageName(), 0).flags;
                } catch (Throwable unused) {
                }
            }
            try {
                applicationInfo = packageManager.getApplicationInfo(str, 0);
            } catch (Throwable unused2) {
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][clientApplicationInfo == null][disabled]");
                return null;
            }
            if (!applicationInfo.enabled) {
                aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][disabled]");
                return null;
            }
            try {
                packageInfo = packageManager.getPackageInfo(str, 0);
            } catch (Throwable unused3) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][packageInfo == null][disabled]");
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                String string = Settings.System.getString(context.getContentResolver(), String.format("org.agoo.android.packs_v1.%s", apo.m4898k(context)));
                String strM11011f = m11011f(context);
                if (!TextUtils.isEmpty(strM11011f) && !TextUtils.isEmpty(string)) {
                    String strM1289b = ahz.m1289b(strM11011f, string, 2);
                    if (TextUtils.isEmpty(strM1289b)) {
                        aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][agooPacks==null][failed]");
                        return null;
                    }
                    try {
                        jSONObject = new JSONObject(strM1289b);
                    } catch (Throwable unused4) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][" + strM1289b + "][json parse failed]");
                    }
                    str2 = jSONObject.optString(str);
                }
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][appInfoStr==null][json parse failed]");
                return null;
            }
            a aVarM11013a = a.m11013a(str2);
            if (aVarM11013a == null) {
                aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][appInfo==null][json parse failed]");
                return null;
            }
            long jM11017b = aVarM11013a.m11017b();
            int iM11014a = aVarM11013a.m11014a();
            if (jM11017b != -1 && iM11014a != -1) {
                long jM11002b = m11002b(packageInfo);
                int iM10990a = m10990a(packageInfo);
                if (jM11002b != -1 && jM11002b != -1) {
                    if (jM11002b != jM11017b) {
                        aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][currentInstallTime:" + jM11002b + "]!=settingsAppInstallTime:" + jM11017b + "][disabled]");
                        return null;
                    }
                    if (iM10990a != iM11014a) {
                        aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][currentVersionHash:" + iM10990a + "]!=setttingVersionHash:" + iM11014a + "][disabled]");
                        return null;
                    }
                    aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][enabled]");
                    return aVarM11013a;
                }
                aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][currentInstallTime==-1||currentInstallTime==-1][disabled]");
                return null;
            }
            aiv.m1415b("ElectionService", "checkPackage[pack:" + str + "][setttingInstallTime==-1||setttingVersionHash==-1][json parse failed]");
            return null;
        } catch (Throwable unused5) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final String m10992a(Context context) {
        String str = null;
        try {
            String string = Settings.System.getString(context.getContentResolver(), String.format("org.agoo.android.sudo.%s", apo.m4898k(context)));
            String strM11011f = m11011f(context);
            if (TextUtils.isEmpty(strM11011f) || TextUtils.isEmpty(string)) {
                return null;
            }
            String strM1289b = ahz.m1289b(strM11011f, string, 2);
            if (m11008c(context, strM1289b)) {
                try {
                    aiv.m1418c("ElectionService", "getCurrentSudo[currentSudo:" + strM1289b + "]");
                    return strM1289b;
                } catch (Throwable th) {
                    th = th;
                    str = strM1289b;
                }
            } else {
                aiv.m1418c("ElectionService", "getCurrentSudo[oldSudo:" + strM1289b + "][remove]");
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        arj.m5272a().m5274a(context, "get_CurrentSudo", "get_CurrentSudo", "exp=" + th.toString());
        return str;
    }

    /* JADX INFO: renamed from: g */
    private static final boolean m11012g(Context context) {
        String strM4936f = apu.m4936f(context);
        String strM4938h = apu.m4938h(context);
        if (TextUtils.isEmpty(strM4936f) || TextUtils.isEmpty(strM4938h)) {
            return false;
        }
        f12020a.mo5186a(strM4936f);
        String strM4940j = apu.m4940j(context);
        if (TextUtils.isEmpty(strM4940j) && !apu.m4918D(context)) {
            return false;
        }
        f12020a.mo5188b(strM4940j);
        f12020a.mo5189c(apu.m4920F(context));
        return true;
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.a$a */
    /* JADX INFO: compiled from: ElectionService.java */
    static final class a {

        /* JADX INFO: renamed from: a */
        private long f12028a = -1;

        /* JADX INFO: renamed from: b */
        private long f12029b = -1;

        /* JADX INFO: renamed from: c */
        private int f12030c = -1;

        /* JADX INFO: renamed from: d */
        private String f12031d = null;

        a() {
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appInstallTime", this.f12028a);
                jSONObject.put("appSdkVersion", this.f12029b);
                jSONObject.put("appVersionHash", this.f12030c);
                jSONObject.put("appKey", this.f12031d);
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: a */
        public int m11014a() {
            return this.f12030c;
        }

        /* JADX INFO: renamed from: a */
        public void m11015a(int i) {
            this.f12030c = i;
        }

        /* JADX INFO: renamed from: a */
        static a m11013a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a();
                    try {
                        aVar.f12028a = jSONObject.optLong("appInstallTime", -1L);
                        aVar.f12029b = jSONObject.optLong("appSdkVersion", -1L);
                        aVar.f12030c = jSONObject.optInt("appVersionHash", -1);
                        aVar.f12031d = jSONObject.optString("appKey", null);
                        return aVar;
                    } catch (Throwable unused) {
                        return aVar;
                    }
                }
            } catch (Throwable unused2) {
            }
            return null;
        }

        /* JADX INFO: renamed from: b */
        public long m11017b() {
            return this.f12028a;
        }

        /* JADX INFO: renamed from: a */
        public void m11016a(long j) {
            this.f12028a = j;
        }

        /* JADX INFO: renamed from: c */
        public long m11020c() {
            return this.f12029b;
        }

        /* JADX INFO: renamed from: b */
        public void m11018b(long j) {
            this.f12029b = j;
        }

        /* JADX INFO: renamed from: d */
        public String m11021d() {
            return this.f12031d;
        }

        /* JADX INFO: renamed from: b */
        public void m11019b(String str) {
            this.f12031d = str;
        }
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.a$b */
    /* JADX INFO: compiled from: ElectionService.java */
    static class b implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return true;
        }

        b() {
        }
    }
}
