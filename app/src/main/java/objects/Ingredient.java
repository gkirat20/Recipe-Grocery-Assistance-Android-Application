package objects;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String ingredientName;
    private String quantity;
    private String unit;
    private String note;

    public Ingredient(String ingredientName, String quantity, String unit, String note) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unit = unit;
        this.note = note;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getNote() {
        return this.note;
    }

    public String toString()
    {
        String ingredient = "";
        ingredient += quantity + " ";
        ingredient += unit + "\t\t";
        ingredient += ingredientName;
        if (note != null) {
            ingredient += " (" + note + ")";
        }

        return ingredient;
    }

}
