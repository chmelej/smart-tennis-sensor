package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.components.YAxis;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utils {
    private static final int[] POW_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics = null;
    private static int mMinimumFlingVelocity = 50;

    public static int getLegendFormatDigits(float f, int i) {
        double d = f;
        return d < 9.9E-6d ? i + 6 : d < 9.9E-5d ? i + 5 : d < 9.9E-4d ? i + 4 : d < 0.0099d ? i + 3 : d < 0.099d ? i + 2 : d < 0.99d ? i + 1 : i + 0;
    }

    public static float getNormalizedAngle(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        return f % 360.0f;
    }

    public static void init(Context context) {
        if (context == null) {
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPAndroidChart, Utils.init(...)", "PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            mMetrics = context.getResources().getDisplayMetrics();
        }
    }

    @Deprecated
    public static void init(Resources resources) {
        mMetrics = resources.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static String formatDecimal(double d, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        return new DecimalFormat("###,###,###,##0" + stringBuffer.toString()).format(d);
    }

    public static float convertDpToPixel(float f) {
        if (mMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f;
        }
        return f * (mMetrics.densityDpi / 160.0f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float convertPixelsToDp(float f) {
        if (mMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
            return f;
        }
        return f / (mMetrics.densityDpi / 160.0f);
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static float getLineHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize calcTextSize(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        return new FSize(r0.width(), r0.height());
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String formatNumber(float r17, int r18, boolean r19) {
        /*
            r0 = r17
            r1 = 35
            char[] r1 = new char[r1]
            r2 = 0
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto Le
            java.lang.String r0 = "0"
            return r0
        Le:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r4 = 0
            r5 = 1
            if (r3 >= 0) goto L1e
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 <= 0) goto L1e
            r3 = 1
            goto L1f
        L1e:
            r3 = 0
        L1f:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L26
            float r0 = -r0
            r2 = 1
            goto L27
        L26:
            r2 = 0
        L27:
            int[] r6 = com.github.mikephil.charting.utils.Utils.POW_10
            int r6 = r6.length
            r7 = r18
            if (r7 <= r6) goto L33
            int[] r6 = com.github.mikephil.charting.utils.Utils.POW_10
            int r6 = r6.length
            int r6 = r6 - r5
            goto L34
        L33:
            r6 = r7
        L34:
            int[] r7 = com.github.mikephil.charting.utils.Utils.POW_10
            r7 = r7[r6]
            float r7 = (float) r7
            float r0 = r0 * r7
            int r0 = java.lang.Math.round(r0)
            long r7 = (long) r0
            int r0 = r1.length
            int r0 = r0 - r5
            r9 = 0
        L43:
            r10 = 0
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            r13 = 48
            if (r12 != 0) goto L6a
            int r12 = r6 + 1
            if (r4 >= r12) goto L50
            goto L6a
        L50:
            if (r3 == 0) goto L59
            int r3 = r0 + (-1)
            r1[r0] = r13
            int r4 = r4 + 1
            r0 = r3
        L59:
            if (r2 == 0) goto L61
            r2 = 45
            r1[r0] = r2
            int r4 = r4 + 1
        L61:
            int r0 = r1.length
            int r0 = r0 - r4
            int r2 = r1.length
            int r2 = r2 - r0
            java.lang.String r0 = java.lang.String.valueOf(r1, r0, r2)
            return r0
        L6a:
            r14 = 10
            long r10 = r7 % r14
            int r10 = (int) r10
            long r7 = r7 / r14
            int r11 = r0 + (-1)
            int r10 = r10 + r13
            char r10 = (char) r10
            r1[r0] = r10
            int r4 = r4 + 1
            if (r4 != r6) goto L85
            int r0 = r11 + (-1)
            r9 = 44
            r1[r11] = r9
            int r4 = r4 + 1
            r12 = r0
            r9 = 1
            goto Laf
        L85:
            if (r19 == 0) goto Lae
            r12 = 0
            int r10 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r10 == 0) goto Lae
            if (r4 <= r6) goto Lae
            r10 = 46
            if (r9 == 0) goto La0
            int r12 = r4 - r6
            int r12 = r12 % 4
            if (r12 != 0) goto Lae
            int r12 = r11 + (-1)
            r1[r11] = r10
            int r4 = r4 + 1
            goto Laf
        La0:
            int r12 = r4 - r6
            int r12 = r12 % 4
            r13 = 3
            if (r12 != r13) goto Lae
            int r12 = r11 + (-1)
            r1[r11] = r10
            int r4 = r4 + 1
            goto Laf
        Lae:
            r12 = r11
        Laf:
            r0 = r12
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.Utils.formatNumber(float, int, boolean):java.lang.String");
    }

    public static float roundToNextSignificant(double d) {
        return Math.round(d * ((double) r0)) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d < 0.0d ? -d : d)))));
    }

    public static int getDecimals(float f) {
        return ((int) Math.ceil(-Math.log10(roundToNextSignificant(f)))) + 2;
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static String[] convertStrings(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = list.get(i);
        }
        return strArr;
    }

    public static Bitmap[] convertBitMaps(List<Bitmap> list) {
        Bitmap[] bitmapArr = new Bitmap[list.size()];
        for (int i = 0; i < bitmapArr.length; i++) {
            bitmapArr[i] = list.get(i);
        }
        return bitmapArr;
    }

    public static double nextUp(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d2) + (d2 >= 0.0d ? 1L : -1L));
    }

    public static int getClosestDataSetIndex(List<SelectionDetail> list, float f, YAxis.AxisDependency axisDependency) {
        int i = -1;
        float f2 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < list.size(); i2++) {
            SelectionDetail selectionDetail = list.get(i2);
            if (axisDependency == null || selectionDetail.dataSet.getAxisDependency() == axisDependency) {
                float fAbs = Math.abs(selectionDetail.val - f);
                if (fAbs < f2) {
                    i = list.get(i2).dataSetIndex;
                    f2 = fAbs;
                }
            }
        }
        return i;
    }

    public static float getMinimumDistance(List<SelectionDetail> list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            SelectionDetail selectionDetail = list.get(i);
            if (selectionDetail.dataSet.getAxisDependency() == axisDependency) {
                float fAbs = Math.abs(selectionDetail.val - f);
                if (fAbs < f2) {
                    f2 = fAbs;
                }
            }
        }
        return f2;
    }

    public static PointF getPosition(PointF pointF, float f, float f2) {
        double d = f;
        double d2 = f2;
        return new PointF((float) (((double) pointF.x) + (Math.cos(Math.toRadians(d2)) * d)), (float) (((double) pointF.y) + (d * Math.sin(Math.toRadians(d2)))));
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if (i != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void postInvalidateOnAnimation(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10L);
        }
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }
}
