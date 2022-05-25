package objects;
import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList;

    public GroceryList()
    {
        groceryList = new ArrayList<String>();
    }

    public GroceryList(ArrayList<String> currentItemList)
    {
        groceryList = currentItemList;
    }

    public ArrayList<String> getGroceryList() {
        return this.groceryList;
    }
}
