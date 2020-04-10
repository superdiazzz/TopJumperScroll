package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class ZoomOut extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 1, 0, 0),
                ObjectAnimator.ofFloat(target, "scaleX", 1, 0.3f, 0),
                ObjectAnimator.ofFloat(target, "scaleY", 1, 0.3f, 0)
        );
    }
}
