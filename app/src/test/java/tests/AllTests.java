package tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import objects.GroceryList;
import tests.business.AccessGroceryListIT;
import tests.business.AccessRecipesIT;
import tests.business.AccessRecipesTest;
import tests.objects.GroceryListTest;
import tests.objects.IngredientTest;
import tests.objects.RecipeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessRecipesIT.class,
        AccessGroceryListIT.class,
        AccessRecipesTest.class,
        RecipeTest.class,
        GroceryListTest.class,
        IngredientTest.class,
})
public class AllTests
{

}
