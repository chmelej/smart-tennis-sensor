package com.lidroid.xutils.bitmap.core;

import android.graphics.Bitmap;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.bitmap.factory.BitmapFactory;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.cache.LruDiskCache;
import com.lidroid.xutils.cache.LruMemoryCache;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
public class BitmapCache {
    private BitmapGlobalConfig globalConfig;
    private LruDiskCache mDiskLruCache;
    private LruMemoryCache<MemoryCacheKey, Bitmap> mMemoryCache;
    private final int DISK_CACHE_INDEX = 0;
    private final Object mDiskCacheLock = new Object();

    public BitmapCache(BitmapGlobalConfig bitmapGlobalConfig) {
        if (bitmapGlobalConfig == null) {
            throw new IllegalArgumentException("globalConfig may not be null");
        }
        this.globalConfig = bitmapGlobalConfig;
    }

    public void initMemoryCache() {
        if (this.globalConfig.isMemoryCacheEnabled()) {
            if (this.mMemoryCache != null) {
                try {
                    clearMemoryCache();
                } catch (Throwable unused) {
                }
            }
            this.mMemoryCache = new LruMemoryCache<MemoryCacheKey, Bitmap>(this.globalConfig.getMemoryCacheSize()) { // from class: com.lidroid.xutils.bitmap.core.BitmapCache.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.lidroid.xutils.cache.LruMemoryCache
                public int sizeOf(MemoryCacheKey memoryCacheKey, Bitmap bitmap) {
                    if (bitmap == null) {
                        return 0;
                    }
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: all -> 0x0061, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x000f, B:10:0x0017, B:12:0x0028, B:14:0x002e, B:19:0x003f, B:23:0x0058, B:24:0x005f), top: B:29:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initDiskCache() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mDiskCacheLock
            monitor-enter(r0)
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r1 = r7.globalConfig     // Catch: java.lang.Throwable -> L61
            boolean r1 = r1.isDiskCacheEnabled()     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L5f
            com.lidroid.xutils.cache.LruDiskCache r1 = r7.mDiskLruCache     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L17
            com.lidroid.xutils.cache.LruDiskCache r1 = r7.mDiskLruCache     // Catch: java.lang.Throwable -> L61
            boolean r1 = r1.isClosed()     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L5f
        L17:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L61
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r2 = r7.globalConfig     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = r2.getDiskCachePath()     // Catch: java.lang.Throwable -> L61
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L61
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L61
            if (r2 != 0) goto L2e
            boolean r2 = r1.mkdirs()     // Catch: java.lang.Throwable -> L61
            if (r2 == 0) goto L5f
        L2e:
            long r2 = com.lidroid.xutils.util.OtherUtils.getAvailableSpace(r1)     // Catch: java.lang.Throwable -> L61
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r4 = r7.globalConfig     // Catch: java.lang.Throwable -> L61
            int r4 = r4.getDiskCacheSize()     // Catch: java.lang.Throwable -> L61
            long r4 = (long) r4
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L3e
            r2 = r4
        L3e:
            r4 = 1
            com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.open(r1, r4, r4, r2)     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            r7.mDiskLruCache = r1     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            com.lidroid.xutils.cache.LruDiskCache r1 = r7.mDiskLruCache     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r2 = r7.globalConfig     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            com.lidroid.xutils.cache.FileNameGenerator r2 = r2.getFileNameGenerator()     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            r1.setFileNameGenerator(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            java.lang.String r1 = "create disk cache success"
            com.lidroid.xutils.util.LogUtils.m8417d(r1)     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L61
            goto L5f
        L56:
            r1 = move-exception
            r2 = 0
            r7.mDiskLruCache = r2     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = "create disk cache error"
            com.lidroid.xutils.util.LogUtils.m8420e(r2, r1)     // Catch: java.lang.Throwable -> L61
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L61
            return
        L61:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L61
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.bitmap.core.BitmapCache.initDiskCache():void");
    }

    public void setMemoryCacheSize(int i) {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.setMaxSize(i);
        }
    }

    public void setDiskCacheSize(int i) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                this.mDiskLruCache.setMaxSize(i);
            }
        }
    }

    public void setDiskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null && fileNameGenerator != null) {
                this.mDiskLruCache.setFileNameGenerator(fileNameGenerator);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac A[Catch: all -> 0x00dc, Throwable -> 0x00df, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00df, blocks: (B:48:0x00ac, B:64:0x00e6, B:45:0x009e), top: B:78:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6 A[Catch: all -> 0x00dc, Throwable -> 0x00df, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00df, blocks: (B:48:0x00ac, B:64:0x00e6, B:45:0x009e), top: B:78:0x009e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap downloadBitmap(java.lang.String r17, com.lidroid.xutils.bitmap.BitmapDisplayConfig r18, com.lidroid.xutils.BitmapUtils.BitmapLoadTask<?> r19) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.bitmap.core.BitmapCache.downloadBitmap(java.lang.String, com.lidroid.xutils.bitmap.BitmapDisplayConfig, com.lidroid.xutils.BitmapUtils$BitmapLoadTask):android.graphics.Bitmap");
    }

    private Bitmap addBitmapToMemoryCache(String str, BitmapDisplayConfig bitmapDisplayConfig, Bitmap bitmap, long j) {
        BitmapFactory bitmapFactory;
        if (bitmapDisplayConfig != null && (bitmapFactory = bitmapDisplayConfig.getBitmapFactory()) != null) {
            bitmap = bitmapFactory.cloneNew().createBitmap(bitmap);
        }
        if (str != null && bitmap != null && this.globalConfig.isMemoryCacheEnabled() && this.mMemoryCache != null) {
            this.mMemoryCache.put(new MemoryCacheKey(this, str, bitmapDisplayConfig, null), bitmap, j);
        }
        return bitmap;
    }

    public Bitmap getBitmapFromMemCache(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        MemoryCacheKey memoryCacheKey = null;
        if (this.mMemoryCache == null || !this.globalConfig.isMemoryCacheEnabled()) {
            return null;
        }
        return this.mMemoryCache.get(new MemoryCacheKey(this, str, bitmapDisplayConfig, memoryCacheKey));
    }

    public File getBitmapFileFromDiskCache(String str) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache == null) {
                return null;
            }
            return this.mDiskLruCache.getCacheFile(str, 0);
        }
    }

    public Bitmap getBitmapFromDiskCache(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        LruDiskCache.Snapshot snapshot;
        Bitmap bitmapDecodeSampledBitmapFromDescriptor;
        if (str == null || !this.globalConfig.isDiskCacheEnabled()) {
            return null;
        }
        if (this.mDiskLruCache == null) {
            initDiskCache();
        }
        LruDiskCache lruDiskCache = this.mDiskLruCache;
        try {
            if (lruDiskCache != null) {
                try {
                    snapshot = this.mDiskLruCache.get(str);
                    if (snapshot != null) {
                        if (bitmapDisplayConfig != null) {
                            try {
                                if (bitmapDisplayConfig.isShowOriginal()) {
                                    bitmapDecodeSampledBitmapFromDescriptor = BitmapDecoder.decodeFileDescriptor(snapshot.getInputStream(0).getFD());
                                } else {
                                    bitmapDecodeSampledBitmapFromDescriptor = BitmapDecoder.decodeSampledBitmapFromDescriptor(snapshot.getInputStream(0).getFD(), bitmapDisplayConfig.getBitmapMaxSize(), bitmapDisplayConfig.getBitmapConfig());
                                }
                            } catch (Throwable th) {
                                th = th;
                                LogUtils.m8420e(th.getMessage(), th);
                                IOUtils.closeQuietly(snapshot);
                                return null;
                            }
                        } else {
                            bitmapDecodeSampledBitmapFromDescriptor = BitmapDecoder.decodeFileDescriptor(snapshot.getInputStream(0).getFD());
                        }
                        Bitmap bitmapAddBitmapToMemoryCache = addBitmapToMemoryCache(str, bitmapDisplayConfig, rotateBitmapIfNeeded(str, bitmapDisplayConfig, bitmapDecodeSampledBitmapFromDescriptor), this.mDiskLruCache.getExpiryTimestamp(str));
                        IOUtils.closeQuietly(snapshot);
                        return bitmapAddBitmapToMemoryCache;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    snapshot = null;
                }
                IOUtils.closeQuietly(snapshot);
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void clearCache() {
        clearMemoryCache();
        clearDiskCache();
    }

    public void clearMemoryCache() {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.evictAll();
        }
    }

    public void clearDiskCache() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null && !this.mDiskLruCache.isClosed()) {
                try {
                    this.mDiskLruCache.delete();
                    this.mDiskLruCache.close();
                } catch (Throwable th) {
                    LogUtils.m8420e(th.getMessage(), th);
                }
                this.mDiskLruCache = null;
            }
        }
        initDiskCache();
    }

    public void clearCache(String str) {
        clearMemoryCache(str);
        clearDiskCache(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void clearMemoryCache(String str) {
        MemoryCacheKey memoryCacheKey = new MemoryCacheKey(this, str, null, 0 == true ? 1 : 0);
        if (this.mMemoryCache != null) {
            while (this.mMemoryCache.containsKey(memoryCacheKey)) {
                this.mMemoryCache.remove(memoryCacheKey);
            }
        }
    }

    public void clearDiskCache(String str) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null && !this.mDiskLruCache.isClosed()) {
                try {
                    this.mDiskLruCache.remove(str);
                } catch (Throwable th) {
                    LogUtils.m8420e(th.getMessage(), th);
                }
            }
        }
    }

    public void flush() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    this.mDiskLruCache.flush();
                } catch (Throwable th) {
                    LogUtils.m8420e(th.getMessage(), th);
                }
            }
        }
    }

    public void close() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    if (!this.mDiskLruCache.isClosed()) {
                        this.mDiskLruCache.close();
                    }
                } catch (Throwable th) {
                    LogUtils.m8420e(th.getMessage(), th);
                }
                this.mDiskLruCache = null;
            }
        }
    }

    class BitmapMeta {
        public byte[] data;
        public long expiryTimestamp;
        public FileInputStream inputStream;

        private BitmapMeta() {
        }

        /* synthetic */ BitmapMeta(BitmapCache bitmapCache, BitmapMeta bitmapMeta) {
            this();
        }
    }

    private Bitmap decodeBitmapMeta(BitmapMeta bitmapMeta, BitmapDisplayConfig bitmapDisplayConfig) {
        if (bitmapMeta == null) {
            return null;
        }
        if (bitmapMeta.inputStream != null) {
            if (bitmapDisplayConfig == null || bitmapDisplayConfig.isShowOriginal()) {
                return BitmapDecoder.decodeFileDescriptor(bitmapMeta.inputStream.getFD());
            }
            return BitmapDecoder.decodeSampledBitmapFromDescriptor(bitmapMeta.inputStream.getFD(), bitmapDisplayConfig.getBitmapMaxSize(), bitmapDisplayConfig.getBitmapConfig());
        }
        if (bitmapMeta.data == null) {
            return null;
        }
        if (bitmapDisplayConfig == null || bitmapDisplayConfig.isShowOriginal()) {
            return BitmapDecoder.decodeByteArray(bitmapMeta.data);
        }
        return BitmapDecoder.decodeSampledBitmapFromByteArray(bitmapMeta.data, bitmapDisplayConfig.getBitmapMaxSize(), bitmapDisplayConfig.getBitmapConfig());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized android.graphics.Bitmap rotateBitmapIfNeeded(java.lang.String r9, com.lidroid.xutils.bitmap.BitmapDisplayConfig r10, android.graphics.Bitmap r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r10 == 0) goto L5c
            boolean r10 = r10.isAutoRotation()     // Catch: java.lang.Throwable -> L59
            if (r10 == 0) goto L5c
            java.io.File r9 = r8.getBitmapFileFromDiskCache(r9)     // Catch: java.lang.Throwable -> L59
            if (r9 == 0) goto L5c
            boolean r10 = r9.exists()     // Catch: java.lang.Throwable -> L59
            if (r10 == 0) goto L5c
            android.media.ExifInterface r10 = new android.media.ExifInterface     // Catch: java.lang.Throwable -> L57 java.lang.Throwable -> L59
            java.lang.String r9 = r9.getPath()     // Catch: java.lang.Throwable -> L57 java.lang.Throwable -> L59
            r10.<init>(r9)     // Catch: java.lang.Throwable -> L57 java.lang.Throwable -> L59
            java.lang.String r9 = "Orientation"
            r0 = 0
            int r9 = r10.getAttributeInt(r9, r0)     // Catch: java.lang.Throwable -> L59
            r10 = 3
            if (r9 == r10) goto L36
            r10 = 6
            if (r9 == r10) goto L33
            r10 = 8
            if (r9 == r10) goto L30
            goto L38
        L30:
            r0 = 270(0x10e, float:3.78E-43)
            goto L38
        L33:
            r0 = 90
            goto L38
        L36:
            r0 = 180(0xb4, float:2.52E-43)
        L38:
            if (r0 == 0) goto L5c
            android.graphics.Matrix r6 = new android.graphics.Matrix     // Catch: java.lang.Throwable -> L59
            r6.<init>()     // Catch: java.lang.Throwable -> L59
            float r9 = (float) r0     // Catch: java.lang.Throwable -> L59
            r6.postRotate(r9)     // Catch: java.lang.Throwable -> L59
            r2 = 0
            r3 = 0
            int r4 = r11.getWidth()     // Catch: java.lang.Throwable -> L59
            int r5 = r11.getHeight()     // Catch: java.lang.Throwable -> L59
            r7 = 1
            r1 = r11
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L59
            r11.recycle()     // Catch: java.lang.Throwable -> L59
            goto L5d
        L57:
            monitor-exit(r8)
            return r11
        L59:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        L5c:
            r9 = r11
        L5d:
            monitor-exit(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.bitmap.core.BitmapCache.rotateBitmapIfNeeded(java.lang.String, com.lidroid.xutils.bitmap.BitmapDisplayConfig, android.graphics.Bitmap):android.graphics.Bitmap");
    }

    public class MemoryCacheKey {
        private String subKey;
        private String uri;

        private MemoryCacheKey(String str, BitmapDisplayConfig bitmapDisplayConfig) {
            this.uri = str;
            this.subKey = bitmapDisplayConfig == null ? null : bitmapDisplayConfig.toString();
        }

        /* synthetic */ MemoryCacheKey(BitmapCache bitmapCache, String str, BitmapDisplayConfig bitmapDisplayConfig, MemoryCacheKey memoryCacheKey) {
            this(str, bitmapDisplayConfig);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MemoryCacheKey)) {
                return false;
            }
            MemoryCacheKey memoryCacheKey = (MemoryCacheKey) obj;
            if (!this.uri.equals(memoryCacheKey.uri)) {
                return false;
            }
            if (this.subKey == null || memoryCacheKey.subKey == null) {
                return true;
            }
            return this.subKey.equals(memoryCacheKey.subKey);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }
    }
}
