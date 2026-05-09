package p000;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: by */
/* JADX INFO: compiled from: AnimatorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C0783by {
    /* JADX INFO: renamed from: a */
    private static boolean m5735a(int i) {
        return i >= 28 && i <= 31;
    }

    /* JADX INFO: renamed from: a */
    public static Animator m5720a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return m5721a(context, context.getResources(), context.getTheme(), i);
    }

    /* JADX INFO: renamed from: a */
    public static Animator m5721a(Context context, Resources resources, Resources.Theme theme, int i) {
        return m5722a(context, resources, theme, i, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static Animator m5722a(Context context, Resources resources, Resources.Theme theme, int i, float f) throws Throwable {
        XmlResourceParser animation;
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                animation = resources.getAnimation(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (XmlPullParserException e2) {
            e = e2;
        }
        try {
            Animator animatorM5723a = m5723a(context, resources, theme, animation, f);
            if (animation != null) {
                animation.close();
            }
            return animatorM5723a;
        } catch (IOException e3) {
            e = e3;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e4) {
            e = e4;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException2.initCause(e);
            throw notFoundException2;
        } catch (Throwable th2) {
            th = th2;
            xmlResourceParser = animation;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: by$a */
    /* JADX INFO: compiled from: AnimatorInflaterCompat.java */
    static class a implements TypeEvaluator<PathParser.PathDataNode[]> {

        /* JADX INFO: renamed from: a */
        private PathParser.PathDataNode[] f5316a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (this.f5316a == null || !PathParser.canMorph(this.f5316a, pathDataNodeArr)) {
                this.f5316a = PathParser.deepCopyNodes(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                this.f5316a[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
            }
            return this.f5316a;
        }
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder m5729a(TypedArray typedArray, int i, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        float dimension;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        float dimension2;
        float dimension3;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && m5735a(i4)) || (z2 && m5735a(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.PathDataNode[] pathDataNodeArrCreateNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathParser.PathDataNode[] pathDataNodeArrCreateNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (pathDataNodeArrCreateNodesFromPathData == null && pathDataNodeArrCreateNodesFromPathData2 == null) {
                return null;
            }
            if (pathDataNodeArrCreateNodesFromPathData == null) {
                if (pathDataNodeArrCreateNodesFromPathData2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), pathDataNodeArrCreateNodesFromPathData2);
                }
                return null;
            }
            a aVar = new a();
            if (pathDataNodeArrCreateNodesFromPathData2 != null) {
                if (!PathParser.canMorph(pathDataNodeArrCreateNodesFromPathData, pathDataNodeArrCreateNodesFromPathData2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, pathDataNodeArrCreateNodesFromPathData, pathDataNodeArrCreateNodesFromPathData2);
            } else {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, pathDataNodeArrCreateNodesFromPathData);
            }
            return propertyValuesHolderOfObject;
        }
        C0784bz c0784bzM5738a = i == 3 ? C0784bz.m5738a() : null;
        if (z3) {
            if (z) {
                if (i4 == 5) {
                    dimension2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    dimension2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i5 == 5) {
                        dimension3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        dimension3 = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension2, dimension3);
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension2);
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, 0.0f);
                } else {
                    dimension = typedArray.getFloat(i3, 0.0f);
                }
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (m5735a(i4)) {
                color2 = typedArray.getColor(i2, 0);
            } else {
                color2 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m5735a(i5)) {
                    color3 = typedArray.getColor(i3, 0);
                } else {
                    color3 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else if (m5735a(i5)) {
                color = typedArray.getColor(i3, 0);
            } else {
                color = typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || c0784bzM5738a == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(c0784bzM5738a);
        return propertyValuesHolderOfInt;
    }

    /* JADX INFO: renamed from: a */
    private static void m5732a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long namedInt = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = m5719a(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderM5729a = m5729a(typedArray, namedInt3, 5, 6, "");
            if (propertyValuesHolderM5729a != null) {
                valueAnimator.setValues(propertyValuesHolderM5729a);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m5731a(valueAnimator, typedArray2, namedInt3, f, xmlPullParser);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5731a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString != null) {
            String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
            String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (namedString2 == null && namedString3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            m5733a(PathParser.createPathFromPathData(namedString), objectAnimator, f * 0.5f, namedString2, namedString3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* JADX INFO: renamed from: a */
    private static void m5733a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f2 = length / (iMin - 1);
        int i = 0;
        float f3 = 0.0f;
        int i2 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f3 += f2;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f3 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Animator m5723a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return m5724a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        if (r23 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d9, code lost:
    
        if (r13 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00db, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00eb, code lost:
    
        if (r2.hasNext() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        r1[r17] = (android.animation.Animator) r2.next();
        r17 = r17 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
    
        if (r24 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0100, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0103, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.animation.Animator m5724a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0783by.m5724a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder[] m5736a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5312i);
                    String namedString = TypedArrayUtils.getNamedString(typedArrayObtainAttributes, xmlPullParser, "propertyName", 3);
                    int namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderM5728a = m5728a(context, resources, theme, xmlPullParser, namedString, namedInt);
                    if (propertyValuesHolderM5728a == null) {
                        propertyValuesHolderM5728a = m5729a(typedArrayObtainAttributes, namedInt, 0, 1, namedString);
                    }
                    if (propertyValuesHolderM5728a != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderM5728a);
                    }
                    typedArrayObtainAttributes.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    /* JADX INFO: renamed from: a */
    private static int m5718a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5313j);
        int i = 0;
        TypedValue typedValuePeekNamedValue = TypedArrayUtils.peekNamedValue(typedArrayObtainAttributes, xmlPullParser, "value", 0);
        if ((typedValuePeekNamedValue != null) && m5735a(typedValuePeekNamedValue.type)) {
            i = 3;
        }
        typedArrayObtainAttributes.recycle();
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static int m5719a(TypedArray typedArray, int i, int i2) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && m5735a(i3)) || (z2 && m5735a(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder m5728a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iM5718a = i;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iM5718a == 4) {
                    iM5718a = m5718a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM5726a = m5726a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), iM5718a, xmlPullParser);
                if (keyframeM5726a != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeM5726a);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), m5725a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, m5725a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            m5734a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iM5718a == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(C0784bz.m5738a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    /* JADX INFO: renamed from: a */
    private static Keyframe m5725a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    /* JADX INFO: renamed from: a */
    private static void m5734a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.animation.Keyframe m5726a(android.content.Context r5, android.content.res.Resources r6, android.content.res.Resources.Theme r7, android.util.AttributeSet r8, int r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            int[] r0 = p000.C0780bv.f5313j
            android.content.res.TypedArray r6 = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(r6, r7, r8, r0)
            java.lang.String r7 = "fraction"
            r8 = 3
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r7 = android.support.v4.content.res.TypedArrayUtils.getNamedFloat(r6, r10, r7, r8, r0)
            java.lang.String r0 = "value"
            r1 = 0
            android.util.TypedValue r0 = android.support.v4.content.res.TypedArrayUtils.peekNamedValue(r6, r10, r0, r1)
            r2 = 1
            if (r0 == 0) goto L1b
            r3 = 1
            goto L1c
        L1b:
            r3 = 0
        L1c:
            r4 = 4
            if (r9 != r4) goto L2c
            if (r3 == 0) goto L2b
            int r9 = r0.type
            boolean r9 = m5735a(r9)
            if (r9 == 0) goto L2b
            r9 = 3
            goto L2c
        L2b:
            r9 = 0
        L2c:
            if (r3 == 0) goto L4c
            if (r9 == r8) goto L41
            switch(r9) {
                case 0: goto L35;
                case 1: goto L41;
                default: goto L33;
            }
        L33:
            r7 = 0
            goto L57
        L35:
            java.lang.String r8 = "value"
            r9 = 0
            float r8 = android.support.v4.content.res.TypedArrayUtils.getNamedFloat(r6, r10, r8, r1, r9)
            android.animation.Keyframe r7 = android.animation.Keyframe.ofFloat(r7, r8)
            goto L57
        L41:
            java.lang.String r8 = "value"
            int r8 = android.support.v4.content.res.TypedArrayUtils.getNamedInt(r6, r10, r8, r1, r1)
            android.animation.Keyframe r7 = android.animation.Keyframe.ofInt(r7, r8)
            goto L57
        L4c:
            if (r9 != 0) goto L53
            android.animation.Keyframe r7 = android.animation.Keyframe.ofFloat(r7)
            goto L57
        L53:
            android.animation.Keyframe r7 = android.animation.Keyframe.ofInt(r7)
        L57:
            java.lang.String r8 = "interpolator"
            int r8 = android.support.v4.content.res.TypedArrayUtils.getNamedResourceId(r6, r10, r8, r2, r1)
            if (r8 <= 0) goto L66
            android.view.animation.Interpolator r5 = p000.C0782bx.m5716a(r5, r8)
            r7.setInterpolator(r5)
        L66:
            r6.recycle()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0783by.m5726a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.util.AttributeSet, int, org.xmlpull.v1.XmlPullParser):android.animation.Keyframe");
    }

    /* JADX INFO: renamed from: a */
    private static ObjectAnimator m5727a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m5730a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* JADX INFO: renamed from: a */
    private static ValueAnimator m5730a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5310g);
        TypedArray typedArrayObtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5314k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m5732a(valueAnimator, typedArrayObtainAttributes, typedArrayObtainAttributes2, f, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(typedArrayObtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(C0782bx.m5716a(context, namedResourceId));
        }
        typedArrayObtainAttributes.recycle();
        if (typedArrayObtainAttributes2 != null) {
            typedArrayObtainAttributes2.recycle();
        }
        return valueAnimator;
    }
}
