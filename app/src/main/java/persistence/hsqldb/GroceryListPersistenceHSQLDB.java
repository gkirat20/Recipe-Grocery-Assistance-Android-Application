package persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.GroceryList;
import persistence.GroceryListPersistence;

public class GroceryListPersistenceHSQLDB implements GroceryListPersistence {
   
    private final String dbPath;

    public GroceryListPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }


    @Override
    public ArrayList<String> getGroceryList() {
       ArrayList<String> groceryItems = new ArrayList<String>();
       try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM GroceryList");
           
            final ResultSet rs = st.executeQuery();
            while(rs.next()) {
                groceryItems.add(rs.getString("item"));
            }
            rs.close();
            st.close();

//            GroceryList newGroceryList = new GroceryList(groceryItems);
            return groceryItems;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }


    @Override
    public String insertItem(String newItem) {
        String result = newItem;
        try (final Connection c = connection()) {
            ArrayList<String> items = getGroceryList();
            if (items.contains(newItem)) {
                result = "Note: " + newItem + " already exists in Grocery List";
            }
            else {
                PreparedStatement st = c.prepareStatement("INSERT INTO GroceryList VALUES(?)");
                st.setString(1, newItem);
                st.executeUpdate();
                st.close();
            }

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return result;
    }

    @Override
    public String updateItem(String currentItem, String newItem) {
       
        try (final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("UPDATE GroceryList SET item = ? WHERE item = ?");
            st.setString(1, newItem);
            st.setString(2, currentItem);
            st.executeUpdate();
            st.close();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
       
        return currentItem;
    }

    @Override
    public void deleteItem(String currentItem) {
          try (final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("DELETE FROM GroceryList WHERE item = ?");
            st.setString(1, currentItem);
            st.executeUpdate();
            st.close();

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }
}
