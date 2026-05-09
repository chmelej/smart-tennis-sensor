package com.vincent.videocompressor;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p000.ajt;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class VideoController {

    /* JADX INFO: renamed from: a */
    public static File f9302a;

    /* JADX INFO: renamed from: c */
    private static volatile VideoController f9303c;

    /* JADX INFO: renamed from: b */
    public String f9304b;

    /* JADX INFO: renamed from: d */
    private boolean f9305d = true;

    /* JADX INFO: renamed from: com.vincent.videocompressor.VideoController$a */
    public interface InterfaceC1637a {
        /* JADX INFO: renamed from: a */
        void mo1693a(float f);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8799a(int i) {
        if (i == 39 || i == 2130706688) {
            return true;
        }
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);

    /* JADX INFO: renamed from: a */
    public static VideoController m8797a() {
        VideoController videoController = f9303c;
        if (videoController == null) {
            synchronized (VideoController.class) {
                videoController = f9303c;
                if (videoController == null) {
                    videoController = new VideoController();
                    f9303c = videoController;
                }
            }
        }
        return videoController;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public static int m8793a(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i = 0;
        for (int i2 = 0; i2 < capabilitiesForType.colorFormats.length; i2++) {
            int i3 = capabilitiesForType.colorFormats[i2];
            if (m8799a(i3)) {
                if (!mediaCodecInfo.getName().equals("OMX.SEC.AVC.Encoder") || i3 != 19) {
                    return i3;
                }
                i = i3;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private void m8798a(boolean z, boolean z2) {
        if (this.f9305d) {
            this.f9305d = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static MediaCodecInfo m8796a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                MediaCodecInfo mediaCodecInfo2 = mediaCodecInfo;
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        if (!codecInfoAt.getName().equals("OMX.SEC.avc.enc") || codecInfoAt.getName().equals("OMX.SEC.AVC.Encoder")) {
                            return codecInfoAt;
                        }
                        mediaCodecInfo2 = codecInfoAt;
                    }
                }
                mediaCodecInfo = mediaCodecInfo2;
            }
        }
        return mediaCodecInfo;
    }

    @TargetApi(16)
    /* JADX INFO: renamed from: a */
    private long m8795a(MediaExtractor mediaExtractor, ajt ajtVar, MediaCodec.BufferInfo bufferInfo, long j, long j2, File file, boolean z) throws IOException {
        ByteBuffer byteBuffer;
        long j3;
        boolean z2;
        long j4 = j;
        int iM8794a = m8794a(mediaExtractor, z);
        if (iM8794a < 0) {
            return -1L;
        }
        mediaExtractor.selectTrack(iM8794a);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM8794a);
        int iM1621a = ajtVar.m1621a(trackFormat, z);
        int integer = trackFormat.getInteger("max-input-size");
        int i = 0;
        if (j4 > 0) {
            mediaExtractor.seekTo(j4, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(integer);
        boolean z3 = false;
        long j5 = -1;
        while (!z3) {
            int sampleTrackIndex = mediaExtractor.getSampleTrackIndex();
            if (sampleTrackIndex == iM8794a) {
                bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, i);
                if (bufferInfo.size < 0) {
                    bufferInfo.size = i;
                    byteBuffer = byteBufferAllocateDirect;
                    z2 = true;
                    j3 = 0;
                } else {
                    ByteBuffer byteBuffer2 = byteBufferAllocateDirect;
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    long j6 = (j4 <= 0 || j5 != -1) ? j5 : bufferInfo.presentationTimeUs;
                    j3 = 0;
                    if (j2 < 0 || bufferInfo.presentationTimeUs < j2) {
                        bufferInfo.offset = 0;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        byteBuffer = byteBuffer2;
                        ajtVar.m1628a(iM1621a, byteBuffer, bufferInfo, z);
                        mediaExtractor.advance();
                        j5 = j6;
                    } else {
                        j5 = j6;
                        byteBuffer = byteBuffer2;
                    }
                }
            } else {
                byteBuffer = byteBufferAllocateDirect;
                j3 = 0;
                z2 = sampleTrackIndex == -1;
            }
            if (z2) {
                z3 = true;
            }
            byteBufferAllocateDirect = byteBuffer;
            j4 = j;
            i = 0;
        }
        mediaExtractor.unselectTrack(iM8794a);
        return j5;
    }

    @TargetApi(16)
    /* JADX INFO: renamed from: a */
    private int m8794a(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(7:579|33|564|34|570|35|36)|(1:(1:39)(12:40|566|41|42|(1:44)|45|(3:442|581|443)(1:449)|(1:451)|(2:532|453)|457|487|488))(1:52)|573|53|(14:530|55|56|(3:527|58|(2:60|61)(4:62|(2:64|(2:72|73)(2:70|71))(3:74|(1:76)(2:77|(1:79)(2:80|(2:82|71)(2:83|(1:85)(1:86))))|73)|87|88))(1:97)|98|99|509|100|519|(2:102|(31:104|123|124|(1:126)|127|128|505|129|130|(4:534|132|507|133)(1:139)|521|140|550|141|142|(2:536|144)(2:560|148)|538|149|150|(13:503|152|(12:154|155|161|(4:163|(5:513|165|(4:167|548|168|(5:170|(1:172)(1:174)|173|175|(1:177)(1:178)))(3:181|(1:183)|(2:188|189))|184|(3:186|188|189))(1:193)|194|(2:(7:199|546|200|201|(1:203)(2:204|(5:554|206|(1:208)|209|210)(2:213|(6:540|215|216|(3:218|572|219)(1:220)|221|210)(2:225|(3:587|227|228)(5:583|233|234|(1:236)(1:238)|(3:588|240|241)(3:242|243|(10:568|245|246|(3:248|249|(1:251))(7:253|(7:255|(3:259|(1:597)(2:265|(7:594|267|268|269|272|(1:275)|276)(1:598))|270)|593|271|272|(1:275)|276)|283|(1:285)(1:287)|286|288|210)|282|283|(0)(0)|286|288|210)(6:282|283|(0)(0)|286|288|210))))))|(2:290|590)(6:511|292|(1:294)(2:296|(2:299|(6:525|301|382|383|384|591)(1:(3:585|307|308)(5:309|310|(1:314)(1:315)|322|(9:528|324|325|(3:329|330|(12:332|515|333|334|517|335|336|(5:558|338|339|562|340)(1:346)|347|552|348|349)(3:357|358|(1:360)(1:361)))(1:362)|363|(3:523|365|(1:367)(2:368|(1:370)))|383|384|591)(0))))(4:382|383|384|591))|295|384|591)|291)|48))|586|392|575|417|(1:419)|(1:421)|(1:423)|(1:425))(1:156)|96|577|415|416|575|417|(0)|(0)|(0)|(0))(1:159)|160|161|(0)|586|392|575|417|(0)|(0)|(0)|(0))(32:105|122|123|124|(0)|127|128|505|129|130|(0)(0)|521|140|550|141|142|(0)(0)|538|149|150|(0)(0)|160|161|(0)|586|392|575|417|(0)|(0)|(0)|(0)))(2:108|(32:110|(1:112)(1:122)|123|124|(0)|127|128|505|129|130|(0)(0)|521|140|550|141|142|(0)(0)|538|149|150|(0)(0)|160|161|(0)|586|392|575|417|(0)|(0)|(0)|(0))(32:113|(2:120|121)(0)|123|124|(0)|127|128|505|129|130|(0)(0)|521|140|550|141|142|(0)(0)|538|149|150|(0)(0)|160|161|(0)|586|392|575|417|(0)|(0)|(0)|(0)))|(1:493)|(2:544|495)|499|500)(1:439)|440|(0)(0)|(0)|(0)|457|487|488) */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x040a, code lost:
    
        r36 = r4;
        r4 = r46;
        r1 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
    
        if (r1 == 270) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x0841, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x0842, code lost:
    
        r12 = r33;
        r14 = false;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x0849, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x084a, code lost:
    
        r13 = r7;
        r42 = r14;
        r40 = r15;
        r12 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0862, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029a A[PHI: r15
      0x029a: PHI (r15v6 int) = (r15v5 int), (r15v5 int), (r15v5 int), (r15v5 int), (r15v32 int) binds: [B:117:0x0280, B:119:0x0288, B:115:0x027e, B:111:0x0272, B:105:0x025a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ce A[Catch: all -> 0x0206, Exception -> 0x025c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x025c, blocks: (B:102:0x0245, B:104:0x0249, B:126:0x02ce, B:110:0x0268, B:112:0x0274, B:118:0x0282, B:120:0x028a), top: B:519:0x0243 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x07ad A[Catch: all -> 0x07c6, Exception -> 0x07c8, TryCatch #52 {Exception -> 0x07c8, all -> 0x07c6, blocks: (B:417:0x07a8, B:419:0x07ad, B:421:0x07b2, B:423:0x07b7, B:425:0x07bf), top: B:575:0x07a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x07b2 A[Catch: all -> 0x07c6, Exception -> 0x07c8, TryCatch #52 {Exception -> 0x07c8, all -> 0x07c6, blocks: (B:417:0x07a8, B:419:0x07ad, B:421:0x07b2, B:423:0x07b7, B:425:0x07bf), top: B:575:0x07a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x07b7 A[Catch: all -> 0x07c6, Exception -> 0x07c8, TryCatch #52 {Exception -> 0x07c8, all -> 0x07c6, blocks: (B:417:0x07a8, B:419:0x07ad, B:421:0x07b2, B:423:0x07b7, B:425:0x07bf), top: B:575:0x07a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x07bf A[Catch: all -> 0x07c6, Exception -> 0x07c8, TRY_LEAVE, TryCatch #52 {Exception -> 0x07c8, all -> 0x07c6, blocks: (B:417:0x07a8, B:419:0x07ad, B:421:0x07b2, B:423:0x07b7, B:425:0x07bf), top: B:575:0x07a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0806  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x091f  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0353 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0813 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x02ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:536:0x0326 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0896 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0924 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.TargetApi(16)
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m8800a(java.lang.String r60, java.lang.String r61, int r62, com.vincent.videocompressor.VideoController.InterfaceC1637a r63) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vincent.videocompressor.VideoController.m8800a(java.lang.String, java.lang.String, int, com.vincent.videocompressor.VideoController$a):boolean");
    }
}
