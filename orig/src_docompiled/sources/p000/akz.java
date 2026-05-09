package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.DfuBaseService;
import p000.ala;

/* JADX INFO: compiled from: BaseCustomDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class akz extends ala {

    /* JADX INFO: renamed from: a */
    protected final int f1539a;

    /* JADX INFO: renamed from: b */
    protected int f1540b;

    /* JADX INFO: renamed from: c */
    protected boolean f1541c;

    /* JADX INFO: renamed from: y */
    private boolean f1542y;

    /* JADX INFO: renamed from: z */
    private boolean f1543z;

    /* JADX INFO: renamed from: a */
    protected abstract UUID mo1784a();

    /* JADX INFO: renamed from: c */
    protected abstract UUID mo1788c();

    /* JADX INFO: renamed from: akz$a */
    /* JADX INFO: compiled from: BaseCustomDfuImpl.java */
    public class C0184a extends ala.C0186a {
        /* JADX INFO: renamed from: a */
        protected void mo1790a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        }

        protected C0184a() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                if (bluetoothGattCharacteristic.getUuid().equals(akz.this.mo1784a())) {
                    if (!akz.this.f1542y) {
                        if (akz.this.f1543z) {
                            akz.this.f1573v.m1851d(bluetoothGattCharacteristic.getValue().length);
                            akz.this.f1540b++;
                            boolean z = akz.this.f1539a > 0 && akz.this.f1540b == akz.this.f1539a;
                            boolean zM1845a = akz.this.f1573v.m1845a();
                            boolean zM1847b = akz.this.f1573v.m1847b();
                            if (z) {
                                return;
                            }
                            if (zM1845a || zM1847b) {
                                akz.this.f1543z = false;
                                akz.this.m1826h();
                                return;
                            }
                            try {
                                akz.this.m1827i();
                                if (!akz.this.f1565n && akz.this.f1569r == 0 && !akz.this.f1541c && !akz.this.f1568q) {
                                    int iM1848c = akz.this.f1573v.m1848c();
                                    byte[] bArr = akz.this.f1571t;
                                    if (iM1848c < 20) {
                                        bArr = new byte[iM1848c];
                                    }
                                    akz.this.m1778a(bluetoothGatt, bluetoothGattCharacteristic, bArr, akz.this.f1560i.read(bArr));
                                    return;
                                }
                                akz.this.f1543z = false;
                                akz.this.f1572u.m10785a(15, "Upload terminated");
                                akz.this.m1826h();
                                return;
                            } catch (als unused) {
                                akz.this.m1816a("Invalid HEX file");
                                akz.this.f1569r = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
                            } catch (IOException e) {
                                akz.this.m1817a("Error while reading the input stream", e);
                                akz.this.f1569r = 4100;
                            }
                        } else {
                            mo1790a(bluetoothGatt, bluetoothGattCharacteristic, i);
                        }
                    } else {
                        akz.this.f1572u.m10785a(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + m1833a(bluetoothGattCharacteristic));
                        akz.this.f1542y = false;
                    }
                } else {
                    akz.this.f1572u.m10785a(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + m1833a(bluetoothGattCharacteristic));
                    akz.this.f1567p = true;
                }
            } else if (akz.this.f1568q) {
                akz.this.f1567p = true;
            } else {
                akz.this.m1816a("Characteristic write error: " + i);
                akz.this.f1569r = i | 16384;
            }
            akz.this.m1826h();
        }

        /* JADX INFO: renamed from: a */
        protected void m1789a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (!akz.this.f1543z) {
                m1791b(bluetoothGatt, bluetoothGattCharacteristic);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(akz.this.mo1788c()).getCharacteristic(akz.this.mo1784a());
            try {
                akz.this.f1540b = 0;
                akz.this.m1827i();
                if (!akz.this.f1565n && akz.this.f1569r == 0 && !akz.this.f1541c && !akz.this.f1568q) {
                    boolean zM1845a = akz.this.f1573v.m1845a();
                    boolean zM1847b = akz.this.f1573v.m1847b();
                    if (!zM1845a && !zM1847b) {
                        int iM1848c = akz.this.f1573v.m1848c();
                        byte[] bArr = akz.this.f1571t;
                        if (iM1848c < 20) {
                            bArr = new byte[iM1848c];
                        }
                        akz.this.m1778a(bluetoothGatt, characteristic, bArr, akz.this.f1560i.read(bArr));
                        return;
                    }
                    akz.this.f1543z = false;
                    akz.this.m1826h();
                    return;
                }
                akz.this.f1543z = false;
                akz.this.f1572u.m10785a(15, "Upload terminated");
            } catch (als unused) {
                akz.this.m1816a("Invalid HEX file");
                akz.this.f1569r = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
            } catch (IOException e) {
                akz.this.m1817a("Error while reading the input stream", e);
                akz.this.f1569r = 4100;
            }
        }

        /* JADX INFO: renamed from: b */
        protected void m1791b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            akz.this.f1572u.m10785a(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + m1833a(bluetoothGattCharacteristic));
            akz.this.f1570s = bluetoothGattCharacteristic.getValue();
            akz.this.f1543z = false;
        }
    }

    akz(Intent intent, DfuBaseService dfuBaseService) {
        int i;
        super(intent, dfuBaseService);
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED")) {
            boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED", Build.VERSION.SDK_INT < 23);
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE", 12);
            this.f1539a = booleanExtra ? (intExtra < 0 || intExtra > 65535) ? 12 : intExtra : 0;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(dfuBaseService);
            boolean z = defaultSharedPreferences.getBoolean("settings_packet_receipt_notification_enabled", Build.VERSION.SDK_INT < 23);
            try {
                i = Integer.parseInt(defaultSharedPreferences.getString("settings_number_of_packets", String.valueOf(12)));
            } catch (NumberFormatException unused) {
            }
            i = (i < 0 || i > 65535) ? 12 : i;
            this.f1539a = z ? i : 0;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1786a(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws alr, alq, alx {
        try {
            byte[] bArr = new byte[20];
            while (true) {
                int i = this.f1561j.read(bArr, 0, bArr.length);
                if (i == -1) {
                    return;
                }
                m1779a(bluetoothGattCharacteristic, bArr, i);
                if (crc32 != null) {
                    crc32.update(bArr, 0, i);
                }
            }
        } catch (IOException e) {
            m1817a("Error while reading Init packet file", e);
            throw new alr("Error while reading Init packet file", InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1779a(android.bluetooth.BluetoothGattCharacteristic r4, byte[] r5, int r6) throws p000.alr, p000.alq, p000.alx {
        /*
            r3 = this;
            boolean r0 = r3.f1565n
            if (r0 == 0) goto La
            alx r4 = new alx
            r4.<init>()
            throw r4
        La:
            int r0 = r5.length
            r1 = 0
            if (r0 == r6) goto L14
            byte[] r0 = new byte[r6]
            java.lang.System.arraycopy(r5, r1, r0, r1, r6)
            r5 = r0
        L14:
            r6 = 0
            r3.f1570s = r6
            r3.f1569r = r1
            r6 = 1
            r3.f1542y = r6
            r4.setWriteType(r6)
            r4.setValue(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Sending init packet (Value = "
            r0.append(r2)
            java.lang.String r5 = r3.m1812a(r5)
            r0.append(r5)
            java.lang.String r5 = ")"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r3.m1821c(r5)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r3.f1572u
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Writing to characteristic "
            r0.append(r2)
            java.util.UUID r2 = r4.getUuid()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r5.m10785a(r6, r0)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r3.f1572u
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "gatt.writeCharacteristic("
            r6.append(r0)
            java.util.UUID r0 = r4.getUuid()
            r6.append(r0)
            java.lang.String r0 = ")"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.m10785a(r1, r6)
            android.bluetooth.BluetoothGatt r5 = r3.f1562k
            r5.writeCharacteristic(r4)
            java.lang.Object r4 = r3.f1559h     // Catch: java.lang.InterruptedException -> L9b
            monitor-enter(r4)     // Catch: java.lang.InterruptedException -> L9b
        L80:
            boolean r5 = r3.f1542y     // Catch: java.lang.Throwable -> L98
            if (r5 == 0) goto L8c
            boolean r5 = r3.f1566o     // Catch: java.lang.Throwable -> L98
            if (r5 == 0) goto L8c
            int r5 = r3.f1569r     // Catch: java.lang.Throwable -> L98
            if (r5 == 0) goto L90
        L8c:
            boolean r5 = r3.f1564m     // Catch: java.lang.Throwable -> L98
            if (r5 == 0) goto L96
        L90:
            java.lang.Object r5 = r3.f1559h     // Catch: java.lang.Throwable -> L98
            r5.wait()     // Catch: java.lang.Throwable -> L98
            goto L80
        L96:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L98
            goto La1
        L98:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L98
            throw r5     // Catch: java.lang.InterruptedException -> L9b
        L9b:
            r4 = move-exception
            java.lang.String r5 = "Sleeping interrupted"
            r3.m1817a(r5, r4)
        La1:
            int r4 = r3.f1569r
            if (r4 == 0) goto Laf
            alr r4 = new alr
            java.lang.String r5 = "Unable to write Init DFU Parameters"
            int r6 = r3.f1569r
            r4.<init>(r5, r6)
            throw r4
        Laf:
            boolean r4 = r3.f1566o
            if (r4 != 0) goto Lbb
            alq r4 = new alq
            java.lang.String r5 = "Unable to write Init DFU Parameters: device disconnected"
            r4.<init>(r5)
            throw r4
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.akz.m1779a(android.bluetooth.BluetoothGattCharacteristic, byte[], int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void m1785a(android.bluetooth.BluetoothGattCharacteristic r7) throws p000.alr, p000.alq, p000.alx {
        /*
            r6 = this;
            boolean r0 = r6.f1565n
            if (r0 == 0) goto La
            alx r7 = new alx
            r7.<init>()
            throw r7
        La:
            r0 = 0
            r6.f1570s = r0
            r0 = 0
            r6.f1569r = r0
            r1 = 1
            r6.f1543z = r1
            r6.f1540b = r0
            byte[] r0 = r6.f1571t
            java.io.InputStream r2 = r6.f1560i     // Catch: java.io.IOException -> L84 p000.als -> L8e
            int r2 = r2.read(r0)     // Catch: java.io.IOException -> L84 p000.als -> L8e
            no.nordicsemi.android.dfu.DfuBaseService r3 = r6.f1572u     // Catch: java.io.IOException -> L84 p000.als -> L8e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L84 p000.als -> L8e
            r4.<init>()     // Catch: java.io.IOException -> L84 p000.als -> L8e
            java.lang.String r5 = "Sending firmware to characteristic "
            r4.append(r5)     // Catch: java.io.IOException -> L84 p000.als -> L8e
            java.util.UUID r5 = r7.getUuid()     // Catch: java.io.IOException -> L84 p000.als -> L8e
            r4.append(r5)     // Catch: java.io.IOException -> L84 p000.als -> L8e
            java.lang.String r5 = "..."
            r4.append(r5)     // Catch: java.io.IOException -> L84 p000.als -> L8e
            java.lang.String r4 = r4.toString()     // Catch: java.io.IOException -> L84 p000.als -> L8e
            r3.m10785a(r1, r4)     // Catch: java.io.IOException -> L84 p000.als -> L8e
            android.bluetooth.BluetoothGatt r1 = r6.f1562k     // Catch: java.io.IOException -> L84 p000.als -> L8e
            r6.m1778a(r1, r7, r0, r2)     // Catch: java.io.IOException -> L84 p000.als -> L8e
            java.lang.Object r7 = r6.f1559h     // Catch: java.lang.InterruptedException -> L63
            monitor-enter(r7)     // Catch: java.lang.InterruptedException -> L63
        L44:
            boolean r0 = r6.f1543z     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L54
            byte[] r0 = r6.f1570s     // Catch: java.lang.Throwable -> L60
            if (r0 != 0) goto L54
            boolean r0 = r6.f1566o     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L54
            int r0 = r6.f1569r     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L58
        L54:
            boolean r0 = r6.f1564m     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L5e
        L58:
            java.lang.Object r0 = r6.f1559h     // Catch: java.lang.Throwable -> L60
            r0.wait()     // Catch: java.lang.Throwable -> L60
            goto L44
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L60
            goto L69
        L60:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L60
            throw r0     // Catch: java.lang.InterruptedException -> L63
        L63:
            r7 = move-exception
            java.lang.String r0 = "Sleeping interrupted"
            r6.m1817a(r0, r7)
        L69:
            int r7 = r6.f1569r
            if (r7 == 0) goto L77
            alr r7 = new alr
            java.lang.String r0 = "Uploading Firmware Image failed"
            int r1 = r6.f1569r
            r7.<init>(r0, r1)
            throw r7
        L77:
            boolean r7 = r6.f1566o
            if (r7 != 0) goto L83
            alq r7 = new alq
            java.lang.String r0 = "Uploading Firmware Image failed: device disconnected"
            r7.<init>(r0)
            throw r7
        L83:
            return
        L84:
            alr r7 = new alr
            java.lang.String r0 = "Error while reading file"
            r1 = 4100(0x1004, float:5.745E-42)
            r7.<init>(r0, r1)
            throw r7
        L8e:
            alr r7 = new alr
            java.lang.String r0 = "HEX file not valid"
            r1 = 4099(0x1003, float:5.744E-42)
            r7.<init>(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.akz.m1785a(android.bluetooth.BluetoothGattCharacteristic):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1778a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        if (bArr.length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(bArr);
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    /* JADX INFO: renamed from: a */
    protected void m1787a(Intent intent, boolean z) {
        boolean z2;
        boolean z3 = false;
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
        this.f1572u.m10788a(this.f1562k, z || !booleanExtra);
        this.f1572u.m10789b(this.f1562k);
        if (this.f1562k.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false);
            if (booleanExtra2 || !booleanExtra) {
                m1829k();
                this.f1572u.m10784a(2000);
                z2 = true;
            } else {
                z2 = false;
            }
            if (!booleanExtra2 || (this.f1563l & 4) <= 0) {
                z3 = z2;
            } else {
                m1828j();
            }
        }
        if (this.f1573v.m1859j()) {
            if (!z3) {
                this.f1572u.m10784a(1400);
            }
            this.f1573v.m1846b(-6);
            return;
        }
        m1821c("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE", "application/zip");
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", 4);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", this.f1573v.m1857h() + 1);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", this.f1573v.m1858i());
        m1819b(intent2, true);
    }
}
