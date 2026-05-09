package cn.jeesoft.widget.pickerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.List;
import p000.C1797ih;

/* JADX INFO: loaded from: classes.dex */
public class CharacterPickerView extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private C1797ih f5350a;

    /* JADX INFO: renamed from: cn.jeesoft.widget.pickerview.CharacterPickerView$a */
    public interface InterfaceC0800a {
        /* JADX INFO: renamed from: a */
        void m5804a(CharacterPickerView characterPickerView, int i, int i2, int i3);
    }

    public CharacterPickerView(Context context) {
        super(context);
        m5803a(context);
    }

    public CharacterPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5803a(context);
    }

    public CharacterPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5803a(context);
    }

    @TargetApi(21)
    public CharacterPickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m5803a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m5803a(Context context) {
        View.inflate(context, R.layout.j_picker_items, this);
        this.f5350a = new C1797ih(this);
    }

    public void setPicker(List<String> list) {
        this.f5350a.m9777a(list, (List<List<String>>) null, (List<List<List<String>>>) null);
    }

    public void setPicker(List<String> list, List<List<String>> list2) {
        this.f5350a.m9777a(list, list2, (List<List<List<String>>>) null);
    }

    public void setPicker(List<String> list, List<List<String>> list2, List<List<List<String>>> list3) {
        this.f5350a.m9777a(list, list2, list3);
    }

    public void setSelectOptions(int i) {
        this.f5350a.m9775a(i, 0, 0);
    }

    public void setSelectOptions(int i, int i2) {
        this.f5350a.m9775a(i, i2, 0);
    }

    public void setSelectOptions(int i, int i2, int i3) {
        this.f5350a.m9775a(i, i2, i3);
    }

    public void setCyclic(boolean z) {
        this.f5350a.m9778a(z);
    }

    public void setCurrentItems(int i, int i2, int i3) {
        this.f5350a.m9775a(i, i2, i3);
    }

    public int[] getCurrentItems() {
        return this.f5350a.m9779a();
    }

    public void setOnOptionChangedListener(InterfaceC0800a interfaceC0800a) {
        this.f5350a.m9776a(interfaceC0800a);
    }
}
