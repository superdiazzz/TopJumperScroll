package zulhijananda.com.jumperscrollview;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperFab extends FloatingActionButton {

    public JumperFab(Context context) {
        super(context);
        initialize(context);
    }


    public JumperFab(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public JumperFab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    private void initialize(Context context) {

    }


}
