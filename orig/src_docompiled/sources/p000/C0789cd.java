package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: renamed from: cd */
/* JADX INFO: compiled from: MultiDexExtractor.java */
/* JADX INFO: loaded from: classes.dex */
final class C0789cd {

    /* JADX INFO: renamed from: cd$a */
    /* JADX INFO: compiled from: MultiDexExtractor.java */
    static class a extends File {

        /* JADX INFO: renamed from: a */
        public long f5324a;

        public a(File file, String str) {
            super(file, str);
            this.f5324a = -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.util.List<? extends java.io.File> m5768a(android.content.Context r14, java.io.File r15, java.io.File r16, java.lang.String r17, boolean r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0789cd.m5768a(android.content.Context, java.io.File, java.io.File, java.lang.String, boolean):java.util.List");
    }

    /* JADX INFO: renamed from: a */
    private static List<a> m5767a(Context context, File file, File file2, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = file.getName() + ".classes";
        SharedPreferences sharedPreferencesM5766a = m5766a(context);
        int i = sharedPreferencesM5766a.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + (-1));
        int i2 = 2;
        while (i2 <= i) {
            a aVar = new a(file2, str2 + i2 + ".zip");
            if (aVar.isFile()) {
                aVar.f5324a = m5775b(aVar);
                long j = sharedPreferencesM5766a.getLong(str + "dex.crc." + i2, -1L);
                long j2 = sharedPreferencesM5766a.getLong(str + "dex.time." + i2, -1L);
                long jLastModified = aVar.lastModified();
                if (j2 == jLastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences = sharedPreferencesM5766a;
                    if (j == aVar.f5324a) {
                        arrayList.add(aVar);
                        i2++;
                        str2 = str3;
                        sharedPreferencesM5766a = sharedPreferences;
                    }
                }
                throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + jLastModified + ", expected crc: " + j + ", file crc: " + aVar.f5324a);
            }
            throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5774a(Context context, File file, long j, String str) {
        SharedPreferences sharedPreferencesM5766a = m5766a(context);
        if (sharedPreferencesM5766a.getLong(str + "timestamp", -1L) == m5765a(file)) {
            if (sharedPreferencesM5766a.getLong(str + "crc", -1L) == j) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static long m5765a(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    /* JADX INFO: renamed from: b */
    private static long m5775b(File file) throws IOException {
        long jM5776a = C0790ce.m5776a(file);
        return jM5776a == -1 ? jM5776a - 1 : jM5776a;
    }

    /* JADX INFO: renamed from: a */
    private static List<a> m5769a(File file, File file2) {
        String str = file.getName() + ".classes";
        m5772a(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        int i = 2;
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            while (entry != null) {
                a aVar = new a(file2, str + i + ".zip");
                arrayList.add(aVar);
                Log.i("MultiDex", "Extraction is needed for file " + aVar);
                int i2 = 0;
                boolean z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    m5773a(zipFile, entry, aVar, str);
                    try {
                        aVar.f5324a = m5775b(aVar);
                        z = true;
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to read crc from " + aVar.getAbsolutePath(), e);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" - length ");
                    sb.append(aVar.getAbsolutePath());
                    sb.append(": ");
                    sb.append(aVar.length());
                    sb.append(" - crc: ");
                    sb.append(aVar.f5324a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        aVar.delete();
                        if (aVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                        }
                    }
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                i++;
                entry = zipFile.getEntry("classes" + i + ".dex");
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5770a(Context context, String str, long j, long j2, List<a> list) {
        SharedPreferences.Editor editorEdit = m5766a(context).edit();
        editorEdit.putLong(str + "timestamp", j);
        editorEdit.putLong(str + "crc", j2);
        editorEdit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (a aVar : list) {
            editorEdit.putLong(str + "dex.crc." + i, aVar.f5324a);
            editorEdit.putLong(str + "dex.time." + i, aVar.lastModified());
            i++;
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    private static SharedPreferences m5766a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* JADX INFO: renamed from: a */
    private static void m5772a(File file, final String str) {
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: cd.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return (name.startsWith(str) || name.equals("MultiDex.lock")) ? false : true;
            }
        });
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : fileArrListFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (file2.delete()) {
                Log.i("MultiDex", "Deleted old file " + file2.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5773a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i = inputStream.read(bArr); i != -1; i = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            m5771a(inputStream);
            fileCreateTempFile.delete();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5771a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }
}
