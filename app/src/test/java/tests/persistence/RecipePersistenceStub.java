package tests.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import objects.Ingredient;
import objects.Recipe;
import persistence.RecipePersistence;

public class RecipePersistenceStub implements RecipePersistence {
    private List<Recipe> recipes;

    public RecipePersistenceStub() {
        this.recipes =new ArrayList<>();
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        Ingredient ingredient = new Ingredient("fish", "10", "bro", "nothing");
        Ingredient ingredient2 = new Ingredient("nom", "10", "bro", "nothing");
        Ingredient ingredient3 = new Ingredient("fsh", "10", "bro", "nothing");
        Ingredient ingredient4 = new Ingredient("ish", "10", "bro", "nothing");
        ingredientList.add(ingredient);
        ingredientList.add(ingredient2);
        ingredientList.add(ingredient3);
        ingredientList.add(ingredient4);


        ArrayList<String> categoryList = new ArrayList<String>();
        categoryList.add("Dessert");

        recipes.add(new Recipe("4", "Easy cake", "US", ingredientList, 5, 10, "Easy", "Too easy", "Mix everything together. Eat it.", "MEME", categoryList));
        recipes.add(new Recipe("5", "Difficult cake", "US", ingredientList, 5, 20, "Hard", "Too hard", "Mix everything together. Don't eat it.", "LMAO", categoryList));
    }

    @Override
    public List<Recipe> getRecipes() {
        return Collections.unmodifiableList(recipes);
    }

    @Override
    public Recipe getRecipe(Recipe currentRecipe) {
        return currentRecipe;
    }

    public Recipe insertRecipe(Recipe currentRecipe) {
        recipes.add(currentRecipe);
        return currentRecipe;
    }

    public Recipe updateRecipe(Recipe currentRecipe) {
        int index;

        index = recipes.indexOf(currentRecipe);
        if (index >= 0)
        {
            recipes.set(index, currentRecipe);
        }
        return currentRecipe;
    }

    public void deleteRecipe(Recipe currentRecipe) {
        int index;

        index = recipes.indexOf(currentRecipe);
        if (index >= 0)
        {
            recipes.remove(index);
        }
    }
}
