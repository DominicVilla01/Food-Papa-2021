package com.example.foodpapa2021.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodpapa2021.CategoryPage;
import com.example.foodpapa2021.R;
import com.example.foodpapa2021.realm.CategoryList;

import javax.annotation.Nullable;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class CategoryAdapter extends RealmRecyclerViewAdapter<CategoryList, CategoryAdapter.ViewHolder> {
    CategoryPage activity;

    public CategoryAdapter(CategoryPage activity, @Nullable OrderedRealmCollection<CategoryList> data, boolean autoUpdate){
        super(data, autoUpdate);
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView rating;
        TextView del_time;
        TextView res_cat;
        ConstraintLayout catObj;

        public ViewHolder(@NonNull View categoryView){
            super(categoryView);

            img = categoryView.findViewById(R.id.cat_img);
            name = categoryView.findViewById(R.id.cat_title);
            rating = categoryView.findViewById(R.id.cat_ratings);
            del_time = categoryView.findViewById(R.id.cat_delivery_time);
            res_cat = categoryView.findViewById(R.id.cat_cat);
            catObj = categoryView.findViewById(R.id.cat_obj);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = activity.getLayoutInflater().inflate(R.layout.category_objects, parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        CategoryList cat = getItem(position);

        holder.name.setText(cat.getCat_name());
        holder.rating.setText(cat.getCat_rating());
        holder.res_cat.setText(cat.getCat_cat());
        holder.del_time.setText(cat.getCat_time_distance());

        //Fast Food
        if(cat.getCat_name().equals("Jollibee"))
        {
            holder.img.setImageResource(R.drawable.jollibee_logo);
        }
        else if(cat.getCat_name().equals("McDo"))
        {
            holder.img.setImageResource(R.drawable.mcdo_logo);
        }
        else if(cat.getCat_name().equals("KFC"))
        {
            holder.img.setImageResource(R.drawable.kfc_logo);
        }
        else if(cat.getCat_name().equals("Wendy's"))
        {
            holder.img.setImageResource(R.drawable.wendys_logo);
        }
        else if(cat.getCat_name().equals("Popeyes"))
        {
            holder.img.setImageResource(R.drawable.popeyes_logo);
        }
        //Milk Tea
        else if(cat.getCat_name().equals("CoCo Fresh Tea & Juice"))
        {
            holder.img.setImageResource(R.drawable.coco_logo);
        }
        else if(cat.getCat_name().equals("Gongcha"))
        {
            holder.img.setImageResource(R.drawable.gongcha_logo);
        }
        else if(cat.getCat_name().equals("Serenitea"))
        {
            holder.img.setImageResource(R.drawable.serenitea_logo);
        }
        else if(cat.getCat_name().equals("Macao Imperial Tea"))
        {
            holder.img.setImageResource(R.drawable.macao_logo);
        }
        else if(cat.getCat_name().equals("Tiger Sugar"))
        {
            holder.img.setImageResource(R.drawable.tiger_logo);
        }

        //Fast-Casual Category
        else if(cat.getCat_name().equals("TGI Fridays"))
        {
            holder.img.setImageResource(R.drawable.tgif_logo);
        }
        else if(cat.getCat_name().equals("Outback Steakhouse"))
        {
            holder.img.setImageResource(R.drawable.outback_logo);
        }
        else if(cat.getCat_name().equals("Claw Daddy"))
        {
            holder.img.setImageResource(R.drawable.clawdaddy_logo);
        }
        else if(cat.getCat_name().equals("Italianni's"))
        {
            holder.img.setImageResource(R.drawable.italiannis_logo);
        }
        else if(cat.getCat_name().equals("Racks"))
        {
            holder.img.setImageResource(R.drawable.racks_logo);
        }
        holder.catObj.setTag(cat);
        holder.catObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.catObj((CategoryList) v.getTag());
            }
        });
    }
}
