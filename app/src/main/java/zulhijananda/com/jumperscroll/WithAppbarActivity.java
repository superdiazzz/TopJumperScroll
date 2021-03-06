package zulhijananda.com.jumperscroll;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;

import zulhijananda.com.jumperscrollview.JumperAnimType;
import zulhijananda.com.jumperscrollview.JumperFab;
import zulhijananda.com.jumperscrollview.JumperObject;
import zulhijananda.com.jumperscrollview.JumperScrollView;

public class WithAppbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_appbar);

        setTitle("WITH APPBAR");

        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        JumperScrollView jumperScrollView = findViewById(R.id.scrollv);
        JumperFab jumperFab = findViewById(R.id.jumperFab);


        try {
            new JumperObject.Builder(this)
                    .setJumperScrollView(jumperScrollView)
                    .setJumperFab(jumperFab)
                    .setAppBarLayout(appBarLayout)
                    .setSpeedScroll(2000)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
