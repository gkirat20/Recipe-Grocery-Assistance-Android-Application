package business;

import java.util.Collections;
import java.util.List;

import application.Services;
import persistence.GroceryListPersistence;

public class AccessGroceryList {
    private GroceryListPersistence groceryListPersistence;
    private List<String> groceryList;
    private String item;
    private int currentItem;

    public AccessGroceryList() {
        groceryListPersistence = Services.getGroceryListPersistence();
        groceryList = null;
        item = null;
        currentItem = 0;
    }

    public AccessGroceryList(final GroceryListPersistence groceryListPersistence) {
        this();
        this.groceryListPersistence = groceryListPersistence;
    }

    public List<String> getGroceryList()
    {
        groceryList = groceryListPersistence.getGroceryList();
        return Collections.unmodifiableList(groceryList);
    }

    public String getSequential() {
        if (groceryList == null) {
            groceryList = groceryListPersistence.getGroceryList();
            currentItem = 0;
        }
        if (currentItem < groceryList.size()) {
            item = groceryList.get(currentItem);
            currentItem++;
        } else {
            groceryList = null;
            item = null;
            currentItem = 0;
        }
        return item;
    }

    public String insertItem(String currentItem)
    {
        return groceryListPersistence.insertItem(currentItem);
    }

    public String updateItem(String currentItem, String newItem)
    {
        return groceryListPersistence.updateItem(currentItem, newItem);
    }

    public void deleteItem(String currentItem) {
        groceryListPersistence.deleteItem(currentItem);
    }
}
