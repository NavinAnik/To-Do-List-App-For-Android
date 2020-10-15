package com.example.todolist;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private TextView txtCatgoryNumber;
    private  TextView txtCatagoryName;
    public CategoryViewHolder(View view)
    {
        super(view);

        txtCatgoryNumber = view.findViewById(R.id.category_number_textview);
        txtCatagoryName = view.findViewById(R.id.Catageory_name_textview);

    }

    public TextView getTxtCatgoryNumber() {
        return txtCatgoryNumber;
    }

    public TextView getTxtCatagoryName() {
        return txtCatagoryName;
    }
}
