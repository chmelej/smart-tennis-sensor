package android.support.v4.content.p001pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompat {
    ComponentName mActivity;
    Context mContext;
    CharSequence mDisabledMessage;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    CharSequence mLabel;
    CharSequence mLongLabel;

    ShortcutInfoCompat() {
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        if (this.mIcon != null) {
            intents.setIcon(this.mIcon.toIcon());
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        if (this.mActivity != null) {
            intents.setActivity(this.mActivity);
        }
        return intents.build();
    }

    Intent addToIntent(Intent intent) throws PackageManager.NameNotFoundException {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[this.mIntents.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon != null) {
            Drawable activityIcon = null;
            if (this.mIsAlwaysBadged) {
                PackageManager packageManager = this.mContext.getPackageManager();
                if (this.mActivity != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(this.mActivity);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.addToShortcutIntent(intent, activityIcon, this.mContext);
        }
        return intent;
    }

    public String getId() {
        return this.mId;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public Intent getIntent() {
        return this.mIntents[this.mIntents.length - 1];
    }

    public Intent[] getIntents() {
        return (Intent[]) Arrays.copyOf(this.mIntents, this.mIntents.length);
    }

    public static class Builder {
        private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();

        public Builder(Context context, String str) {
            this.mInfo.mContext = context;
            this.mInfo.mId = str;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        public Builder setActivity(ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            if (this.mInfo.mIntents == null || this.mInfo.mIntents.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            return this.mInfo;
        }
    }
}
