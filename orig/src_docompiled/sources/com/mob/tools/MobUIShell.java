package com.mob.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.mob.tools.utils.ReflectHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MobUIShell extends Activity {
    private static HashMap<String, FakeActivity> executors = new HashMap<>();
    public static int forceTheme;
    private FakeActivity executor;

    static {
        MobLog.getInstance().m8609d("===============================", new Object[0]);
        MobLog.getInstance().m8609d("MobTools " + "2016-12-22".replace("-0", "-").replace("-", "."), new Object[0]);
        MobLog.getInstance().m8609d("===============================", new Object[0]);
    }

    protected static String registerExecutor(Object obj) {
        return registerExecutor(String.valueOf(System.currentTimeMillis()), obj);
    }

    protected static String registerExecutor(String str, Object obj) {
        executors.put(str, (FakeActivity) obj);
        return str;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (forceTheme > 0) {
            super.setTheme(forceTheme);
        } else {
            super.setTheme(i);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        try {
            String stringExtra = intent.getStringExtra("launch_time");
            String stringExtra2 = intent.getStringExtra("executor_name");
            this.executor = executors.remove(stringExtra);
            if (this.executor == null) {
                this.executor = executors.remove(intent.getScheme());
                if (this.executor == null) {
                    this.executor = getDefault();
                    if (this.executor == null) {
                        MobLog.getInstance().m8622w(new RuntimeException("Executor lost! launchTime = " + stringExtra + ", executorName: " + stringExtra2));
                        super.onCreate(bundle);
                        finish();
                        return;
                    }
                }
            }
            MobLog.getInstance().m8615i("MobUIShell found executor: " + this.executor.getClass(), new Object[0]);
            this.executor.setActivity(this);
            super.onCreate(bundle);
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onCreate", new Object[0]);
            this.executor.onCreate();
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            super.onCreate(bundle);
            finish();
        }
    }

    public FakeActivity getDefault() {
        Object objNewInstance;
        try {
            String string = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString("defaultActivity");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (string.startsWith(".")) {
                string = getPackageName() + string;
            }
            String strImportClass = ReflectHelper.importClass(string);
            if (TextUtils.isEmpty(strImportClass) || (objNewInstance = ReflectHelper.newInstance(strImportClass, new Object[0])) == null || !(objNewInstance instanceof FakeActivity)) {
                return null;
            }
            return (FakeActivity) objNewInstance;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        super.setContentView(view);
        if (this.executor != null) {
            this.executor.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            super.setContentView(view);
        } else {
            super.setContentView(view, layoutParams);
        }
        if (this.executor != null) {
            this.executor.setContentView(view);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (this.executor == null) {
            super.onNewIntent(intent);
        } else {
            this.executor.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        if (this.executor != null) {
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onStart", new Object[0]);
            this.executor.onStart();
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.executor != null) {
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onResume", new Object[0]);
            this.executor.onResume();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (this.executor != null) {
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onPause", new Object[0]);
            this.executor.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.executor != null) {
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onStop", new Object[0]);
            this.executor.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        if (this.executor != null) {
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onRestart", new Object[0]);
            this.executor.onRestart();
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.executor != null) {
            this.executor.sendResult();
            MobLog.getInstance().m8609d(this.executor.getClass().getSimpleName() + " onDestroy", new Object[0]);
            this.executor.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.executor != null) {
            this.executor.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.executor != null ? this.executor.onKeyEvent(i, keyEvent) : false) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.executor != null ? this.executor.onKeyEvent(i, keyEvent) : false) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.executor != null) {
            this.executor.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.executor != null) {
            this.executor.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.executor == null || !this.executor.onFinish()) {
            super.finish();
        }
    }

    public Object getExecutor() {
        return this.executor;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.executor != null ? this.executor.onCreateOptionsMenu(menu) : super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.executor != null ? this.executor.onOptionsItemSelected(menuItem) : super.onOptionsItemSelected(menuItem);
    }
}
