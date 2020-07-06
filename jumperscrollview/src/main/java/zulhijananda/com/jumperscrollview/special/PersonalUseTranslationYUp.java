package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class PersonalUseTranslationYUp extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {

        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1),
                ObjectAnimator.ofFloat(target, "translationY", 400, 0f)
        );
        setDuration(1000);
    }
}
