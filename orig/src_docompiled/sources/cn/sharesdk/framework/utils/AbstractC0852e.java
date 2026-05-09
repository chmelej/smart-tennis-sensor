package cn.sharesdk.framework.utils;

import java.io.IOException;

/* JADX INFO: renamed from: cn.sharesdk.framework.utils.e */
/* JADX INFO: compiled from: UnicodeEscaper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0852e implements Escaper {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<char[]> f5713a = new ThreadLocal<char[]>() { // from class: cn.sharesdk.framework.utils.e.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    };

    /* JADX INFO: renamed from: a */
    protected abstract char[] mo6193a(int i);

    /* JADX INFO: renamed from: a */
    protected int mo6192a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int iM6198b = m6198b(charSequence, i, i2);
            if (iM6198b < 0 || mo6193a(iM6198b) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(iM6198b) ? 2 : 1;
        }
        return i;
    }

    @Override // cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        int iMo6192a = mo6192a(str, 0, length);
        return iMo6192a == length ? str : m6199a(str, iMo6192a);
    }

    /* JADX INFO: renamed from: a */
    protected final String m6199a(String str, int i) {
        int i2;
        int length = str.length();
        char[] cArrM6197a = f5713a.get();
        int i3 = 0;
        int length2 = 0;
        while (i < length) {
            int iM6198b = m6198b(str, i, length);
            if (iM6198b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrMo6193a = mo6193a(iM6198b);
            if (cArrMo6193a != null) {
                int i4 = i - i3;
                int i5 = length2 + i4;
                int length3 = cArrMo6193a.length + i5;
                if (cArrM6197a.length < length3) {
                    cArrM6197a = m6197a(cArrM6197a, length2, length3 + (length - i) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i3, i, cArrM6197a, length2);
                    length2 = i5;
                }
                if (cArrMo6193a.length > 0) {
                    System.arraycopy(cArrMo6193a, 0, cArrM6197a, length2, cArrMo6193a.length);
                    length2 += cArrMo6193a.length;
                }
            }
            i3 = (Character.isSupplementaryCodePoint(iM6198b) ? 2 : 1) + i;
            i = mo6192a(str, i3, length);
        }
        int i6 = length - i3;
        if (i6 > 0) {
            i2 = i6 + length2;
            if (cArrM6197a.length < i2) {
                cArrM6197a = m6197a(cArrM6197a, length2, i2);
            }
            str.getChars(i3, length, cArrM6197a, length2);
        } else {
            i2 = length2;
        }
        return new String(cArrM6197a, 0, i2);
    }

    @Override // cn.sharesdk.framework.utils.Escaper
    public Appendable escape(final Appendable appendable) {
        C0850c.m6194a(appendable);
        return new Appendable() { // from class: cn.sharesdk.framework.utils.e.1

            /* JADX INFO: renamed from: a */
            int f5714a = -1;

            /* JADX INFO: renamed from: b */
            char[] f5715b = new char[2];

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) {
                return append(charSequence, 0, charSequence.length());
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
                int i3;
                if (i < i2) {
                    if (this.f5714a != -1) {
                        int i4 = i + 1;
                        char cCharAt = charSequence.charAt(i);
                        if (!Character.isLowSurrogate(cCharAt)) {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + cCharAt);
                        }
                        char[] cArrMo6193a = AbstractC0852e.this.mo6193a(Character.toCodePoint((char) this.f5714a, cCharAt));
                        if (cArrMo6193a != null) {
                            m6200a(cArrMo6193a, cArrMo6193a.length);
                            i = i4;
                        } else {
                            appendable.append((char) this.f5714a);
                        }
                        this.f5714a = -1;
                        i3 = i;
                        i = i4;
                    } else {
                        i3 = i;
                    }
                    while (true) {
                        int iMo6192a = AbstractC0852e.this.mo6192a(charSequence, i, i2);
                        if (iMo6192a > i3) {
                            appendable.append(charSequence, i3, iMo6192a);
                        }
                        if (iMo6192a == i2) {
                            break;
                        }
                        int iM6198b = AbstractC0852e.m6198b(charSequence, iMo6192a, i2);
                        if (iM6198b < 0) {
                            this.f5714a = -iM6198b;
                            break;
                        }
                        char[] cArrMo6193a2 = AbstractC0852e.this.mo6193a(iM6198b);
                        if (cArrMo6193a2 != null) {
                            m6200a(cArrMo6193a2, cArrMo6193a2.length);
                        } else {
                            m6200a(this.f5715b, Character.toChars(iM6198b, this.f5715b, 0));
                        }
                        i3 = (Character.isSupplementaryCodePoint(iM6198b) ? 2 : 1) + iMo6192a;
                        i = i3;
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) throws IOException {
                if (this.f5714a != -1) {
                    if (!Character.isLowSurrogate(c)) {
                        throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + ((int) c));
                    }
                    char[] cArrMo6193a = AbstractC0852e.this.mo6193a(Character.toCodePoint((char) this.f5714a, c));
                    if (cArrMo6193a != null) {
                        m6200a(cArrMo6193a, cArrMo6193a.length);
                    } else {
                        appendable.append((char) this.f5714a);
                        appendable.append(c);
                    }
                    this.f5714a = -1;
                } else if (Character.isHighSurrogate(c)) {
                    this.f5714a = c;
                } else {
                    if (Character.isLowSurrogate(c)) {
                        throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + ((int) c));
                    }
                    char[] cArrMo6193a2 = AbstractC0852e.this.mo6193a(c);
                    if (cArrMo6193a2 != null) {
                        m6200a(cArrMo6193a2, cArrMo6193a2.length);
                    } else {
                        appendable.append(c);
                    }
                }
                return this;
            }

            /* JADX INFO: renamed from: a */
            private void m6200a(char[] cArr, int i) throws IOException {
                for (int i2 = 0; i2 < i; i2++) {
                    appendable.append(cArr[i2]);
                }
            }
        };
    }

    /* JADX INFO: renamed from: b */
    protected static final int m6198b(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 55296 || cCharAt > 57343) {
                return cCharAt;
            }
            if (cCharAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(cCharAt);
                sb.append("' with value ");
                sb.append((int) cCharAt);
                sb.append(" at index ");
                sb.append(i3 - 1);
                throw new IllegalArgumentException(sb.toString());
            }
            if (i3 == i2) {
                return -cCharAt;
            }
            char cCharAt2 = charSequence.charAt(i3);
            if (Character.isLowSurrogate(cCharAt2)) {
                return Character.toCodePoint(cCharAt, cCharAt2);
            }
            throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i3);
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    /* JADX INFO: renamed from: a */
    private static final char[] m6197a(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
