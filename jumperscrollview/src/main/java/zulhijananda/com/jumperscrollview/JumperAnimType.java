package zulhijananda.com.jumperscrollview;

import com.daimajia.androidanimations.library.Techniques;

public enum JumperAnimType {


    TAKINGOFF(Techniques.TakingOff),
    FLIPOUTY(Techniques.FlipOutY),
    RUBBERBAND(Techniques.RubberBand),
    FADEOUT(Techniques.FadeOut),
    ZOOMOUT(Techniques.ZoomOut),
    FADEOUTRIGHT(Techniques.FadeOutRight),
    BOUNCEINUP(Techniques.BounceInUp),
    BOUNCEINDOWN(Techniques.BounceInDown),
    ROLLOUT(Techniques.RollOut),
    ROTATEOUT(Techniques.RotateOut),
    SHAKE(Techniques.Shake),
    HINGE(Techniques.Hinge);

    private final Techniques value;
    private JumperAnimType(Techniques value){
        this.value = value;
    }

    public Techniques getValue(){
        return value;
    }


}
