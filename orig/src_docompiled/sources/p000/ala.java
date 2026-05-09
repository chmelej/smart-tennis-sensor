package p000;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;
import p000.ale;

/* JADX INFO: compiled from: BaseDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class ala implements alh {

    /* JADX INFO: renamed from: d */
    protected static final UUID f1555d = new UUID(26392574038016L, -9223371485494954757L);

    /* JADX INFO: renamed from: e */
    protected static final UUID f1556e = new UUID(46200963207168L, -9223371485494954757L);

    /* JADX INFO: renamed from: f */
    protected static final UUID f1557f = new UUID(45088566677504L, -9223371485494954757L);

    /* JADX INFO: renamed from: g */
    protected static final char[] f1558g = "0123456789ABCDEF".toCharArray();

    /* JADX INFO: renamed from: i */
    protected InputStream f1560i;

    /* JADX INFO: renamed from: j */
    protected InputStream f1561j;

    /* JADX INFO: renamed from: k */
    protected BluetoothGatt f1562k;

    /* JADX INFO: renamed from: l */
    protected int f1563l;

    /* JADX INFO: renamed from: m */
    protected boolean f1564m;

    /* JADX INFO: renamed from: n */
    protected boolean f1565n;

    /* JADX INFO: renamed from: p */
    protected boolean f1567p;

    /* JADX INFO: renamed from: q */
    protected boolean f1568q;

    /* JADX INFO: renamed from: r */
    protected int f1569r;

    /* JADX INFO: renamed from: u */
    protected DfuBaseService f1572u;

    /* JADX INFO: renamed from: v */
    protected alg f1573v;

    /* JADX INFO: renamed from: w */
    protected int f1574w;

    /* JADX INFO: renamed from: x */
    protected int f1575x;

    /* JADX INFO: renamed from: h */
    protected final Object f1559h = new Object();

    /* JADX INFO: renamed from: s */
    protected byte[] f1570s = null;

    /* JADX INFO: renamed from: t */
    protected final byte[] f1571t = new byte[20];

    /* JADX INFO: renamed from: o */
    protected boolean f1566o = true;

    /* JADX INFO: renamed from: ala$a */
    /* JADX INFO: compiled from: BaseDfuImpl.java */
    public class C0186a extends ale.C0187a {
        protected C0186a() {
        }

        @Override // p000.ale.C0187a
        /* JADX INFO: renamed from: a */
        public void mo1835a() {
            ala.this.f1566o = false;
            ala.this.m1826h();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                ala.this.f1572u.m10785a(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + m1833a(bluetoothGattCharacteristic));
                ala.this.f1570s = bluetoothGattCharacteristic.getValue();
                ala.this.f1567p = true;
            } else {
                ala.this.m1816a("Characteristic read error: " + i);
                ala.this.f1569r = i | 16384;
            }
            ala.this.m1826h();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (ala.f1557f.equals(bluetoothGattDescriptor.getUuid())) {
                    ala.this.f1572u.m10785a(5, "Read Response received from descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + m1834a(bluetoothGattDescriptor));
                    if (ala.f1556e.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                        ala.this.f1567p = true;
                    } else {
                        ala.this.m1816a("Unknown descriptor read");
                    }
                }
            } else {
                ala.this.m1816a("Descriptor read error: " + i);
                ala.this.f1569r = i | 16384;
            }
            ala.this.m1826h();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (ala.f1557f.equals(bluetoothGattDescriptor.getUuid())) {
                    ala.this.f1572u.m10785a(5, "Data written to descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + m1834a(bluetoothGattDescriptor));
                    if (ala.f1556e.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                        ala.this.f1572u.m10785a(1, "Indications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                    } else {
                        ala.this.f1572u.m10785a(1, "Notifications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                    }
                }
            } else {
                ala.this.m1816a("Descriptor write error: " + i);
                ala.this.f1569r = i | 16384;
            }
            ala.this.m1826h();
        }

        /* JADX INFO: renamed from: a */
        protected String m1833a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return m1832a(bluetoothGattCharacteristic.getValue());
        }

        /* JADX INFO: renamed from: a */
        protected String m1834a(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return m1832a(bluetoothGattDescriptor.getValue());
        }

        /* JADX INFO: renamed from: a */
        private String m1832a(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int i = 0; i < length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 3;
                cArr[i3] = ala.f1558g[i2 >>> 4];
                cArr[i3 + 1] = ala.f1558g[i2 & 15];
                if (i != length - 1) {
                    cArr[i3 + 2] = '-';
                }
            }
            return new String(cArr);
        }
    }

    ala(Intent intent, DfuBaseService dfuBaseService) {
        this.f1572u = dfuBaseService;
        this.f1573v = dfuBaseService.f11732c;
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: d */
    public void mo1822d() {
        this.f1572u = null;
    }

    @Override // p000.alf
    /* JADX INFO: renamed from: e */
    public void mo1823e() {
        this.f1564m = true;
    }

    @Override // p000.alf
    /* JADX INFO: renamed from: f */
    public void mo1824f() {
        this.f1564m = false;
        m1826h();
    }

    @Override // p000.alf
    /* JADX INFO: renamed from: g */
    public void mo1825g() {
        this.f1564m = false;
        this.f1565n = true;
        m1826h();
    }

    @Override // p000.ale
    /* JADX INFO: renamed from: a */
    public void mo1813a(int i) {
        this.f1567p = true;
        m1826h();
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1818a(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws alr, alq, IOException, alx {
        int iAvailable;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.f1562k = bluetoothGatt;
        this.f1563l = i;
        this.f1560i = inputStream;
        this.f1561j = inputStream2;
        int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1);
        int intExtra2 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1);
        if (i > 4) {
            m1820b("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.f1572u.m10785a(15, "Sending system components");
            this.f1563l &= -5;
            ((alo) this.f1560i).m1889a(this.f1563l);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.f1572u.m10785a(15, "Sending application");
        }
        int iAvailable2 = 0;
        try {
            iAvailable = inputStream2.available();
        } catch (Exception unused) {
            iAvailable = 0;
        }
        this.f1575x = iAvailable;
        try {
            iAvailable2 = inputStream.available();
        } catch (Exception unused2) {
        }
        this.f1574w = iAvailable2;
        this.f1573v.m1844a(iAvailable2, intExtra, intExtra2);
        if (Build.VERSION.SDK_INT < 23 && bluetoothGatt.getDevice().getBondState() == 12 && (service = bluetoothGatt.getService(f1555d)) != null && (characteristic = service.getCharacteristic(f1556e)) != null) {
            if (!m1810a()) {
                m1814a(characteristic, 2);
            }
            this.f1572u.m10785a(10, "Service Changed indications enabled");
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    protected void m1826h() {
        synchronized (this.f1559h) {
            this.f1559h.notifyAll();
        }
    }

    /* JADX INFO: renamed from: i */
    protected void m1827i() {
        try {
            synchronized (this.f1559h) {
                while (this.f1564m) {
                    this.f1559h.wait();
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1814a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws alr, alq, alx {
        BluetoothGatt bluetoothGatt = this.f1562k;
        String str = i == 1 ? "notifications" : "indications";
        if (!this.f1566o) {
            throw new alq("Unable to set " + str + " state: device disconnected");
        }
        if (this.f1565n) {
            throw new alx();
        }
        this.f1570s = null;
        this.f1569r = 0;
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f1557f);
        boolean z = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
        if (z) {
            return;
        }
        m1821c("Enabling " + str + "...");
        this.f1572u.m10785a(1, "Enabling " + str + " for " + bluetoothGattCharacteristic.getUuid());
        this.f1572u.m10785a(0, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        descriptor.setValue(i == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        DfuBaseService dfuBaseService = this.f1572u;
        StringBuilder sb = new StringBuilder();
        sb.append("gatt.writeDescriptor(");
        sb.append(descriptor.getUuid());
        sb.append(i == 1 ? ", value=0x01-00)" : ", value=0x02-00)");
        dfuBaseService.m10785a(0, sb.toString());
        bluetoothGatt.writeDescriptor(descriptor);
        try {
            synchronized (this.f1559h) {
                while (true) {
                    if (!z) {
                        try {
                            if (!this.f1566o || this.f1569r != 0) {
                            }
                            this.f1559h.wait();
                            z = descriptor.getValue() == null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
                        } finally {
                        }
                    }
                    if (!this.f1564m) {
                        break;
                    }
                    this.f1559h.wait();
                    if (descriptor.getValue() == null) {
                    }
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        if (this.f1569r != 0) {
            throw new alr("Unable to set " + str + " state", this.f1569r);
        }
        if (this.f1566o) {
            return;
        }
        throw new alq("Unable to set " + str + " state: device disconnected");
    }

    /* JADX INFO: renamed from: a */
    private boolean m1810a() throws alr, alq, alx {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        if (!this.f1566o) {
            throw new alq("Unable to read Service Changed CCCD: device disconnected");
        }
        if (this.f1565n) {
            throw new alx();
        }
        BluetoothGatt bluetoothGatt = this.f1562k;
        BluetoothGattService service = bluetoothGatt.getService(f1555d);
        if (service == null || (characteristic = service.getCharacteristic(f1556e)) == null || (descriptor = characteristic.getDescriptor(f1557f)) == null) {
            return false;
        }
        this.f1567p = false;
        this.f1569r = 0;
        m1821c("Reading Service Changed CCCD value...");
        this.f1572u.m10785a(1, "Reading Service Changed CCCD value...");
        this.f1572u.m10785a(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
        bluetoothGatt.readDescriptor(descriptor);
        try {
            synchronized (this.f1559h) {
                while (true) {
                    if ((this.f1567p || !this.f1566o || this.f1569r != 0) && !this.f1564m) {
                        break;
                    }
                    this.f1559h.wait();
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        if (this.f1569r != 0) {
            throw new alr("Unable to read Service Changed CCCD", this.f1569r);
        }
        if (this.f1566o) {
            return descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0] && descriptor.getValue()[1] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1];
        }
        throw new alq("Unable to read Service Changed CCCD: device disconnected");
    }

    /* JADX INFO: renamed from: a */
    protected void m1815a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws alr, alq, alx {
        if (this.f1565n) {
            throw new alx();
        }
        this.f1570s = null;
        this.f1569r = 0;
        this.f1567p = false;
        this.f1568q = z;
        bluetoothGattCharacteristic.setWriteType(2);
        bluetoothGattCharacteristic.setValue(bArr);
        this.f1572u.m10785a(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.f1572u.m10785a(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.f1562k.writeCharacteristic(bluetoothGattCharacteristic);
        try {
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        synchronized (this.f1559h) {
            while (true) {
                if ((this.f1567p || !this.f1566o || this.f1569r != 0) && !this.f1564m) {
                    break;
                } else {
                    this.f1559h.wait();
                }
                m1817a("Sleeping interrupted", e);
                if (this.f1568q && this.f1569r != 0) {
                    throw new alr("Unable to write Op Code " + ((int) bArr[0]), this.f1569r);
                }
                if (!this.f1568q || this.f1566o) {
                }
                throw new alq("Unable to write Op Code " + ((int) bArr[0]) + ": device disconnected");
            }
        }
        if (this.f1568q) {
        }
        if (this.f1568q) {
        }
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: j */
    protected boolean m1828j() {
        boolean zM1811a;
        BluetoothDevice device = this.f1562k.getDevice();
        if (device.getBondState() == 12) {
            return true;
        }
        this.f1567p = false;
        this.f1572u.m10785a(1, "Starting pairing...");
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1572u.m10785a(0, "gatt.getDevice().createBond()");
            zM1811a = device.createBond();
        } else {
            zM1811a = m1811a(device);
        }
        try {
            synchronized (this.f1559h) {
                while (!this.f1567p && !this.f1565n) {
                    this.f1559h.wait();
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        return zM1811a;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1811a(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            if (method != null) {
                this.f1572u.m10785a(0, "gatt.getDevice().createBond() (hidden)");
                return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            Log.w("DfuImpl", "An exception occurred while creating bond", e);
        }
        return false;
    }

    /* JADX INFO: renamed from: k */
    protected boolean m1829k() {
        BluetoothDevice device = this.f1562k.getDevice();
        boolean z = true;
        if (device.getBondState() == 10) {
            return true;
        }
        this.f1572u.m10785a(1, "Removing bond information...");
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            if (method != null) {
                this.f1567p = false;
                this.f1572u.m10785a(0, "gatt.getDevice().removeBond() (hidden)");
                boolean zBooleanValue = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
                try {
                    try {
                        synchronized (this.f1559h) {
                            while (!this.f1567p && !this.f1565n) {
                                this.f1559h.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        m1817a("Sleeping interrupted", e);
                    }
                } catch (Exception e2) {
                    z = zBooleanValue;
                    e = e2;
                    Log.w("DfuImpl", "An exception occurred while removing bond information", e);
                }
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        return z;
    }

    /* JADX INFO: renamed from: l */
    protected boolean m1830l() {
        return this.f1562k.getDevice().getBondState() == 12;
    }

    /* JADX INFO: renamed from: m */
    protected byte[] m1831m() throws alr, alq, alx {
        try {
            synchronized (this.f1559h) {
                while (true) {
                    if ((this.f1570s != null || !this.f1566o || this.f1569r != 0 || this.f1565n) && !this.f1564m) {
                        break;
                    }
                    this.f1559h.wait();
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        if (this.f1565n) {
            throw new alx();
        }
        if (this.f1569r != 0) {
            throw new alr("Unable to write Op Code", this.f1569r);
        }
        if (!this.f1566o) {
            throw new alq("Unable to write Op Code: device disconnected");
        }
        return this.f1570s;
    }

    /* JADX INFO: renamed from: b */
    protected void m1819b(Intent intent, boolean z) {
        String strMo1910a;
        if (z) {
            this.f1572u.m10785a(1, "Scanning for the DFU Bootloader...");
            strMo1910a = alz.m1911a().mo1910a(this.f1562k.getDevice().getAddress());
            m1821c("Scanning for new address finished with: " + strMo1910a);
            if (strMo1910a != null) {
                this.f1572u.m10785a(5, "DFU Bootloader found with address " + strMo1910a);
            } else {
                this.f1572u.m10785a(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            strMo1910a = null;
        }
        if (strMo1910a != null) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", strMo1910a);
        }
        this.f1572u.startService(intent);
    }

    /* JADX INFO: renamed from: a */
    protected String m1812a(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 3;
            cArr[i3] = f1558g[i2 >>> 4];
            cArr[i3 + 1] = f1558g[i2 & 15];
            if (i != length - 1) {
                cArr[i3 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    void m1816a(String str) {
        Log.e("DfuImpl", str);
    }

    /* JADX INFO: renamed from: a */
    void m1817a(String str, Throwable th) {
        Log.e("DfuImpl", str, th);
    }

    /* JADX INFO: renamed from: b */
    void m1820b(String str) {
        if (DfuBaseService.f11730a) {
            Log.w("DfuImpl", str);
        }
    }

    /* JADX INFO: renamed from: c */
    void m1821c(String str) {
        if (DfuBaseService.f11730a) {
            Log.i("DfuImpl", str);
        }
    }
}
