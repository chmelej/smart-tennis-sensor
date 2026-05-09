package p000;

import android.annotation.TargetApi;

/* JADX INFO: renamed from: wj */
/* JADX INFO: compiled from: ExternalTextureNormalizer.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(18)
public class C2215wj extends C2219wn {
    @Override // p000.C2218wm
    /* JADX INFO: renamed from: g */
    protected int mo12126g() {
        return 36197;
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: a */
    protected String[] mo11987a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n"};
    }
}
