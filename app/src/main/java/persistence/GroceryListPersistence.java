package persistence;

import java.util.ArrayList;
import java.util.List;

import objects.GroceryList;

public interface GroceryListPersistence {

    ArrayList<String> getGroceryList();

    String insertItem(String currentItem);

    String updateItem(String currentItem, String newItem);

    void deleteItem(String currentItem);
}
