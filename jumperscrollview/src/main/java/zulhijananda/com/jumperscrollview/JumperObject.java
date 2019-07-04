package zulhijananda.com.jumperscrollview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperObject {

    private Activity activity;

    public JumperObject(Activity activity,
                        JumperScrollView jumperScrollView,
                        JumperFab jumperFab,
                        AppBarLayout appBarLayout){

        this.activity = activity;

        responseJumperScroll(jumperScrollView, jumperFab);

        eventJumperFab(jumperFab, appBarLayout, jumperScrollView);

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

    private void eventJumperFab(JumperFab jumperFab, AppBarLayout appBarLayout,  JumperScrollView scrollView) {

        jumperFab.setOnClickListener(v -> {
            scrollView.scrollTo(0, 0);
            scrollView.fullScroll(View.FOCUS_UP);
            if(appBarLayout != null){
                appBarLayout.setExpanded(true);
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

        public Builder setJumperScrollView(JumperScrollView jumperScrollView){
            this.jumperScrollView = jumperScrollView;
            return  this;
        }

        public Builder setJumperFab(JumperFab jumperFab){
            this.jumperFab = jumperFab;
            return this;
        }

        public JumperObject build(){
            return new JumperObject(activity, jumperScrollView, jumperFab, appBarLayout);
        }


    }

}
