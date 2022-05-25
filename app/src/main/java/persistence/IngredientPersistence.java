package persistence;

import java.util.ArrayList;
import java.util.List;

import objects.Ingredient;
import objects.Recipe;

public interface IngredientPersistence {

    ArrayList<Ingredient> getRecipeIngredients(String recipeID); //Returns the list of ingredients with quantity, unit and note for a certain recipe

//    Ingredient getIngredient(); //Do we need this?
//
//    Ingredient insertIngredient(Ingredient currentIngredient);
//
//    Ingredient updateIngredient();
//
//    void deleteIngredient();
}
