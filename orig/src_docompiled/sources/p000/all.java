package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.FragmentTransaction;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.DfuBaseService;
import p000.akz;

/* JADX INFO: compiled from: LegacyDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
class all extends akz {

    /* JADX INFO: renamed from: P */
    private BluetoothGattCharacteristic f1631P;

    /* JADX INFO: renamed from: Q */
    private BluetoothGattCharacteristic f1632Q;

    /* JADX INFO: renamed from: R */
    private boolean f1633R;

    /* JADX INFO: renamed from: S */
    private final C0189a f1634S;

    /* JADX INFO: renamed from: y */
    protected static final UUID f1629y = new UUID(23296205844446L, 1523193452336828707L);

    /* JADX INFO: renamed from: z */
    protected static final UUID f1630z = new UUID(23300500811742L, 1523193452336828707L);

    /* JADX INFO: renamed from: A */
    protected static final UUID f1614A = new UUID(23304795779038L, 1523193452336828707L);

    /* JADX INFO: renamed from: B */
    protected static final UUID f1615B = new UUID(23313385713630L, 1523193452336828707L);

    /* JADX INFO: renamed from: C */
    protected static UUID f1616C = f1629y;

    /* JADX INFO: renamed from: D */
    protected static UUID f1617D = f1630z;

    /* JADX INFO: renamed from: E */
    protected static UUID f1618E = f1614A;

    /* JADX INFO: renamed from: F */
    protected static UUID f1619F = f1615B;

    /* JADX INFO: renamed from: G */
    private static final byte[] f1620G = {1, 0};

    /* JADX INFO: renamed from: H */
    private static final byte[] f1621H = {2};

    /* JADX INFO: renamed from: I */
    private static final byte[] f1622I = {2, 0};

    /* JADX INFO: renamed from: J */
    private static final byte[] f1623J = {2, 1};

    /* JADX INFO: renamed from: K */
    private static final byte[] f1624K = {3};

    /* JADX INFO: renamed from: L */
    private static final byte[] f1625L = {4};

    /* JADX INFO: renamed from: M */
    private static final byte[] f1626M = {5};

    /* JADX INFO: renamed from: N */
    private static final byte[] f1627N = {6};

    /* JADX INFO: renamed from: O */
    private static final byte[] f1628O = {8, 0, 0};

    /* JADX INFO: renamed from: all$a */
    /* JADX INFO: compiled from: LegacyDfuImpl.java */
    public class C0189a extends akz.C0184a {
        protected C0189a() {
            super();
        }

        @Override // p000.akz.C0184a
        /* JADX INFO: renamed from: a */
        protected void mo1790a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (all.this.f1633R) {
                all.this.f1572u.m10785a(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + m1833a(bluetoothGattCharacteristic));
                all.this.f1633R = false;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 17) {
                all.this.f1573v.m1853e(bluetoothGattCharacteristic.getIntValue(20, 1).intValue());
                m1789a(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!all.this.f1541c) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    all.this.f1541c = true;
                }
                m1791b(bluetoothGatt, bluetoothGattCharacteristic);
            }
            all.this.m1826h();
        }
    }

    all(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.f1634S = new C0189a();
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1842a(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(f1616C);
        if (service == null) {
            return false;
        }
        this.f1631P = service.getCharacteristic(f1617D);
        this.f1632Q = service.getCharacteristic(f1618E);
        return (this.f1631P == null || this.f1632Q == null) ? false : true;
    }

    @Override // p000.ale
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public akz.C0184a mo1776b() {
        return this.f1634S;
    }

    @Override // p000.akz
    /* JADX INFO: renamed from: a */
    protected UUID mo1784a() {
        return f1618E;
    }

    @Override // p000.akz
    /* JADX INFO: renamed from: c */
    protected UUID mo1788c() {
        return f1616C;
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) throws alr, alq, alx {
        int iM1892c;
        int iM1894e;
        int iM1893d;
        boolean z;
        int iM1871b;
        m1820b("Legacy DFU bootloader found");
        this.f1573v.m1846b(-2);
        this.f1572u.m10784a(1000);
        BluetoothGatt bluetoothGatt = this.f1562k;
        int iM1870b = m1870b(bluetoothGatt.getService(f1616C).getCharacteristic(f1619F));
        if (iM1870b >= 5 && this.f1561j == null) {
            m1820b("Init packet not set for the DFU Bootloader version " + iM1870b);
            this.f1572u.m10785a(20, "The Init packet is required by this version DFU Bootloader");
            this.f1572u.m10787a(bluetoothGatt, 4107);
            return;
        }
        try {
            try {
                m1814a(this.f1631P, 1);
                this.f1572u.m10785a(10, "Notifications enabled");
                this.f1572u.m10784a(1000);
                int i = this.f1563l;
                int i2 = (i & 1) > 0 ? this.f1574w : 0;
                int i3 = (i & 2) > 0 ? this.f1574w : 0;
                int i4 = i & 4;
                int i5 = i4 > 0 ? this.f1574w : 0;
                if (this.f1560i instanceof alo) {
                    alo aloVar = (alo) this.f1560i;
                    if (aloVar.m1897h()) {
                        m1816a("Secure DFU is required to upload selected firmware");
                        this.f1572u.m10785a(20, "The device does not support given firmware.");
                        m1821c("Sending Reset command (Op Code = 6)");
                        m1866a(this.f1631P, f1627N);
                        this.f1572u.m10785a(10, "Reset request sent");
                        this.f1572u.m10787a(bluetoothGatt, FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        return;
                    }
                    iM1892c = aloVar.m1892c();
                    iM1893d = aloVar.m1893d();
                    iM1894e = aloVar.m1894e();
                } else {
                    int i6 = i3;
                    iM1892c = i2;
                    iM1894e = i5;
                    iM1893d = i6;
                }
                try {
                    f1620G[1] = (byte) i;
                    m1821c("Sending Start DFU command (Op Code = 1, Upload Mode = " + i + ")");
                    m1866a(this.f1631P, f1620G);
                    this.f1572u.m10785a(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i + ")");
                    m1821c("Sending image size array to DFU Packet (" + iM1892c + "b, " + iM1893d + "b, " + iM1894e + "b)");
                    m1865a(this.f1632Q, iM1892c, iM1893d, iM1894e);
                    this.f1572u.m10785a(10, "Firmware image size sent (" + iM1892c + "b, " + iM1893d + "b, " + iM1894e + "b)");
                    byte[] bArrM = m1831m();
                    iM1871b = m1871b(bArrM, 1);
                    this.f1572u.m10785a(10, "Response received (Op Code = " + ((int) bArrM[1]) + " Status = " + iM1871b + ")");
                } catch (alt e) {
                    try {
                        if (e.m1907a() == 3 && i4 > 0 && (i & 3) > 0) {
                            this.f1541c = false;
                            m1820b("DFU target does not support (SD/BL)+App update");
                            this.f1572u.m10785a(15, "DFU target does not support (SD/BL)+App update");
                            int i7 = i & (-5);
                            this.f1563l = i7;
                            f1620G[1] = (byte) i7;
                            this.f1573v.m1843a(2);
                            ((alo) this.f1560i).m1889a(i7);
                            this.f1572u.m10785a(1, "Sending only SD/BL");
                            m1821c("Resending Start DFU command (Op Code = 1, Upload Mode = " + i7 + ")");
                            m1866a(this.f1631P, f1620G);
                            this.f1572u.m10785a(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i7 + ")");
                            m1821c("Sending image size array to DFU Packet: [" + iM1892c + "b, " + iM1893d + "b, 0b]");
                            m1865a(this.f1632Q, iM1892c, iM1893d, 0);
                            this.f1572u.m10785a(10, "Firmware image size sent [" + iM1892c + "b, " + iM1893d + "b, 0b]");
                            byte[] bArrM2 = m1831m();
                            int iM1871b2 = m1871b(bArrM2, 1);
                            this.f1572u.m10785a(10, "Response received (Op Code = " + ((int) bArrM2[1]) + " Status = " + iM1871b2 + ")");
                            if (iM1871b2 == 2) {
                                m1864a(bluetoothGatt, intent);
                                return;
                            } else if (iM1871b2 != 1) {
                                throw new alt("Starting DFU failed", iM1871b2);
                            }
                        } else {
                            throw e;
                        }
                    } catch (alt e2) {
                        if (e2.m1907a() == 3 && i == 4) {
                            this.f1541c = false;
                            m1820b("DFU target does not support DFU v.2");
                            this.f1572u.m10785a(15, "DFU target does not support DFU v.2");
                            this.f1572u.m10785a(1, "Switching to DFU v.1");
                            m1821c("Resending Start DFU command (Op Code = 1)");
                            m1866a(this.f1631P, f1620G);
                            this.f1572u.m10785a(10, "DFU Start sent (Op Code = 1)");
                            m1821c("Sending application image size to DFU Packet: " + this.f1574w + " bytes");
                            m1872b(this.f1632Q, this.f1574w);
                            this.f1572u.m10785a(10, "Firmware image size sent (" + this.f1574w + " bytes)");
                            byte[] bArrM3 = m1831m();
                            int iM1871b3 = m1871b(bArrM3, 1);
                            this.f1572u.m10785a(10, "Response received (Op Code = " + ((int) bArrM3[1]) + ", Status = " + iM1871b3 + ")");
                            if (iM1871b3 == 2) {
                                m1864a(bluetoothGatt, intent);
                                return;
                            } else {
                                if (iM1871b3 != 1) {
                                    throw new alt("Starting DFU failed", iM1871b3);
                                }
                                z = false;
                            }
                        } else {
                            throw e2;
                        }
                    }
                }
                if (iM1871b == 2) {
                    m1864a(bluetoothGatt, intent);
                    return;
                }
                if (iM1871b != 1) {
                    throw new alt("Starting DFU failed", iM1871b);
                }
                z = true;
                if (this.f1561j != null) {
                    this.f1572u.m10785a(10, "Writing Initialize DFU Parameters...");
                    if (z) {
                        m1821c("Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)");
                        m1866a(this.f1631P, f1622I);
                        m1821c("Sending " + this.f1575x + " bytes of init packet");
                        m1786a(this.f1632Q, (CRC32) null);
                        m1821c("Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)");
                        m1866a(this.f1631P, f1623J);
                        this.f1572u.m10785a(10, "Initialize DFU Parameters completed");
                    } else {
                        m1821c("Sending the Initialize DFU Parameters (Op Code = 2)");
                        m1866a(this.f1631P, f1621H);
                        m1821c("Sending " + this.f1575x + " bytes of init packet");
                        m1786a(this.f1632Q, (CRC32) null);
                    }
                    byte[] bArrM4 = m1831m();
                    int iM1871b4 = m1871b(bArrM4, 2);
                    this.f1572u.m10785a(10, "Response received (Op Code = " + ((int) bArrM4[1]) + ", Status = " + iM1871b4 + ")");
                    if (iM1871b4 != 1) {
                        throw new alt("Device returned error after sending init packet", iM1871b4);
                    }
                }
                int i8 = (z || (this.f1539a > 0 && this.f1539a <= 10)) ? this.f1539a : 10;
                if (i8 > 0) {
                    m1821c("Sending the number of packets before notifications (Op Code = 8, Value = " + i8 + ")");
                    m1867a(f1628O, i8);
                    m1866a(this.f1631P, f1628O);
                    this.f1572u.m10785a(10, "Packet Receipt Notif Req (Op Code = 8) sent (Value = " + i8 + ")");
                }
                m1821c("Sending Receive Firmware Image request (Op Code = 3)");
                m1866a(this.f1631P, f1624K);
                this.f1572u.m10785a(10, "Receive Firmware Image request sent");
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f1573v.m1849c(0);
                try {
                    m1821c("Uploading firmware...");
                    this.f1572u.m10785a(10, "Uploading firmware...");
                    m1785a(this.f1632Q);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    byte[] bArrM5 = m1831m();
                    int iM1871b5 = m1871b(bArrM5, 3);
                    m1821c("Response received (Op Code = " + ((int) bArrM5[0]) + ", Req Op Code = " + ((int) bArrM5[1]) + ", Status = " + ((int) bArrM5[2]) + ")");
                    DfuBaseService dfuBaseService = this.f1572u;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response received (Op Code = ");
                    sb.append((int) bArrM5[1]);
                    sb.append(", Status = ");
                    sb.append(iM1871b5);
                    sb.append(")");
                    dfuBaseService.m10785a(10, sb.toString());
                    if (iM1871b5 != 1) {
                        throw new alt("Device returned error after sending file", iM1871b5);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Transfer of ");
                    sb2.append(this.f1573v.m1852e());
                    sb2.append(" bytes has taken ");
                    long j = jElapsedRealtime2 - jElapsedRealtime;
                    sb2.append(j);
                    sb2.append(" ms");
                    m1821c(sb2.toString());
                    this.f1572u.m10785a(10, "Upload completed in " + j + " ms");
                    m1821c("Sending Validate request (Op Code = 4)");
                    m1866a(this.f1631P, f1625L);
                    this.f1572u.m10785a(10, "Validate request sent");
                    byte[] bArrM6 = m1831m();
                    int iM1871b6 = m1871b(bArrM6, 4);
                    m1821c("Response received (Op Code = " + ((int) bArrM6[0]) + ", Req Op Code = " + ((int) bArrM6[1]) + ", Status = " + ((int) bArrM6[2]) + ")");
                    DfuBaseService dfuBaseService2 = this.f1572u;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Response received (Op Code = ");
                    sb3.append((int) bArrM6[1]);
                    sb3.append(", Status = ");
                    sb3.append(iM1871b6);
                    sb3.append(")");
                    dfuBaseService2.m10785a(10, sb3.toString());
                    if (iM1871b6 != 1) {
                        throw new alt("Device returned validation error", iM1871b6);
                    }
                    this.f1573v.m1846b(-5);
                    m1821c("Sending Activate and Reset request (Op Code = 5)");
                    m1866a(this.f1631P, f1626M);
                    this.f1572u.m10785a(10, "Activate and Reset request sent");
                    this.f1572u.m10783a();
                    this.f1572u.m10785a(5, "Disconnected by the remote device");
                    m1787a(intent, iM1870b == 5);
                } catch (alq e3) {
                    m1816a("Disconnected while sending data");
                    throw e3;
                }
            } catch (alt e4) {
                int iM1907a = e4.m1907a() | 8192;
                m1816a(e4.getMessage());
                this.f1572u.m10785a(20, String.format("Remote DFU error: %s", amd.m1932a(iM1907a)));
                m1821c("Sending Reset command (Op Code = 6)");
                m1866a(this.f1631P, f1627N);
                this.f1572u.m10785a(10, "Reset request sent");
                this.f1572u.m10787a(bluetoothGatt, iM1907a);
            }
        } catch (alw e5) {
            m1816a(e5.getMessage());
            this.f1572u.m10785a(20, e5.getMessage());
            m1821c("Sending Reset command (Op Code = 6)");
            m1866a(this.f1631P, f1627N);
            this.f1572u.m10785a(10, "Reset request sent");
            this.f1572u.m10787a(bluetoothGatt, 4104);
        } catch (alx e6) {
            m1821c("Sending Reset command (Op Code = 6)");
            this.f1565n = false;
            m1866a(this.f1631P, f1627N);
            this.f1572u.m10785a(10, "Reset request sent");
            throw e6;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1867a(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    /* JADX INFO: renamed from: b */
    private int m1871b(byte[] bArr, int i) throws alw {
        if (bArr == null || bArr.length != 3 || bArr[0] != 16 || bArr[1] != i || bArr[2] < 1 || bArr[2] > 6) {
            throw new alw("Invalid response received", bArr, 16, i);
        }
        return bArr[2];
    }

    /* JADX INFO: renamed from: b */
    private int m1870b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private void m1866a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        m1815a(bluetoothGattCharacteristic, bArr, bArr[0] == 6 || bArr[0] == 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1872b(android.bluetooth.BluetoothGattCharacteristic r5, int r6) throws p000.alr, p000.alq, p000.alx {
        /*
            r4 = this;
            r0 = 0
            r4.f1570s = r0
            r0 = 0
            r4.f1569r = r0
            r1 = 1
            r4.f1633R = r1
            r5.setWriteType(r1)
            r2 = 4
            byte[] r2 = new byte[r2]
            r5.setValue(r2)
            r2 = 20
            r5.setValue(r6, r2, r0)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.f1572u
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Writing to characteristic "
            r2.append(r3)
            java.util.UUID r3 = r5.getUuid()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.m10785a(r1, r2)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.f1572u
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "gatt.writeCharacteristic("
            r1.append(r2)
            java.util.UUID r2 = r5.getUuid()
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.m10785a(r0, r1)
            android.bluetooth.BluetoothGatt r6 = r4.f1562k
            r6.writeCharacteristic(r5)
            java.lang.Object r5 = r4.f1559h     // Catch: java.lang.InterruptedException -> L77
            monitor-enter(r5)     // Catch: java.lang.InterruptedException -> L77
        L58:
            boolean r6 = r4.f1633R     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L68
            boolean r6 = r4.f1566o     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L68
            int r6 = r4.f1569r     // Catch: java.lang.Throwable -> L74
            if (r6 != 0) goto L68
            boolean r6 = r4.f1565n     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L6c
        L68:
            boolean r6 = r4.f1564m     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L72
        L6c:
            java.lang.Object r6 = r4.f1559h     // Catch: java.lang.Throwable -> L74
            r6.wait()     // Catch: java.lang.Throwable -> L74
            goto L58
        L72:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L74
            goto L7d
        L74:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L74
            throw r6     // Catch: java.lang.InterruptedException -> L77
        L77:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.m1817a(r6, r5)
        L7d:
            boolean r5 = r4.f1565n
            if (r5 == 0) goto L87
            alx r5 = new alx
            r5.<init>()
            throw r5
        L87:
            int r5 = r4.f1569r
            if (r5 == 0) goto L95
            alr r5 = new alr
            java.lang.String r6 = "Unable to write Image Size"
            int r0 = r4.f1569r
            r5.<init>(r6, r0)
            throw r5
        L95:
            boolean r5 = r4.f1566o
            if (r5 != 0) goto La1
            alq r5 = new alq
            java.lang.String r6 = "Unable to write Image Size: device disconnected"
            r5.<init>(r6)
            throw r5
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.all.m1872b(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    /* JADX INFO: renamed from: a */
    private void m1865a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws alr, alq, alx {
        this.f1570s = null;
        this.f1569r = 0;
        this.f1633R = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        bluetoothGattCharacteristic.setValue(i2, 20, 4);
        bluetoothGattCharacteristic.setValue(i3, 20, 8);
        this.f1572u.m10785a(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.f1572u.m10785a(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.f1562k.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.f1559h) {
                while (true) {
                    if ((!this.f1633R || !this.f1566o || this.f1569r != 0 || this.f1565n) && !this.f1564m) {
                        break;
                    } else {
                        this.f1559h.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        if (this.f1565n) {
            throw new alx();
        }
        if (this.f1569r != 0) {
            throw new alr("Unable to write Image Sizes", this.f1569r);
        }
        if (!this.f1566o) {
            throw new alq("Unable to write Image Sizes: device disconnected");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1864a(BluetoothGatt bluetoothGatt, Intent intent) {
        this.f1572u.m10785a(15, "Last upload interrupted. Restarting device...");
        this.f1573v.m1846b(-5);
        m1821c("Sending Reset command (Op Code = 6)");
        m1866a(this.f1631P, f1627N);
        this.f1572u.m10785a(10, "Reset request sent");
        this.f1572u.m10783a();
        this.f1572u.m10785a(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(f1555d);
        this.f1572u.m10788a(bluetoothGatt, !((service == null || service.getCharacteristic(f1556e) == null) ? false : true));
        this.f1572u.m10789b(bluetoothGatt);
        m1821c("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        m1819b(intent2, false);
    }
}
