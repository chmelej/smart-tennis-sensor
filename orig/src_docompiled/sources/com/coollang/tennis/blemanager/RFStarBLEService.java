package com.coollang.tennis.blemanager;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import p000.C1900mc;
import p000.HandlerC1841jy;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class RFStarBLEService extends Service {

    /* JADX INFO: renamed from: d */
    private static ArrayList<BluetoothGatt> f7438d = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private HandlerThread f7440b;

    /* JADX INFO: renamed from: c */
    private HandlerC1841jy f7441c;

    /* JADX INFO: renamed from: a */
    private final IBinder f7439a = new BinderC1218a();

    /* JADX INFO: renamed from: e */
    private final BluetoothGattCallback f7442e = new BluetoothGattCallback() { // from class: com.coollang.tennis.blemanager.RFStarBLEService.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            String str;
            if (i2 == 2) {
                str = "com.rfstar.kevin.service.ACTION_GATT_CONNECTED";
                Log.w("bleservice", "action = ACTION_GATT_CONNECTED; ");
                bluetoothGatt.discoverServices();
            } else if (i2 == 0) {
                str = "com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED";
                RFStarBLEService.this.m7758b(bluetoothGatt.getDevice());
            } else {
                str = null;
            }
            if (str == null || str.equals("")) {
                return;
            }
            RFStarBLEService.this.m7751a(str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            Log.w("bleservice", "eeeeeeee  onServicesDiscovered received: " + i);
            if (i == 0) {
                RFStarBLEService.this.m7751a("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED");
                return;
            }
            Log.w("bleservice", "onServicesDiscovered received: " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                RFStarBLEService.this.m7752a("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
                return;
            }
            Log.d("bleservice", "onCharacteristicRead received: " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            RFStarBLEService.this.m7752a("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (bluetoothGatt.connect()) {
                RFStarBLEService.this.m7751a("com.rfstar.kevin.service.RSSI");
                Log.d("bleservice", "11111111111111111 onReadRemoteRssi  : " + i);
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C1900mc.m10474b("RFStarBLEService", "onBind");
        this.f7440b = new HandlerThread("dataprocess");
        this.f7440b.start();
        this.f7441c = new HandlerC1841jy(this.f7440b.getLooper());
        return this.f7439a;
    }

    /* JADX INFO: renamed from: a */
    private void m7753a(byte[] bArr) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = bArr;
        this.f7441c.sendMessage(messageObtain);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C1900mc.m10474b("RFStarBLEService", "onUnbind");
        if (this.f7440b != null) {
            this.f7440b.quit();
        }
        return super.onUnbind(intent);
    }

    /* JADX INFO: renamed from: a */
    public boolean m7757a(BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGattM7754e = m7754e(bluetoothDevice);
        if (bluetoothGattM7754e != null) {
            if (!bluetoothGattM7754e.connect()) {
                return false;
            }
            Log.d("bleservice", "55555 当前连接的设备同address mac : " + bluetoothGattM7754e.getDevice().getAddress() + "  连接上  数量: " + f7438d.size());
            return true;
        }
        Log.w("bleservice", "5555" + bluetoothDevice.getName() + ": 蓝牙设备正准备连接");
        BluetoothGatt bluetoothGattConnectGatt = bluetoothDevice.connectGatt(this, false, this.f7442e);
        if (bluetoothGattConnectGatt != null) {
            f7438d.add(bluetoothGattConnectGatt);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void m7758b(BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGattM7754e = m7754e(bluetoothDevice);
        if (bluetoothGattM7754e == null) {
            Log.w("bleservice", "kBluetoothGatt 不能断开连接");
            return;
        }
        bluetoothGattM7754e.close();
        bluetoothGattM7754e.disconnect();
        f7438d.remove(bluetoothGattM7754e);
        Log.w("bleservice", "kBluetoothGatt 断开连接");
    }

    /* JADX INFO: renamed from: c */
    public boolean m7759c(BluetoothDevice bluetoothDevice) {
        return m7757a(bluetoothDevice);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.blemanager.RFStarBLEService$a */
    public class BinderC1218a extends Binder {
        public BinderC1218a() {
        }

        /* JADX INFO: renamed from: a */
        public RFStarBLEService m7761a() {
            return RFStarBLEService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7751a(String str) {
        sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7752a(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intent intent = new Intent(str);
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value != null && value.length > 0) {
            m7753a(value);
            intent.putExtra("com.rfstar.kevin.service.EXTRA_DATA", bluetoothGattCharacteristic.getValue());
            intent.putExtra("com.rfstar.kevin.service.characteristic", bluetoothGattCharacteristic.getUuid().toString());
        }
        sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: a */
    public void m7755a(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGattM7754e = m7754e(bluetoothDevice);
        if (bluetoothGattM7754e == null) {
            Log.w("bleservice", "kBluetoothGatt 为没有初始化，所以不能写入数据");
            return;
        }
        bluetoothGattM7754e.writeCharacteristic(bluetoothGattCharacteristic);
        Log.d("bleservice", "55 connect :  连接上  数量： " + f7438d.size());
    }

    /* JADX INFO: renamed from: a */
    public void m7756a(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGatt bluetoothGattM7754e = m7754e(bluetoothDevice);
        if (bluetoothGattM7754e == null) {
            Log.w("bleservice", "kBluetoothGatt 为没有初始化，所以不能发送使能数据");
            return;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805F9B34FB"));
        if (z) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        bluetoothGattM7754e.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        bluetoothGattM7754e.writeDescriptor(descriptor);
    }

    /* JADX INFO: renamed from: d */
    public List<BluetoothGattService> m7760d(BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGattM7754e = m7754e(bluetoothDevice);
        if (bluetoothGattM7754e == null) {
            Log.w("bleservice", "111111111111  services is null ");
            return null;
        }
        return bluetoothGattM7754e.getServices();
    }

    /* JADX INFO: renamed from: e */
    private BluetoothGatt m7754e(BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGatt = null;
        for (int i = 0; i < f7438d.size(); i++) {
            if (f7438d.get(i).getDevice().getAddress().equals(bluetoothDevice.getAddress())) {
                bluetoothGatt = f7438d.get(i);
            }
        }
        return bluetoothGatt;
    }
}
