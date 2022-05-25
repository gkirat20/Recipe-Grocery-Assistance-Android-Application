package tests.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

import objects.Ingredient;
import objects.Recipe;

public class RecipeTest {
    @Test
    public void testRecipe1() {
        Recipe recipe;
        Recipe recipe1;

        System.out.println("\nStarting testRecipe");

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

        recipe = new Recipe("4", "Easy cake", "US", ingredientList, 5, 10, "Easy", "Too easy", "Mix everything together. Eat it.", "MEME", categoryList);
        assertNotNull(recipe);
        assertEquals("4", recipe.getRecipeID());
        assertTrue("Easy cake".equals(recipe.getName()));
        assertTrue("US".equals(recipe.getNationality()));
        assertTrue(ingredientList.equals(recipe.getIngredientList()));
        assertTrue(5 == recipe.getPrepTime());
        assertTrue(10 == recipe.getCookTime());
        assertTrue("Easy".equals(recipe.getCookingSkillLevel()));
        assertTrue("Too easy".equals(recipe.getDescription()));
        assertTrue("Mix everything together. Eat it.".equals(recipe.getInstructions()));
        assertTrue("MEME".equals(recipe.getLink()));
        assertTrue(categoryList.equals(recipe.getCategoryList()));

        recipe1 = new Recipe("Random");
        assertNotNull(recipe);
        assertEquals("Random", recipe1.getRecipeID());

        System.out.println("Finished testStudent");
    }
}
