package p000;

import android.os.AsyncTask;
import com.vincent.videocompressor.VideoController;

/* JADX INFO: compiled from: VideoCompress.java */
/* JADX INFO: loaded from: classes.dex */
public class ajz {

    /* JADX INFO: renamed from: a */
    private static final String f1417a = "ajz";

    /* JADX INFO: renamed from: ajz$a */
    /* JADX INFO: compiled from: VideoCompress.java */
    public interface InterfaceC0173a {
        /* JADX INFO: renamed from: a */
        void mo1685a();

        /* JADX INFO: renamed from: a */
        void mo1686a(float f);

        /* JADX INFO: renamed from: b */
        void mo1687b();

        /* JADX INFO: renamed from: c */
        void mo1688c();
    }

    /* JADX INFO: renamed from: a */
    public static AsyncTaskC0174b m1684a(String str, String str2, InterfaceC0173a interfaceC0173a) {
        AsyncTaskC0174b asyncTaskC0174b = new AsyncTaskC0174b(interfaceC0173a, 3);
        asyncTaskC0174b.execute(str, str2);
        return asyncTaskC0174b;
    }

    /* JADX INFO: renamed from: ajz$b */
    /* JADX INFO: compiled from: VideoCompress.java */
    public static class AsyncTaskC0174b extends AsyncTask<String, Float, Boolean> {

        /* JADX INFO: renamed from: a */
        private InterfaceC0173a f1418a;

        /* JADX INFO: renamed from: b */
        private int f1419b;

        public AsyncTaskC0174b(InterfaceC0173a interfaceC0173a, int i) {
            this.f1418a = interfaceC0173a;
            this.f1419b = i;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            if (this.f1418a != null) {
                this.f1418a.mo1685a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(VideoController.m8797a().m8800a(strArr[0], strArr[1], this.f1419b, new VideoController.InterfaceC1637a() { // from class: ajz.b.1
                @Override // com.vincent.videocompressor.VideoController.InterfaceC1637a
                /* JADX INFO: renamed from: a */
                public void mo1693a(float f) {
                    AsyncTaskC0174b.this.publishProgress(Float.valueOf(f));
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Float... fArr) {
            super.onProgressUpdate(fArr);
            if (this.f1418a != null) {
                this.f1418a.mo1686a(fArr[0].floatValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.f1418a != null) {
                if (bool.booleanValue()) {
                    this.f1418a.mo1687b();
                } else {
                    this.f1418a.mo1688c();
                }
            }
        }
    }
}
