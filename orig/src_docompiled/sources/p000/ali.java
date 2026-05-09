package p000;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import no.nordicsemi.android.dfu.DfuBaseService;
import p000.ale;

/* JADX INFO: compiled from: DfuServiceProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class ali implements ale {

    /* JADX INFO: renamed from: a */
    private ala f1600a;

    /* JADX INFO: renamed from: b */
    private boolean f1601b;

    /* JADX INFO: renamed from: c */
    private boolean f1602c;

    /* JADX INFO: renamed from: a */
    public alh m1861a(Intent intent, DfuBaseService dfuBaseService, BluetoothGatt bluetoothGatt) {
        try {
            this.f1600a = new alc(intent, dfuBaseService);
            if (this.f1600a.mo1842a(intent, bluetoothGatt)) {
                return this.f1600a;
            }
            this.f1600a = new ald(intent, dfuBaseService);
            if (this.f1600a.mo1842a(intent, bluetoothGatt)) {
                ala alaVar = this.f1600a;
                if (this.f1600a != null) {
                    if (this.f1601b) {
                        this.f1600a.mo1823e();
                    }
                    if (this.f1602c) {
                        this.f1600a.mo1825g();
                    }
                }
                return alaVar;
            }
            this.f1600a = new alm(intent, dfuBaseService);
            if (this.f1600a.mo1842a(intent, bluetoothGatt)) {
                ala alaVar2 = this.f1600a;
                if (this.f1600a != null) {
                    if (this.f1601b) {
                        this.f1600a.mo1823e();
                    }
                    if (this.f1602c) {
                        this.f1600a.mo1825g();
                    }
                }
                return alaVar2;
            }
            this.f1600a = new alk(intent, dfuBaseService);
            if (this.f1600a.mo1842a(intent, bluetoothGatt)) {
                ala alaVar3 = this.f1600a;
                if (this.f1600a != null) {
                    if (this.f1601b) {
                        this.f1600a.mo1823e();
                    }
                    if (this.f1602c) {
                        this.f1600a.mo1825g();
                    }
                }
                return alaVar3;
            }
            this.f1600a = new all(intent, dfuBaseService);
            if (this.f1600a.mo1842a(intent, bluetoothGatt)) {
                ala alaVar4 = this.f1600a;
                if (this.f1600a != null) {
                    if (this.f1601b) {
                        this.f1600a.mo1823e();
                    }
                    if (this.f1602c) {
                        this.f1600a.mo1825g();
                    }
                }
                return alaVar4;
            }
            if (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU", false)) {
                this.f1600a = new alj(intent, dfuBaseService);
                if (this.f1600a.mo1842a(intent, bluetoothGatt)) {
                    ala alaVar5 = this.f1600a;
                    if (this.f1600a != null) {
                        if (this.f1601b) {
                            this.f1600a.mo1823e();
                        }
                        if (this.f1602c) {
                            this.f1600a.mo1825g();
                        }
                    }
                    return alaVar5;
                }
            }
            if (this.f1600a != null) {
                if (this.f1601b) {
                    this.f1600a.mo1823e();
                }
                if (this.f1602c) {
                    this.f1600a.mo1825g();
                }
            }
            return null;
        } finally {
            if (this.f1600a != null) {
                if (this.f1601b) {
                    this.f1600a.mo1823e();
                }
                if (this.f1602c) {
                    this.f1600a.mo1825g();
                }
            }
        }
    }

    @Override // p000.ale
    /* JADX INFO: renamed from: b */
    public ale.C0187a mo1776b() {
        if (this.f1600a != null) {
            return this.f1600a.mo1776b();
        }
        return null;
    }

    @Override // p000.ale
    /* JADX INFO: renamed from: a */
    public void mo1813a(int i) {
        if (this.f1600a != null) {
            this.f1600a.mo1813a(i);
        }
    }

    @Override // p000.alf
    /* JADX INFO: renamed from: e */
    public void mo1823e() {
        this.f1601b = true;
    }

    @Override // p000.alf
    /* JADX INFO: renamed from: f */
    public void mo1824f() {
        this.f1601b = false;
    }

    @Override // p000.alf
    /* JADX INFO: renamed from: g */
    public void mo1825g() {
        this.f1602c = true;
        if (this.f1600a != null) {
            this.f1600a.mo1825g();
        }
    }
}
