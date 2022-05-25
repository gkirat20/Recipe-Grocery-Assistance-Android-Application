package tests.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import afu.org.checkerframework.checker.igj.qual.I;
import objects.Ingredient;

public class IngredientTest {
    @Test
    public void teStringTest() {
        Ingredient ingredient;
        String ingredientString = "shitton gram(s)\t\tground pork (null)";

        ingredient = new Ingredient("ground pork", "shitton", "gram(s)", "null");
        assertNotNull(ingredient);
        assertTrue("ground pork".equals(ingredient.getIngredientName()));
        assertTrue("shitton".equals(ingredient.getQuantity()));
        assertTrue("gram(s)".equals(ingredient.getUnit()));
        assertTrue("ground pork".equals(ingredient.getIngredientName()));
        assertTrue("null".equals(ingredient.getNote()));
        assertTrue(ingredientString.equals(ingredient.toString()));
    }

}
