package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i) {
        return initSo(str, i, null);
    }

    public static boolean initSo(String str, int i, ClassLoader classLoader) {
        boolean z = true;
        try {
            if (classLoader == null) {
                System.loadLibrary(str);
            } else {
                Runtime runtime = Runtime.getRuntime();
                Method declaredMethod = Runtime.class.getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(runtime, str, classLoader);
            }
        } catch (Error e) {
            e.printStackTrace();
            z = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            z = false;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            z = false;
        }
        if (!z) {
            try {
                if (isExist(str, i)) {
                    boolean z_loadUnzipSo = _loadUnzipSo(str, i, classLoader);
                    if (z_loadUnzipSo) {
                        return z_loadUnzipSo;
                    }
                    removeSoIfExit(str, i);
                }
                String str_cpuType = _cpuType();
                if (!str_cpuType.equalsIgnoreCase(MIPS) && !str_cpuType.equalsIgnoreCase(X86)) {
                    try {
                        return unZipSelectedFiles(str, i, classLoader);
                    } catch (ZipException e4) {
                        e4.printStackTrace();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Error e6) {
                e6.printStackTrace();
                return false;
            } catch (Exception e7) {
                e7.printStackTrace();
                return false;
            } catch (UnsatisfiedLinkError e8) {
                e8.printStackTrace();
                return false;
            }
        }
        return z;
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    private static String _cpuType() {
        String str_getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (str_getFieldReflectively == null || str_getFieldReflectively.length() == 0 || str_getFieldReflectively.equals("Unknown")) {
            str_getFieldReflectively = ARMEABI;
        }
        return str_getFieldReflectively.toLowerCase();
    }

    static String _targetSoFile(String str, int i) {
        Context context = mContext;
        if (context == null) {
            return "";
        }
        String path = "/data/data/" + context.getPackageName() + "/files";
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            path = filesDir.getPath();
        }
        return path + "/lib" + str + "bk" + i + ".so";
    }

    static void removeSoIfExit(String str, int i) {
        File file = new File(_targetSoFile(str, i));
        if (file.exists()) {
            file.delete();
        }
    }

    static boolean isExist(String str, int i) {
        return new File(_targetSoFile(str, i)).exists();
    }

    static boolean _loadUnzipSo(String str, int i, ClassLoader classLoader) {
        try {
            if (isExist(str, i)) {
                if (classLoader == null) {
                    System.load(_targetSoFile(str, i));
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    Method declaredMethod = Runtime.class.getDeclaredMethod("load", String.class, ClassLoader.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(runtime, _targetSoFile(str, i), classLoader);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Error e3) {
            e3.printStackTrace();
            return false;
        }
    }

    static boolean unZipSelectedFiles(String str, int i, ClassLoader classLoader) throws Throwable {
        Context context;
        InputStream inputStream;
        FileOutputStream fileOutputStreamOpenFileOutput;
        String str2 = "lib/armeabi/lib" + str + ".so";
        try {
            context = mContext;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (context == null) {
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement.getName().startsWith(str2)) {
                FileChannel fileChannel = null;
                try {
                    removeSoIfExit(str, i);
                    inputStream = zipFile.getInputStream(zipEntryNextElement);
                    try {
                        fileOutputStreamOpenFileOutput = context.openFileOutput("lib" + str + "bk" + i + ".so", 0);
                        try {
                            FileChannel channel = fileOutputStreamOpenFileOutput.getChannel();
                            try {
                                byte[] bArr = new byte[1024];
                                int i2 = 0;
                                while (true) {
                                    int i3 = inputStream.read(bArr);
                                    if (i3 <= 0) {
                                        break;
                                    }
                                    channel.write(ByteBuffer.wrap(bArr, 0, i3));
                                    i2 += i3;
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (channel != null) {
                                    try {
                                        channel.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileOutputStreamOpenFileOutput != null) {
                                    try {
                                        fileOutputStreamOpenFileOutput.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (zipFile != null) {
                                    zipFile.close();
                                }
                                if (i2 > 0) {
                                    return _loadUnzipSo(str, i, classLoader);
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileChannel = channel;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (fileOutputStreamOpenFileOutput != null) {
                                    try {
                                        fileOutputStreamOpenFileOutput.close();
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (zipFile != null) {
                                    zipFile.close();
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStreamOpenFileOutput = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    fileOutputStreamOpenFileOutput = null;
                }
            }
        }
        return false;
    }
}
