package tests.business;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import business.AccessRecipes;
import objects.Recipe;
import persistence.RecipePersistence;
import persistence.hsqldb.RecipePersistenceHSQLDB;
import tests.persistence.RecipePersistenceStub;

public class AccessRecipesTest
{
	private AccessRecipes accessRecipes;

	@Before
	public void setUp() {
		RecipePersistence recipePersistenceMock = mock(RecipePersistenceHSQLDB.class);

		// Set up mock recipes for the recipePersistenceMock to get
		Recipe mock_recipe1 = mock(Recipe.class);
		Recipe mock_recipe2 = mock(Recipe.class);
//		Recipe mock_recipe3 = mock(Recipe.class);
		List<Recipe> recipeList = new ArrayList<>();
		recipeList.add(mock_recipe1);
		recipeList.add(mock_recipe2);

		// Set up what the mock recipe will return when it's functions are called
		when(mock_recipe1.getRecipeID()).thenReturn("4");
		when(mock_recipe1.getName()).thenReturn("Easy cake");

		// Set up what the recipePersistenceMock will return when it's functions are called
		when(recipePersistenceMock.getRecipes()).thenReturn(recipeList);
		when(recipePersistenceMock.getRecipe(any(Recipe.class))).thenReturn(mock_recipe1);

		this.accessRecipes = new AccessRecipes(recipePersistenceMock);

		// This is to test using the stub
//	    this.accessRecipes = new AccessRecipes(new RecipePersistenceStub());

		// This is to test using the real persistent database
//		this.accessRecipes = new AccessRecipes(new RecipePersistenceHSQLDB(Main.getDBPathName()));
//		this.accessRecipes = new AccessRecipes(new RecipePersistenceHSQLDB(new File("src/main/assets/db/SC.script").getAbsolutePath().replace(".script", "")));
//		this.accessRecipes = new AccessRecipes();
	}

	@Test
	public void testGettingSequentialRecipe()
	{
		final Recipe recipe = accessRecipes.getSequential();
		assertNotNull(recipe);

		// This is for stub and mock
		assertEquals("4", recipe.getRecipeID());

		// This is for the real persistent database
//		assertTrue("The Best Classic Chilli".equals(recipe.getName()));
	}

	@Test
	public void testGettingAllRecipes()
	{
		final List<Recipe> recipes = accessRecipes.getRecipes();
		assertNotNull(recipes); // This should still be good for the Mock test, if the Mock object is not null
		System.out.println(recipes);
		// This is for stub and mock
		assertTrue(2 == (recipes.size()));

	}

	@Test
	public void testGettingOneRecipe()
	{
		final Recipe first_recipe = accessRecipes.getSequential();
		final Recipe recipe = accessRecipes.getRecipe(first_recipe);
		assertNotNull(recipe);

		// This is for stub and mock
		assertEquals("Easy cake", recipe.getName());

		// This is for the real persistent database
//		assertTrue("The Best Classic Chilli".equals(recipe.getName()));
	}
}
