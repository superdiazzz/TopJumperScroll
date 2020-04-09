package zulhijananda.com.jumperscroll.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import zulhijananda.com.jumperscroll.R;
import zulhijananda.com.jumperscroll.data.Food;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Food> foods;


    public FoodAdapter(ArrayList<Food> foods){
        this.foods = foods;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_food, viewGroup, false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {

        Food currentFood = foods.get(i);

        foodViewHolder.title.setText(currentFood.getName());
        foodViewHolder.img.setImageResource(currentFood.getImage());

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.text);
        }
    }
}
