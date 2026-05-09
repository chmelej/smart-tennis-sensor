package cn.smssdk.contact;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.contact.a */
/* JADX INFO: compiled from: AlertPage.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0918a extends FakeActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private static ViewOnClickListenerC0918a f6013a;

    /* JADX INFO: renamed from: b */
    private ArrayList<Runnable> f6014b;

    /* JADX INFO: renamed from: c */
    private ArrayList<Runnable> f6015c;

    /* JADX INFO: renamed from: d */
    private TextView f6016d;

    /* JADX INFO: renamed from: e */
    private TextView f6017e;

    /* JADX INFO: renamed from: f */
    private HashMap<String, Object> f6018f;

    public ViewOnClickListenerC0918a() {
        f6013a = this;
        this.f6014b = new ArrayList<>();
        this.f6015c = new ArrayList<>();
        this.f6018f = new HashMap<>();
        this.f6018f.put("okActions", this.f6014b);
        this.f6018f.put("cancelActions", this.f6015c);
        setResult(this.f6018f);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6634a() {
        return f6013a != null;
    }

    /* JADX INFO: renamed from: a */
    public static void m6633a(Runnable runnable, Runnable runnable2) {
        f6013a.f6014b.add(runnable);
        f6013a.f6015c.add(runnable2);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.activity.setContentView(m6636b());
    }

    /* JADX INFO: renamed from: b */
    private LinearLayout m6636b() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        TextView textView = new TextView(this.activity);
        textView.setBackgroundColor(-13617865);
        int iDipToPx = ResHelper.dipToPx(this.activity, 26);
        textView.setPadding(iDipToPx, 0, iDipToPx, 0);
        textView.setTextColor(-3158065);
        textView.setTextSize(1, 20.0f);
        textView.setText(m6638c());
        textView.setGravity(16);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, ResHelper.dipToPx(this.activity, 52)));
        View view = new View(this.activity);
        view.setBackgroundColor(-15066083);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, ResHelper.dipToPx(this.activity, 2)));
        TextView textView2 = new TextView(this.activity);
        int iDipToPx2 = ResHelper.dipToPx(this.activity, 15);
        textView2.setPadding(iDipToPx2, iDipToPx2, iDipToPx2, iDipToPx2);
        textView2.setTextColor(Res.color.smssdk_lv_title_color);
        textView2.setTextSize(1, 18.0f);
        textView2.setText(m6639d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(textView2, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        int iDipToPx3 = ResHelper.dipToPx(this.activity, 5);
        linearLayout2.setPadding(iDipToPx3, iDipToPx3, iDipToPx3, iDipToPx3);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        this.f6016d = new TextView(this.activity);
        this.f6016d.setTextColor(-6102899);
        this.f6016d.setTextSize(1, 20.0f);
        this.f6016d.setText(m6640e());
        this.f6016d.setBackgroundDrawable(m6641f());
        this.f6016d.setGravity(17);
        int iDipToPx4 = ResHelper.dipToPx(this.activity, 48);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, iDipToPx4);
        layoutParams2.weight = 1.0f;
        linearLayout2.addView(this.f6016d, layoutParams2);
        this.f6016d.setOnClickListener(this);
        linearLayout2.addView(new View(this.activity), new LinearLayout.LayoutParams(iDipToPx3, -1));
        this.f6017e = new TextView(this.activity);
        this.f6017e.setTextColor(-1);
        this.f6017e.setTextSize(1, 20.0f);
        this.f6017e.setText(m6642g());
        this.f6017e.setBackgroundDrawable(m6643h());
        this.f6017e.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, iDipToPx4);
        layoutParams3.weight = 1.0f;
        linearLayout2.addView(this.f6017e, layoutParams3);
        this.f6017e.setOnClickListener(this);
        return linearLayout;
    }

    /* JADX INFO: renamed from: c */
    private String m6638c() {
        return "zh".equals(DeviceHelper.getInstance(this.activity).getOSLanguage()) ? String.valueOf(new char[]{35686, 21578}) : "Warning";
    }

    /* JADX INFO: renamed from: d */
    private String m6639d() {
        String str;
        String appName = DeviceHelper.getInstance(this.activity).getAppName();
        if ("zh".equals(DeviceHelper.getInstance(this.activity).getOSLanguage())) {
            str = "\"%s\"" + String.valueOf(new char[]{24819, 35775, 38382, 24744, 30340, 36890, 20449, 24405});
        } else {
            str = "\"%s\" would like to access your contacts.";
        }
        return String.format(str, appName);
    }

    /* JADX INFO: renamed from: e */
    private String m6640e() {
        return "zh".equals(DeviceHelper.getInstance(this.activity).getOSLanguage()) ? String.valueOf(new char[]{21462, 28040}) : "Cancel";
    }

    /* JADX INFO: renamed from: f */
    private Drawable m6641f() {
        return new ShapeDrawable(new Shape() { // from class: cn.smssdk.contact.a.1
            @Override // android.graphics.drawable.shapes.Shape
            public void draw(Canvas canvas, Paint paint) {
                paint.setColor(-6102899);
                RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
                float fDipToPx = ResHelper.dipToPx(ViewOnClickListenerC0918a.this.activity, 4);
                canvas.drawRoundRect(rectF, fDipToPx, fDipToPx, paint);
                paint.setColor(-1);
                float fDipToPx2 = ResHelper.dipToPx(ViewOnClickListenerC0918a.this.activity, 2);
                canvas.drawRoundRect(new RectF(fDipToPx2, fDipToPx2, getWidth() - fDipToPx2, getHeight() - fDipToPx2), fDipToPx2, fDipToPx2, paint);
            }
        });
    }

    /* JADX INFO: renamed from: g */
    private String m6642g() {
        return "zh".equals(DeviceHelper.getInstance(this.activity).getOSLanguage()) ? String.valueOf(new char[]{32487, 32493}) : "OK";
    }

    /* JADX INFO: renamed from: h */
    private Drawable m6643h() {
        return new ShapeDrawable(new Shape() { // from class: cn.smssdk.contact.a.2
            @Override // android.graphics.drawable.shapes.Shape
            public void draw(Canvas canvas, Paint paint) {
                paint.setColor(-6102899);
                RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
                float fDipToPx = ResHelper.dipToPx(ViewOnClickListenerC0918a.this.activity, 4);
                canvas.drawRoundRect(rectF, fDipToPx, fDipToPx, paint);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f6017e)) {
            this.f6018f.put("res", true);
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        f6013a = null;
        super.onDestroy();
    }
}
