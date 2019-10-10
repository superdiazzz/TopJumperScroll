package zulhijananda.com.jumperscrollview;

import com.daimajia.androidanimations.library.Techniques;

public enum JumperAnimType {


    TAKINGOFF(Techniques.TakingOff),
    FLIPOUTY(Techniques.FlipOutY),
    RUBBERBAND(Techniques.RubberBand),
    FADEOUT(Techniques.FadeOut),
    ZOOMOUT(Techniques.ZoomOut),
    FADEOUTRIGHT(Techniques.FadeOutRight);

    private final Techniques value;
    private JumperAnimType(Techniques value){
        this.value = value;
    }

    public Techniques getValue(){
        return value;
    }


}
