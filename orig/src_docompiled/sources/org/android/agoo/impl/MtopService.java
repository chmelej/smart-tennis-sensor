package org.android.agoo.impl;

import android.content.Context;
import p000.aie;
import p000.apq;
import p000.apu;
import p000.apx;
import p000.apz;
import p000.aqa;
import p000.aqb;
import p000.ara;
import p000.arb;
import p000.ard;
import p000.arf;
import p000.arg;

/* JADX INFO: loaded from: classes.dex */
public final class MtopService implements apq {
    @Override // p000.apq
    public final void sendMtop(Context context, apz apzVar, final aqa aqaVar) {
        if (context == null || apzVar == null || aqaVar == null) {
            return;
        }
        try {
            arb arbVar = new arb();
            arbVar.m5232c(apzVar.m4969b());
            arbVar.m5234d(apzVar.m4971c());
            arbVar.m5224a(apx.getRegistrationId(context));
            if (!aie.m1309a(apzVar.m4972d())) {
                arbVar.m5236e(apzVar.m4972d());
            }
            arbVar.m5230b(apzVar.m4973e());
            arbVar.m5226a(apzVar.m4966a());
            ara araVar = new ara();
            araVar.mo5182a(apu.m4936f(context));
            araVar.mo5183b(apu.m4940j(context));
            araVar.mo5184c(apu.m4920F(context));
            araVar.mo5181a(context, arbVar, new ard() { // from class: org.android.agoo.impl.MtopService.1
                @Override // p000.aqe
                public final void onSuccess(String str) {
                    aqaVar.m4980a(str);
                }

                @Override // p000.ard
                public final void onFailure(String str, String str2) {
                    aqaVar.m4981a(str, str2);
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // p000.apq
    public final void sendMtop(Context context, apz apzVar) {
        if (context == null || apzVar == null) {
            return;
        }
        try {
            arb arbVar = new arb();
            arbVar.m5232c(apzVar.m4969b());
            arbVar.m5234d(apzVar.m4971c());
            arbVar.m5224a(apx.getRegistrationId(context));
            if (!aie.m1309a(apzVar.m4972d())) {
                arbVar.m5236e(apzVar.m4972d());
            }
            arbVar.m5230b(apzVar.m4973e());
            arbVar.m5226a(apzVar.m4966a());
            ara araVar = new ara();
            araVar.mo5182a(apu.m4936f(context));
            araVar.mo5183b(apu.m4940j(context));
            araVar.mo5184c(apu.m4920F(context));
            araVar.mo5181a(context, arbVar, new ard() { // from class: org.android.agoo.impl.MtopService.2
                @Override // p000.ard
                public final void onFailure(String str, String str2) {
                }

                @Override // p000.aqe
                public final void onSuccess(String str) {
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // p000.apq
    public final aqb getV3(Context context, apz apzVar) {
        if (context != null && apzVar != null) {
            try {
                arb arbVar = new arb();
                arbVar.m5232c(apzVar.m4969b());
                arbVar.m5234d(apzVar.m4971c());
                arbVar.m5224a(apx.getRegistrationId(context));
                if (!aie.m1309a(apzVar.m4972d())) {
                    arbVar.m5236e(apzVar.m4972d());
                }
                arbVar.m5238f(apu.m4936f(context));
                arbVar.m5240g(apu.m4940j(context));
                arbVar.m5230b(apzVar.m4973e());
                arbVar.m5226a(apzVar.m4966a());
                arf arfVar = new arf();
                arfVar.mo5189c(apu.m4920F(context));
                arg argVarMo5185a = arfVar.mo5185a(context, arbVar);
                if (argVarMo5185a != null) {
                    aqb aqbVar = new aqb();
                    aqbVar.m4983a(argVarMo5185a.m5259b());
                    aqbVar.m4982a(argVarMo5185a.m5260c());
                    aqbVar.m4986b(argVarMo5185a.m5262d());
                    aqbVar.m4987c(argVarMo5185a.m5263e());
                    return aqbVar;
                }
            } catch (Throwable th) {
                aqb aqbVar2 = new aqb();
                aqbVar2.m4983a(false);
                aqbVar2.m4986b(th.getMessage());
                return aqbVar2;
            }
        }
        return null;
    }
}
