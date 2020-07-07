package zulhijananda.com.jumperscroll;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import zulhijananda.com.jumperscroll.adapter.FoodAdapter;
import zulhijananda.com.jumperscroll.data.Food;
import zulhijananda.com.jumperscrollview.JumperAnimType;
import zulhijananda.com.jumperscrollview.JumperObject;

public class WithMaterialButtonActivity extends AppCompatActivity {

    private ArrayList listOfFoods = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_material_button);

        loadFood();

        RecyclerView recyclerView = findViewById(R.id.recyclerview_main);
        MaterialButton materialButton = findViewById(R.id.to_top);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            new JumperObject.Builder(this)
                    .setJumperRecyclerView(recyclerView)
                    .setCustomMaterialButton(materialButton)
                    .hideWhenScrollUp(true)
                    .setAnimStartTechnique(JumperAnimType.PERSONAL_USE_TRANLATION_Y_UP)
                    .setAnimCloseTechnique(JumperAnimType.PERSONAL_USE_TRANLATION_Y_BOTTOM)
                    .setSpeedScroll(2000)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
