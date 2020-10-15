package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatagoryRecylerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

   // String [] categories ={"Hobbies","Sports","Games","Food","Country"};
    private ArrayList<Category> categories;

    public CatagoryRecylerAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_viewholder,parent,false);


        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.getTxtCatgoryNumber().setText(Integer.toString(position + 1 ));
        holder.getTxtCatagoryName().setText(categories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void addCategory(Category category)
    {
        categories.add(category);
        notifyItemInserted(categories.size()-1);
    }
}
