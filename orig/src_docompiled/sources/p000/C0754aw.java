package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.R;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextPaint;
import android.util.Log;

/* JADX INFO: renamed from: aw */
/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes.dex */
public class C0754aw {

    /* JADX INFO: renamed from: a */
    public final float f5056a;

    /* JADX INFO: renamed from: b */
    public final ColorStateList f5057b;

    /* JADX INFO: renamed from: c */
    public final ColorStateList f5058c;

    /* JADX INFO: renamed from: d */
    public final ColorStateList f5059d;

    /* JADX INFO: renamed from: e */
    public final int f5060e;

    /* JADX INFO: renamed from: f */
    public final int f5061f;

    /* JADX INFO: renamed from: g */
    public final String f5062g;

    /* JADX INFO: renamed from: h */
    public final boolean f5063h;

    /* JADX INFO: renamed from: i */
    public final ColorStateList f5064i;

    /* JADX INFO: renamed from: j */
    public final float f5065j;

    /* JADX INFO: renamed from: k */
    public final float f5066k;

    /* JADX INFO: renamed from: l */
    public final float f5067l;

    /* JADX INFO: renamed from: m */
    private final int f5068m;

    /* JADX INFO: renamed from: n */
    private boolean f5069n = false;

    /* JADX INFO: renamed from: o */
    private Typeface f5070o;

    public C0754aw(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        this.f5056a = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f5057b = C0753av.m5478a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.f5058c = C0753av.m5478a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f5059d = C0753av.m5478a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f5060e = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f5061f = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int iM5477a = C0753av.m5477a(typedArrayObtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f5068m = typedArrayObtainStyledAttributes.getResourceId(iM5477a, 0);
        this.f5062g = typedArrayObtainStyledAttributes.getString(iM5477a);
        this.f5063h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f5064i = C0753av.m5478a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f5065j = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f5066k = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f5067l = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public Typeface m5485a(Context context) {
        if (this.f5069n) {
            return this.f5070o;
        }
        if (!context.isRestricted()) {
            try {
                this.f5070o = ResourcesCompat.getFont(context, this.f5068m);
                if (this.f5070o != null) {
                    this.f5070o = Typeface.create(this.f5070o, this.f5060e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.f5062g, e);
            }
        }
        m5482a();
        this.f5069n = true;
        return this.f5070o;
    }

    /* JADX INFO: renamed from: a */
    public void m5486a(Context context, final TextPaint textPaint, final ResourcesCompat.FontCallback fontCallback) {
        if (this.f5069n) {
            m5487a(textPaint, this.f5070o);
            return;
        }
        m5482a();
        if (context.isRestricted()) {
            this.f5069n = true;
            m5487a(textPaint, this.f5070o);
            return;
        }
        try {
            ResourcesCompat.getFont(context, this.f5068m, new ResourcesCompat.FontCallback() { // from class: aw.1
                @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                public void onFontRetrieved(Typeface typeface) {
                    C0754aw.this.f5070o = Typeface.create(typeface, C0754aw.this.f5060e);
                    C0754aw.this.m5487a(textPaint, typeface);
                    C0754aw.this.f5069n = true;
                    fontCallback.onFontRetrieved(typeface);
                }

                @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                public void onFontRetrievalFailed(int i) {
                    C0754aw.this.m5482a();
                    C0754aw.this.f5069n = true;
                    fontCallback.onFontRetrievalFailed(i);
                }
            }, null);
        } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.f5062g, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m5482a() {
        if (this.f5070o == null) {
            this.f5070o = Typeface.create(this.f5062g, this.f5060e);
        }
        if (this.f5070o == null) {
            switch (this.f5061f) {
                case 1:
                    this.f5070o = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.f5070o = Typeface.SERIF;
                    break;
                case 3:
                    this.f5070o = Typeface.MONOSPACE;
                    break;
                default:
                    this.f5070o = Typeface.DEFAULT;
                    break;
            }
            if (this.f5070o != null) {
                this.f5070o = Typeface.create(this.f5070o, this.f5060e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5488b(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        m5489c(context, textPaint, fontCallback);
        textPaint.setColor(this.f5057b != null ? this.f5057b.getColorForState(textPaint.drawableState, this.f5057b.getDefaultColor()) : -16777216);
        textPaint.setShadowLayer(this.f5067l, this.f5065j, this.f5066k, this.f5064i != null ? this.f5064i.getColorForState(textPaint.drawableState, this.f5064i.getDefaultColor()) : 0);
    }

    /* JADX INFO: renamed from: c */
    public void m5489c(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        if (C0755ax.m5490a()) {
            m5487a(textPaint, m5485a(context));
            return;
        }
        m5486a(context, textPaint, fontCallback);
        if (this.f5069n) {
            return;
        }
        m5487a(textPaint, this.f5070o);
    }

    /* JADX INFO: renamed from: a */
    public void m5487a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.f5060e;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f5056a);
    }
}
