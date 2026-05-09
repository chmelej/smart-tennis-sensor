package p000;

import java.io.File;

/* JADX INFO: renamed from: lx */
/* JADX INFO: compiled from: DeleteFileUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class C1894lx {
    /* JADX INFO: renamed from: a */
    public static boolean m10457a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + str + "不存在！");
            return false;
        }
        if (file.isFile()) {
            return m10458b(str);
        }
        return m10459c(str);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10458b(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + str + "成功！");
                return true;
            }
            System.out.println("删除单个文件" + str + "失败！");
            return false;
        }
        System.out.println("删除单个文件失败：" + str + "不存在！");
        return false;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m10459c(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("删除目录失败：" + str + "不存在！");
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        boolean zM10459c = true;
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].isFile()) {
                zM10459c = m10458b(fileArrListFiles[i].getAbsolutePath());
                if (!zM10459c) {
                    break;
                }
            } else {
                if (fileArrListFiles[i].isDirectory() && !(zM10459c = m10459c(fileArrListFiles[i].getAbsolutePath()))) {
                    break;
                }
            }
        }
        if (!zM10459c) {
            System.out.println("删除目录失败！");
            return false;
        }
        if (!file.delete()) {
            return false;
        }
        System.out.println("删除目录" + str + "成功！");
        return true;
    }
}
