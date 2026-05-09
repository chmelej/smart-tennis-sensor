package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.UserInfoBean;
import com.coollang.tennis.choosephoto.CropImageActivity;
import com.coollang.tennis.choosephoto.ImageChooseActivity_new;
import com.coollang.tennis.fragment.PersonalMainFramgent;
import com.coollang.tennis.fragment.RankListFragment;
import com.coollang.tennis.p011db.model.VideoTable;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import java.io.File;
import org.litepal.crud.DataSupport;
import p000.C1836jt;
import p000.C1839jw;
import p000.C1845kb;
import p000.C1852ki;
import p000.C1900mc;
import p000.C1902me;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    public static final String f6468a = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: c */
    public static boolean f6469c = false;

    /* JADX INFO: renamed from: e */
    private RadioGroup f6472e;

    /* JADX INFO: renamed from: f */
    private RadioButton f6473f;

    /* JADX INFO: renamed from: g */
    private String f6474g;

    /* JADX INFO: renamed from: h */
    private FragmentManager f6475h;

    /* JADX INFO: renamed from: j */
    private PushAgent f6477j;

    /* JADX INFO: renamed from: b */
    public int f6470b = 0;

    /* JADX INFO: renamed from: d */
    private boolean f6471d = true;

    /* JADX INFO: renamed from: i */
    private String f6476i = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            PersonalMainFramgent.f7520c = true;
            PersonalMainFramgent.f7519b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        m6985c();
        setContentView(R.layout.activity_main);
        m6988a(R.color.text_menu_checked);
        this.f6472e = (RadioGroup) findViewById(R.id.menu_radio);
        this.f6473f = (RadioButton) findViewById(R.id.rb_sport);
        this.f6472e.setOnCheckedChangeListener(this);
        m6986d();
        this.f6473f.setChecked(true);
    }

    /* JADX INFO: renamed from: c */
    private void m6985c() {
        if (Build.VERSION.SDK_INT < 21) {
            ((ViewGroup) findViewById(android.R.id.content)).setPadding(0, getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android")), 0, 0);
            getWindow().addFlags(256);
            getWindow().addFlags(512);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m6986d() {
        this.f6475h = getSupportFragmentManager();
        this.f6475h.beginTransaction().add(R.id.fl_content_main, C1836jt.m10014a(0), String.valueOf(0)).commit();
        this.f6474g = String.valueOf(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.f6470b = i;
        String strM10487b = C1902me.m10487b(getApplicationContext(), "Hand", "2");
        UserInfoBean userInfoBeanM7745e = MyApplication.m7738a().m7745e();
        if (userInfoBeanM7745e != null && userInfoBeanM7745e.errDesc != null && userInfoBeanM7745e.errDesc.Hand != null) {
            String str = MyApplication.m7738a().m7745e().errDesc.Hand;
            if (!strM10487b.equals(str) && !"2".equals(strM10487b)) {
                f6469c = true;
            }
            C1902me.m10484a(getApplicationContext(), "Hand", str);
        }
        this.f6477j = PushAgent.getInstance(this);
        this.f6477j.enable(new IUmengRegisterCallback() { // from class: com.coollang.tennis.activity.MainActivity.1
            @Override // com.umeng.message.IUmengRegisterCallback
            public void onRegistered(String str2) {
                C1900mc.m10475c("冬冬", "registerId=" + str2);
            }
        });
        if (userInfoBeanM7745e != null) {
            this.f6477j.setAlias(userInfoBeanM7745e.errDesc.UserID, "Tennis");
            new AsyncTaskC1033a().execute(new Void[0]);
        }
        m6987e();
    }

    /* JADX INFO: renamed from: a */
    public void m6989a(String str) {
        this.f6476i = str;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Environment.getExternalStorageState().equals("mounted")) {
            intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg")));
        }
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
    }

    /* JADX INFO: renamed from: b */
    public void m6990b(String str) {
        this.f6476i = str;
        startActivityForResult(new Intent(this, (Class<?>) ImageChooseActivity_new.class), 2);
        overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.MainActivity$a */
    class AsyncTaskC1033a extends AsyncTask<Void, Void, String> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
        }

        AsyncTaskC1033a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            try {
                return MainActivity.this.f6477j.getTagManager().m1472a("Tennis").toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "Fail";
            }
        }
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rb_history) {
            m6984a(this.f6474g, C1836jt.m10014a(1), String.valueOf(1));
            return;
        }
        if (i == R.id.rb_person) {
            m6984a(this.f6474g, C1836jt.m10014a(3), String.valueOf(3));
        } else if (i == R.id.rb_rank) {
            m6984a(this.f6474g, C1836jt.m10014a(2), String.valueOf(2));
        } else {
            if (i != R.id.rb_sport) {
                return;
            }
            m6984a(this.f6474g, C1836jt.m10014a(0), String.valueOf(0));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6983a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) MainActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    private void m6984a(String str, Fragment fragment, String str2) {
        if (this.f6474g.equals(str2)) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = this.f6475h.beginTransaction();
        Fragment fragmentFindFragmentByTag = this.f6475h.findFragmentByTag(str);
        this.f6474g = str2;
        if (!fragment.isAdded()) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag).add(R.id.fl_content_main, fragment, str2).commit();
        } else {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag).show(fragment).commit();
        }
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || JZVideoPlayer.m5816b()) {
            return true;
        }
        if (!this.f6474g.equals(String.valueOf(0))) {
            this.f6472e.check(R.id.rb_sport);
            return true;
        }
        if (C1839jw.f10820a != null) {
            C1839jw.f10820a.m10016a();
            C1839jw.f10820a = null;
        }
        MyApplication.m7738a().f7401b = false;
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: renamed from: e */
    private void m6987e() {
        if (C1902me.m10489b((Context) this, "VIDEO_TABLE_UPGRATE", true)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("userId", C1902me.m10487b(this, "UserID", "-1"));
            DataSupport.updateAll((Class<?>) VideoTable.class, contentValues, new String[0]);
            C1902me.m10485a((Context) this, "VIDEO_TABLE_UPGRATE", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
        }
        switch (i) {
            case 1:
                if (Environment.getExternalStorageState().equals("mounted")) {
                    CropImageActivity.m7766a(this, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg").getPath(), 3);
                }
                break;
            case 2:
                File file = new File(intent.getStringExtra("pictureURI"));
                File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg");
                if (file2.exists()) {
                    file2.delete();
                }
                File fileM10082a = C1845kb.m10082a(file, file2);
                if (fileM10082a != null) {
                    CropImageActivity.m7766a(this, fileM10082a.getPath(), 3);
                }
                break;
            case 3:
                if (this.f6474g.equals(String.valueOf(2)) && this.f6476i.equals("rankhead")) {
                    ((RankListFragment) C1836jt.m10014a(2)).m7848b();
                } else if (this.f6474g.equals(String.valueOf(3))) {
                    if (this.f6476i.equals("racket")) {
                        ((PersonalMainFramgent) C1836jt.m10014a(3)).m7826d();
                    } else if (this.f6476i.equals("shoes")) {
                        ((PersonalMainFramgent) C1836jt.m10014a(3)).m7827e();
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        JZVideoPlayer.m5813a();
    }

    /* JADX INFO: renamed from: a */
    public void m6988a(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            int dimensionPixelSize = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
            View view = new View(this);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize));
            view.setBackgroundColor(getResources().getColor(i));
            ((ViewGroup) getWindow().getDecorView()).addView(view);
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
        }
    }
}
