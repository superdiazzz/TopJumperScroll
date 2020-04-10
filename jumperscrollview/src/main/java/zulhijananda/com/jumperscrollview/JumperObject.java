package zulhijananda.com.jumperscrollview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperObject {


    public static final int DEFAULT_DISPLAY_THRESHOLD_NUM = 5;

    private int displayThresholdNum;

    private Activity activity;
    private boolean display = false;

    private JumperObject(Activity activity,
                         JumperScrollView jumperScrollView,
                         JumperFab jumperFab,
                         AppBarLayout appBarLayout,
                         int speedScroll,
                         JumperAnimType endTechniques,
                         RecyclerView recyclerView,
                         MaterialButton customMaterialButton,
                         JumperAnimType startTechniques,
                         int displayThreshold) throws Exception {

        this.activity = activity;

        if(jumperScrollView != null){
            responseJumperScroll(jumperScrollView, jumperFab);
        }

        eventJumperFab(
                jumperFab,
                appBarLayout,
                jumperScrollView,
                speedScroll,
                endTechniques,
                recyclerView,
                customMaterialButton,
                startTechniques,
                displayThreshold);

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
                                JumperAnimType endTechniques,
                                RecyclerView recyclerView,
                                MaterialButton customMaterialButton,
                                JumperAnimType startTechniques,
                                int positionDisplayThreshold) throws Exception {

        // -- validation --

        validation(jumperFab, customMaterialButton, positionDisplayThreshold);

        // -- Custom Material Button --

        if(customMaterialButton != null){

            if(recyclerView != null){

                customMaterialButton.setVisibility(View.GONE);

                customMaterialButton.setOnClickListener(view -> {

                    if(speed != 0){

                        if(endTechniques != null){

                            MyYoyo.with(endTechniques)
                                    .duration(speed)
                                    .playOn(customMaterialButton);
                        }


                        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(activity) {
                            @Override protected int getVerticalSnapPreference() {
                                return LinearSmoothScroller.SNAP_TO_START;
                            }
                        };
                        smoothScroller.setTargetPosition(0);
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        linearLayoutManager.startSmoothScroll(smoothScroller);
                        //responseRecyclerView(recyclerView);

                        if(scrollView != null){
                            ObjectAnimator animator  = ObjectAnimator.ofInt(scrollView, "scrollY", 0);
                            animator.setDuration(speed);
                            animator.start();
                        }

                        if(appBarLayout != null){
                            appBarLayout.postDelayed(() -> appBarLayout.setExpanded(true), speed-200);
                        }

                    }

                    Log.d("CUSTOMMATERIALBUTTON", "diklik!");
                    new Handler().postDelayed(() -> display = false, 1000);

                });


                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);

                        LinearLayoutManager layoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();

                        assert layoutManager != null;
                        int pos = layoutManager.findLastVisibleItemPosition();
                        Log.d("JUMPER", ""+pos+" display : " + display);

                        if(pos > displayThresholdNum && !display){

                            customMaterialButton.setVisibility(View.VISIBLE);

                            if(startTechniques != null){
                                MyYoyo.with(startTechniques)  // EX: BOUNCEINUP
                                        .duration(speed)
                                        .playOn(customMaterialButton);
                            }
                            display = true;
                        }

                        if(pos <=3){
                            customMaterialButton.setVisibility(View.GONE);
                            display = false;
                        }

                    }

                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);

                    }
                });



            }
            else{

                customMaterialButton.setOnClickListener(view -> {

                    if(scrollView != null){
                        scrollView.scrollTo(0, 0);
                        scrollView.fullScroll(View.FOCUS_UP);
                    }


                    if(appBarLayout != null){
                        appBarLayout.setExpanded(true);
                    }
                });


            }

        }

        // -- Jumper FAB --

        if(jumperFab != null){

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

                    if(endTechniques != null){
                        MyYoyo.with(endTechniques)
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


    }

    private void validation(JumperFab jumperFab, MaterialButton customMaterialButton, int displayThreshold) throws JumperException {
        if(customMaterialButton != null && jumperFab != null){
            throw new JumperException("You have to choose using MaterialButton or JumperFAB! Can not use both of them");
        }

        if(customMaterialButton == null && jumperFab == null){
            throw new JumperException("You need JumperFab or MaterialButton to Jumpt to Top!");
        }

        if(displayThreshold != 0){
            displayThresholdNum = displayThreshold;
        }else{
            displayThresholdNum = DEFAULT_DISPLAY_THRESHOLD_NUM;
        }

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
        private JumperAnimType animStartTechnique;
        private MaterialButton customMaterialButton;
        private int displayThreshold = 0;

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

        public Builder setAnimStartTechnique(JumperAnimType startTechnique){
            this.animStartTechnique = startTechnique;
            return this;
        }

        /**
         * determining your Custom button will be display at any index
         * @param displayThreshold
         * @return
         */
        public Builder setDisplayThreshold(int displayThreshold){
            this.displayThreshold = displayThreshold;
            return this;
        }

        /**
         * with custom material Button
         * @param materialButton
         * @return
         */
        public Builder setCustomMaterialButton(MaterialButton materialButton){
            this.customMaterialButton = materialButton;
            return this;
        }


        public JumperObject build() throws Exception {
            return new JumperObject(activity, jumperScrollView, jumperFab, appBarLayout,
                    speedScroll, animCloseTechnique, recyclerView, customMaterialButton, animStartTechnique,
                    displayThreshold);
        }


    }

}
