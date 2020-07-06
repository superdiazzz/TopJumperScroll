package zulhijananda.com.jumperscrollview;

import zulhijananda.com.jumperscrollview.special.BounceInDown;
import zulhijananda.com.jumperscrollview.special.BounceInUp;
import zulhijananda.com.jumperscrollview.special.FadeIn;
import zulhijananda.com.jumperscrollview.special.FadeOut;
import zulhijananda.com.jumperscrollview.special.FadeOutDown;
import zulhijananda.com.jumperscrollview.special.FadeOutLeft;
import zulhijananda.com.jumperscrollview.special.FadeOutRight;
import zulhijananda.com.jumperscrollview.special.FlipInX;
import zulhijananda.com.jumperscrollview.special.FlipOutY;
import zulhijananda.com.jumperscrollview.special.Hinge;
import zulhijananda.com.jumperscrollview.special.Landing;
import zulhijananda.com.jumperscrollview.special.PersonalUseTranslationYBottom;
import zulhijananda.com.jumperscrollview.special.PersonalUseTranslationYUp;
import zulhijananda.com.jumperscrollview.special.RollOut;
import zulhijananda.com.jumperscrollview.special.RotateOut;
import zulhijananda.com.jumperscrollview.special.RubberBand;
import zulhijananda.com.jumperscrollview.special.Shake;
import zulhijananda.com.jumperscrollview.special.TakingOff;
import zulhijananda.com.jumperscrollview.special.ZoomOut;

public enum JumperAnimType {

    TAKINGOFF(TakingOff.class),
    FLIPOUTY(FlipOutY.class),
    RUBBERBAND(RubberBand.class),
    FADEOUT(FadeOut.class),
    ZOOMOUT(ZoomOut.class),
    FADEOUTRIGHT(FadeOutRight.class),
    BOUNCEINUP(BounceInUp.class),
    BOUNCEINDOWN(BounceInDown.class),
    ROLLOUT(RollOut.class),
    ROTATEOUT(RotateOut.class),
    SHAKE(Shake.class),
    HINGE(Hinge.class),
    FADEIN(FadeIn.class),
    LANDING(Landing.class),
    FLIPINX(FlipInX.class),
    FADEOUTLEFT(FadeOutLeft.class),
    FADEOUTDOWN(FadeOutDown.class),
    PERSONAL_USE_TRANLATION_Y_UP(PersonalUseTranslationYUp.class),
    PERSONAL_USE_TRANLATION_Y_BOTTOM(PersonalUseTranslationYBottom.class);


    private Class animatorClazz;

    private JumperAnimType(Class clazz){
        animatorClazz = clazz;
    }


    public MyBaseViewAnimator getAnimator() {
        try {
            return (MyBaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }

}
