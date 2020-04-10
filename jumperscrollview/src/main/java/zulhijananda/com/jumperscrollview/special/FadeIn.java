package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class FadeIn extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1)
        );
    }
}
