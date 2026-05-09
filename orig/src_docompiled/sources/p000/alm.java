package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.DfuBaseService;
import p000.akz;
import p000.ala;

/* JADX INFO: compiled from: SecureDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
class alm extends akz {

    /* JADX INFO: renamed from: K */
    private BluetoothGattCharacteristic f1648K;

    /* JADX INFO: renamed from: L */
    private BluetoothGattCharacteristic f1649L;

    /* JADX INFO: renamed from: M */
    private final C0193c f1650M;

    /* JADX INFO: renamed from: y */
    protected static final UUID f1646y = new UUID(279658205548544L, -9223371485494954757L);

    /* JADX INFO: renamed from: z */
    protected static final UUID f1647z = new UUID(-8157989241631715488L, -6937650605005804976L);

    /* JADX INFO: renamed from: A */
    protected static final UUID f1636A = new UUID(-8157989237336748192L, -6937650605005804976L);

    /* JADX INFO: renamed from: B */
    protected static UUID f1637B = f1646y;

    /* JADX INFO: renamed from: C */
    protected static UUID f1638C = f1647z;

    /* JADX INFO: renamed from: D */
    protected static UUID f1639D = f1636A;

    /* JADX INFO: renamed from: E */
    private static final byte[] f1640E = {1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: F */
    private static final byte[] f1641F = {1, 2, 0, 0, 0, 0};

    /* JADX INFO: renamed from: G */
    private static final byte[] f1642G = {2, 0, 0};

    /* JADX INFO: renamed from: H */
    private static final byte[] f1643H = {3};

    /* JADX INFO: renamed from: I */
    private static final byte[] f1644I = {4};

    /* JADX INFO: renamed from: J */
    private static final byte[] f1645J = {6, 0};

    /* JADX INFO: renamed from: alm$c */
    /* JADX INFO: compiled from: SecureDfuImpl.java */
    public class C0193c extends akz.C0184a {
        protected C0193c() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length < 3) {
                alm.this.m1816a("Empty response: " + m1833a(bluetoothGattCharacteristic));
                alm.this.f1569r = 4104;
                alm.this.m1826h();
                return;
            }
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 96) {
                if (bluetoothGattCharacteristic.getIntValue(17, 1).intValue() == 3) {
                    alm.this.f1573v.m1853e(bluetoothGattCharacteristic.getIntValue(20, 3).intValue());
                    m1789a(bluetoothGatt, bluetoothGattCharacteristic);
                } else if (!alm.this.f1541c) {
                    if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                        alm.this.f1541c = true;
                    }
                    m1791b(bluetoothGatt, bluetoothGattCharacteristic);
                }
            } else {
                alm.this.m1816a("Invalid response: " + m1833a(bluetoothGattCharacteristic));
                alm.this.f1569r = 4104;
            }
            alm.this.m1826h();
        }
    }

    alm(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.f1650M = new C0193c();
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1842a(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(f1637B);
        if (service == null) {
            return false;
        }
        this.f1648K = service.getCharacteristic(f1638C);
        this.f1649L = service.getCharacteristic(f1639D);
        return (this.f1648K == null || this.f1649L == null) ? false : true;
    }

    @Override // p000.ala, p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1818a(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) {
        if (inputStream2 == null) {
            this.f1572u.m10785a(20, "The Init packet is required by this version DFU Bootloader");
            this.f1572u.m10787a(bluetoothGatt, 4107);
            return false;
        }
        return super.mo1818a(intent, bluetoothGatt, i, inputStream, inputStream2);
    }

    @Override // p000.ale
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ala.C0186a mo1776b() {
        return this.f1650M;
    }

    @Override // p000.akz
    /* JADX INFO: renamed from: a */
    protected UUID mo1784a() {
        return f1639D;
    }

    @Override // p000.akz
    /* JADX INFO: renamed from: c */
    protected UUID mo1788c() {
        return f1637B;
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) throws alq, alx {
        m1820b("Secure DFU bootloader found");
        this.f1573v.m1846b(-2);
        this.f1572u.m10784a(1000);
        BluetoothGatt bluetoothGatt = this.f1562k;
        try {
            m1814a(this.f1648K, 1);
            this.f1572u.m10785a(10, "Notifications enabled");
            this.f1572u.m10784a(1000);
            m1876a(bluetoothGatt);
            m1879b(bluetoothGatt);
            this.f1573v.m1846b(-5);
            this.f1572u.m10783a();
            this.f1572u.m10785a(5, "Disconnected by the remote device");
            m1787a(intent, false);
        } catch (alt e) {
            int iM1907a = e.m1907a() | 8192;
            m1816a(e.getMessage());
            this.f1572u.m10785a(20, String.format("Remote DFU error: %s", ame.m1933a(iM1907a)));
            if (e instanceof alu) {
                alu aluVar = (alu) e;
                m1821c("Extended Error details: " + ame.m1934b(aluVar.m1908b()));
                this.f1572u.m10785a(20, "Details: " + ame.m1934b(aluVar.m1908b()) + " (Code = " + aluVar.m1908b() + ")");
            }
            this.f1572u.m10787a(bluetoothGatt, iM1907a);
        } catch (alw e2) {
            m1816a(e2.getMessage());
            this.f1572u.m10785a(20, e2.getMessage());
            this.f1572u.m10787a(bluetoothGatt, 4104);
        } catch (alx e3) {
            throw e3;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1876a(BluetoothGatt bluetoothGatt) throws alq, alt, alw {
        boolean z;
        boolean z2;
        IOException iOException;
        boolean z3;
        boolean z4;
        CRC32 crc32 = new CRC32();
        m1821c("Setting object to Command (Op Code = 6, Type = 1)");
        C0192b c0192bM1881c = m1881c(1);
        int i = 3;
        this.f1572u.m10785a(10, String.format(Locale.US, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(c0192bM1881c.f1654d), Integer.valueOf(c0192bM1881c.f1651a), Integer.valueOf(c0192bM1881c.f1652b)));
        int i2 = this.f1575x;
        int i3 = c0192bM1881c.f1654d;
        long j = 4294967295L;
        if (c0192bM1881c.f1651a <= 0 || c0192bM1881c.f1651a > this.f1575x) {
            z = false;
            z2 = false;
        } else {
            try {
                byte[] bArr = new byte[c0192bM1881c.f1651a];
                this.f1561j.read(bArr);
                crc32.update(bArr);
                if (c0192bM1881c.f1652b == ((int) (crc32.getValue() & 4294967295L))) {
                    m1821c("Init packet CRC is the same");
                    if (c0192bM1881c.f1651a == this.f1575x) {
                        m1821c("-> Whole Init packet was sent before");
                        try {
                            this.f1572u.m10785a(10, "Received CRC match Init packet");
                            z = true;
                            z2 = false;
                        } catch (IOException e) {
                            iOException = e;
                            z3 = true;
                            z4 = false;
                            m1817a("Error while reading " + c0192bM1881c.f1651a + " bytes from the init packet stream", iOException);
                            try {
                                this.f1561j.reset();
                                crc32.reset();
                                z = z3;
                                z2 = z4;
                            } catch (IOException e2) {
                                m1817a("Error while resetting the init packet stream", e2);
                                this.f1572u.m10787a(bluetoothGatt, 4100);
                                return;
                            }
                        }
                    } else {
                        m1821c("-> " + c0192bM1881c.f1651a + " bytes of Init packet were sent before");
                        try {
                            this.f1572u.m10785a(10, "Resuming sending Init packet...");
                            z = false;
                            z2 = true;
                        } catch (IOException e3) {
                            iOException = e3;
                            z3 = false;
                            z4 = true;
                            m1817a("Error while reading " + c0192bM1881c.f1651a + " bytes from the init packet stream", iOException);
                            this.f1561j.reset();
                            crc32.reset();
                            z = z3;
                            z2 = z4;
                        }
                    }
                } else {
                    this.f1561j.reset();
                    crc32.reset();
                    z = false;
                    z2 = false;
                }
            } catch (IOException e4) {
                iOException = e4;
                z3 = false;
            }
        }
        if (!z) {
            m1821c("Disabling Packet Receipt Notifications (Op Code = 2, Value = 0)");
            m1878b(0);
            this.f1572u.m10785a(10, "Packet Receipt Notif disabled (Op Code = 2, Value = 0)");
            int i4 = 1;
            while (i4 <= i) {
                if (!z2) {
                    m1821c("Creating Init packet object (Op Code = 1, Type = 1, Size = " + this.f1575x + ")");
                    m1875a(1, this.f1575x);
                    this.f1572u.m10785a(10, "Command object created");
                }
                m1821c("Sending " + (this.f1575x - c0192bM1881c.f1651a) + " bytes of init packet...");
                m1786a(this.f1649L, crc32);
                int value = (int) (crc32.getValue() & j);
                this.f1572u.m10785a(10, String.format(Locale.US, "Command object sent (CRC = %08X)", Integer.valueOf(value)));
                m1821c("Sending Calculate Checksum command (Op Code = 3)");
                C0191a c0191aM1883o = m1883o();
                this.f1572u.m10785a(10, String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(c0191aM1883o.f1651a), Integer.valueOf(c0191aM1883o.f1652b)));
                m1821c(String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(c0191aM1883o.f1651a), Integer.valueOf(c0191aM1883o.f1652b)));
                if (value == c0191aM1883o.f1652b) {
                    break;
                }
                if (i4 < 3) {
                    i4++;
                    m1821c("CRC does not match! Retrying...(" + i4 + "/3)");
                    this.f1572u.m10785a(15, "CRC does not match! Retrying...(" + i4 + "/3)");
                    try {
                        c0192bM1881c.f1651a = 0;
                        c0192bM1881c.f1652b = 0;
                        this.f1561j.reset();
                        crc32.reset();
                        z2 = false;
                        i = 3;
                        j = 4294967295L;
                    } catch (IOException e5) {
                        m1817a("Error while resetting the init packet stream", e5);
                        this.f1572u.m10787a(bluetoothGatt, 4100);
                        return;
                    }
                } else {
                    m1816a("CRC does not match!");
                    this.f1572u.m10785a(20, "CRC does not match!");
                    this.f1572u.m10787a(bluetoothGatt, 4109);
                    return;
                }
            }
        }
        m1821c("Executing init packet (Op Code = 4)");
        m1884p();
        this.f1572u.m10785a(10, "Command object executed");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x031b  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1879b(android.bluetooth.BluetoothGatt r24) throws p000.alq, p000.alt, p000.alw {
        /*
            Method dump skipped, instruction units count: 891
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.alm.m1879b(android.bluetooth.BluetoothGatt):void");
    }

    /* JADX INFO: renamed from: a */
    private int m1874a(byte[] bArr, int i) throws alw {
        if (bArr == null || bArr.length < 3 || bArr[0] != 96 || bArr[1] != i || (bArr[2] != 1 && bArr[2] != 2 && bArr[2] != 3 && bArr[2] != 4 && bArr[2] != 5 && bArr[2] != 7 && bArr[2] != 10 && bArr[2] != 11)) {
            throw new alw("Invalid response received", bArr, 96, i);
        }
        return bArr[2];
    }

    /* JADX INFO: renamed from: b */
    private void m1880b(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    /* JADX INFO: renamed from: c */
    private void m1882c(byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    /* JADX INFO: renamed from: b */
    private void m1878b(int i) throws alq, alt, alw {
        if (!this.f1566o) {
            throw new alq("Unable to read Checksum: device disconnected");
        }
        m1821c("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
        m1880b(f1642G, i);
        m1877a(this.f1648K, f1642G);
        byte[] bArrM = m1831m();
        int iM1874a = m1874a(bArrM, 2);
        if (iM1874a == 11) {
            throw new alu("Sending the number of packets failed", bArrM[3]);
        }
        if (iM1874a != 1) {
            throw new alt("Sending the number of packets failed", iM1874a);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1877a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        m1815a(bluetoothGattCharacteristic, bArr, false);
    }

    /* JADX INFO: renamed from: a */
    private void m1875a(int i, int i2) throws alq, alt, alw {
        if (!this.f1566o) {
            throw new alq("Unable to create object: device disconnected");
        }
        byte[] bArr = i == 1 ? f1640E : f1641F;
        m1882c(bArr, i2);
        m1877a(this.f1648K, bArr);
        byte[] bArrM = m1831m();
        int iM1874a = m1874a(bArrM, 1);
        if (iM1874a == 11) {
            throw new alu("Creating Command object failed", bArrM[3]);
        }
        if (iM1874a != 1) {
            throw new alt("Creating Command object failed", iM1874a);
        }
    }

    /* JADX INFO: renamed from: c */
    private C0192b m1881c(int i) throws alq, alt, alw {
        if (!this.f1566o) {
            throw new alq("Unable to read object info: device disconnected");
        }
        f1645J[1] = (byte) i;
        m1877a(this.f1648K, f1645J);
        byte[] bArrM = m1831m();
        int iM1874a = m1874a(bArrM, 6);
        if (iM1874a == 11) {
            throw new alu("Selecting object failed", bArrM[3]);
        }
        if (iM1874a != 1) {
            throw new alt("Selecting object failed", iM1874a);
        }
        C0192b c0192b = new C0192b();
        c0192b.f1654d = this.f1648K.getIntValue(20, 3).intValue();
        c0192b.f1651a = this.f1648K.getIntValue(20, 7).intValue();
        c0192b.f1652b = this.f1648K.getIntValue(20, 11).intValue();
        return c0192b;
    }

    /* JADX INFO: renamed from: o */
    private C0191a m1883o() throws alq, alt, alw {
        if (!this.f1566o) {
            throw new alq("Unable to read Checksum: device disconnected");
        }
        m1877a(this.f1648K, f1643H);
        byte[] bArrM = m1831m();
        int iM1874a = m1874a(bArrM, 3);
        if (iM1874a == 11) {
            throw new alu("Receiving Checksum failed", bArrM[3]);
        }
        if (iM1874a != 1) {
            throw new alt("Receiving Checksum failed", iM1874a);
        }
        C0191a c0191a = new C0191a();
        c0191a.f1651a = this.f1648K.getIntValue(20, 3).intValue();
        c0191a.f1652b = this.f1648K.getIntValue(20, 7).intValue();
        return c0191a;
    }

    /* JADX INFO: renamed from: p */
    private void m1884p() throws alq, alt, alw {
        if (!this.f1566o) {
            throw new alq("Unable to read Checksum: device disconnected");
        }
        m1877a(this.f1648K, f1644I);
        byte[] bArrM = m1831m();
        int iM1874a = m1874a(bArrM, 4);
        if (iM1874a == 11) {
            throw new alu("Executing object failed", bArrM[3]);
        }
        if (iM1874a != 1) {
            throw new alt("Executing object failed", iM1874a);
        }
    }

    /* JADX INFO: renamed from: alm$b */
    /* JADX INFO: compiled from: SecureDfuImpl.java */
    class C0192b extends C0191a {

        /* JADX INFO: renamed from: d */
        protected int f1654d;

        private C0192b() {
            super();
        }
    }

    /* JADX INFO: renamed from: alm$a */
    /* JADX INFO: compiled from: SecureDfuImpl.java */
    class C0191a {

        /* JADX INFO: renamed from: a */
        protected int f1651a;

        /* JADX INFO: renamed from: b */
        protected int f1652b;

        private C0191a() {
        }
    }
}
