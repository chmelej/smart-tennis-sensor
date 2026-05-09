package p000;

import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;

/* JADX INFO: compiled from: UuidHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class aln {
    /* JADX INFO: renamed from: a */
    public static void m1886a(Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length == 4) {
            all.f1616C = parcelableArrayExtra[0] != null ? ((ParcelUuid) parcelableArrayExtra[0]).getUuid() : all.f1629y;
            all.f1617D = parcelableArrayExtra[1] != null ? ((ParcelUuid) parcelableArrayExtra[1]).getUuid() : all.f1630z;
            all.f1618E = parcelableArrayExtra[2] != null ? ((ParcelUuid) parcelableArrayExtra[2]).getUuid() : all.f1614A;
            all.f1619F = parcelableArrayExtra[3] != null ? ((ParcelUuid) parcelableArrayExtra[3]).getUuid() : all.f1615B;
            alk.f1608a = all.f1616C;
            alk.f1609b = all.f1617D;
            alk.f1610c = all.f1619F;
        } else {
            all.f1616C = all.f1629y;
            all.f1617D = all.f1630z;
            all.f1618E = all.f1614A;
            all.f1619F = all.f1615B;
            alk.f1608a = all.f1629y;
            alk.f1609b = all.f1630z;
            alk.f1610c = all.f1615B;
        }
        Parcelable[] parcelableArrayExtra2 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU");
        if (parcelableArrayExtra2 != null && parcelableArrayExtra2.length == 3) {
            alm.f1637B = parcelableArrayExtra2[0] != null ? ((ParcelUuid) parcelableArrayExtra2[0]).getUuid() : alm.f1646y;
            alm.f1638C = parcelableArrayExtra2[1] != null ? ((ParcelUuid) parcelableArrayExtra2[1]).getUuid() : alm.f1647z;
            alm.f1639D = parcelableArrayExtra2[2] != null ? ((ParcelUuid) parcelableArrayExtra2[2]).getUuid() : alm.f1636A;
        } else {
            alm.f1637B = alm.f1646y;
            alm.f1638C = alm.f1647z;
            alm.f1639D = alm.f1636A;
        }
        Parcelable[] parcelableArrayExtra3 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU");
        if (parcelableArrayExtra3 != null && parcelableArrayExtra3.length == 2) {
            alj.f1605c = parcelableArrayExtra3[0] != null ? ((ParcelUuid) parcelableArrayExtra3[0]).getUuid() : alj.f1603a;
            alj.f1606y = parcelableArrayExtra3[1] != null ? ((ParcelUuid) parcelableArrayExtra3[1]).getUuid() : alj.f1604b;
        } else {
            alj.f1605c = alj.f1603a;
            alj.f1606y = alj.f1604b;
        }
        Parcelable[] parcelableArrayExtra4 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING");
        if (parcelableArrayExtra4 != null && parcelableArrayExtra4.length == 2) {
            ald.f1585c = parcelableArrayExtra4[0] != null ? ((ParcelUuid) parcelableArrayExtra4[0]).getUuid() : ald.f1583a;
            ald.f1586y = parcelableArrayExtra4[1] != null ? ((ParcelUuid) parcelableArrayExtra4[1]).getUuid() : ald.f1584b;
        } else {
            ald.f1585c = ald.f1583a;
            ald.f1586y = ald.f1584b;
        }
        Parcelable[] parcelableArrayExtra5 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING");
        if (parcelableArrayExtra5 != null && parcelableArrayExtra5.length == 2) {
            alc.f1580c = parcelableArrayExtra5[0] != null ? ((ParcelUuid) parcelableArrayExtra5[0]).getUuid() : alc.f1578a;
            alc.f1581y = parcelableArrayExtra5[1] != null ? ((ParcelUuid) parcelableArrayExtra5[1]).getUuid() : alc.f1579b;
        } else {
            alc.f1580c = alc.f1578a;
            alc.f1581y = alc.f1579b;
        }
    }
}
