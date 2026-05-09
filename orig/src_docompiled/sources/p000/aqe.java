package p000;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

/* JADX INFO: compiled from: AsyncHttpResponseHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class aqe {

    /* JADX INFO: renamed from: a */
    private volatile Handler f4629a;

    public void onFailure(Throwable th) {
    }

    public final void onFinish() {
    }

    public final void onStart() {
    }

    public void onSuccess(String str) {
    }

    public aqe() {
        this.f4629a = null;
        this.f4629a = new Handler() { // from class: aqe.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                aqe.this.m5000a(message);
            }
        };
    }

    public void onFailure(Throwable th, Map<String, String> map, String str) {
        onFailure(th, str);
    }

    public void onFailure(Throwable th, String str) {
        onFailure(th);
    }

    public void onSuccess(Map<String, String> map, String str) {
        onSuccess(str);
    }

    /* JADX INFO: renamed from: a */
    final void m5001a(C0719a c0719a) {
        m5006b(m4998a(0, c0719a));
    }

    /* JADX INFO: renamed from: a */
    final void m5002a(Throwable th) {
        m5006b(m4998a(1, th));
    }

    /* JADX INFO: renamed from: a */
    final void m4999a() {
        m5006b(m4998a(2, (Object) null));
    }

    /* JADX INFO: renamed from: b */
    final void m5005b() {
        m5006b(m4998a(3, (Object) null));
    }

    /* JADX INFO: renamed from: b */
    protected void m5007b(Throwable th) {
        onFailure(th, null, null);
    }

    /* JADX INFO: renamed from: a */
    protected void mo5003a(Map<String, String> map, String str) {
        onSuccess(map, str);
    }

    /* JADX INFO: renamed from: a */
    private void m4997a(Object obj) {
        try {
            if (obj instanceof C0719a) {
                C0719a c0719a = (C0719a) obj;
                int i = c0719a.f4631a;
                Map<String, String> map = c0719a.f4633c;
                String str = c0719a.f4634d;
                aiv.m1415b("AsyncHttpResponseHandler", "onHandleMessage[" + str + "]");
                if (i == 200) {
                    mo5003a(map, str);
                } else {
                    onFailure(new HttpResponseException(i, c0719a.f4632b), map, str);
                }
            } else {
                aiv.m1413a("AsyncHttpResponseHandler", "onHandleMessage", new RuntimeException("!result instanceof IResponse"));
                onFailure(new RuntimeException("!result instanceof IResponse"), null, null);
            }
        } catch (Throwable th) {
            aiv.m1413a("AsyncHttpResponseHandler", "onHandleMessage", th);
            onFailure(th, null, null);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m5000a(Message message) {
        try {
            switch (message.what) {
                case 0:
                    m4997a(message.obj);
                    break;
                case 1:
                    m5007b((Throwable) message.obj);
                    break;
                case 2:
                    onStart();
                    break;
                case 3:
                    onFinish();
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    final void m5006b(Message message) {
        try {
            if (this.f4629a != null && !Thread.currentThread().isInterrupted()) {
                this.f4629a.sendMessage(message);
            } else {
                m5000a(message);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    Message m4998a(int i, Object obj) {
        Message messageObtainMessage;
        try {
            if (this.f4629a != null) {
                messageObtainMessage = this.f4629a.obtainMessage(i, obj);
            } else {
                Message message = new Message();
                try {
                    message.what = i;
                    message.obj = obj;
                } catch (Throwable unused) {
                }
                messageObtainMessage = message;
            }
            return messageObtainMessage;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m5004a(HttpResponse httpResponse) {
        try {
            StatusLine statusLine = httpResponse.getStatusLine();
            C0719a c0719a = new C0719a();
            c0719a.f4632b = statusLine.getReasonPhrase();
            c0719a.f4633c = m4996a(httpResponse.getAllHeaders());
            c0719a.f4631a = statusLine.getStatusCode();
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                c0719a.f4634d = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            }
            m5001a(c0719a);
        } catch (Throwable th) {
            m5002a(th);
        }
    }

    /* JADX INFO: renamed from: a */
    private final Map<String, String> m4996a(Header[] headerArr) {
        HashMap map = new HashMap();
        for (Header header : headerArr) {
            String name = header.getName();
            if (!TextUtils.isEmpty(name)) {
                String value = header.getValue();
                if (!TextUtils.isEmpty(value)) {
                    map.put(name.toLowerCase(), value);
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: aqe$a */
    /* JADX INFO: compiled from: AsyncHttpResponseHandler.java */
    class C0719a {

        /* JADX INFO: renamed from: a */
        int f4631a;

        /* JADX INFO: renamed from: b */
        String f4632b;

        /* JADX INFO: renamed from: c */
        Map<String, String> f4633c;

        /* JADX INFO: renamed from: d */
        String f4634d;

        private C0719a() {
            this.f4631a = -1;
            this.f4632b = "";
            this.f4633c = new HashMap();
            this.f4634d = "";
        }
    }
}
