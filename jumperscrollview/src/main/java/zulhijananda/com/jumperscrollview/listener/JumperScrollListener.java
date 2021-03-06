package zulhijananda.com.jumperscrollview.listener;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.AbsListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.button.MaterialButton;

import zulhijananda.com.jumperscrollview.JumperAnimType;
import zulhijananda.com.jumperscrollview.JumperFab;
import zulhijananda.com.jumperscrollview.MyYoyo;

public class JumperScrollListener extends RecyclerView.OnScrollListener {

    private JumperAnimType startAnim, endAnim;
    private boolean hideWhenScrolling = false;
    private boolean scrolling = false;
    private MaterialButton customMaterialButton;
    private JumperFab jumperFab;
    private int y = 0;

    public JumperScrollListener(JumperAnimType startAnim, JumperAnimType endAnim,
                                boolean hide, MaterialButton customMaterialButton,
                                JumperFab jumperFab){
        this.startAnim = startAnim;
        this.endAnim = endAnim;
        this.hideWhenScrolling = hide;
        this.customMaterialButton = customMaterialButton;
        this.jumperFab = jumperFab;
    }


    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        y = dy;

    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        switch (newState){
            case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
            case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                break;
            default:
                if (hideWhenScrolling) {
                    if (y > 0) {
                        // scrolling up
                        Log.d("JUMPERLISTERNER", "scroll up");
                        if(customMaterialButton != null && !scrolling){
                            if (customMaterialButton.isShown()) {
                                MyYoyo.with(this.endAnim).duration(1000).playOn(customMaterialButton); // jumperAnimType.FADEOUT
                                customMaterialButton.postDelayed(() -> customMaterialButton.setVisibility(View.GONE), 1000);
                                scrolling = true;
                            }
                        }

                        if(jumperFab != null && !scrolling){
                            if(jumperFab.isShown()){
                                MyYoyo.with(this.endAnim).duration(1000).playOn(jumperFab);
                                jumperFab.postDelayed(() -> jumperFab.setVisibility(View.GONE), 1000);
                                scrolling = true;
                            }
                        }


                    } else {
                        // scrolling down
                        Log.d("JUMPERLISTERNER", "scroll down");
                        if(customMaterialButton != null){

                            if(!customMaterialButton.isShown()){
                                customMaterialButton.setVisibility(View.VISIBLE);
                                MyYoyo.with(this.startAnim)
                                        .duration(1000)
                                        .onEnd(animator -> {
                                            Log.d("JUMPERLISTERNER", "End anim");
                                            scrolling = false;
                                        })
                                        .playOn(customMaterialButton);

                            }
                        }

                        if(jumperFab != null){
                            if(!jumperFab.isShown()){
                                jumperFab.setVisibility(View.VISIBLE);
                                MyYoyo.with(this.startAnim)
                                        .duration(1000)
                                        .onEnd(animator -> {
                                            Log.d("JUMPERLISTERNER", "End anim");
                                            scrolling = false;
                                        })
                                        .playOn(jumperFab);
                            }
                        }

                    }
                }
                break;
        }


        if(customMaterialButton != null){
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            assert layoutManager != null;
            int pos = layoutManager.findLastVisibleItemPosition();

            if (pos <= 3) {
                customMaterialButton.setVisibility(View.GONE);
            }
        }
    }
}
