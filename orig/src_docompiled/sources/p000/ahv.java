package p000;

import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* JADX INFO: compiled from: ShellUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class ahv {
    /* JADX INFO: renamed from: a */
    public static boolean m1269a(String str, String str2, StringBuilder sb) {
        Log.w("TAG.", str2);
        try {
            Process processExec = Runtime.getRuntime().exec("sh");
            DataInputStream dataInputStream = new DataInputStream(processExec.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(processExec.getOutputStream());
            if (str != null && !"".equals(str.trim())) {
                dataOutputStream.writeBytes("cd " + str + "\n");
            }
            dataOutputStream.writeBytes(str2 + " &\n");
            dataOutputStream.writeBytes("exit \n");
            dataOutputStream.flush();
            processExec.waitFor();
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            String str3 = new String(bArr);
            if (str3.length() == 0) {
                return true;
            }
            sb.append(str3);
            return true;
        } catch (Exception e) {
            sb.append("Exception:" + e.getMessage());
            return false;
        }
    }
}
