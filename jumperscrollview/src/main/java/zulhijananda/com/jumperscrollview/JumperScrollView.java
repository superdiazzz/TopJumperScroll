package zulhijananda.com.jumperscrollview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by N Zul on 7/4/2019.
 */
public class JumperScrollView extends NestedScrollView {

    private Runnable scrollerTask;

    private int newCheck = 100;

    private OnScrollStopListener onScrollStopListener;

    private int initialPosition;

    public interface  OnScrollStopListener {
        void onScrollStopped();
    }

    public JumperScrollView(@NonNull Context context) {
        super(context);
        initializeCaller(context);
    }

    public JumperScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeCaller(context);

    }

    public JumperScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeCaller(context);

    }

    void initializeCaller(Context context){

        scrollerTask = () -> {

            int newPosition = getScrollY();
            if(initialPosition - newPosition == 0){
                if(onScrollStopListener != null){
                    onScrollStopListener.onScrollStopped();
                }
            }else {
                initialPosition = getScrollY();
                JumperScrollView.this.postDelayed(scrollerTask, newCheck);
            }
        };
    }

    public void setOnScrollStopListener(OnScrollStopListener listener){
        this.onScrollStopListener = listener;
    }


    public void startScrollerTask(){
        initialPosition = getScrollY();
        this.postDelayed(scrollerTask, newCheck);
    }
}
