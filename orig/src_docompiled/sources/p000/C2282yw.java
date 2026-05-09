package p000;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: yw */
/* JADX INFO: loaded from: classes.dex */
final class C2282yw {
    /* JADX INFO: renamed from: a */
    static File m12517a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            m12517a(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }

    /* JADX INFO: renamed from: a */
    static List<String> m12518a(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
            arrayList.add(line.trim());
        }
    }
}
