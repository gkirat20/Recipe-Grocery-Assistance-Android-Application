package presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.recipeapp.R;

import java.util.ArrayList;
import java.util.List;

import business.AccessRecipes;
import objects.Ingredient;
import objects.Recipe;

public class RecipeAddActivity extends AppCompatActivity implements ReturnIngredientInterface {

    private ArrayList<Ingredient> ingredientList;
    private ArrayAdapter<Ingredient> ingredientArrayAdapter;
    private ArrayAdapter<String> categoryArrayAdapter;
    private AccessRecipes accessRecipes;

    private Recipe myRecipe;
    private String id = "";
    private EditText name;
    private EditText description;
    private EditText skillLevel;
    private EditText prepTime;
    private EditText cookTime;
    private Spinner categories;
    private EditText instructions;
    private  String[] myCategories = new String[]{"Appetizer","Dessert","Entree","Soup"};

    final int MAX_STRING_LENGTH = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_add);

        name = findViewById(R.id.recipeName);
        description = findViewById(R.id.recipeDesc);
        skillLevel = findViewById(R.id.recipeSkill);
        prepTime = findViewById(R.id.recipePrep);
        cookTime = findViewById(R.id.recipeCook);
        categories = findViewById(R.id.categories);

        instructions = findViewById(R.id.recipeInstructions);
        accessRecipes = new AccessRecipes();
        ingredientList = new ArrayList<>();
        categoryArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, myCategories);
        categories.setAdapter(categoryArrayAdapter);

        //Make an arrayadapter wrapper
        ingredientArrayAdapter = new ArrayAdapter<Ingredient>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, ingredientList);
        final ListView listView = findViewById(R.id.ingredientList);
        listView.setAdapter(ingredientArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                new AlertDialog.Builder(RecipeAddActivity.this)
                        .setTitle("Delete Ingredient")
                        .setMessage("Do you really want to delete " + ingredientList.get(position).getIngredientName() + "?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                ingredientList.remove(position);
                                ingredientArrayAdapter.notifyDataSetChanged();
                                setIngredientListHeight();

                            }})
                        .setNegativeButton(android.R.string.no, null).show();

            }
        });


        //If a bundle was passed through
        if(getIntent().getExtras() != null)
        {
            myRecipe = (Recipe) getIntent().getSerializableExtra("recipe");

            name.setText(myRecipe.getName());
            description.setText(myRecipe.getDescription());
            skillLevel.setText(myRecipe.getCookingSkillLevel());
            prepTime.setText(String.valueOf(myRecipe.getPrepTime()));
            cookTime.setText(String.valueOf(myRecipe.getCookTime()));
            ingredientList.addAll(myRecipe.getIngredientList());
            ingredientArrayAdapter.notifyDataSetChanged();

            if(myRecipe.getInstructions() != null) {
                String newInstuctions = myRecipe.getInstructions().replace("$", "\n");
                instructions.setText(newInstuctions);
            }
            for(int i = 0; i < myCategories.length; i++)
            {
                if(myRecipe.getCategoryList().contains(myCategories[i]))
                    categories.setSelection(i);
            }

            id = myRecipe.getRecipeID();
        }

    }

    public void buttonAddIngredientOnClick(View v)
    {
        IngredientFragment newFragment = new IngredientFragment();
        newFragment.show(getSupportFragmentManager(), "game");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recipe_add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onSelectedData(Ingredient ing) {
        //Check if ingredient is already in recipe
        boolean alreadyIn = false;

        for(int i = 0; i < ingredientList.size(); i++)
        {
            if(ing.getIngredientName().equals(ingredientList.get(i).getIngredientName()))
            {
                Toast.makeText(this, "Ingredient already in list", Toast.LENGTH_SHORT).show();
                alreadyIn = true;
            }
        }

        if(!alreadyIn) {
            //get array adapter, add new item to it, reset listview
            ingredientList.add(ing);
            //ingredientArrayAdapter = new ArrayAdapter<Ingredient>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, ingredientList);
            ingredientArrayAdapter.notifyDataSetChanged();
            setIngredientListHeight();
        }
    }

    public void addRecipeButtonClick(MenuItem item)
    {
        //If name and instructions are not empty
        if(!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(instructions.getText().toString()))
        {
            String formattedInstructions = instructions.getText().toString();
            formattedInstructions = formattedInstructions.replace("\n","$");

            ArrayList<String> newCategories = new ArrayList<>();
            newCategories.add(categories.getSelectedItem().toString());

            //Check if numbers are within range
            if(checkInt(prepTime.getText().toString()) && checkInt(cookTime.getText().toString())) {

                Recipe newRecipe = new Recipe(id, truncateText(name.getText().toString(), 40), null, ingredientList, Integer.parseInt(prepTime.getText().toString()), Integer.parseInt(cookTime.getText().toString()), truncateText(skillLevel.getText().toString(), 15), truncateText(description.getText().toString(),2000), truncateText(instructions.getText().toString(),2000), null, newCategories);

                if(myRecipe != null)
                {
                    accessRecipes.updateRecipe(newRecipe);
                }
                else
                {
                    accessRecipes.insertRecipe(newRecipe);
                }

                finish();
            }
        }
        else if(TextUtils.isEmpty(name.getText().toString()))
        {
            Toast.makeText(RecipeAddActivity.this, "Please fill in a name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(instructions.getText().toString()))
        {
            Toast.makeText(RecipeAddActivity.this, "Please fill in some instructions", Toast.LENGTH_SHORT).show();
        }

    }

    private void setIngredientListHeight()
    {
        final ListView listView = findViewById(R.id.ingredientList);
        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) listView.getLayoutParams();
        lp.height = 500 + 500 * ingredientList.size();
        listView.setLayoutParams(lp);

    }

    private boolean checkInt(String s)
    {
        boolean returnVal = true;

        if(!TextUtils.isEmpty(s)) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Time too long", Toast.LENGTH_SHORT).show();
                returnVal = false;
            }
        }
        else
        {
            Toast.makeText(this, "Fill in a time", Toast.LENGTH_SHORT).show();
            returnVal = false;
        }
        return returnVal;
    }

    private String truncateText(String s, int maxLength)
    {
        String returnVal = s;

        if(returnVal.length() > maxLength)
            returnVal = returnVal.substring(0,maxLength-3) + "...";

        return returnVal;
    }
}