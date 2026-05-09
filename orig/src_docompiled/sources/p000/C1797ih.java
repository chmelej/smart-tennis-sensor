package p000;

import cn.jeesoft.widget.pickerview.CharacterPickerView;
import cn.jeesoft.widget.pickerview.LoopView;
import cn.jeesoft.widget.pickerview.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ih */
/* JADX INFO: compiled from: MWheelOptions.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1797ih {

    /* JADX INFO: renamed from: a */
    private CharacterPickerView f10322a;

    /* JADX INFO: renamed from: b */
    private LoopView f10323b;

    /* JADX INFO: renamed from: c */
    private LoopView f10324c;

    /* JADX INFO: renamed from: d */
    private LoopView f10325d;

    /* JADX INFO: renamed from: e */
    private List<String> f10326e;

    /* JADX INFO: renamed from: f */
    private List<List<String>> f10327f;

    /* JADX INFO: renamed from: g */
    private List<List<List<String>>> f10328g;

    /* JADX INFO: renamed from: h */
    private CharacterPickerView.InterfaceC0800a f10329h;

    public C1797ih(CharacterPickerView characterPickerView) {
        this.f10322a = characterPickerView;
    }

    /* JADX INFO: renamed from: a */
    public void m9776a(CharacterPickerView.InterfaceC0800a interfaceC0800a) {
        this.f10329h = interfaceC0800a;
    }

    /* JADX INFO: renamed from: a */
    public void m9777a(List<String> list, List<List<String>> list2, List<List<List<String>>> list3) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f10326e = list;
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        this.f10327f = list2;
        if (list3 == null) {
            list3 = new ArrayList<>();
        }
        this.f10328g = list3;
        this.f10323b = (LoopView) this.f10322a.findViewById(R.id.j_options1);
        this.f10323b.setArrayList(this.f10326e);
        this.f10323b.setCurrentItem(0);
        this.f10323b.setNotLoop();
        this.f10323b.setListener(new InterfaceC1792ic() { // from class: ih.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                if (!C1797ih.this.f10327f.isEmpty()) {
                    C1797ih.this.f10324c.setArrayList((List) C1797ih.this.f10327f.get(i));
                    C1797ih.this.f10324c.setCurrentItem(0);
                }
                if (!C1797ih.this.f10328g.isEmpty()) {
                    C1797ih.this.f10325d.setArrayList((List) ((List) C1797ih.this.f10328g.get(i)).get(0));
                    C1797ih.this.f10325d.setCurrentItem(0);
                } else {
                    C1797ih.this.m9770b();
                }
            }
        });
        this.f10324c = (LoopView) this.f10322a.findViewById(R.id.j_options2);
        if (!this.f10327f.isEmpty()) {
            this.f10324c.setArrayList(this.f10327f.get(0));
            this.f10324c.setCurrentItem(0);
            this.f10324c.setNotLoop();
            this.f10324c.setListener(new InterfaceC1792ic() { // from class: ih.2
                @Override // p000.InterfaceC1792ic
                /* JADX INFO: renamed from: a */
                public void mo7111a(int i) {
                    if (!C1797ih.this.f10328g.isEmpty()) {
                        C1797ih.this.f10325d.setArrayList((List) ((List) C1797ih.this.f10328g.get(C1797ih.this.f10323b.getCurrentItem())).get(i));
                        C1797ih.this.f10325d.setCurrentItem(0);
                    } else {
                        C1797ih.this.m9770b();
                    }
                }
            });
        }
        this.f10325d = (LoopView) this.f10322a.findViewById(R.id.j_options3);
        if (!this.f10328g.isEmpty()) {
            this.f10325d.setArrayList(this.f10328g.get(0).get(0));
            this.f10325d.setCurrentItem(0);
            this.f10325d.setNotLoop();
            this.f10325d.setListener(new InterfaceC1792ic() { // from class: ih.3
                @Override // p000.InterfaceC1792ic
                /* JADX INFO: renamed from: a */
                public void mo7111a(int i) {
                    C1797ih.this.m9770b();
                }
            });
        }
        if (this.f10327f.isEmpty()) {
            this.f10322a.findViewById(R.id.j_layout2).setVisibility(8);
        }
        if (this.f10328g.isEmpty()) {
            this.f10322a.findViewById(R.id.j_layout3).setVisibility(8);
        }
        m9775a(0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m9770b() {
        if (this.f10329h != null) {
            this.f10329h.m5804a(this.f10322a, this.f10323b.getCurrentItem(), this.f10324c.getCurrentItem(), this.f10325d.getCurrentItem());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9778a(boolean z) {
        this.f10323b.setCyclic(z);
        this.f10324c.setCyclic(z);
        this.f10325d.setCyclic(z);
    }

    /* JADX INFO: renamed from: a */
    public int[] m9779a() {
        return new int[]{this.f10323b.getCurrentItem(), this.f10324c.getCurrentItem(), this.f10325d.getCurrentItem()};
    }

    /* JADX INFO: renamed from: a */
    public void m9775a(int i, int i2, int i3) {
        this.f10323b.setCurrentItem(i);
        this.f10324c.setCurrentItem(i2);
        this.f10325d.setCurrentItem(i3);
    }
}
