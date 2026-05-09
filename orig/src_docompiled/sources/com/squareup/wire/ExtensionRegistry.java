package com.squareup.wire;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ExtensionRegistry {
    private final Map<Class<? extends ExtendableMessage>, Map<Integer, Extension<?, ?>>> extensionsByTag = new LinkedHashMap();
    private final Map<Class<? extends ExtendableMessage>, Map<String, Extension<?, ?>>> extensionsByName = new LinkedHashMap();

    ExtensionRegistry() {
    }

    public <T extends ExtendableMessage<?>, E> void add(Extension<T, E> extension) {
        Class<T> extendedType = extension.getExtendedType();
        Map<Integer, Extension<?, ?>> linkedHashMap = this.extensionsByTag.get(extendedType);
        Map<String, Extension<?, ?>> linkedHashMap2 = this.extensionsByName.get(extendedType);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            linkedHashMap2 = new LinkedHashMap<>();
            this.extensionsByTag.put(extendedType, linkedHashMap);
            this.extensionsByName.put(extendedType, linkedHashMap2);
        }
        linkedHashMap.put(Integer.valueOf(extension.getTag()), extension);
        linkedHashMap2.put(extension.getName(), extension);
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, int i) {
        Map<Integer, Extension<?, ?>> map = this.extensionsByTag.get(cls);
        if (map == null) {
            return null;
        }
        return (Extension) map.get(Integer.valueOf(i));
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, String str) {
        Map<String, Extension<?, ?>> map = this.extensionsByName.get(cls);
        if (map == null) {
            return null;
        }
        return (Extension) map.get(str);
    }
}
