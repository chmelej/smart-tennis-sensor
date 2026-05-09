package p000;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.coollang.tennis.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: jb */
/* JADX INFO: compiled from: MyArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1818jb extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    List<BluetoothDevice> f10475a;

    /* JADX INFO: renamed from: d */
    Context f10478d;

    /* JADX INFO: renamed from: b */
    Map<String, Integer> f10476b = new LinkedHashMap();

    /* JADX INFO: renamed from: c */
    HashMap<String, String> f10477c = new HashMap<>();

    /* JADX INFO: renamed from: h */
    private int f10482h = -1;

    /* JADX INFO: renamed from: i */
    private boolean f10483i = true;

    /* JADX INFO: renamed from: f */
    Runnable f10480f = new Runnable() { // from class: jb.1
        @Override // java.lang.Runnable
        public void run() {
            C1818jb.this.f10483i = true;
            C1818jb.this.f10479e.postDelayed(this, 1000L);
            C1818jb.this.m9853b();
            C1900mc.m10474b("isok", "isok");
        }
    };

    /* JADX INFO: renamed from: g */
    Comparator f10481g = new Comparator<BluetoothDevice>() { // from class: jb.2
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
            return C1818jb.this.f10476b.get(bluetoothDevice2.getAddress()).intValue() - C1818jb.this.f10476b.get(bluetoothDevice.getAddress()).intValue();
        }
    };

    /* JADX INFO: renamed from: e */
    public final Handler f10479e = new Handler();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1818jb(Context context, List<BluetoothDevice> list) {
        this.f10475a = new ArrayList();
        this.f10475a = list;
        this.f10478d = context;
        this.f10479e.postDelayed(this.f10480f, 2000L);
    }

    /* JADX INFO: renamed from: a */
    public void m9851a() {
        this.f10479e.removeCallbacks(this.f10480f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10475a.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BluetoothDevice getItem(int i) {
        return this.f10475a.get(i);
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ViewHolder"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = View.inflate(this.f10478d, R.layout.list_tv, null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.cb_ble);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_rssi);
        if (i == this.f10482h) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        if (this.f10475a.size() > 0 && this.f10475a.get(i).getName() != null && !TextUtils.isEmpty(this.f10475a.get(i).getAddress().trim())) {
            checkBox.setText(this.f10475a.get(i).getName().trim());
            if (this.f10476b.size() > 0) {
                int iIntValue = this.f10476b.get(this.f10475a.get(i).getAddress()).intValue();
                if (iIntValue > -55) {
                    imageView.setImageResource(R.drawable.rssi4);
                } else if (iIntValue < -55 && iIntValue > -65) {
                    imageView.setImageResource(R.drawable.rssi4);
                } else if (iIntValue < -65 && iIntValue > -85) {
                    imageView.setImageResource(R.drawable.rssi3);
                } else if (iIntValue < -85 && iIntValue > -100) {
                    imageView.setImageResource(R.drawable.rssi2);
                } else {
                    imageView.setImageResource(R.drawable.rssi1);
                }
            }
        }
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public void m9852a(String str, int i, String str2) {
        this.f10476b.put(str, Integer.valueOf(i));
        this.f10477c.put(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public void m9853b() {
        if (this.f10483i) {
            this.f10483i = false;
            String address = this.f10482h != -1 ? this.f10475a.get(this.f10482h).getAddress() : "";
            Collections.sort(this.f10475a, this.f10481g);
            if (this.f10482h != -1) {
                this.f10482h = -1;
                for (int i = 0; i < this.f10475a.size(); i++) {
                    if (this.f10475a.get(i).getAddress().equals(address)) {
                        this.f10482h = i;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9854b(int i) {
        this.f10482h = i;
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: c */
    public int m9855c() {
        return this.f10482h;
    }

    /* JADX INFO: renamed from: d */
    public String m9856d() {
        return this.f10477c.get(this.f10475a.get(this.f10482h).getAddress());
    }

    /* JADX INFO: renamed from: e */
    public BluetoothDevice m9857e() {
        if (this.f10482h == -1 || this.f10475a == null || this.f10475a.size() <= this.f10482h) {
            return null;
        }
        return this.f10475a.get(this.f10482h);
    }

    /* JADX INFO: renamed from: f */
    public void m9858f() {
        this.f10479e.removeCallbacks(this.f10480f);
        this.f10483i = true;
    }
}
