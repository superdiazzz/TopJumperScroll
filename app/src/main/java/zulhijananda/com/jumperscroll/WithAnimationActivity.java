package zulhijananda.com.jumperscroll;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        try {
            myJumperObj = new JumperObject.Builder(this)
                        .setJumperScrollView(jumperScrollView)
                        .setJumperFab(jumperFab)
                        .setSpeedScroll(2000)
                        .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.TAKINGOFF)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Taking off", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.flipouty:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.FLIPOUTY)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Flip out y", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.rubberband:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.RUBBERBAND)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Rubberband", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.fade_out:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.FADEOUT)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Fade Out", Toast.LENGTH_SHORT).show();


                return true;

            case R.id.zoom_out:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.ZOOMOUT)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Zoom Out", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.fade_out_right:

                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.FADEOUTRIGHT)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Fade Out Right", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.bounce_in_up:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.BOUNCEINUP)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Bounce in up", Toast.LENGTH_SHORT).show();
                return true;

           case  R.id.bounce_in_down:
               if(!jumperFab.isShown()){
                   jumperFab.show();
               }

               try {
                   new JumperObject.Builder(this)
                           .setJumperScrollView(jumperScrollView)
                           .setJumperFab(jumperFab)
                           .setSpeedScroll(2000)
                           .setAnimCloseTechnique(JumperAnimType.BOUNCEINDOWN)
                           .build();
               } catch (Exception e) {
                   e.printStackTrace();
               }

               Toast.makeText(this, "Bounce in Down", Toast.LENGTH_SHORT).show();
               return true;

            case R.id.roll_out:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.ROLLOUT)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Roll out", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.rotate_out:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.ROTATEOUT)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Rotate Out", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.shake:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.SHAKE)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "Shake", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.hinge:
                if(!jumperFab.isShown()){
                    jumperFab.show();
                }

                try {
                    new JumperObject.Builder(this)
                            .setJumperScrollView(jumperScrollView)
                            .setJumperFab(jumperFab)
                            .setSpeedScroll(2000)
                            .setAnimCloseTechnique(JumperAnimType.HINGE)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(this, "HInge", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);



        }

    }
}
