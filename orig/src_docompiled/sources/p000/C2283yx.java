package p000;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.umeng.message.MsgConstant;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: renamed from: yx */
/* JADX INFO: loaded from: classes.dex */
final class C2283yx extends AbstractC2288zb {
    C2283yx(Context context) {
        super(context);
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: a */
    protected final void mo12519a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            C2282yw.m12517a(Environment.getExternalStorageDirectory() + "/" + C2290zd.m12540c("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C2290zd.m12540c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(C2290zd.m12540c("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Exception e) {
                Log.w("MID", e);
            }
        }
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: a */
    protected final boolean mo12520a() {
        return C2290zd.m12536a(this.f13775a, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) && Environment.getExternalStorageState().equals("mounted");
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: b */
    protected final String mo12521b() {
        String str;
        Iterator<String> it;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                it = C2282yw.m12518a(new File(Environment.getExternalStorageDirectory(), C2290zd.m12540c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))).iterator();
            } catch (IOException e) {
                Log.w("MID", e);
            }
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(",");
                if (strArrSplit.length == 2 && strArrSplit[0].equals(C2290zd.m12540c("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                    Log.i("MID", "read mid from InternalStorage:" + strArrSplit[1]);
                    str = strArrSplit[1];
                    break;
                }
                str = null;
            }
            str = null;
        }
        return str;
    }
}
