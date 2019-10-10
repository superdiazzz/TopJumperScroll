package zulhijananda.com.jumperscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import zulhijananda.com.jumperscrollview.JumperAnimType;
import zulhijananda.com.jumperscrollview.JumperFab;
import zulhijananda.com.jumperscrollview.JumperObject;
import zulhijananda.com.jumperscrollview.JumperScrollView;

public class WithAnimationActivity extends AppCompatActivity {

    private JumperScrollView jumperScrollView;
    private JumperFab jumperFab;
    private JumperObject myJumperObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_animation);

        setTitle("WITH ANIMATION FAB");


        jumperScrollView = findViewById(R.id.scrollv);
        jumperFab = findViewById(R.id.jumperFab);

        myJumperObj = new JumperObject.Builder(this)
                    .setJumperScrollView(jumperScrollView)
                    .setJumperFab(jumperFab)
                    .setSpeedScroll(2000)
                    .build();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anim_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.taking_off:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .setAnimCloseTechnique(JumperAnimType.TAKINGOFF)
                        .build();

                Toast.makeText(this, "Taking off", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.flipouty:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .setAnimCloseTechnique(JumperAnimType.FLIPOUTY)
                        .build();

                Toast.makeText(this, "Flip out y", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.rubberband:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .setAnimCloseTechnique(JumperAnimType.RUBBERBAND)
                        .build();

                Toast.makeText(this, "Rubberband", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.fade_out:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .setAnimCloseTechnique(JumperAnimType.FADEOUT)
                        .build();

                Toast.makeText(this, "Fade Out", Toast.LENGTH_SHORT).show();


                return true;

            case R.id.zoom_out:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .setAnimCloseTechnique(JumperAnimType.ZOOMOUT)
                        .build();

                Toast.makeText(this, "Zoom Out", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.fade_out_right:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .setAnimCloseTechnique(JumperAnimType.FADEOUTRIGHT)
                        .build();

                Toast.makeText(this, "Fade Out Right", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);



        }

    }
}
