package zulhijananda.com.jumperscroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import zulhijananda.com.jumperscrollview.JumperFab;
import zulhijananda.com.jumperscrollview.JumperObject;
import zulhijananda.com.jumperscrollview.JumperScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JumperScrollView jumperScrollView = findViewById(R.id.scrollv);
        JumperFab jumperFab = findViewById(R.id.jumperFab);

        new JumperObject.Builder(this)
                .setJumperScrollView(jumperScrollView)
                .setJumperFab(jumperFab)
                .setSpeedScroll(2000)
                .build();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.withAppBar:
                startActivity(new Intent(this, WithAppbarActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
