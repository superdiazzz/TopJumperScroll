package zulhijananda.com.jumperscrollview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.appbar.AppBarLayout;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperObject {

    private Activity activity;

    private JumperObject(Activity activity,
                        JumperScrollView jumperScrollView,
                        JumperFab jumperFab,
                        AppBarLayout appBarLayout,
                         int speedScroll,
                         JumperAnimType techniques,
                         RecyclerView recyclerView){

        this.activity = activity;

        if(jumperScrollView != null){
            responseJumperScroll(jumperScrollView, jumperFab);
        }

        eventJumperFab(jumperFab, appBarLayout, jumperScrollView, speedScroll, techniques, recyclerView);

        eventJumperAppBar(jumperFab, appBarLayout);
    }

    private void responseRecyclerView(RecyclerView recyclerView) {

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager llmanager = (LinearLayoutManager) layoutManager;
        llmanager.scrollToPositionWithOffset(0,0);
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
     * @param recyclerView
     */
    private void eventJumperFab(JumperFab jumperFab,
                                AppBarLayout appBarLayout,
                                JumperScrollView scrollView,
                                int speed,
                                JumperAnimType techniques, RecyclerView recyclerView) {

        jumperFab.setOnClickListener(v -> {

            if(speed != 0){

                if(jumperFab.getJumpingImage() != null){
                    jumperFab.transitionImage(speed-200);
                }

                if(recyclerView != null){


                    RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(activity) {
                        @Override protected int getVerticalSnapPreference() {
                            return LinearSmoothScroller.SNAP_TO_START;
                        }
                    };
                    smoothScroller.setTargetPosition(0);
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    linearLayoutManager.startSmoothScroll(smoothScroller);
                    //responseRecyclerView(recyclerView);
                }

                if(scrollView != null){
                    ObjectAnimator animator  = ObjectAnimator.ofInt(scrollView, "scrollY", 0);
                    animator.setDuration(speed);
                    animator.start();
                }

                if(techniques != null){
                    YoYo.with(techniques.getValue())
                            .duration(speed)
                            .playOn(jumperFab);

                }

                if(appBarLayout != null){
                    appBarLayout.postDelayed(() -> appBarLayout.setExpanded(true), speed-200);
                }

            }else {

                if(scrollView != null){
                    scrollView.scrollTo(0, 0);
                    scrollView.fullScroll(View.FOCUS_UP);
                }


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
        private RecyclerView recyclerView;
        private int speedScroll = 0;
        private JumperAnimType animCloseTechnique;

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
         * connecting with your recyclerview
         * @param recyclerView
         * @return
         */
        public Builder setJumperRecyclerView(RecyclerView recyclerView){
            this.recyclerView = recyclerView;
            return this;
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

        /**
         * If you want to show closing animation interact with FAB
         * @param animTechnique
         * @return
         */
        public Builder setAnimCloseTechnique(JumperAnimType animTechnique){
            this.animCloseTechnique = animTechnique;
            return this;
        }


        public JumperObject build(){
            return new JumperObject(activity, jumperScrollView, jumperFab, appBarLayout, speedScroll, animCloseTechnique, recyclerView);
        }


    }

}
