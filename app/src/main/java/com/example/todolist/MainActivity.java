package com.example.todolist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerview;
    private CategoryManager mCategoryManager = new CategoryManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Category> categories = mCategoryManager.retriveCategories();
        categoryRecyclerview =findViewById(R.id.catagory_recylerview);
        categoryRecyclerview.setAdapter(new CatagoryRecylerAdapter(categories));
        categoryRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Fab is tapped",Toast.LENGTH_LONG).show();
                displayCreateCategoryDialog();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayCreateCategoryDialog()
    {
        String alertTittle = getString(R.string.create_category);
        String positiveButtonTitle =getString(R.string.positive_button_tittle);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        EditText categoryEditext = new EditText(this);
        categoryEditext.setInputType(InputType.TYPE_CLASS_TEXT);

        alertBuilder.setTitle(alertTittle);
        alertBuilder.setView(categoryEditext);

        alertBuilder.setPositiveButton(positiveButtonTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Category category = new Category(categoryEditext.getText().toString() ,new ArrayList<String>());
                mCategoryManager.saveCatagory(category);

                CatagoryRecylerAdapter catagoryRecylerAdapter = (CatagoryRecylerAdapter) categoryRecyclerview.getAdapter();
                catagoryRecylerAdapter.addCategory(category);
                dialog.dismiss();
            }
        });
        alertBuilder.create().show();
    }
}