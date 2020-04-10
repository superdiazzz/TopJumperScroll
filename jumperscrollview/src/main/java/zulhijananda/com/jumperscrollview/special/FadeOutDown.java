package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class FadeOutDown extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 1, 0),
                ObjectAnimator.ofFloat(target, "translationY", 0, target.getHeight() / 4)
        );
    }
}
