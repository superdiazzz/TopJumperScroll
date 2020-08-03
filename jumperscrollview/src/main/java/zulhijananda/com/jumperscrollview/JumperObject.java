package zulhijananda.com.jumperscrollview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

import zulhijananda.com.jumperscrollview.listener.JumperScrollListener;

/**
 * Created by N Zul on 7/4/2019.
 *
 * This library dedicated for Tribunnews Project,
 * i collecting some people project then made this
 */
public class JumperObject {


    public static final int DEFAULT_DISPLAY_THRESHOLD_NUM = 5;

    private int displayThresholdNum;

    private Activity activity;
    private boolean display = false;
    private int y = 0;
    private Boolean hide = false;
    private JumperAnimType startTechniques, endTechniques;
    private JumperScrollView jumperScrollView;
    private JumperFab jumperFab;
    private AppBarLayout appBarLayout;
    private int speedScroll;



    private JumperObject(Activity activity,
                         JumperScrollView jumperScrollView,
                         JumperFab jumperFab,
                         AppBarLayout appBarLayout,
                         int speedScroll,
                         JumperAnimType endTechniques,
                         RecyclerView recyclerView,
                         MaterialButton customMaterialButton,
                         JumperAnimType startTechniques,
                         int displayThreshold,
                         boolean hide) throws Exception {

        this.activity = activity;
        this.jumperFab = jumperFab;
        this.jumperScrollView = jumperScrollView;
        this.hide = hide;
        this.startTechniques = startTechniques;
        this.endTechniques = endTechniques;
        this.appBarLayout = appBarLayout;
        this.speedScroll = speedScroll;


        if (jumperScrollView != null) {
            responseJumperScroll(jumperScrollView, jumperFab);
        }

        eventJumperFab(
                jumperFab,
                this.endTechniques,
                recyclerView,
                customMaterialButton,
                this.startTechniques,
                displayThreshold,
                this.hide);

        eventJumperAppBar(jumperFab, appBarLayout);
    }

    private void eventJumperAppBar(JumperFab jumperFab, AppBarLayout appBarLayout) {

        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
                if (Math.abs(verticalOffset) - appBarLayout1.getTotalScrollRange() == 0) {
                    // collapsed
                    //fabLayout.setVisibility(View.GONE);
                    jumperFab.show();
                } else {
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
     *
     * @param jumperFab
     * @param recyclerView
     */
    private void eventJumperFab(JumperFab jumperFab,
                                JumperAnimType endTechniques,
                                RecyclerView recyclerView,
                                MaterialButton customMaterialButton,
                                JumperAnimType startTechniques,
                                int positionDisplayThreshold,
                                boolean hide) throws Exception {

        // -- validation --

        if(hide){
            if(startTechniques == null || endTechniques == null){
                // default technique
                startTechniques = JumperAnimType.BOUNCEINUP;
                endTechniques = JumperAnimType.ZOOMOUT;
            }
        }

        validation(jumperFab, customMaterialButton, positionDisplayThreshold);

        // -- Custom Material Button --

        if (customMaterialButton != null) {

            if (recyclerView != null) {

                customMaterialButton.setVisibility(View.GONE);

                customMaterialButton.setOnClickListener(view -> {

                    if (this.speedScroll != 0) {

                        if (this.endTechniques != null) {

                            MyYoyo.with(this.endTechniques)
                                    .duration(this.speedScroll)
                                    .playOn(customMaterialButton);
                        }


                        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(activity) {
                            @Override
                            protected int getVerticalSnapPreference() {
                                return LinearSmoothScroller.SNAP_TO_START;
                            }
                        };
                        smoothScroller.setTargetPosition(0);
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        assert linearLayoutManager != null;
                        linearLayoutManager.startSmoothScroll(smoothScroller);

                        if (this.speedScroll != 0 && this.jumperScrollView != null) {
                            ObjectAnimator animator = ObjectAnimator.ofInt(this.jumperScrollView, "scrollY", 0);
                            animator.setDuration(this.speedScroll);
                            animator.start();
                        }

                        if (appBarLayout != null) {
                            appBarLayout.postDelayed(() -> appBarLayout.setExpanded(true), this.speedScroll - 200);
                        }

                    }

                    //Log.d("CUSTOMMATERIALBUTTON", "diklik!");
                    new Handler().postDelayed(() -> display = false, 1000);

                });

                // pull recyclerview state
                recyclerView.addOnScrollListener(new JumperScrollListener(startTechniques, endTechniques, hide, customMaterialButton, null));
            }
            else {
                customMaterialButton.setOnClickListener(view -> {

                    jumperWithoutSpeed(appBarLayout, jumperScrollView);
                });
            }

        }

        // -- Jumper FAB --

        if (jumperFab != null) {

            jumperFab.setOnClickListener(v -> {

                if (this.speedScroll != 0) {
                    jumperFabWithSpeed(jumperFab, appBarLayout, jumperScrollView, speedScroll, this.endTechniques, recyclerView);
                }
                else {
                    jumperWithoutSpeed(appBarLayout, jumperScrollView);
                }


                if(jumperFab.jumperFabCallback != null){
                    jumperFab.jumperFabCallback.fabOnClick();
                }

            });

            // pull recyclerview state
            recyclerView.addOnScrollListener(new JumperScrollListener(startTechniques, endTechniques, hide, null, jumperFab));

        }


    }

    private void jumperWithoutSpeed(AppBarLayout appBarLayout, JumperScrollView scrollView) {
        if (scrollView != null) {
            scrollView.scrollTo(0, 0);
            scrollView.fullScroll(View.FOCUS_UP);
        }


        if (appBarLayout != null) {
            appBarLayout.setExpanded(true);
        }
    }

    private void jumperFabWithSpeed(JumperFab jumperFab, AppBarLayout appBarLayout, JumperScrollView scrollView, int speed, JumperAnimType endTechniques, RecyclerView recyclerView) {
        if (jumperFab.getJumpingImage() != null) {
            jumperFab.transitionImage(speed - 200);
        }

        if (recyclerView != null) {

            RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(activity) {
                @Override
                protected int getVerticalSnapPreference() {
                    return LinearSmoothScroller.SNAP_TO_START;
                }
            };
            smoothScroller.setTargetPosition(0);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            assert linearLayoutManager != null;
            linearLayoutManager.startSmoothScroll(smoothScroller);
        }

        if (scrollView != null) {
            ObjectAnimator animator = ObjectAnimator.ofInt(scrollView, "scrollY", 0);
            animator.setDuration(speed);
            animator.start();
        }

        if (endTechniques != null) {
            MyYoyo.with(endTechniques)
                    .duration(speed)
                    .playOn(jumperFab);

        }

        if (appBarLayout != null) {
            appBarLayout.postDelayed(() -> appBarLayout.setExpanded(true), speed - 200);
        }
    }

    private void validation(JumperFab jumperFab, MaterialButton customMaterialButton, int displayThreshold) throws JumperException {
        if (customMaterialButton != null && jumperFab != null) {
            throw new JumperException("You have to choose using MaterialButton or JumperFAB! Can not use both of them");
        }

        if (customMaterialButton == null && jumperFab == null) {
            throw new JumperException("You need JumperFab or MaterialButton to Jumpt to Top!");
        }

        if (displayThreshold != 0) {
            displayThresholdNum = displayThreshold;
        } else {
            displayThresholdNum = DEFAULT_DISPLAY_THRESHOLD_NUM;
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private void responseJumperScroll(JumperScrollView jumperScrollView, JumperFab jumperFab) {

        jumperScrollView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                jumperScrollView.startScrollerTask();
                jumperFab.hide();
            }
            return false;
        });

        jumperScrollView.setOnScrollStopListener(jumperFab::show);

    }

    public static class Builder {

        private Activity activity;
        private AppBarLayout appBarLayout;
        private JumperScrollView jumperScrollView;
        private JumperFab jumperFab;
        private RecyclerView recyclerView;
        private int speedScroll = 0;
        private JumperAnimType animCloseTechnique;
        private JumperAnimType animStartTechnique;
        private MaterialButton customMaterialButton;
        private boolean hide = false;
        private int displayThreshold = 0;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        /**
         * if you have Appbar like CollapsingToolbarLayout,
         * you can set it then connecting with JumperFab
         *
         * @param appBarLayout your appbar put here
         * @return
         */
        public Builder setAppBarLayout(AppBarLayout appBarLayout) {
            this.appBarLayout = appBarLayout;
            return this;
        }

        /**
         * Your scroolview (NestedScrollview)
         *
         * @param jumperScrollView your scrollview
         * @return
         */
        public Builder setJumperScrollView(JumperScrollView jumperScrollView) {
            this.jumperScrollView = jumperScrollView;
            return this;
        }

        /**
         * connecting with your recyclerview
         *
         * @param recyclerView your recyclerview
         * @return
         */
        public Builder setJumperRecyclerView(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
            return this;
        }


        /**
         * Your FloatingActionBar
         *
         * @param jumperFab your FAB
         * @return
         */
        public Builder setJumperFab(JumperFab jumperFab) {
            this.jumperFab = jumperFab;
            return this;
        }

        /**
         * indicator to setting speed while your scroll is jumping to Top
         *
         * @param millis
         * @return
         */
        public Builder setSpeedScroll(int millis) {
            this.speedScroll = millis;
            return this;
        }

        /**
         * If you want to show closing animation interact with FAB
         *
         * @param animTechnique animation when ending
         * @return
         */
        public Builder setAnimCloseTechnique(JumperAnimType animTechnique) {
            this.animCloseTechnique = animTechnique;
            return this;
        }

        public Builder setAnimStartTechnique(JumperAnimType startTechnique) {
            this.animStartTechnique = startTechnique;
            return this;
        }

        /**
         * determining your Custom button will be display at any index
         *
         * @param displayThreshold
         * @return
         */
        public Builder setDisplayThreshold(int displayThreshold) {
            this.displayThreshold = displayThreshold;
            return this;
        }

        /**
         * with custom material Button
         *
         * @param materialButton
         * @return
         */
        public Builder setCustomMaterialButton(MaterialButton materialButton) {
            this.customMaterialButton = materialButton;
            return this;
        }

        /**
         * Only display jumper when scrolling up
         * @param hide hide when scrolling up
         * @return
         */
        public Builder hideWhenScrollUp(boolean hide) {
            this.hide = hide;
            return this;
        }


        public JumperObject build() throws Exception {
            return new JumperObject(activity, jumperScrollView, jumperFab, appBarLayout,
                    speedScroll, animCloseTechnique, recyclerView, customMaterialButton, animStartTechnique,
                    displayThreshold, hide);
        }


    }

}
