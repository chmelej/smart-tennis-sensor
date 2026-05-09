package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: renamed from: cn.sharesdk.sina.weibo.a */
/* JADX INFO: compiled from: SinaActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0867a extends FakeActivity implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    private long f5727a = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;

    /* JADX INFO: renamed from: b */
    private boolean f5728b;

    /* JADX INFO: renamed from: c */
    private String f5729c;

    /* JADX INFO: renamed from: d */
    private Platform.ShareParams f5730d;

    /* JADX INFO: renamed from: e */
    private AuthorizeListener f5731e;

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            Intent intent = new Intent();
            intent.setAction("com.sina.weibo.action.browser.share");
            startActivity(intent);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        if (m6226c()) {
            UIHandler.sendEmptyMessageDelayed(1, 700L, new Handler.Callback() { // from class: cn.sharesdk.sina.weibo.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    C0867a.this.m6218a();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6231a(String str) {
        this.f5729c = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6229a(Platform.ShareParams shareParams) {
        this.f5730d = shareParams;
    }

    /* JADX INFO: renamed from: a */
    public void m6230a(AuthorizeListener authorizeListener) {
        this.f5731e = authorizeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6218a() {
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(this.f5730d.getText())) {
            bundle.putParcelable("_weibo_message_text", m6227d());
            bundle.putString("_weibo_message_text_extra", "");
        }
        if (this.f5730d.getImageData() != null || !TextUtils.isEmpty(this.f5730d.getImagePath())) {
            this.f5727a = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            ImageObject imageObjectM6228e = m6228e();
            if (imageObjectM6228e.m8671a()) {
                bundle.putParcelable("_weibo_message_image", imageObjectM6228e);
                bundle.putString("_weibo_message_image_extra", "");
            }
        }
        try {
            try {
                m6221a(this.activity, C0871e.m6269a(this.activity).m6276a(), this.f5729c, bundle);
            } catch (Throwable th) {
                if (this.f5731e != null) {
                    this.f5731e.onError(new Throwable(th));
                }
            }
        } catch (Throwable unused) {
            m6221a(this.activity, "com.sina.weibog3", this.f5729c, bundle);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        C0851d.m6195a().m8609d("sina activity requestCode = %s, resultCode = %s", Integer.valueOf(i), Integer.valueOf(i));
        m6223b();
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        this.f5728b = true;
        Bundle extras = intent.getExtras();
        C0851d.m6195a().m8615i("onNewIntent ==>>", extras.toString());
        String stringExtra = intent.getStringExtra("_weibo_appPackage");
        String stringExtra2 = intent.getStringExtra("_weibo_transaction");
        if (TextUtils.isEmpty(stringExtra)) {
            C0851d.m6195a().m8612e("handleWeiboResponse faild appPackage is null", new Object[0]);
            return;
        }
        String callingPackage = this.activity.getCallingPackage();
        C0851d.m6195a().m8609d("handleWeiboResponse getCallingPackage : " + callingPackage, new Object[0]);
        if (TextUtils.isEmpty(stringExtra2)) {
            C0851d.m6195a().m8612e("handleWeiboResponse faild intent _weibo_transaction is null", new Object[0]);
        } else if (!C0871e.m6270a(this.activity, stringExtra) && !stringExtra.equals(this.activity.getPackageName())) {
            C0851d.m6195a().m8612e("handleWeiboResponse faild appPackage validateSign faild", new Object[0]);
        } else {
            m6219a(extras.getInt("_weibo_resp_errcode"), extras.getString("_weibo_resp_errstr"));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6219a(int i, String str) {
        switch (i) {
            case 0:
                if (this.f5731e != null) {
                    this.f5731e.onComplete(null);
                }
                break;
            case 1:
                if (this.f5731e != null) {
                    this.f5731e.onCancel();
                }
                break;
            case 2:
                if (this.f5731e != null) {
                    this.f5731e.onError(new Throwable(str));
                }
                break;
        }
        finish();
    }

    /* JADX INFO: renamed from: b */
    private void m6223b() {
        UIHandler.sendEmptyMessageDelayed(1, 200L, this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        if (!this.f5728b && this.f5731e != null) {
            this.f5731e.onCancel();
        }
        finish();
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m6221a(Activity activity, String str, String str2, Bundle bundle) {
        if (activity == null || TextUtils.isEmpty("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY") || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0851d.m6195a().m8612e("launchWeiboActivity fail, invalid arguments", new Object[0]);
            return false;
        }
        String packageName = activity.getPackageName();
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", str2);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", m6217a(activity, packageName));
        intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            C0851d.m6195a().m8609d("launchWeiboActivity intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
            activity.startActivityForResult(intent, 765);
            return true;
        } catch (ActivityNotFoundException e) {
            C0851d.m6195a().m8612e(e.getMessage(), new Object[0]);
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m6226c() {
        Intent intent = new Intent();
        intent.setAction("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
        String packageName = this.activity.getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", this.f5729c);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", m6217a(this.activity, packageName));
        C0851d.m6195a().m8609d("intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
        this.activity.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
        return true;
    }

    /* JADX INFO: renamed from: a */
    private String m6217a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                byte[] byteArray = packageInfo.signatures[i].toByteArray();
                if (byteArray != null) {
                    return Data.MD5(byteArray);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private TextObject m6227d() {
        TextObject textObject = new TextObject();
        textObject.f9110a = this.f5730d.getText();
        return textObject;
    }

    /* JADX INFO: renamed from: e */
    private ImageObject m6228e() {
        ImageObject imageObject = new ImageObject();
        try {
            if (this.f5730d.getImageData() != null) {
                imageObject.f9108a = m6222a(this.activity, this.f5730d.getImageData());
            } else if (!TextUtils.isEmpty(this.f5730d.getImagePath())) {
                DeviceHelper deviceHelper = DeviceHelper.getInstance(this.activity);
                try {
                    if (deviceHelper.getSdcardState() && this.f5730d.getImagePath().startsWith(deviceHelper.getSdcardPath())) {
                        File file = new File(this.f5730d.getImagePath());
                        if (file.exists() && file.length() != 0 && file.length() < 10485760) {
                            imageObject.f9109b = this.f5730d.getImagePath();
                            return imageObject;
                        }
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().m8610d(th);
                }
                imageObject.f9108a = m6225b(this.activity, this.f5730d.getImagePath());
            }
        } catch (Throwable th2) {
            C0851d.m6195a().m8610d(th2);
        }
        return imageObject;
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6222a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        return m6224b(context, bitmap);
    }

    /* JADX INFO: renamed from: b */
    private byte[] m6225b(Context context, String str) throws FileNotFoundException {
        if (!new File(str).exists()) {
            throw new FileNotFoundException();
        }
        return m6224b(context, BitmapHelper.getBitmap(str));
    }

    /* JADX INFO: renamed from: b */
    private byte[] m6224b(Context context, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > this.f5727a) {
            bitmap = m6216a(bitmap, ((double) length) / this.f5727a);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            byteArray = byteArrayOutputStream2.toByteArray();
            length = byteArray.length;
        }
        return byteArray;
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m6216a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double dSqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) / dSqrt), (int) (((double) height) / dSqrt), true);
    }
}
