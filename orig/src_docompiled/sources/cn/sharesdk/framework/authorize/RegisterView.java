package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class RegisterView extends ResizeLayout {

    /* JADX INFO: renamed from: a */
    private TitleLayout f5538a;

    /* JADX INFO: renamed from: b */
    private RelativeLayout f5539b;

    /* JADX INFO: renamed from: c */
    private WebView f5540c;

    /* JADX INFO: renamed from: d */
    private TextView f5541d;

    public RegisterView(Context context) {
        super(context);
        m5974a(context);
    }

    public RegisterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5974a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m5974a(Context context) {
        setBackgroundColor(-1);
        setOrientation(1);
        final int iM5975b = m5975b(context);
        this.f5538a = new TitleLayout(context);
        try {
            int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_auth_title_back");
            if (bitmapRes > 0) {
                this.f5538a.setBackgroundResource(bitmapRes);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        this.f5538a.getBtnRight().setVisibility(8);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
        if (stringRes > 0) {
            this.f5538a.getTvTitle().setText(stringRes);
        }
        addView(this.f5538a);
        ImageView imageView = new ImageView(context);
        int bitmapRes2 = ResHelper.getBitmapRes(context, "ssdk_logo");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(0, 0, ResHelper.dipToPx(context, 10), 0);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.authorize.RegisterView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    int stringRes2 = ResHelper.getStringRes(view.getContext(), "ssdk_website");
                    String string = stringRes2 > 0 ? view.getResources().getString(stringRes2) : null;
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
                } catch (Throwable th2) {
                    C0851d.m6195a().m8610d(th2);
                }
            }
        });
        this.f5538a.addView(imageView);
        this.f5539b = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.f5539b.setLayoutParams(layoutParams);
        addView(this.f5539b);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f5539b.addView(linearLayout);
        this.f5541d = new TextView(context);
        this.f5541d.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
        this.f5541d.setBackgroundColor(-12929302);
        linearLayout.addView(this.f5541d);
        this.f5541d.setVisibility(8);
        this.f5540c = new WebView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.f5540c.setLayoutParams(layoutParams2);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.sharesdk.framework.authorize.RegisterView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) RegisterView.this.f5541d.getLayoutParams();
                layoutParams3.width = (iM5975b * i) / 100;
                RegisterView.this.f5541d.setLayoutParams(layoutParams3);
                if (i <= 0 || i >= 100) {
                    RegisterView.this.f5541d.setVisibility(8);
                } else {
                    RegisterView.this.f5541d.setVisibility(0);
                }
            }
        };
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
            try {
                Method method = this.f5540c.getClass().getMethod("removeJavascriptInterface", String.class);
                method.setAccessible(true);
                method.invoke(this.f5540c, "searchBoxJavaBridge_");
            } catch (Throwable th2) {
                C0851d.m6195a().m8610d(th2);
            }
        }
        this.f5540c.setWebChromeClient(webChromeClient);
        linearLayout.addView(this.f5540c);
        this.f5540c.requestFocus();
    }

    /* JADX INFO: renamed from: b */
    private int m5975b(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(context instanceof Activity) || (windowManager = ((Activity) context).getWindowManager()) == null) {
            return 0;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* JADX INFO: renamed from: a */
    public View m5976a() {
        return this.f5538a.getBtnBack();
    }

    /* JADX INFO: renamed from: a */
    public void m5977a(boolean z) {
        this.f5538a.setVisibility(z ? 8 : 0);
    }

    /* JADX INFO: renamed from: b */
    public WebView m5978b() {
        return this.f5540c;
    }

    /* JADX INFO: renamed from: c */
    public TitleLayout m5979c() {
        return this.f5538a;
    }

    /* JADX INFO: renamed from: d */
    public RelativeLayout m5980d() {
        return this.f5539b;
    }
}
