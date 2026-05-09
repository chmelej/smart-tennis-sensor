package p000;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.C1686eg;

/* JADX INFO: renamed from: ej */
/* JADX INFO: compiled from: StateListDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class C1691ej extends C1686eg {

    /* JADX INFO: renamed from: a */
    private a f9605a;

    /* JADX INFO: renamed from: b */
    private boolean f9606b;

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    C1691ej() {
        this(null, null);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iM9058b = this.f9605a.m9058b(iArr);
        if (iM9058b < 0) {
            iM9058b = this.f9605a.m9058b(StateSet.WILD_CARD);
        }
        return m9011a(iM9058b) || zOnStateChange;
    }

    /* JADX INFO: renamed from: b */
    public void mo8989b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(typedArrayObtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        m9055a(typedArrayObtainAttributes);
        m9009a(resources);
        typedArrayObtainAttributes.recycle();
        m9054a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    /* JADX INFO: renamed from: a */
    private void m9055a(TypedArray typedArray) {
        a aVar = this.f9605a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f9565f |= typedArray.getChangingConfigurations();
        }
        aVar.f9570k = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f9570k);
        aVar.f9573n = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f9573n);
        aVar.f9553C = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.f9553C);
        aVar.f9554D = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.f9554D);
        aVar.f9585z = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f9585z);
    }

    /* JADX INFO: renamed from: a */
    private void m9054a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.f9605a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable drawableM8975b = resourceId > 0 ? C1684ee.m8975b(context, resourceId) : null;
                typedArrayObtainAttributes.recycle();
                int[] iArrM9056a = m9056a(attributeSet);
                if (drawableM8975b == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawableM8975b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        drawableM8975b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.m9057a(iArrM9056a, drawableM8975b);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int[] m9056a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9606b && super.mutate() == this) {
            this.f9605a.mo8999a();
            this.f9606b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C1686eg
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mo8990c() {
        return new a(this.f9605a, this, null);
    }

    /* JADX INFO: renamed from: ej$a */
    /* JADX INFO: compiled from: StateListDrawable.java */
    static class a extends C1686eg.b {

        /* JADX INFO: renamed from: L */
        int[][] f9607L;

        a(a aVar, C1691ej c1691ej, Resources resources) {
            super(aVar, c1691ej, resources);
            if (aVar != null) {
                this.f9607L = aVar.f9607L;
            } else {
                this.f9607L = new int[m9024c()][];
            }
        }

        @Override // p000.C1686eg.b
        /* JADX INFO: renamed from: a */
        void mo8999a() {
            int[][] iArr = new int[this.f9607L.length][];
            for (int length = this.f9607L.length - 1; length >= 0; length--) {
                iArr[length] = this.f9607L[length] != null ? (int[]) this.f9607L[length].clone() : null;
            }
            this.f9607L = iArr;
        }

        /* JADX INFO: renamed from: a */
        int m9057a(int[] iArr, Drawable drawable) {
            int iA = m9017a(drawable);
            this.f9607L[iA] = iArr;
            return iA;
        }

        /* JADX INFO: renamed from: b */
        int m9058b(int[] iArr) {
            int[][] iArr2 = this.f9607L;
            int iD = m9026d();
            for (int i = 0; i < iD; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C1691ej(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C1691ej(this, resources);
        }

        @Override // p000.C1686eg.b
        /* JADX INFO: renamed from: e */
        public void mo9030e(int i, int i2) {
            super.mo9030e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f9607L, 0, iArr, 0, i);
            this.f9607L = iArr;
        }
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // p000.C1686eg
    /* JADX INFO: renamed from: a */
    protected void mo8987a(C1686eg.b bVar) {
        super.mo8987a(bVar);
        if (bVar instanceof a) {
            this.f9605a = (a) bVar;
        }
    }

    C1691ej(a aVar, Resources resources) {
        mo8987a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    C1691ej(a aVar) {
        if (aVar != null) {
            mo8987a(aVar);
        }
    }
}
