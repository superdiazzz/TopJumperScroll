package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class PersonalUseTranslationYBottom extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {

        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 1, 0),
                ObjectAnimator.ofFloat(target, "translationY", 0, 400f)
        );
        setDuration(2000);
        setInterpolator(new BounceInterpolator());
    }
}
