package com.squareup.wire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
abstract class TagMap<T> {
    private static final Comparator<? super Map.Entry<Integer, ?>> COMPARATOR = new Comparator<Map.Entry<Integer, ?>>() { // from class: com.squareup.wire.TagMap.1
        @Override // java.util.Comparator
        public int compare(Map.Entry<Integer, ?> entry, Map.Entry<Integer, ?> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    };
    private static final float RATIO_THRESHOLD = 0.75f;
    private static final int SIZE_THRESHOLD = 64;
    List<T> values;

    private static boolean isCompact(int i, int i2) {
        return i2 <= 64 || ((float) i) / ((float) i2) > RATIO_THRESHOLD;
    }

    public abstract boolean containsKey(int i);

    public abstract T get(int i);

    /* JADX INFO: renamed from: of */
    public static <T> TagMap<T> m8679of(Map<Integer, T> map) {
        int iMaxTag = maxTag(map);
        if (isCompact(map.size(), iMaxTag)) {
            return Compact.compactTagMapOf(map, iMaxTag);
        }
        return Sparse.sparseTagMapOf(map);
    }

    private static <T> int maxTag(Map<Integer, T> map) {
        Iterator<Integer> it = map.keySet().iterator();
        int i = -1;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue > i) {
                i = iIntValue;
            }
        }
        return i;
    }

    private static <T> List<T> sortedValues(Map<Integer, T> map) {
        TreeSet treeSet = new TreeSet(COMPARATOR);
        treeSet.addAll(map.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    protected TagMap(Map<Integer, T> map) {
        this.values = sortedValues(map);
    }

    public Collection<T> values() {
        return this.values;
    }

    static final class Compact<T> extends TagMap<T> {
        Object[] elementsByTag;
        int maxTag;

        public static <T> Compact<T> compactTagMapOf(Map<Integer, T> map, int i) {
            return new Compact<>(map, i);
        }

        private Compact(Map<Integer, T> map, int i) {
            super(map);
            this.maxTag = -1;
            this.maxTag = i;
            this.elementsByTag = new Object[i + 1];
            for (Map.Entry<Integer, T> entry : map.entrySet()) {
                Integer key = entry.getKey();
                if (key.intValue() <= 0) {
                    throw new IllegalArgumentException("Input map key is negative or zero");
                }
                this.elementsByTag[key.intValue()] = entry.getValue();
            }
        }

        @Override // com.squareup.wire.TagMap
        public T get(int i) {
            if (i > this.maxTag) {
                return null;
            }
            return (T) this.elementsByTag[i];
        }

        @Override // com.squareup.wire.TagMap
        public boolean containsKey(int i) {
            return i <= this.maxTag && this.elementsByTag[i] != null;
        }
    }

    static final class Sparse<T> extends TagMap<T> {
        Map<Integer, T> map;

        public static <T> Sparse<T> sparseTagMapOf(Map<Integer, T> map) {
            return new Sparse<>(map);
        }

        private Sparse(Map<Integer, T> map) {
            super(map);
            this.map = map;
        }

        @Override // com.squareup.wire.TagMap
        public T get(int i) {
            return this.map.get(Integer.valueOf(i));
        }

        @Override // com.squareup.wire.TagMap
        public boolean containsKey(int i) {
            return this.map.containsKey(Integer.valueOf(i));
        }
    }
}
