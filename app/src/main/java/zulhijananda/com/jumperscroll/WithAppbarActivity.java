package zulhijananda.com.jumperscroll;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zulhijananda.com.jumperscrollview.JumperFab;
import zulhijananda.com.jumperscrollview.JumperObject;
import zulhijananda.com.jumperscrollview.JumperScrollView;

public class WithAppbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_appbar);

        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        JumperScrollView jumperScrollView = findViewById(R.id.scrollv);
        JumperFab jumperFab = findViewById(R.id.jumperFab);


        new JumperObject.Builder(this)
                .setJumperScrollView(jumperScrollView)
                .setJumperFab(jumperFab)
                .setAppBarLayout(appBarLayout)
                .build();


    }
}
