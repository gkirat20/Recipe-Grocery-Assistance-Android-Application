package tests.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.ArrayList;

import objects.GroceryList;

public class GroceryListTest{

   @Test
   public void groceryTest1() {
       GroceryList Grocery;
       GroceryList grocList;

       System.out.println("\nStarting Grocery\n");
       ArrayList<String> groceryItems = new ArrayList<String>();
       groceryItems.add("sugar");
       groceryItems.add("salt");
       groceryItems.add("oil");


       Grocery = new GroceryList(groceryItems);
       grocList = new GroceryList();

       //check if the object is not null after creation
       assertNotNull(Grocery);
       assertNotNull(grocList);
       assertTrue(groceryItems.equals(Grocery.getGroceryList()));

       ArrayList<String> groceryItems2 = new ArrayList<String>();
       groceryItems2.add("pepper");
       groceryItems2.add("spice");

       assertFalse(groceryItems2.equals(Grocery.getGroceryList()));
       assertFalse(groceryItems2.equals(groceryItems));

       groceryItems2.removeAll(groceryItems2);
       groceryItems2.add("sugar");
       groceryItems2.add("salt");
       groceryItems2.add("oil");
       assertTrue(groceryItems2.equals(Grocery.getGroceryList()));

       System.out.println("\nEnding Grocery Test\n");

   }

}
