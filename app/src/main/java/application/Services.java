package application;

import objects.GroceryList;
import persistence.GroceryListPersistence;
import persistence.RecipePersistence;
import persistence.hsqldb.GroceryListPersistenceHSQLDB;
import persistence.hsqldb.RecipePersistenceHSQLDB;

public class Services
{
    private static RecipePersistence recipePersistence = null;
    private static GroceryListPersistence groceryListPersistence = null;

    public static synchronized RecipePersistence getRecipePersistence()
    {
        if (recipePersistence == null)
        {
            //recipePersistence = new RecipePersistenceStub();
            recipePersistence = new RecipePersistenceHSQLDB(Main.getDBPathName());
        }

        return recipePersistence;
    }

    public static synchronized GroceryListPersistence getGroceryListPersistence()
    {
        if (groceryListPersistence == null)
        {
            //recipePersistence = new RecipePersistenceStub();
            groceryListPersistence = new GroceryListPersistenceHSQLDB(Main.getDBPathName());
        }

        return groceryListPersistence;
    }
}
