package tests.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import business.AccessGroceryList;
import persistence.GroceryListPersistence;
import persistence.hsqldb.GroceryListPersistenceHSQLDB;
import tests.utils.TestUtils;

public class AccessGroceryListIT {
    private AccessGroceryList accessGroceryList;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final GroceryListPersistence persistence = new GroceryListPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessGroceryList = new AccessGroceryList(persistence);
    }

    @Test
    public void testListItems() {
        final String item;

        item = accessGroceryList.getSequential();
        assertNotNull("first sequential recipe should not be null", item);
        assertTrue("milk".equals(item));

        System.out.println("Finished test AccessRecipes");
    }

    @Test
    public void testGetGroceryList() {
        final List<String> groceryList = accessGroceryList.getGroceryList();
        assertEquals(4, groceryList.size());
    }

    @Test
    public void testDeleteItem() {
        final String item = accessGroceryList.getSequential();
        List<String> groceryList = accessGroceryList.getGroceryList();
        assertEquals(4, groceryList.size());
        accessGroceryList.deleteItem(item);
        groceryList = accessGroceryList.getGroceryList();
        assertEquals(3, groceryList.size());
    }

    @Test
    public void testInsertItem() {
        accessGroceryList.insertItem("VINEGAR");
        assertEquals(5, accessGroceryList.getGroceryList().size());
    }

    @Test
    public void testInsertDuplicate() {
        String insertItem1 = accessGroceryList.insertItem("VINEGAR");
        String insertItem2 = accessGroceryList.insertItem("VINEGAR");
        assertEquals(5, accessGroceryList.getGroceryList().size());
        assertTrue(insertItem2.split(":")[0].equals("Note"));
    }

    @Test
    public void testUpdateItem() {
        final String item = accessGroceryList.getSequential();
        accessGroceryList.updateItem(item, "Random Item");
        assertEquals(4, accessGroceryList.getGroceryList().size());
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
