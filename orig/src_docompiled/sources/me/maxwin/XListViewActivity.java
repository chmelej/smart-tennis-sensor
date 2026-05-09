package me.maxwin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
import me.maxwin.view.XListView;

/* JADX INFO: loaded from: classes.dex */
public class XListViewActivity extends Activity implements XListView.InterfaceC1905a {

    /* JADX INFO: renamed from: f */
    private static int f11455f;

    /* JADX INFO: renamed from: a */
    private XListView f11456a;

    /* JADX INFO: renamed from: b */
    private ArrayAdapter<String> f11457b;

    /* JADX INFO: renamed from: d */
    private Handler f11459d;

    /* JADX INFO: renamed from: c */
    private ArrayList<String> f11458c = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    private int f11460e = 0;

    /* JADX INFO: renamed from: c */
    static /* synthetic */ int m10495c() {
        int i = f11455f + 1;
        f11455f = i;
        return i;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        m10498d();
        this.f11456a = (XListView) findViewById(R.id.xListView);
        this.f11456a.setPullLoadEnable(true);
        this.f11457b = new ArrayAdapter<>(this, R.layout.list_item, this.f11458c);
        this.f11456a.setAdapter((ListAdapter) this.f11457b);
        this.f11456a.setXListViewListener(this);
        this.f11459d = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m10498d() {
        for (int i = 0; i != 20; i++) {
            ArrayList<String> arrayList = this.f11458c;
            StringBuilder sb = new StringBuilder();
            sb.append("refresh cnt ");
            int i2 = this.f11460e + 1;
            this.f11460e = i2;
            sb.append(i2);
            arrayList.add(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m10499e() {
        this.f11456a.m10510a();
        this.f11456a.m10511b();
        this.f11456a.setRefreshTime("刚刚");
    }

    @Override // me.maxwin.view.XListView.InterfaceC1905a
    /* JADX INFO: renamed from: a */
    public void mo10501a() {
        this.f11459d.postDelayed(new Runnable() { // from class: me.maxwin.XListViewActivity.1
            @Override // java.lang.Runnable
            public void run() {
                XListViewActivity.this.f11460e = XListViewActivity.m10495c();
                XListViewActivity.this.f11458c.clear();
                XListViewActivity.this.m10498d();
                XListViewActivity.this.f11457b = new ArrayAdapter(XListViewActivity.this, R.layout.list_item, XListViewActivity.this.f11458c);
                XListViewActivity.this.f11456a.setAdapter((ListAdapter) XListViewActivity.this.f11457b);
                XListViewActivity.this.m10499e();
            }
        }, 2000L);
    }

    @Override // me.maxwin.view.XListView.InterfaceC1905a
    /* JADX INFO: renamed from: b */
    public void mo10502b() {
        this.f11459d.postDelayed(new Runnable() { // from class: me.maxwin.XListViewActivity.2
            @Override // java.lang.Runnable
            public void run() {
                XListViewActivity.this.m10498d();
                XListViewActivity.this.f11457b.notifyDataSetChanged();
                XListViewActivity.this.m10499e();
            }
        }, 2000L);
    }
}
