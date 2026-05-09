package p000;

import android.R;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.umeng.message.MsgConstant;
import com.umeng.message.NotificationProxyBroadcastReceiver;
import com.umeng.message.PushAgent;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

/* JADX INFO: compiled from: UmengNotificationBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class ahl implements Serializable {

    /* JADX INFO: renamed from: a */
    private static String f1031a = "ahl";

    /* JADX INFO: renamed from: b */
    private String f1032b;

    /* JADX INFO: renamed from: c */
    private String f1033c;

    /* JADX INFO: renamed from: d */
    private int f1034d;

    /* JADX INFO: renamed from: e */
    private int f1035e;

    /* JADX INFO: renamed from: f */
    private String f1036f;

    /* JADX INFO: renamed from: g */
    private String f1037g;

    /* JADX INFO: renamed from: h */
    private String f1038h;

    /* JADX INFO: renamed from: i */
    private boolean f1039i;

    /* JADX INFO: renamed from: j */
    private boolean f1040j;

    /* JADX INFO: renamed from: k */
    private boolean f1041k;

    /* JADX INFO: renamed from: l */
    private boolean f1042l;

    /* JADX INFO: renamed from: m */
    private int f1043m;

    /* JADX INFO: renamed from: n */
    private int f1044n;

    /* JADX INFO: renamed from: o */
    private int f1045o;

    /* JADX INFO: renamed from: p */
    private int f1046p;

    /* JADX INFO: renamed from: q */
    private int f1047q;

    public ahl() {
        this.f1032b = ail.m1337a();
        this.f1034d = 16;
        this.f1039i = true;
        this.f1040j = true;
        this.f1041k = true;
        this.f1042l = true;
        this.f1047q = -1;
        this.f1046p = -1;
        this.f1045o = -1;
        this.f1044n = -1;
        this.f1043m = -1;
    }

    ahl(String str) {
        this.f1032b = ail.m1337a();
        this.f1034d = 16;
        this.f1039i = true;
        this.f1040j = true;
        this.f1041k = true;
        this.f1042l = true;
        this.f1047q = -1;
        this.f1046p = -1;
        this.f1045o = -1;
        this.f1044n = -1;
        this.f1043m = -1;
        if (!TextUtils.isEmpty(str)) {
            this.f1033c = str;
        } else {
            this.f1033c = "";
            ahb.m1041b(f1031a, "localNotificationId is null");
        }
    }

    ahl(Cursor cursor) {
        if (cursor != null) {
            this.f1032b = cursor.getString(cursor.getColumnIndex("id"));
            this.f1033c = cursor.getString(cursor.getColumnIndex("localnotification_id"));
            this.f1034d = cursor.getInt(cursor.getColumnIndex("flags"));
            this.f1035e = cursor.getInt(cursor.getColumnIndex("defaults"));
            this.f1036f = cursor.getString(cursor.getColumnIndex("smallicon_drawable"));
            this.f1037g = cursor.getString(cursor.getColumnIndex("largeicon_drawable"));
            this.f1038h = cursor.getString(cursor.getColumnIndex("sound_drawable"));
            this.f1039i = cursor.getInt(cursor.getColumnIndex("play_vibrate")) == 1;
            this.f1040j = cursor.getInt(cursor.getColumnIndex("play_lights")) == 1;
            this.f1041k = cursor.getInt(cursor.getColumnIndex("play_sound")) == 1;
            this.f1042l = cursor.getInt(cursor.getColumnIndex("screen_on")) == 1;
            this.f1043m = cursor.getInt(cursor.getColumnIndex("layout_id"));
            this.f1044n = cursor.getInt(cursor.getColumnIndex("layout_title_id"));
            this.f1045o = cursor.getInt(cursor.getColumnIndex("layout_content_id"));
            this.f1046p = cursor.getInt(cursor.getColumnIndex("layout_icon_id"));
            this.f1047q = cursor.getInt(cursor.getColumnIndex("layout_icon_drawable_id"));
        }
    }

    /* JADX INFO: renamed from: a */
    public Notification m1159a(Context context, String str, String str2, String str3) {
        Notification notificationBuild;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        int iM1154c = m1154c(context);
        ahb.m1043c(f1031a, "title=" + str);
        ahb.m1043c(f1031a, "smallIconId=" + iM1154c);
        if (iM1154c <= 0) {
            return null;
        }
        builder.setSmallIcon(iM1154c);
        Bitmap bitmapM1155d = m1155d(context);
        boolean z = (this.f1034d & 16) != 0;
        ahb.m1043c(f1031a, "flags=" + this.f1034d);
        ahb.m1043c(f1031a, "isAutoCancel=" + z);
        if (this.f1043m <= 0 || this.f1044n <= 0 || this.f1045o <= 0 || this.f1046p <= 0 || this.f1047q <= 0) {
            if (bitmapM1155d != null) {
                builder.setLargeIcon(bitmapM1155d);
            }
            builder.setContentTitle(str).setContentText(str2).setTicker(str3).setAutoCancel(z);
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setBigContentTitle(str);
            bigTextStyle.bigText(str2);
            builder.setStyle(bigTextStyle);
            notificationBuild = builder.build();
        } else {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.f1043m);
            remoteViews.setTextViewText(this.f1044n, str);
            remoteViews.setTextViewText(this.f1045o, str2);
            remoteViews.setImageViewBitmap(this.f1047q, bitmapM1155d);
            remoteViews.setImageViewResource(this.f1046p, iM1154c);
            builder.setContent(remoteViews);
            builder.setAutoCancel(z);
            notificationBuild = builder.build();
            notificationBuild.contentView = remoteViews;
        }
        int iM1153b = m1153b(context);
        if ((iM1153b & 1) != 0) {
            Uri uriM1156e = m1156e(context);
            if (uriM1156e != null) {
                notificationBuild.sound = uriM1156e;
            }
            if (uriM1156e != null) {
                iM1153b ^= 1;
            }
        }
        notificationBuild.defaults = iM1153b;
        notificationBuild.contentIntent = m1152a(context);
        return notificationBuild;
    }

    /* JADX INFO: renamed from: a */
    public void m1161a(Context context, Notification notification) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int iNextInt = MsgConstant.NOTIFICATION_MERGE_ID;
            try {
                if (!PushAgent.getInstance(context).getMergeNotificaiton()) {
                    iNextInt = new Random().nextInt();
                } else if (!ail.m1348b(context) || !ail.m1342a(context) || PushAgent.getInstance(context).getNotificationOnForeground()) {
                    notificationManager.cancel(MsgConstant.NOTIFICATION_MERGE_ID);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ail.m1348b(context) && ail.m1342a(context) && !PushAgent.getInstance(context).getNotificationOnForeground()) {
                return;
            }
            notificationManager.notify(iNextInt, notification);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private PendingIntent m1152a(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 12);
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, 268435456);
    }

    /* JADX INFO: renamed from: b */
    private int m1153b(Context context) {
        if (!m1157f(context)) {
            i = this.f1039i ? 0 | this.f1035e | 2 : 0;
            if (this.f1040j) {
                i |= this.f1035e | 4;
            }
            if (this.f1041k) {
                i = this.f1035e | 1 | i;
            }
            if (this.f1042l) {
                m1158g(context);
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: c */
    private int m1154c(Context context) {
        try {
            iM1088a = TextUtils.isEmpty(this.f1036f) ? -1 : ahe.m1087a(context).m1088a(this.f1036f);
            if (iM1088a < 0) {
                iM1088a = ahe.m1087a(context).m1088a("umeng_push_notification_default_small_icon");
            }
            if (iM1088a < 0) {
                ahb.m1043c(f1031a, "no custom notificaiton icon, fail back to app icon.");
                iM1088a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
            }
            if (iM1088a < 0) {
                ahb.m1041b(f1031a, "Cann't find appropriate icon for notification, please make sure you have specified an icon for this notification or the app has defined an icon.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iM1088a;
    }

    /* JADX INFO: renamed from: d */
    private Bitmap m1155d(Context context) {
        int iM1351a;
        try {
            int iM1088a = TextUtils.isEmpty(this.f1037g) ? -1 : ahe.m1087a(context).m1088a(this.f1037g);
            if (iM1088a < 0) {
                iM1088a = ahe.m1087a(context).m1088a("umeng_push_notification_default_large_icon");
            }
            Bitmap bitmapDecodeResource = iM1088a > 0 ? BitmapFactory.decodeResource(context.getResources(), iM1088a) : null;
            if (bitmapDecodeResource != null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    iM1351a = (int) context.getResources().getDimension(R.dimen.notification_large_icon_height);
                } else {
                    iM1351a = aim.m1351a(64.0f);
                }
                return Bitmap.createScaledBitmap(bitmapDecodeResource, iM1351a, iM1351a, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    private Uri m1156e(Context context) {
        String str;
        try {
            int iM1089b = TextUtils.isEmpty(this.f1038h) ? -1 : ahe.m1087a(context).m1089b(this.f1038h);
            if (iM1089b < 0) {
                iM1089b = ahe.m1087a(context).m1089b("umeng_push_notification_default_sound");
            }
            if (iM1089b > 0) {
                str = "android.resource://" + context.getPackageName() + "/" + iM1089b;
            } else {
                str = null;
            }
            if (str != null) {
                return Uri.parse(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    private boolean m1157f(Context context) {
        int i = (Calendar.getInstance().get(11) * 60) + Calendar.getInstance().get(12);
        boolean z = i >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z2 = i <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        if ((PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute()) {
            if (!z || !z2) {
                return false;
            }
        } else if (!z && !z2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ahl$1] */
    @SuppressLint({"NewApi", "Wakelock"})
    /* JADX INFO: renamed from: g */
    private void m1158g(Context context) {
        try {
            final PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean zM1165a = false;
            if (Build.VERSION.SDK_INT >= 7) {
                zM1165a = new Object() { // from class: ahl.1
                    /* JADX INFO: renamed from: a */
                    boolean m1165a() {
                        return powerManager.isScreenOn();
                    }
                }.m1165a();
            } else {
                ahb.m1043c(f1031a, "android os version < 7, skip checking screen on status");
            }
            ahb.m1043c(f1031a, "screen on................................." + zM1165a);
            if (zM1165a) {
                return;
            }
            powerManager.newWakeLock(805306374, "MyLock").acquire(10000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public String m1160a() {
        return this.f1032b;
    }

    /* JADX INFO: renamed from: b */
    public String m1163b() {
        return this.f1033c;
    }

    /* JADX INFO: renamed from: a */
    public void m1162a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1033c = str;
        } else {
            this.f1033c = "";
            ahb.m1041b(f1031a, "localNotificationId is null");
        }
    }

    /* JADX INFO: renamed from: c */
    public ContentValues m1164c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", this.f1032b);
        contentValues.put("localnotification_id", this.f1033c);
        contentValues.put("flags", Integer.valueOf(this.f1034d));
        contentValues.put("defaults", Integer.valueOf(this.f1035e));
        contentValues.put("smallicon_drawable", this.f1036f);
        contentValues.put("largeicon_drawable", this.f1037g);
        contentValues.put("sound_drawable", this.f1038h);
        contentValues.put("play_vibrate", Boolean.valueOf(this.f1039i));
        contentValues.put("play_lights", Boolean.valueOf(this.f1040j));
        contentValues.put("play_sound", Boolean.valueOf(this.f1041k));
        contentValues.put("screen_on", Boolean.valueOf(this.f1042l));
        contentValues.put("layout_id", Integer.valueOf(this.f1043m));
        contentValues.put("layout_title_id", Integer.valueOf(this.f1044n));
        contentValues.put("layout_content_id", Integer.valueOf(this.f1045o));
        contentValues.put("layout_icon_id", Integer.valueOf(this.f1046p));
        contentValues.put("layout_icon_drawable_id", Integer.valueOf(this.f1047q));
        return contentValues;
    }
}
