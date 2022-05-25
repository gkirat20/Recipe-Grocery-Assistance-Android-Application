package tests.business;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import application.Main;
import business.AccessGroceryList;
import business.AccessRecipes;
import objects.Recipe;
import persistence.hsqldb.GroceryListPersistenceHSQLDB;
import persistence.hsqldb.RecipePersistenceHSQLDB;
import tests.persistence.GroceryPersistenceStub;
import tests.persistence.RecipePersistenceStub;
import persistence.GroceryListPersistence;

import static org.mockito.Mockito.*;

public class AccessGroceryListTest
{
    private AccessGroceryList accessGroceryList;
    private GroceryListPersistenceHSQLDB persistenceMock;
    private AccessGroceryList accessGroceryListMock;


    @Before
    public void setUp() {
    //    this.accessGroceryList = new AccessGroceryList(new GroceryPersistenceStub());

        //mock instantiations
        persistenceMock= Mockito.mock(GroceryListPersistenceHSQLDB.class);
        accessGroceryListMock = new AccessGroceryList(persistenceMock);

        //this.accessRecipes = new AccessRecipes(new RecipePersistenceHSQLDB(Main.getDBPathName()));
        //this.accessRecipes = new AccessRecipes(new RecipePersistenceHSQLDB(new File("src/main/assets/db/SC.script").getAbsolutePath().replace(".script", "")));
        //this.accessRecipes = new AccessRecipes();
    }
/*
    @Test
    public void test1()
    {
        final String item = accessGroceryList.getSequential();
        assertNotNull(item);
        assertTrue("Egg".equals(item));
//		assertTrue("The Best Classic Chilli".equals(recipe.getName()));
    }*/

  /*  @Test
    public void test2()
    {
        final List<String> items = accessGroceryList.getGroceryList();
        assertNotNull(items);
        assertTrue(3 == (items.size()));
    }*/

   @Test
    public void testGroceryListMock()
    {
        //final List<String> items = Arrays.asList("food1");
        final List<String> items = new ArrayList<String>();
        items.add("food1");
        items.add("food2");
        items.add("food3");

        when(persistenceMock.getGroceryList()).thenReturn((ArrayList<String>) items);

        System.out.println(accessGroceryListMock.getGroceryList());
        System.out.println(persistenceMock.getGroceryList());

        List<String> items1 = accessGroceryListMock.getGroceryList();
        System.out.println(items1);
        assertNotNull(persistenceMock.getGroceryList());
        assertTrue((items1.size()) == 3);
        assertTrue(items1.contains(items.get(1)));
        assertEquals(items.get(0),accessGroceryListMock.getGroceryList().get(0));
        //Mockito.verify(persistenceMock).getGroceryList();

    }






}
