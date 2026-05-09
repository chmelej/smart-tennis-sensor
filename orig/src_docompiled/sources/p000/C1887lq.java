package p000;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.GetEmailPasswordActivity;
import com.coollang.tennis.activity.PerfectInformationActivity;
import com.coollang.tennis.activity.SettingActivity;
import com.coollang.tennis.activity.SettingAddAchieveActivity;
import com.coollang.tennis.activity.SettingHistoryActivity;
import com.coollang.tennis.activity.SettingInputActivity;
import com.coollang.tennis.activity.SettingInputCheckActivity;
import com.coollang.tennis.activity.SettingMyEquipActivity;
import com.coollang.tennis.activity.SettingPersonInfoActivity;
import com.coollang.tennis.activity.SettingRollBirthdayActivity;
import com.coollang.tennis.activity.SettingRollMonthActivity;
import com.coollang.tennis.activity.SettingRollSeletctActivity;
import com.coollang.tennis.activity.SettingSelectListActivity;
import com.coollang.tennis.activity.SettingSelectRacketLineActivity;
import com.coollang.tennis.activity.SettingSelectRacketTypeActivity;
import com.coollang.tennis.activity.SettingTennisLevelActivity;
import com.coollang.tennis.activity.ShowImageActivity;
import com.coollang.tennis.activity.TrainHandInfoActivity;
import com.coollang.tennis.activity.TrainHandReportActivity;
import com.coollang.tennis.activity.TrainHistoryActivity;
import com.coollang.tennis.activity.TrainOnTimeActivity;
import com.coollang.tennis.activity.TrainSendInfoActivity;
import com.coollang.tennis.activity.TrainSendReportActivity;
import com.coollang.tennis.activity.UpdateDeviceActivity;
import com.coollang.tennis.activity.WebVideoPlayActivity;

/* JADX INFO: renamed from: lq */
/* JADX INFO: compiled from: ActivitySwitcher.java */
/* JADX INFO: loaded from: classes.dex */
public class C1887lq {
    /* JADX INFO: renamed from: a */
    public static void m10412a(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) WebVideoPlayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("videourl", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10407a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) TrainHistoryActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: b */
    public static void m10416b(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) TrainOnTimeActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10409a(Activity activity, int i, int i2) {
        Intent intent = new Intent(activity, (Class<?>) TrainHandReportActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("mainid", i);
        bundle.putInt("trainTime", i2);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: b */
    public static void m10417b(Activity activity, int i, int i2) {
        Intent intent = new Intent(activity, (Class<?>) TrainSendReportActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("mainid", i);
        bundle.putInt("trainTime", i2);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: c */
    public static void m10421c(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) TrainHandInfoActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: d */
    public static void m10424d(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) TrainSendInfoActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: e */
    public static void m10427e(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SettingActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10415a(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, (Class<?>) SettingAddAchieveActivity.class);
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("year", str);
        bundle.putString("archieve", str2);
        bundle.putInt("position", i);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: f */
    public static void m10428f(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SettingHistoryActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10408a(Activity activity, int i) {
        Intent intent = new Intent(activity, (Class<?>) SettingSelectListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("racketSelect", i);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10410a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingSelectRacketTypeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("racketname", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: g */
    public static void m10429g(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SettingMyEquipActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: b */
    public static void m10418b(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingRollSeletctActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("rollType", i);
        bundle.putString("rollData", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10411a(Activity activity, int i, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, (Class<?>) SettingSelectRacketLineActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("lineDirection", i);
        bundle.putString("lineFactory", str);
        bundle.putString("lineType", str2);
        bundle.putString("lineWidth", str3);
        bundle.putString("linePower", str4);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: c */
    public static void m10422c(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingInputActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("content", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: h */
    public static void m10430h(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SettingPersonInfoActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: d */
    public static void m10425d(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingInputCheckActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("content", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: b */
    public static void m10419b(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingRollBirthdayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("birthday", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: c */
    public static void m10423c(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingTennisLevelActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("content", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10413a(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, (Class<?>) SettingRollMonthActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("equipDate", str);
        bundle.putInt("roll_type", i);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static void m10414a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) PerfectInformationActivity.class);
        intent.putExtra("headurl", str);
        intent.putExtra("nickname", str2);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: d */
    public static void m10426d(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) ShowImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: i */
    public static void m10431i(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) GetEmailPasswordActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: b */
    public static void m10420b(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, (Class<?>) UpdateDeviceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device_version", str);
        bundle.putInt("device_type", i);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
