package zulhijananda.com.jumperscrollview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperFab extends FloatingActionButton {

    private Drawable jumpingImage;
    private Drawable defaultImage;
    private TypedArray ta;
    private int colorBackground;

    public JumperFab(Context context) {
        super(context);
        initialize(context, null);
    }


    public JumperFab(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);

    }

    public JumperFab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);

    }

    private void initialize(Context context, AttributeSet attr) {

        if(attr == null){
            return;
        }
        ta = context.obtainStyledAttributes(attr, R.styleable.JumperFab);
        defaultImage = ta.getDrawable(R.styleable.JumperFab_defaultImage);
        if(defaultImage != null){
            this.setImageDrawable(defaultImage);
        }

        jumpingImage = ta.getDrawable(R.styleable.JumperFab_jumpingImage);
        colorBackground = ta.getColor(R.styleable.JumperFab_colorBackground, getThemeAccentColor(context));
        this.setBackgroundTintList(ColorStateList.valueOf(colorBackground));

    }

    public void transitionImage(int milis){
        this.hide();
        this.setImageDrawable(jumpingImage);
        this.show();
        this.postDelayed(() -> {
            this.hide();
            this.setImageDrawable(defaultImage); // put it back
            this.show();
        }, milis);
    }


    public Drawable getJumpingImage() {
        return jumpingImage;
    }

    public Drawable getDefaultImage() {
        return defaultImage;
    }

    public void setJumpingImage(Drawable jumpingImage) {
        this.jumpingImage = jumpingImage;
        this.setImageDrawable(jumpingImage);
    }

    public void setDefaultImage(Drawable defaultImage) {
        this.defaultImage = defaultImage;
    }

    public static int getThemeAccentColor (final Context context) {
        final TypedValue value = new TypedValue ();
        context.getTheme ().resolveAttribute (R.attr.colorAccent, value, true);
        return value.data;
    }
}
