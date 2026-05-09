package p000;

import java.util.List;
import p000.C1723fo;

/* JADX INFO: renamed from: gp */
/* JADX INFO: compiled from: OpReorderer.java */
/* JADX INFO: loaded from: classes.dex */
class C1751gp {

    /* JADX INFO: renamed from: a */
    final a f10055a;

    /* JADX INFO: renamed from: gp$a */
    /* JADX INFO: compiled from: OpReorderer.java */
    interface a {
        /* JADX INFO: renamed from: a */
        C1723fo.b mo9198a(int i, int i2, int i3, Object obj);

        /* JADX INFO: renamed from: a */
        void mo9200a(C1723fo.b bVar);
    }

    C1751gp(a aVar) {
        this.f10055a = aVar;
    }

    /* JADX INFO: renamed from: a */
    void m9490a(List<C1723fo.b> list) {
        while (true) {
            int iM9488b = m9488b(list);
            if (iM9488b == -1) {
                return;
            } else {
                m9487a(list, iM9488b, iM9488b + 1);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9487a(List<C1723fo.b> list, int i, int i2) {
        C1723fo.b bVar = list.get(i);
        C1723fo.b bVar2 = list.get(i2);
        int i3 = bVar2.f9838a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    m9489c(list, i, bVar, i2, bVar2);
                    break;
                case 2:
                    m9491a(list, i, bVar, i2, bVar2);
                    break;
            }
        }
        m9492b(list, i, bVar, i2, bVar2);
    }

    /* JADX INFO: renamed from: a */
    void m9491a(List<C1723fo.b> list, int i, C1723fo.b bVar, int i2, C1723fo.b bVar2) {
        boolean z;
        boolean z2 = false;
        if (bVar.f9839b < bVar.f9841d) {
            if (bVar2.f9839b == bVar.f9839b && bVar2.f9841d == bVar.f9841d - bVar.f9839b) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f9839b == bVar.f9841d + 1 && bVar2.f9841d == bVar.f9839b - bVar.f9841d) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (bVar.f9841d < bVar2.f9839b) {
            bVar2.f9839b--;
        } else if (bVar.f9841d < bVar2.f9839b + bVar2.f9841d) {
            bVar2.f9841d--;
            bVar.f9838a = 2;
            bVar.f9841d = 1;
            if (bVar2.f9841d == 0) {
                list.remove(i2);
                this.f10055a.mo9200a(bVar2);
                return;
            }
            return;
        }
        C1723fo.b bVarMo9198a = null;
        if (bVar.f9839b <= bVar2.f9839b) {
            bVar2.f9839b++;
        } else if (bVar.f9839b < bVar2.f9839b + bVar2.f9841d) {
            bVarMo9198a = this.f10055a.mo9198a(2, bVar.f9839b + 1, (bVar2.f9839b + bVar2.f9841d) - bVar.f9839b, null);
            bVar2.f9841d = bVar.f9839b - bVar2.f9839b;
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.f10055a.mo9200a(bVar);
            return;
        }
        if (z) {
            if (bVarMo9198a != null) {
                if (bVar.f9839b > bVarMo9198a.f9839b) {
                    bVar.f9839b -= bVarMo9198a.f9841d;
                }
                if (bVar.f9841d > bVarMo9198a.f9839b) {
                    bVar.f9841d -= bVarMo9198a.f9841d;
                }
            }
            if (bVar.f9839b > bVar2.f9839b) {
                bVar.f9839b -= bVar2.f9841d;
            }
            if (bVar.f9841d > bVar2.f9839b) {
                bVar.f9841d -= bVar2.f9841d;
            }
        } else {
            if (bVarMo9198a != null) {
                if (bVar.f9839b >= bVarMo9198a.f9839b) {
                    bVar.f9839b -= bVarMo9198a.f9841d;
                }
                if (bVar.f9841d >= bVarMo9198a.f9839b) {
                    bVar.f9841d -= bVarMo9198a.f9841d;
                }
            }
            if (bVar.f9839b >= bVar2.f9839b) {
                bVar.f9839b -= bVar2.f9841d;
            }
            if (bVar.f9841d >= bVar2.f9839b) {
                bVar.f9841d -= bVar2.f9841d;
            }
        }
        list.set(i, bVar2);
        if (bVar.f9839b != bVar.f9841d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarMo9198a != null) {
            list.add(i, bVarMo9198a);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m9489c(List<C1723fo.b> list, int i, C1723fo.b bVar, int i2, C1723fo.b bVar2) {
        int i3 = bVar.f9841d < bVar2.f9839b ? -1 : 0;
        if (bVar.f9839b < bVar2.f9839b) {
            i3++;
        }
        if (bVar2.f9839b <= bVar.f9839b) {
            bVar.f9839b += bVar2.f9841d;
        }
        if (bVar2.f9839b <= bVar.f9841d) {
            bVar.f9841d += bVar2.f9841d;
        }
        bVar2.f9839b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m9492b(java.util.List<p000.C1723fo.b> r8, int r9, p000.C1723fo.b r10, int r11, p000.C1723fo.b r12) {
        /*
            r7 = this;
            int r0 = r10.f9841d
            int r1 = r12.f9839b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Lf
            int r0 = r12.f9839b
            int r0 = r0 - r4
            r12.f9839b = r0
            goto L28
        Lf:
            int r0 = r10.f9841d
            int r1 = r12.f9839b
            int r5 = r12.f9841d
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.f9841d
            int r0 = r0 - r4
            r12.f9841d = r0
            gp$a r0 = r7.f10055a
            int r1 = r10.f9839b
            java.lang.Object r5 = r12.f9840c
            fo$b r0 = r0.mo9198a(r2, r1, r4, r5)
            goto L29
        L28:
            r0 = r3
        L29:
            int r1 = r10.f9839b
            int r5 = r12.f9839b
            if (r1 > r5) goto L35
            int r1 = r12.f9839b
            int r1 = r1 + r4
            r12.f9839b = r1
            goto L56
        L35:
            int r1 = r10.f9839b
            int r5 = r12.f9839b
            int r6 = r12.f9841d
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.f9839b
            int r3 = r12.f9841d
            int r1 = r1 + r3
            int r3 = r10.f9839b
            int r1 = r1 - r3
            gp$a r3 = r7.f10055a
            int r5 = r10.f9839b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f9840c
            fo$b r3 = r3.mo9198a(r2, r5, r1, r4)
            int r2 = r12.f9841d
            int r2 = r2 - r1
            r12.f9841d = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.f9841d
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            gp$a r10 = r7.f10055a
            r10.mo9200a(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r3 == 0) goto L73
            r8.add(r9, r3)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1751gp.m9492b(java.util.List, int, fo$b, int, fo$b):void");
    }

    /* JADX INFO: renamed from: b */
    private int m9488b(List<C1723fo.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f9838a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
