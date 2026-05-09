package p000;

/* JADX INFO: renamed from: yv */
/* JADX INFO: compiled from: UTUtdidHelper2.java */
/* JADX INFO: loaded from: classes.dex */
public class C2281yv {

    /* JADX INFO: renamed from: a */
    private String f13768a;

    public C2281yv() {
        this.f13768a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f13768a = C2267yh.m12417b(this.f13768a.getBytes(), 0);
    }

    /* JADX INFO: renamed from: a */
    public String m12515a(String str) {
        return C2266yg.m12411b(this.f13768a, str);
    }

    /* JADX INFO: renamed from: b */
    public String m12516b(String str) {
        String strM12411b = C2266yg.m12411b(this.f13768a, str);
        if (C2270yk.m12426a(strM12411b)) {
            return null;
        }
        try {
            return new String(C2267yh.m12414a(strM12411b, 0));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
