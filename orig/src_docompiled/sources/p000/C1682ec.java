package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: renamed from: ec */
/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1682ec {

    /* JADX INFO: renamed from: a */
    private static C1682ec f9464a;

    /* JADX INFO: renamed from: b */
    private final Context f9465b;

    /* JADX INFO: renamed from: c */
    private final LocationManager f9466c;

    /* JADX INFO: renamed from: d */
    private final a f9467d = new a();

    /* JADX INFO: renamed from: a */
    public static C1682ec m8937a(Context context) {
        if (f9464a == null) {
            Context applicationContext = context.getApplicationContext();
            f9464a = new C1682ec(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f9464a;
    }

    C1682ec(Context context, LocationManager locationManager) {
        this.f9465b = context;
        this.f9466c = locationManager;
    }

    /* JADX INFO: renamed from: a */
    public boolean m8941a() {
        a aVar = this.f9467d;
        if (m8940c()) {
            return aVar.f9468a;
        }
        Location locationM8939b = m8939b();
        if (locationM8939b != null) {
            m8938a(locationM8939b);
            return aVar.f9468a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: b */
    private Location m8939b() {
        Location locationM8936a = PermissionChecker.checkSelfPermission(this.f9465b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m8936a("network") : null;
        Location locationM8936a2 = PermissionChecker.checkSelfPermission(this.f9465b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? m8936a("gps") : null;
        return (locationM8936a2 == null || locationM8936a == null) ? locationM8936a2 != null ? locationM8936a2 : locationM8936a : locationM8936a2.getTime() > locationM8936a.getTime() ? locationM8936a2 : locationM8936a;
    }

    /* JADX INFO: renamed from: a */
    private Location m8936a(String str) {
        try {
            if (this.f9466c.isProviderEnabled(str)) {
                return this.f9466c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m8940c() {
        return this.f9467d.f9473f > System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    private void m8938a(Location location) {
        long j;
        a aVar = this.f9467d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1681eb c1681ebM8934a = C1681eb.m8934a();
        c1681ebM8934a.m8935a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = c1681ebM8934a.f9461a;
        c1681ebM8934a.m8935a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = c1681ebM8934a.f9463c == 1;
        long j3 = c1681ebM8934a.f9462b;
        long j4 = c1681ebM8934a.f9461a;
        boolean z2 = z;
        c1681ebM8934a.m8935a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j5 = c1681ebM8934a.f9462b;
        if (j3 == -1 || j4 == -1) {
            j = jCurrentTimeMillis + 43200000;
        } else {
            j = (jCurrentTimeMillis > j4 ? j5 + 0 : jCurrentTimeMillis > j3 ? j4 + 0 : j3 + 0) + 60000;
        }
        aVar.f9468a = z2;
        aVar.f9469b = j2;
        aVar.f9470c = j3;
        aVar.f9471d = j4;
        aVar.f9472e = j5;
        aVar.f9473f = j;
    }

    /* JADX INFO: renamed from: ec$a */
    /* JADX INFO: compiled from: TwilightManager.java */
    static class a {

        /* JADX INFO: renamed from: a */
        boolean f9468a;

        /* JADX INFO: renamed from: b */
        long f9469b;

        /* JADX INFO: renamed from: c */
        long f9470c;

        /* JADX INFO: renamed from: d */
        long f9471d;

        /* JADX INFO: renamed from: e */
        long f9472e;

        /* JADX INFO: renamed from: f */
        long f9473f;

        a() {
        }
    }
}
