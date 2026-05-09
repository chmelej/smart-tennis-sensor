package p000;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: wx */
/* JADX INFO: compiled from: OptAnimationLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2229wx {
    /* JADX INFO: renamed from: a */
    public static Animation m12182a(Context context, int i) throws Throwable {
        XmlResourceParser animation;
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                animation = context.getResources().getAnimation(i);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Animation animationM12183a = m12183a(context, animation);
                if (animation != null) {
                    animation.close();
                }
                return animationM12183a;
            } catch (IOException e) {
                e = e;
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                e = e2;
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e);
                throw notFoundException2;
            } catch (Throwable th2) {
                th = th2;
                xmlResourceParser = animation;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (XmlPullParserException e4) {
            e = e4;
        }
    }

    /* JADX INFO: renamed from: a */
    private static Animation m12183a(Context context, XmlPullParser xmlPullParser) {
        return m12184a(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX INFO: renamed from: a */
    private static Animation m12184a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        Animation translateAnimation = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("set")) {
                    translateAnimation = new AnimationSet(context, attributeSet);
                    m12184a(context, xmlPullParser, (AnimationSet) translateAnimation, attributeSet);
                } else if (name.equals("alpha")) {
                    translateAnimation = new AlphaAnimation(context, attributeSet);
                } else if (name.equals("scale")) {
                    translateAnimation = new ScaleAnimation(context, attributeSet);
                } else if (name.equals("rotate")) {
                    translateAnimation = new RotateAnimation(context, attributeSet);
                } else if (name.equals("translate")) {
                    translateAnimation = new TranslateAnimation(context, attributeSet);
                } else {
                    try {
                        translateAnimation = (Animation) Class.forName(name).getConstructor(Context.class, AttributeSet.class).newInstance(context, attributeSet);
                    } catch (Exception e) {
                        throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName() + " error:" + e.getMessage());
                    }
                }
                if (animationSet != null) {
                    animationSet.addAnimation(translateAnimation);
                }
            }
        }
        return translateAnimation;
    }
}
