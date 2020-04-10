package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class FlipInX extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "rotationX", 90, -15, 15, 0),
                ObjectAnimator.ofFloat(target, "alpha", 0.25f, 0.5f, 0.75f, 1)
        );
    }
}
