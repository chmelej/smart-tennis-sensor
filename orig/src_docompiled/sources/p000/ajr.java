package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: NotificationBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class ajr {

    /* JADX INFO: renamed from: b */
    protected Context f1349b;

    /* JADX INFO: renamed from: c */
    protected Notification f1350c = new Notification();

    /* JADX INFO: renamed from: d */
    protected Notification.Builder f1351d;

    public ajr(Context context) {
        this.f1349b = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d = new Notification.Builder(context);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m1612e() {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Field declaredField = Notification.Builder.class.getDeclaredField("mActions");
                declaredField.setAccessible(true);
                declaredField.set(this.f1351d, declaredField.get(this.f1351d).getClass().newInstance());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public ajr m1609b(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT < 16 && Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setContent(remoteViews);
        }
        this.f1350c.contentView = remoteViews;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ajr m1607a(PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setContentIntent(pendingIntent);
        }
        this.f1350c.contentIntent = pendingIntent;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ajr m1608a(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setOngoing(z);
        }
        if (z) {
            this.f1350c.flags |= 2;
        } else {
            this.f1350c.flags &= -3;
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ajr m1610b(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setAutoCancel(z);
        }
        if (z) {
            this.f1350c.flags |= 16;
        } else {
            this.f1350c.flags &= -17;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ajr m1605a(int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setSmallIcon(i);
        }
        this.f1350c.icon = i;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public ajr m1611d(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setTicker(charSequence);
        }
        this.f1350c.tickerText = charSequence;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ajr m1606a(long j) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1351d.setWhen(j);
        }
        this.f1350c.when = j;
        return this;
    }
}
