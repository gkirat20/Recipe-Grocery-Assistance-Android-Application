package presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.recipeapp.R;

import java.util.ArrayList;
import java.util.List;

import business.AccessRecipes;
import objects.Recipe;


public class RecipeListActivity extends AppCompatActivity {

    private AccessRecipes accessRecipes;
    private List<Recipe> recipeList;
    private List<String> recipeNames;
    private ArrayAdapter<Recipe> recipeArrayAdapter;
    private int previousButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        previousButtonId = -1;

        accessRecipes = new AccessRecipes();
        setList();
    }

    private void setList()
    {
        try
        {
            recipeList = new ArrayList<>();
            recipeList.addAll(accessRecipes.getRecipes());

            recipeNames = new ArrayList<>();
            for(int i = 0; i < recipeList.size(); i++)
            {
                recipeNames.add(recipeList.get(i).getName());
            }

            //Make an arrayadapter wrapper
            recipeArrayAdapter = new ArrayAdapter<Recipe>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, recipeList);

            final ListView listView = findViewById(R.id.listRecipes);
            listView.setAdapter(recipeArrayAdapter);

            listView.setOnItemClickListener((adapterView, view, position, l) -> {
                Recipe item = (Recipe)adapterView.getItemAtPosition(position);

                Intent recipeIntent = new Intent(RecipeListActivity.this,RecipeViewerActivity.class);
                recipeIntent.putExtra("recipe",item);
                startActivity(recipeIntent);

            });

        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        setList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recipe_list_menu, menu);

        searchBar(menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void buttonAddRecipeClick(MenuItem item)
    {
        Intent addIntent = new Intent(RecipeListActivity.this, RecipeAddActivity.class);
        RecipeListActivity.this.startActivity(addIntent);
    }

    public void buttonFilterOnClick(View v)
    {
        RadioButton button = (RadioButton) findViewById(v.getId());
        String name = (String) button.getText();

        if(previousButtonId != v.getId())
        {
            categoryFilters(name);
            previousButtonId = v.getId();
        }
        else
        {
            System.out.println(previousButtonId);

            resetFilter();
            RadioGroup buttons = findViewById(R.id.category_radio_group);
            buttons.clearCheck();
            previousButtonId = -1;
        }
    }

    private void categoryFilters(String filter)
    {
        List<Recipe> newRecipeList = new ArrayList<>();

        for(int i = 0; i < recipeList.size(); i++)
        {
            if(recipeList.get(i).getCategoryList().contains(filter))
            {
                newRecipeList.add(recipeList.get(i));
            }
        }

        recipeArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, newRecipeList);
        final ListView listView = findViewById(R.id.listRecipes);
        listView.setAdapter(recipeArrayAdapter);
    }

    private void resetFilter()
    {
        recipeArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, recipeList);
        final ListView listView = findViewById(R.id.listRecipes);
        listView.setAdapter(recipeArrayAdapter);

    }

    private void searchBar(Menu menu)
    {
        // Initialise search bar
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

        // attach setOnQueryTextListener to search view
        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        //If the list contains a recipe name containing the query, then filter it
                        if (recipeNames.contains(query)) {
                            recipeArrayAdapter.getFilter().filter(query);
                        }
                        else {
                            // Little pop up when nothing is found
                            Toast.makeText(RecipeListActivity.this,"Recipe Not found",Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }

                    //Filters while the user is typing, not just when it's entered
                    @Override
                    public boolean onQueryTextChange(String newText)
                    {
                        recipeArrayAdapter.getFilter().filter(newText);
                        return false;
                    }
                });

    }

}
