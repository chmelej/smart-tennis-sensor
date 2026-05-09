package p000;

import android.content.Context;
import android.opengl.GLES20;

/* JADX INFO: renamed from: vl */
/* JADX INFO: compiled from: FilterProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public class C2190vl extends C2219wn {

    /* JADX INFO: renamed from: j */
    private Context f13144j;

    /* JADX INFO: renamed from: k */
    private String f13145k;

    /* JADX INFO: renamed from: l */
    private int f13146l;

    /* JADX INFO: renamed from: m */
    private int f13147m;

    /* JADX INFO: renamed from: n */
    private boolean f13148n;

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: a */
    protected String[] mo11987a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "varying highp vec2 v_tex_coord;\n \n uniform sampler2D u_tex;\n uniform sampler2D u_filter;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(u_tex, v_tex_coord);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1 = texture2D(u_filter, texPos1);\n     lowp vec4 newColor2 = texture2D(u_filter, texPos2);\n     \n     lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = vec4(newColor.rgb, textureColor.w);\n }"};
    }

    @Override // p000.C2219wn, p000.C2218wm
    /* JADX INFO: renamed from: b */
    public boolean mo11988b() {
        this.f13147m = C2191vm.m11993a(this.f13144j, this.f13145k, this.f13148n);
        return super.mo11988b();
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: c */
    protected boolean mo11989c() {
        this.f13146l = GLES20.glGetUniformLocation(this.f13338f, "u_filter");
        return super.mo11989c();
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: d */
    protected void mo11990d() {
        super.mo11990d();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f13147m);
        GLES20.glUniform1i(this.f13146l, 1);
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: e */
    protected void mo11991e() {
        super.mo11991e();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // p000.C2219wn, p000.C2218wm
    /* JADX INFO: renamed from: f */
    public void mo11992f() {
        super.mo11992f();
        GLES20.glDeleteTextures(1, new int[]{this.f13147m}, 0);
    }
}
