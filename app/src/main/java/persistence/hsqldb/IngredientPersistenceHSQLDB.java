package persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objects.Ingredient;
import objects.Recipe;
import persistence.IngredientPersistence;

public class IngredientPersistenceHSQLDB implements IngredientPersistence {
    private final String dbPath;

    public IngredientPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public ArrayList<Ingredient> getRecipeIngredients(String recipeID) {
        final ArrayList<Ingredient> ingredientList = new ArrayList<>();
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM RECIPEINGREDIENTS WHERE RECIPEID = ?");
            st.setString(1, recipeID);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                final Ingredient ingredient = new Ingredient(rs.getString("ingredientName"), rs.getString("quantity"), rs.getString("unit"), rs.getString("note"));
                ingredientList.add(ingredient);
            }
            rs.close();
            st.close();

            return ingredientList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }



    // Probably don't need any of these methods, as all ingredient depends on the recipeID, so it wouldn't make sense to use any of these methods
//    @Override
//    public Ingredient getIngredient() {
//        return null;
//    }
//
//    @Override
//    public Ingredient insertIngredient(Ingredient currentIngredient) {
//        /* Insert ingredient into Ingredient table so that when we add a new ingredient that is not in the table using either the (future) insert button in grocery list
//        or by modifying the recipe, or by adding a new recipe. Need to check if the ingredient already exist in the table.
//        */
//        return null;
//    }
//
//    @Override
//    public Ingredient updateIngredient() {
//        return null;
//    }
//
//    @Override
//    public void deleteIngredient() {
//
//    }
}
