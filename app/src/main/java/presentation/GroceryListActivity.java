package presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.recipeapp.R;

import java.util.ArrayList;

import business.AccessGroceryList;
import objects.Recipe;
import persistence.GroceryList;

public class GroceryListActivity extends AppCompatActivity {

    private AccessGroceryList accessGroceries;
    ArrayList<String> groceryList = null;
    ListView groceryListView;
    ArrayAdapter myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Create a grocery list and give GUI the array list
        groceryList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        accessGroceries = new AccessGroceryList();

        groceryList = new ArrayList<>();
        groceryList.addAll(accessGroceries.getGroceryList());

        //Make an arrayadapter wrapper
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, groceryList);

        final ListView groceryListView = findViewById(R.id.groceryListView);
        groceryListView.setAdapter(myArrayAdapter);

        groceryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                PopupMenu popUpMenu = new PopupMenu(GroceryListActivity.this, view);
                popUpMenu.getMenuInflater().inflate(R.menu.grocery_pop_up_menu, popUpMenu.getMenu());

                popUpMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.item_update:
                                AlertDialog.Builder builder = new AlertDialog.Builder(GroceryListActivity.this);
                                View v = LayoutInflater.from(GroceryListActivity.this).inflate(R.layout.item_dialogue,null,false);
                                builder.setTitle("Update Item");
                                EditText editText = v.findViewById(R.id.etItem);
                                editText.setText(groceryList.get(position));

                                builder.setView(v);
                                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if (!editText.getText().toString().isEmpty()) {
                                            groceryList.set(position, editText.getText().toString().trim());
                                            myArrayAdapter.notifyDataSetChanged();
                                            Toast.makeText(GroceryListActivity.this, "Item Updated!", Toast.LENGTH_SHORT);
                                        } else {
                                            editText.setError("Enter item");
                                        }
                                    }
                                });

                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });

                                builder.show();
                                break;

                            case R.id.item_delete:

                                Toast.makeText(GroceryListActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                                accessGroceries.deleteItem(groceryList.get(position));
                                groceryList.remove(position);
                                myArrayAdapter.notifyDataSetChanged();
                                break;

                        }

                        return true;
                    }
                });

                popUpMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grocery_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.printItemButton:
                addToList();
                break;
        }

        return true;
    }

    private void addToList() {
        AlertDialog.Builder builder = new AlertDialog.Builder(GroceryListActivity.this);
        builder.setTitle("Add Item");

        View v = LayoutInflater.from(GroceryListActivity.this).inflate(R.layout.item_dialogue, null, false);

        builder.setView(v);
        final EditText etItem = v.findViewById(R.id.etItem);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (!etItem.getText().toString().isEmpty()) {
                    groceryList.add(etItem.getText().toString().trim());
                    accessGroceries.insertItem(etItem.getText().toString().trim());
                    myArrayAdapter.notifyDataSetChanged();
                } else {
                    etItem.setError("Enter item");
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }
}