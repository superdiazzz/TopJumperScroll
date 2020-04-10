package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class RubberBand extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "scaleX", 1, 1.25f, 0.75f, 1.15f, 1),
                ObjectAnimator.ofFloat(target, "scaleY", 1, 0.75f, 1.25f, 0.85f, 1)
        );
    }
}
