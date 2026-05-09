package p000;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.support.v7.widget.AppCompatEditText;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: fx */
/* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C1732fx {

    /* JADX INFO: renamed from: a */
    private static final RectF f9895a = new RectF();

    /* JADX INFO: renamed from: b */
    private static ConcurrentHashMap<String, Method> f9896b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c */
    private int f9897c = 0;

    /* JADX INFO: renamed from: d */
    private boolean f9898d = false;

    /* JADX INFO: renamed from: e */
    private float f9899e = -1.0f;

    /* JADX INFO: renamed from: f */
    private float f9900f = -1.0f;

    /* JADX INFO: renamed from: g */
    private float f9901g = -1.0f;

    /* JADX INFO: renamed from: h */
    private int[] f9902h = new int[0];

    /* JADX INFO: renamed from: i */
    private boolean f9903i = false;

    /* JADX INFO: renamed from: j */
    private TextPaint f9904j;

    /* JADX INFO: renamed from: k */
    private final TextView f9905k;

    /* JADX INFO: renamed from: l */
    private final Context f9906l;

    C1732fx(TextView textView) {
        this.f9905k = textView;
        this.f9906l = this.f9905k.getContext();
    }

    /* JADX INFO: renamed from: a */
    void m9325a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f9906l.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f9897c = typedArrayObtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m9314a(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (m9320k()) {
            if (this.f9897c == 1) {
                if (!this.f9903i) {
                    DisplayMetrics displayMetrics = this.f9906l.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    m9313a(dimension2, dimension3, dimension);
                }
                m9318i();
                return;
            }
            return;
        }
        this.f9897c = 0;
    }

    /* JADX INFO: renamed from: a */
    void m9322a(int i) {
        if (m9320k()) {
            switch (i) {
                case 0:
                    m9319j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f9906l.getResources().getDisplayMetrics();
                    m9313a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m9318i()) {
                        m9331f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m9324a(int i, int i2, int i3, int i4) {
        if (m9320k()) {
            DisplayMetrics displayMetrics = this.f9906l.getResources().getDisplayMetrics();
            m9313a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m9318i()) {
                m9331f();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m9326a(int[] iArr, int i) {
        if (m9320k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f9906l.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f9902h = m9316a(iArrCopyOf);
                if (!m9317h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f9903i = false;
            }
            if (m9318i()) {
                m9331f();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m9321a() {
        return this.f9897c;
    }

    /* JADX INFO: renamed from: b */
    int m9327b() {
        return Math.round(this.f9899e);
    }

    /* JADX INFO: renamed from: c */
    int m9328c() {
        return Math.round(this.f9900f);
    }

    /* JADX INFO: renamed from: d */
    int m9329d() {
        return Math.round(this.f9901g);
    }

    /* JADX INFO: renamed from: e */
    int[] m9330e() {
        return this.f9902h;
    }

    /* JADX INFO: renamed from: a */
    private void m9314a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f9902h = m9316a(iArr);
            m9317h();
        }
    }

    /* JADX INFO: renamed from: h */
    private boolean m9317h() {
        this.f9903i = this.f9902h.length > 0;
        if (this.f9903i) {
            this.f9897c = 1;
            this.f9900f = this.f9902h[0];
            this.f9901g = this.f9902h[r0 - 1];
            this.f9899e = -1.0f;
        }
        return this.f9903i;
    }

    /* JADX INFO: renamed from: a */
    private int[] m9316a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* JADX INFO: renamed from: a */
    private void m9313a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f9897c = 1;
        this.f9900f = f;
        this.f9901g = f2;
        this.f9899e = f3;
        this.f9903i = false;
    }

    /* JADX INFO: renamed from: i */
    private boolean m9318i() {
        if (m9320k() && this.f9897c == 1) {
            if (!this.f9903i || this.f9902h.length == 0) {
                float fRound = Math.round(this.f9900f);
                int i = 1;
                while (Math.round(this.f9899e + fRound) <= Math.round(this.f9901g)) {
                    i++;
                    fRound += this.f9899e;
                }
                int[] iArr = new int[i];
                float f = this.f9900f;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.f9899e;
                }
                this.f9902h = m9316a(iArr);
            }
            this.f9898d = true;
        } else {
            this.f9898d = false;
        }
        return this.f9898d;
    }

    /* JADX INFO: renamed from: f */
    void m9331f() {
        if (m9332g()) {
            if (this.f9898d) {
                if (this.f9905k.getMeasuredHeight() <= 0 || this.f9905k.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = ((Boolean) m9310a(this.f9905k, "getHorizontallyScrolling", false)).booleanValue() ? 1048576 : (this.f9905k.getMeasuredWidth() - this.f9905k.getTotalPaddingLeft()) - this.f9905k.getTotalPaddingRight();
                int height = (this.f9905k.getHeight() - this.f9905k.getCompoundPaddingBottom()) - this.f9905k.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f9895a) {
                    f9895a.setEmpty();
                    f9895a.right = measuredWidth;
                    f9895a.bottom = height;
                    float fM9307a = m9307a(f9895a);
                    if (fM9307a != this.f9905k.getTextSize()) {
                        m9323a(0, fM9307a);
                    }
                }
            }
            this.f9898d = true;
        }
    }

    /* JADX INFO: renamed from: j */
    private void m9319j() {
        this.f9897c = 0;
        this.f9900f = -1.0f;
        this.f9901g = -1.0f;
        this.f9899e = -1.0f;
        this.f9902h = new int[0];
        this.f9898d = false;
    }

    /* JADX INFO: renamed from: a */
    void m9323a(int i, float f) {
        Resources resources;
        if (this.f9906l == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.f9906l.getResources();
        }
        m9312a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    /* JADX INFO: renamed from: a */
    private void m9312a(float f) {
        if (f != this.f9905k.getPaint().getTextSize()) {
            this.f9905k.getPaint().setTextSize(f);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f9905k.isInLayout() : false;
            if (this.f9905k.getLayout() != null) {
                this.f9898d = false;
                try {
                    Method methodM9311a = m9311a("nullLayouts");
                    if (methodM9311a != null) {
                        methodM9311a.invoke(this.f9905k, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!zIsInLayout) {
                    this.f9905k.requestLayout();
                } else {
                    this.f9905k.forceLayout();
                }
                this.f9905k.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m9307a(RectF rectF) {
        int length = this.f9902h.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = length - 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = (i2 + i) / 2;
            if (m9315a(this.f9902h[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i2;
                i2 = i5;
            } else {
                i3 = i4 - 1;
                i = i3;
            }
        }
        return this.f9902h[i3];
    }

    /* JADX INFO: renamed from: a */
    private boolean m9315a(int i, RectF rectF) {
        StaticLayout staticLayoutM9308a;
        CharSequence transformation;
        CharSequence text = this.f9905k.getText();
        TransformationMethod transformationMethod = this.f9905k.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f9905k)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f9905k.getMaxLines() : -1;
        if (this.f9904j == null) {
            this.f9904j = new TextPaint();
        } else {
            this.f9904j.reset();
        }
        this.f9904j.set(this.f9905k.getPaint());
        this.f9904j.setTextSize(i);
        Layout.Alignment alignment = (Layout.Alignment) m9310a(this.f9905k, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayoutM9308a = m9309a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            staticLayoutM9308a = m9308a(text, alignment, Math.round(rectF.right));
        }
        return (maxLines == -1 || (staticLayoutM9308a.getLineCount() <= maxLines && staticLayoutM9308a.getLineEnd(staticLayoutM9308a.getLineCount() - 1) == text.length())) && ((float) staticLayoutM9308a.getHeight()) <= rectF.bottom;
    }

    /* JADX INFO: renamed from: a */
    private StaticLayout m9309a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m9310a(this.f9905k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f9904j, i).setAlignment(alignment).setLineSpacing(this.f9905k.getLineSpacingExtra(), this.f9905k.getLineSpacingMultiplier()).setIncludePad(this.f9905k.getIncludeFontPadding()).setBreakStrategy(this.f9905k.getBreakStrategy()).setHyphenationFrequency(this.f9905k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* JADX INFO: renamed from: a */
    private StaticLayout m9308a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        float fFloatValue;
        float fFloatValue2;
        boolean zBooleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            fFloatValue = this.f9905k.getLineSpacingMultiplier();
            fFloatValue2 = this.f9905k.getLineSpacingExtra();
            zBooleanValue = this.f9905k.getIncludeFontPadding();
        } else {
            fFloatValue = ((Float) m9310a(this.f9905k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            fFloatValue2 = ((Float) m9310a(this.f9905k, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            zBooleanValue = ((Boolean) m9310a(this.f9905k, "getIncludeFontPadding", true)).booleanValue();
        }
        return new StaticLayout(charSequence, this.f9904j, i, alignment, fFloatValue, fFloatValue2, zBooleanValue);
    }

    /* JADX INFO: renamed from: a */
    private <T> T m9310a(Object obj, String str, T t) {
        try {
            return (T) m9311a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* JADX INFO: renamed from: a */
    private Method m9311a(String str) {
        try {
            Method declaredMethod = f9896b.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f9896b.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    boolean m9332g() {
        return m9320k() && this.f9897c != 0;
    }

    /* JADX INFO: renamed from: k */
    private boolean m9320k() {
        return !(this.f9905k instanceof AppCompatEditText);
    }
}
