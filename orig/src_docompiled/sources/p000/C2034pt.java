package p000;

/* JADX INFO: renamed from: pt */
/* JADX INFO: compiled from: OpenCameraException.java */
/* JADX INFO: loaded from: classes.dex */
public class C2034pt extends Exception {

    /* JADX INFO: renamed from: a */
    private final a f12212a;

    /* JADX INFO: renamed from: pt$a */
    /* JADX INFO: compiled from: OpenCameraException.java */
    public enum a {
        INUSE("Camera disabled or in use by other process"),
        NOCAMERA("Device does not have camera");


        /* JADX INFO: renamed from: c */
        private String f12216c;

        a(String str) {
            this.f12216c = str;
        }

        /* JADX INFO: renamed from: a */
        public String m11127a() {
            return this.f12216c;
        }
    }

    public C2034pt(a aVar) {
        super(aVar.m11127a());
        this.f12212a = aVar;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        C2031pq.m11103b("VideoCapture_Exception", "Unable to open camera - " + this.f12212a.m11127a());
        super.printStackTrace();
    }
}
