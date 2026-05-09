package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p000.aka;

/* JADX INFO: loaded from: classes.dex */
public class TagFlowLayout extends FlowLayout implements aka.InterfaceC0176a {

    /* JADX INFO: renamed from: d */
    private aka f9311d;

    /* JADX INFO: renamed from: e */
    private int f9312e;

    /* JADX INFO: renamed from: f */
    private Set<Integer> f9313f;

    /* JADX INFO: renamed from: g */
    private InterfaceC1639a f9314g;

    /* JADX INFO: renamed from: h */
    private InterfaceC1640b f9315h;

    /* JADX INFO: renamed from: com.zhy.view.flowlayout.TagFlowLayout$a */
    public interface InterfaceC1639a {
        /* JADX INFO: renamed from: a */
        void m8808a(Set<Integer> set);
    }

    /* JADX INFO: renamed from: com.zhy.view.flowlayout.TagFlowLayout$b */
    public interface InterfaceC1640b {
        /* JADX INFO: renamed from: a */
        boolean mo7994a(View view, int i, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9312e = -1;
        this.f9313f = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f9312e = typedArrayObtainStyledAttributes.getInt(R.styleable.TagFlowLayout_max_select, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    @Override // com.zhy.view.flowlayout.FlowLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setOnSelectListener(InterfaceC1639a interfaceC1639a) {
        this.f9314g = interfaceC1639a;
    }

    public void setOnTagClickListener(InterfaceC1640b interfaceC1640b) {
        this.f9315h = interfaceC1640b;
    }

    public void setAdapter(aka akaVar) {
        this.f9311d = akaVar;
        this.f9311d.m1700a(this);
        this.f9313f.clear();
        m8803a();
    }

    /* JADX INFO: renamed from: a */
    private void m8803a() {
        removeAllViews();
        aka akaVar = this.f9311d;
        HashSet<Integer> hashSetM1698a = this.f9311d.m1698a();
        for (final int i = 0; i < akaVar.m1702b(); i++) {
            View viewMo1696a = akaVar.mo1696a(this, i, akaVar.m1697a(i));
            final TagView tagView = new TagView(getContext());
            viewMo1696a.setDuplicateParentStateEnabled(true);
            if (viewMo1696a.getLayoutParams() != null) {
                tagView.setLayoutParams(viewMo1696a.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(m8801a(getContext(), 5.0f), m8801a(getContext(), 5.0f), m8801a(getContext(), 5.0f), m8801a(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            viewMo1696a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            tagView.addView(viewMo1696a);
            addView(tagView);
            if (hashSetM1698a.contains(Integer.valueOf(i))) {
                m8804a(i, tagView);
            }
            if (this.f9311d.m1701a(i, akaVar.m1697a(i))) {
                m8804a(i, tagView);
            }
            viewMo1696a.setClickable(false);
            tagView.setOnClickListener(new View.OnClickListener() { // from class: com.zhy.view.flowlayout.TagFlowLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TagFlowLayout.this.m8806a(tagView, i);
                    if (TagFlowLayout.this.f9315h != null) {
                        TagFlowLayout.this.f9315h.mo7994a(tagView, i, TagFlowLayout.this);
                    }
                }
            });
        }
        this.f9313f.addAll(hashSetM1698a);
    }

    public void setMaxSelectCount(int i) {
        if (this.f9313f.size() > i) {
            Log.w("TagFlowLayout", "you has already select more than " + i + " views , so it will be clear .");
            this.f9313f.clear();
        }
        this.f9312e = i;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f9313f);
    }

    /* JADX INFO: renamed from: a */
    private void m8804a(int i, TagView tagView) {
        tagView.setChecked(true);
        this.f9311d.m1699a(i, tagView.getTagView());
    }

    /* JADX INFO: renamed from: b */
    private void m8807b(int i, TagView tagView) {
        tagView.setChecked(false);
        this.f9311d.m1703b(i, tagView.getTagView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8806a(TagView tagView, int i) {
        if (!tagView.isChecked()) {
            if (this.f9312e == 1 && this.f9313f.size() == 1) {
                Integer next = this.f9313f.iterator().next();
                m8807b(next.intValue(), (TagView) getChildAt(next.intValue()));
                m8804a(i, tagView);
                this.f9313f.remove(next);
                this.f9313f.add(Integer.valueOf(i));
            } else {
                if (this.f9312e > 0 && this.f9313f.size() >= this.f9312e) {
                    return;
                }
                m8804a(i, tagView);
                this.f9313f.add(Integer.valueOf(i));
            }
        } else {
            m8807b(i, tagView);
            this.f9313f.remove(Integer.valueOf(i));
        }
        if (this.f9314g != null) {
            this.f9314g.m8808a(new HashSet(this.f9313f));
        }
    }

    public aka getAdapter() {
        return this.f9311d;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String strSubstring = "";
        if (this.f9313f.size() > 0) {
            Iterator<Integer> it = this.f9313f.iterator();
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next().intValue() + "|";
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        bundle.putString("key_choose_pos", strSubstring);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    int i = Integer.parseInt(str);
                    this.f9313f.add(Integer.valueOf(i));
                    TagView tagView = (TagView) getChildAt(i);
                    if (tagView != null) {
                        m8804a(i, tagView);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX INFO: renamed from: a */
    public static int m8801a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
