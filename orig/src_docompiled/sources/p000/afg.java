package p000;

import android.support.v4.app.FrameMetricsAggregator;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: TBaseHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class afg {

    /* JADX INFO: renamed from: a */
    private static final Comparator f754a = new C0086a();

    /* JADX INFO: renamed from: a */
    public static int m832a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public static int m833a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public static int m838a(byte[] bArr, byte[] bArr2) {
        int iM833a = m833a(bArr.length, bArr2.length);
        if (iM833a != 0) {
            return iM833a;
        }
        for (int i = 0; i < bArr.length; i++) {
            int iM832a = m832a(bArr[i], bArr2[i]);
            if (iM832a != 0) {
                return iM832a;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public static int m834a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* JADX INFO: renamed from: a */
    public static int m835a(List list, List list2) {
        int iM833a = m833a(list.size(), list2.size());
        if (iM833a != 0) {
            return iM833a;
        }
        for (int i = 0; i < list.size(); i++) {
            int iCompare = f754a.compare(list.get(i), list2.get(i));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public static int m837a(Set set, Set set2) {
        int iM833a = m833a(set.size(), set2.size());
        if (iM833a != 0) {
            return iM833a;
        }
        TreeSet treeSet = new TreeSet(f754a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f754a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompare = f754a.compare(it.next(), it2.next());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public static int m836a(Map map, Map map2) {
        int iM833a = m833a(map.size(), map2.size());
        if (iM833a != 0) {
            return iM833a;
        }
        TreeMap treeMap = new TreeMap(f754a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f754a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int iCompare = f754a.compare(entry.getKey(), entry2.getKey());
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompare2 = f754a.compare(entry.getValue(), entry2.getValue());
            if (iCompare2 != 0) {
                return iCompare2;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: afg$a */
    /* JADX INFO: compiled from: TBaseHelper.java */
    static class C0086a implements Comparator {
        private C0086a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return afg.m835a((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return afg.m837a((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return afg.m836a((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return afg.m838a((byte[]) obj, (byte[]) obj2);
            }
            return afg.m834a((Comparable) obj, (Comparable) obj2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m840a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        int iPosition = byteBuffer.position() + iArrayOffset;
        int iLimit = iArrayOffset + byteBuffer.limit();
        int i = iLimit - iPosition > 128 ? iPosition + 128 : iLimit;
        for (int i2 = iPosition; i2 < i; i2++) {
            if (i2 > iPosition) {
                sb.append(" ");
            }
            sb.append(m839a(bArrArray[i2]));
        }
        if (iLimit != i) {
            sb.append("...");
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m839a(byte b) {
        return Integer.toHexString((b | 256) & FrameMetricsAggregator.EVERY_DURATION).toUpperCase().substring(1);
    }
}
