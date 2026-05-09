package p000;

import com.coollang.tennis.p011db.model.MyDetailTable;
import com.coollang.tennis.p011db.model.VideoDetailTable;
import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.DataSupport;

/* JADX INFO: renamed from: jz */
/* JADX INFO: compiled from: MainDataManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1842jz {

    /* JADX INFO: renamed from: a */
    public static C1842jz f10846a;

    /* JADX INFO: renamed from: e */
    private a f10850e;

    /* JADX INFO: renamed from: d */
    private String f10849d = "-1";

    /* JADX INFO: renamed from: b */
    public boolean f10847b = false;

    /* JADX INFO: renamed from: c */
    long f10848c = 0;

    /* JADX INFO: renamed from: f */
    private int f10851f = 0;

    /* JADX INFO: renamed from: jz$a */
    /* JADX INFO: compiled from: MainDataManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7381a();
    }

    private C1842jz() {
    }

    /* JADX INFO: renamed from: a */
    public static C1842jz m10050a() {
        if (f10846a == null) {
            f10846a = new C1842jz();
        }
        return f10846a;
    }

    /* JADX INFO: renamed from: a */
    public void m10054a(a aVar) {
        this.f10850e = aVar;
    }

    /* JADX INFO: renamed from: b */
    public void m10055b() {
        if (C1839jw.f10820a != null) {
            C1839jw.f10820a.m10019a(C1839jw.m10026a());
        }
        this.f10849d = C1902me.m10480a(C1914mm.m10554a());
    }

    /* JADX INFO: renamed from: c */
    public void m10056c() {
        this.f10847b = false;
        C1808is.m9827c("run- synchroData()");
        m10051e();
    }

    /* JADX INFO: renamed from: a */
    public List<MyDetailTable> m10052a(long j, long j2, String str) {
        List<VideoDetailTable> listFind;
        List<MyDetailTable> listFind2 = DataSupport.where("timestamp > ? and timestamp < ? And userid = ?", String.valueOf(j), String.valueOf(j2), str).find(MyDetailTable.class);
        if ((listFind2 != null && !listFind2.isEmpty()) || (listFind = DataSupport.where("timestamp > ? and timestamp < ? And userid = ?", String.valueOf(j), String.valueOf(j2), str).find(VideoDetailTable.class)) == null || listFind.isEmpty()) {
            return listFind2;
        }
        listFind2.clear();
        listFind2.addAll(m10049a(listFind));
        return listFind2;
    }

    /* JADX INFO: renamed from: a */
    private List<MyDetailTable> m10049a(List<VideoDetailTable> list) {
        List<VideoDetailTable> list2 = list;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            arrayList.add(new MyDetailTable(list2.get(i).getTimestamp(), list2.get(i).getActionType(), list2.get(i).getSpeed(), list2.get(i).getRadian(), list2.get(i).getForce(), list2.get(i).getIstarget(), i, 1, list2.get(i).getDay(), list2.get(i).getUserID(), list2.get(i).getHandType()));
            i++;
            list2 = list;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public List<Long> m10053a(List<MyDetailTable> list, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(list.get(0).getTimestamp() - j));
        for (int i = 1; i < list.size(); i++) {
            arrayList.add(Long.valueOf(list.get(i).getTimestamp() - list.get(i - 1).getTimestamp()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    private void m10051e() {
        long jM10532a = C1912mk.m10532a() - C1912mk.m10533a("1970-01-01 00:00:00");
        C1900mc.m10474b("MainDataManager_校准时间", "time == " + jM10532a + " date == " + C1912mk.m10534a(jM10532a));
        byte[] bArrM10450a = C1893lw.m10450a(jM10532a);
        C1839jw.m10026a().m10042a(17, bArrM10450a[0], bArrM10450a[1], bArrM10450a[2], bArrM10450a[3]);
    }

    /* JADX INFO: renamed from: d */
    public void m10057d() {
        this.f10847b = true;
        if (this.f10850e != null) {
            this.f10850e.mo7381a();
        }
    }
}
