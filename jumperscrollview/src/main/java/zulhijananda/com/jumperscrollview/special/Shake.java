package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class Shake extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0)
        );
    }
}
