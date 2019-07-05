package zulhijananda.com.jumperscrollview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.CountDownTimer;
import android.support.design.widget.AppBarLayout;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperObject {

    private Activity activity;

    private JumperObject(Activity activity,
                        JumperScrollView jumperScrollView,
                        JumperFab jumperFab,
                        AppBarLayout appBarLayout,
                         int speedScroll){

        this.activity = activity;

        responseJumperScroll(jumperScrollView, jumperFab);

        eventJumperFab(jumperFab, appBarLayout, jumperScrollView, speedScroll);

        eventJumperAppBar(jumperFab, appBarLayout);
    }

    private void eventJumperAppBar(JumperFab jumperFab, AppBarLayout appBarLayout) {

        if(appBarLayout != null){
            appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
                if(Math.abs(verticalOffset) - appBarLayout1.getTotalScrollRange() == 0){
                    // collapsed
                    //fabLayout.setVisibility(View.GONE);
                    jumperFab.show();
                }else {
                    // expanded
                    //fabLayout.setVisibility(View.VISIBLE);
                    jumperFab.hide();
                }
            });
        }

    }

    /**
     * Solving post delay scrollview
     * https://stackoverflow.com/questions/7202193/scroll-up-a-scrollview-slowly
     * @param jumperFab
     * @param appBarLayout
     * @param scrollView
     * @param speed
     */
    private void eventJumperFab(JumperFab jumperFab, AppBarLayout appBarLayout,  JumperScrollView scrollView, int speed) {

        jumperFab.setOnClickListener(v -> {

            if(speed != 0){
                ObjectAnimator animator  = ObjectAnimator.ofInt(scrollView, "scrollY", 0);
                animator.setDuration(speed);
                animator.start();
                if(appBarLayout != null){
                    appBarLayout.postDelayed(() -> appBarLayout.setExpanded(true), speed-200);
                }

                /*new CountDownTimer(speed, 20){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        scrollView.scrollTo(0, (int) (speed - millisUntilFinished));
                    }

                    @Override
                    public void onFinish() {

                        if(appBarLayout != null){
                            appBarLayout.setExpanded(true);
                        }
                    }
                }.start();*/

            }else {
                scrollView.scrollTo(0, 0);
                scrollView.fullScroll(View.FOCUS_UP);

                if(appBarLayout != null){
                    appBarLayout.setExpanded(true);
                }

            }



        });

    }

    @SuppressLint("ClickableViewAccessibility")
    private void responseJumperScroll(JumperScrollView jumperScrollView, JumperFab jumperFab) {

        jumperScrollView.setOnTouchListener((v, event) -> {
            if(event.getAction() == MotionEvent.ACTION_UP){
                jumperScrollView.startScrollerTask();
                jumperFab.hide();
            }
            return false;
        });

        jumperScrollView.setOnScrollStopListener(() -> {
            jumperFab.show();
        });

    }

    public static class Builder {

        private Activity activity;
        private AppBarLayout appBarLayout;
        private JumperScrollView jumperScrollView;
        private JumperFab jumperFab;
        private int speedScroll = 0;

        public Builder(Activity activity){
            this.activity = activity;
        }

        /**
         * if you have Appbar like CollapsingToolbarLayout,
         * you can set it then connecting with JumperFab
         * @param appBarLayout
         * @return
         */
        public Builder setAppBarLayout(AppBarLayout appBarLayout){
            this.appBarLayout = appBarLayout;
            return this;
        }

        /**
         * Your scroolview (NestedScrollview)
         * @param jumperScrollView
         * @return
         */
        public Builder setJumperScrollView(JumperScrollView jumperScrollView){
            this.jumperScrollView = jumperScrollView;
            return  this;
        }

        /**
         * Your FloatingActionBar
         * @param jumperFab
         * @return
         */
        public Builder setJumperFab(JumperFab jumperFab){
            this.jumperFab = jumperFab;
            return this;
        }

        /**
         * indicator to setting speed while your scroll is jumping to Top
         * @param millis
         * @return
         */
        public Builder setSpeedScroll(int millis){
            this.speedScroll = millis;
            return this;
        }

        public JumperObject build(){
            return new JumperObject(activity, jumperScrollView, jumperFab, appBarLayout, speedScroll);
        }


    }

}
