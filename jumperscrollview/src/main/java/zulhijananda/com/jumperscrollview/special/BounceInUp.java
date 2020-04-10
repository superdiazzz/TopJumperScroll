package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class BounceInUp extends MyBaseViewAnimator {

    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "translationY", target.getMeasuredHeight(), -30, 10, 0),
                ObjectAnimator.ofFloat(target, "alpha", 0, 1, 1, 1)
        );
    }
}
