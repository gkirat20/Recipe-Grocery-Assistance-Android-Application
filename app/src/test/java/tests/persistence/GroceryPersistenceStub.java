package tests.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import persistence.GroceryListPersistence;

public class GroceryPersistenceStub implements GroceryListPersistence {
    private ArrayList<String> items;

    public GroceryPersistenceStub() {
        this.items = new ArrayList<>();
        items.add("Egg");
        items.add("Tofu");
        items.add("Carrot");
    }

    @Override
    public ArrayList<String> getGroceryList() {
        return items;
    }

    @Override
    public String insertItem(String currentItem) {
        items.add(currentItem);
        return currentItem;
    }

    @Override
    public String updateItem(String currentItem, String newItem) {
        int index;

        index = items.indexOf(currentItem);
        if (index >= 0)
        {
            items.set(index, newItem);
        }
        return newItem;
    }

    @Override
    public void deleteItem(String currentItem) {
        int index;

        index = items.indexOf(currentItem);
        if (index >= 0)
        {
            items.remove(index);
        }
    }
}
