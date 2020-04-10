package zulhijananda.com.jumperscrollview.special;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;

import zulhijananda.com.jumperscrollview.MyBaseViewAnimator;

public class TakingOff extends MyBaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "alpha", 1, 0))
        );
    }
}
