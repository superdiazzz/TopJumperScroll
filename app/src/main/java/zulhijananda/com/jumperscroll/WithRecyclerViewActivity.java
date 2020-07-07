package zulhijananda.com.jumperscroll;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

import zulhijananda.com.jumperscroll.adapter.FoodAdapter;
import zulhijananda.com.jumperscroll.data.Food;
import zulhijananda.com.jumperscrollview.JumperAnimType;
import zulhijananda.com.jumperscrollview.JumperFab;
import zulhijananda.com.jumperscrollview.JumperObject;

public class WithRecyclerViewActivity extends AppCompatActivity {

    private ArrayList listOfFoods = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);


        loadFood();

        RecyclerView recyclerView = findViewById(R.id.recyclerview_main);
        JumperFab jumperFab = findViewById(R.id.jumperFab);
        //ExtendedFloatingActionButton fab = findViewById(R.id.totop_btn);

        jumperFab.setJumperFabCallback(new JumperFab.JumperFabCallback() {
            @Override
            public void fabOnClick() {
                Toast.makeText(WithRecyclerViewActivity.this, "Kepanggil", Toast.LENGTH_SHORT).show();
            }
        });
        
        try {

            // With JumperFAB
            new JumperObject.Builder(this)
                    .setJumperRecyclerView(recyclerView)
                    .setJumperFab(jumperFab)
                    .hideWhenScrollUp(false)
                    .setAnimStartTechnique(JumperAnimType.PERSONAL_USE_TRANLATION_Y_UP)
                    .setAnimCloseTechnique(JumperAnimType.PERSONAL_USE_TRANLATION_Y_BOTTOM)
                    .setSpeedScroll(2000)
                    .build();

            // With Material Button

//            new JumperObject.Builder(this)
//                    .setJumperRecyclerView(recyclerView)
//                    .setCustomMaterialButton(fab)
//                    .setSpeedScroll(3000)
//                    .setDisplayThreshold(15)
//                    .hideWhenScrollUp(true)
//                    .setAnimStartTechnique(JumperAnimType.LANDING)
//                    .setAnimCloseTechnique(JumperAnimType.FADEOUTDOWN)
//                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FoodAdapter adapter = new FoodAdapter(listOfFoods);
        recyclerView.setAdapter(adapter);



    }

    private void loadFood() {

        // load food
        listOfFoods.add(new Food("Coffe", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.coffee_pot));
        listOfFoods.add(new Food("Esspresso", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.espresso));
        listOfFoods.add(new Food("Friech fries", "Heat of inches of vegetable oil", R.drawable.french_fries));
        listOfFoods.add(new Food("Honey", "I love this, pour to your cup", R.drawable.honey));
        listOfFoods.add(new Food("Strawberry", "So this is what harvested every springs", R.drawable.strawberry_ice_cream));
        listOfFoods.add(new Food("Sugar cube", "This is so sweets!", R.drawable.sugar_cubes));
        listOfFoods.add(new Food("Coffe", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.coffee_pot));
        listOfFoods.add(new Food("Esspresso", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.espresso));
        listOfFoods.add(new Food("Friech fries", "Heat of inches of vegetable oil", R.drawable.french_fries));
        listOfFoods.add(new Food("Honey", "I love this, pour to your cup", R.drawable.honey));
        listOfFoods.add(new Food("Honey", "I love this, pour to your cup", R.drawable.honey));
        listOfFoods.add(new Food("Strawberry", "So this is what harvested every springs", R.drawable.strawberry_ice_cream));
        listOfFoods.add(new Food("Sugar cube", "This is so sweets!", R.drawable.sugar_cubes));
        listOfFoods.add(new Food("Coffe", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.coffee_pot));
        listOfFoods.add(new Food("Coffe", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.coffee_pot));
        listOfFoods.add(new Food("Esspresso", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.espresso));
        listOfFoods.add(new Food("Friech fries", "Heat of inches of vegetable oil", R.drawable.french_fries));
        listOfFoods.add(new Food("Honey", "I love this, pour to your cup", R.drawable.honey));
        listOfFoods.add(new Food("Coffe", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.coffee_pot));
        listOfFoods.add(new Food("Esspresso", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.espresso));
        listOfFoods.add(new Food("Friech fries", "Heat of inches of vegetable oil", R.drawable.french_fries));
        listOfFoods.add(new Food("Honey", "I love this, pour to your cup", R.drawable.honey));
        listOfFoods.add(new Food("Coffe", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.coffee_pot));
        listOfFoods.add(new Food("Esspresso", "Kopi tora bika ala kapucino ya ya ya ahoy", R.drawable.espresso));
        listOfFoods.add(new Food("Friech fries", "Heat of inches of vegetable oil", R.drawable.french_fries));
        listOfFoods.add(new Food("Honey", "I love this, pour to your cup", R.drawable.honey));
        listOfFoods.add(new Food("Strawberry", "So this is what harvested every springs", R.drawable.strawberry_ice_cream));
        listOfFoods.add(new Food("Sugar cube", "This is so sweets!", R.drawable.sugar_cubes));
    }
}
