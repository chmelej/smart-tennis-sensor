package p000;

import java.io.PrintWriter;

/* JADX INFO: renamed from: yc */
/* JADX INFO: compiled from: StatsSnapshot.java */
/* JADX INFO: loaded from: classes.dex */
public class C2262yc {

    /* JADX INFO: renamed from: a */
    public final int f13675a;

    /* JADX INFO: renamed from: b */
    public final int f13676b;

    /* JADX INFO: renamed from: c */
    public final long f13677c;

    /* JADX INFO: renamed from: d */
    public final long f13678d;

    /* JADX INFO: renamed from: e */
    public final long f13679e;

    /* JADX INFO: renamed from: f */
    public final long f13680f;

    /* JADX INFO: renamed from: g */
    public final long f13681g;

    /* JADX INFO: renamed from: h */
    public final long f13682h;

    /* JADX INFO: renamed from: i */
    public final long f13683i;

    /* JADX INFO: renamed from: j */
    public final long f13684j;

    /* JADX INFO: renamed from: k */
    public final int f13685k;

    /* JADX INFO: renamed from: l */
    public final int f13686l;

    /* JADX INFO: renamed from: m */
    public final int f13687m;

    /* JADX INFO: renamed from: n */
    public final long f13688n;

    public C2262yc(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f13675a = i;
        this.f13676b = i2;
        this.f13677c = j;
        this.f13678d = j2;
        this.f13679e = j3;
        this.f13680f = j4;
        this.f13681g = j5;
        this.f13682h = j6;
        this.f13683i = j7;
        this.f13684j = j8;
        this.f13685k = i3;
        this.f13686l = i4;
        this.f13687m = i5;
        this.f13688n = j9;
    }

    /* JADX INFO: renamed from: a */
    public void m12374a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f13675a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f13676b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f13676b / this.f13675a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f13677c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f13678d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f13685k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f13679e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f13682h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f13686l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f13680f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f13687m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f13681g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f13683i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f13684j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f13675a + ", size=" + this.f13676b + ", cacheHits=" + this.f13677c + ", cacheMisses=" + this.f13678d + ", downloadCount=" + this.f13685k + ", totalDownloadSize=" + this.f13679e + ", averageDownloadSize=" + this.f13682h + ", totalOriginalBitmapSize=" + this.f13680f + ", totalTransformedBitmapSize=" + this.f13681g + ", averageOriginalBitmapSize=" + this.f13683i + ", averageTransformedBitmapSize=" + this.f13684j + ", originalBitmapCount=" + this.f13686l + ", transformedBitmapCount=" + this.f13687m + ", timeStamp=" + this.f13688n + '}';
    }
}
