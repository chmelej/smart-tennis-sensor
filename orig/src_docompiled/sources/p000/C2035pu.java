package p000;

/* JADX INFO: renamed from: pu */
/* JADX INFO: compiled from: PrepareCameraException.java */
/* JADX INFO: loaded from: classes.dex */
public class C2035pu extends Exception {
    @Override // java.lang.Throwable
    public String getMessage() {
        C2031pq.m11103b("VideoCapture_Exception", "Unable to unlock camera - Unable to use camera for recording");
        return "Unable to use camera for recording";
    }
}
