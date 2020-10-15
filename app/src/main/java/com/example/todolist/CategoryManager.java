package com.example.todolist;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class CategoryManager {

         private Context mContext;
         public CategoryManager(Context context)
         {
             mContext =context;
         }

         public void saveCatagory(Category category)
         {
             SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
             SharedPreferences.Editor editor = sharedPreferences.edit();

             HashSet itemHashset = new HashSet(Arrays.asList(category.getItems()));

             editor.putStringSet(category.getName(),itemHashset);
             editor.apply();
         }

         public ArrayList<Category> retriveCategories()
         {
             SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
             Map<String, ?> data = sharedPreferences.getAll();

             ArrayList<Category> categories = new ArrayList<>();

             for(Map.Entry<String, ? >entry : data.entrySet())
             {
                Category category = new Category(entry.getKey(), new ArrayList<String>((HashSet) entry.getValue()));
                categories.add(category);

             }
            return  categories;
         }

}
