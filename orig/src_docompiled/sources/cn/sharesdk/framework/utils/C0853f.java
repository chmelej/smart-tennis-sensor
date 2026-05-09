package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: renamed from: cn.sharesdk.framework.utils.f */
/* JADX INFO: compiled from: XmlParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C0853f {
    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6202a(String str) throws SAXException {
        a aVar = new a();
        Xml.parse(str, aVar);
        return aVar.m6203a();
    }

    /* JADX INFO: renamed from: cn.sharesdk.framework.utils.f$a */
    /* JADX INFO: compiled from: XmlParser.java */
    static class a extends DefaultHandler {

        /* JADX INFO: renamed from: a */
        private HashMap<String, Object> f5718a = new HashMap<>();

        /* JADX INFO: renamed from: b */
        private HashMap<String, Object> f5719b;

        /* JADX INFO: renamed from: a */
        public HashMap<String, Object> m6203a() {
            return this.f5718a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (this.f5719b != null) {
                HashMap<String, Object> map = new HashMap<>();
                this.f5719b.put(str2, map);
                this.f5719b = map;
            } else {
                this.f5719b = new HashMap<>();
                this.f5718a.put(str2, this.f5719b);
            }
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                this.f5719b.put(attributes.getLocalName(i), attributes.getValue(i));
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this.f5719b = null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            String strTrim = String.valueOf(cArr, i, i2).trim();
            if (TextUtils.isEmpty(strTrim) || this.f5719b == null) {
                return;
            }
            this.f5719b.put("value", strTrim);
        }
    }
}
