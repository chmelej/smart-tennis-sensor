package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FakeActivity {
    private static Class<? extends Activity> shellClass;
    protected Activity activity;
    private View contentView;
    private HashMap<String, Object> result;
    private FakeActivity resultReceiver;

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onRestart() {
    }

    public void onResult(HashMap<String, Object> map) {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public static void setShell(Class<? extends Activity> cls) {
        shellClass = cls;
    }

    public static void registerExecutor(String str, Object obj) {
        if (shellClass != null) {
            try {
                Method method = shellClass.getMethod("registerExecutor", String.class, Object.class);
                method.setAccessible(true);
                method.invoke(null, str, obj);
                return;
            } catch (Throwable th) {
                MobLog.getInstance().m8622w(th);
                return;
            }
        }
        MobUIShell.registerExecutor(str, obj);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setContentViewLayoutResName(String str) {
        int layoutRes;
        if (this.activity != null && (layoutRes = ResHelper.getLayoutRes(this.activity, str)) > 0) {
            this.activity.setContentView(layoutRes);
        }
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public View getContentView() {
        return this.contentView;
    }

    public <T extends View> T findViewById(int i) {
        if (this.activity == null) {
            return null;
        }
        return (T) this.activity.findViewById(i);
    }

    public <T extends View> T findViewByResName(View view, String str) {
        int idRes;
        if (this.activity != null && (idRes = ResHelper.getIdRes(this.activity, str)) > 0) {
            return (T) view.findViewById(idRes);
        }
        return null;
    }

    public <T extends View> T findViewByResName(String str) {
        int idRes;
        if (this.activity != null && (idRes = ResHelper.getIdRes(this.activity, str)) > 0) {
            return (T) findViewById(idRes);
        }
        return null;
    }

    public final void finish() {
        if (this.activity != null) {
            this.activity.finish();
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.activity == null) {
            return;
        }
        this.activity.startActivityForResult(intent, i);
    }

    public Context getContext() {
        return this.activity;
    }

    public void show(Context context, Intent intent) {
        showForResult(context, intent, null);
    }

    public void show(Context context, Intent intent, boolean z) {
        showForResult(context, intent, null, z);
    }

    public void showForResult(Context context, Intent intent, FakeActivity fakeActivity) {
        showForResult(context, intent, fakeActivity, false);
    }

    public void showForResult(Context context, Intent intent, FakeActivity fakeActivity, final boolean z) {
        Intent intent2;
        this.resultReceiver = fakeActivity;
        Message message = new Message();
        String strRegisterExecutor = null;
        if (shellClass != null) {
            intent2 = new Intent(context, shellClass);
            try {
                Method method = shellClass.getMethod("registerExecutor", Object.class);
                method.setAccessible(true);
                strRegisterExecutor = (String) method.invoke(null, this);
            } catch (Throwable th) {
                MobLog.getInstance().m8622w(th);
            }
        } else {
            intent2 = new Intent(context, (Class<?>) MobUIShell.class);
            strRegisterExecutor = MobUIShell.registerExecutor(this);
        }
        intent2.putExtra("launch_time", strRegisterExecutor);
        intent2.putExtra("executor_name", getClass().getName());
        if (intent != null) {
            intent2.putExtras(intent);
        }
        message.obj = new Object[]{context, intent2};
        UIHandler.sendMessage(message, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message2) {
                Object[] objArr = (Object[]) message2.obj;
                Context context2 = (Context) objArr[0];
                Intent intent3 = (Intent) objArr[1];
                if (z) {
                    intent3.addFlags(268435456);
                    intent3.addFlags(134217728);
                } else if (!(context2 instanceof Activity)) {
                    intent3.addFlags(268435456);
                }
                context2.startActivity(intent3);
                return false;
            }
        });
    }

    public FakeActivity getParent() {
        return this.resultReceiver;
    }

    public final void setResult(HashMap<String, Object> map) {
        this.result = map;
    }

    public void sendResult() {
        if (this.resultReceiver != null) {
            this.resultReceiver.onResult(this.result);
        }
    }

    public void runOnUIThread(final Runnable runnable) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public void runOnUIThread(final Runnable runnable, long j) {
        UIHandler.sendEmptyMessageDelayed(0, j, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public void setRequestedOrientation(int i) {
        if (this.activity == null) {
            return;
        }
        this.activity.setRequestedOrientation(i);
    }

    public void requestPortraitOrientation() {
        setRequestedOrientation(1);
    }

    public void requestLandscapeOrientation() {
        setRequestedOrientation(0);
    }

    public int getOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    public void requestFullScreen(boolean z) {
        if (this.activity == null) {
            return;
        }
        if (z) {
            this.activity.getWindow().addFlags(1024);
            this.activity.getWindow().clearFlags(2048);
        } else {
            this.activity.getWindow().addFlags(2048);
            this.activity.getWindow().clearFlags(1024);
        }
        this.activity.getWindow().getDecorView().requestLayout();
    }

    public void requestPermissions(String[] strArr, int i) {
        if (this.activity != null && Build.VERSION.SDK_INT >= 23) {
            try {
                ReflectHelper.invokeInstanceMethod(this.activity, "requestPermissions", strArr, Integer.valueOf(i));
            } catch (Throwable th) {
                MobLog.getInstance().m8610d(th);
            }
        }
    }
}
