package persistence;
/*
Comp 3350 Software Engineering
Group 8
February 28, 2022
persistence.GroceryList.java

Private member:
groceryList - Linked list of the ingredients.

Public method:
persistence.GroceryList() - Constructor to initialize the linked list.
addIngredient() - Add the given string ingredient to the list.
removeIngredient() - Remove the given index of the ingredient from the list.
getIngredient() - Get the ingredient from a given index.
numIngredients() - Number of ingredients in the grocery list.
getArrayList() - Get the array list data structure implementation.
*/

import java.util.ArrayList;

public class GroceryList
{
    // Private member
    private final ArrayList<String> groceryList;

    // Public method

    /* persistence.GroceryList()
     */
    public GroceryList()
    {
        groceryList = new ArrayList<String>();
    }

    /* addIngredient()
    Parameter:
    newIngredient - The given ingredient string to append to the grocery list.
    */
    public void addIngredient(String newIngredient)
    {
        if (newIngredient != null)
        {
            groceryList.add(newIngredient);
        }
    }

    /* removeIngredient()
    Parameter:
    index - Remove the ingredient at given index. Do nothing if element at given
        index does not exist.
    */
    public void removeIngredient(int index) throws IndexOutOfBoundsException
    {
        // Remove the ingredient at given index
        if(index < groceryList.size() && index >= 0)
        {
            groceryList.remove(index);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /* getIngredient()
    Parameter:
    index - The index of the ingredient in the grocery list.

    Return:
    String ingredient at given index in the grocery list.
    Null if the given index is invalid.
    */
    public String getIngredient(int index) throws IndexOutOfBoundsException
    {
        // Get the ingredient string from the grocery list
        String returnIngredient = null;
        if (index < groceryList.size() && index >= 0)
        {
            returnIngredient = groceryList.get(index);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }

        // Return
        return returnIngredient;
    }

    /* numIngredients()
    Return:
    Number of ingredient elements in the grocery list.
    */
    public int numIngredients()
    {
        return this.groceryList.size();
    }

    /* getArrayList()
    Return:
    The array list data structure of the grocery list.
    This will be use for the GUI to update the items in the grocery list.
    */
    public ArrayList<String> getArrayList()
    {
        return this.groceryList;
    }

}
