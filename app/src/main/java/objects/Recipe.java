package objects;
import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

/*
Comp 3350 Software Engineering
Group 8
February 28, 2022
Recipe.java

Public static member:
recipeList - Linked list of recipes.

Public static method:
getRecipeFromDatabase() - Get the recipes from the database.

Private member:
name - String name of the recipe.
ingredientList - Linked list of ingredients string.
nationality - The country name where the food originated.
prepTime - Integer the amount of time it takes to prep.
cookTime - Integer the amount of time it takes to cook.
cookingSkillLevel - Easy, Medium, or Hard cooking level.
description - String description of the recipe.
instructionList - Cooking instructions.
link - Youtube link.
vegetarian - String Yes or No if the food is vegetarian.
filterList - Linked list of string filter. Holiday like Christmas, New Year, to Seafood.
bookmarked - Bookmarking flag to remember the recipe for the user.

Public method:
Recipe() - Constructor to create an instance of recipe.
getName() - Get the name of the recipe.
getNationality() - Get the nationality of the recipe.
getPrepTime() - Get the prep time for the recipe.
getCookTime() - Get the cooking time for the recipe.
getCookingSkillLevel() - Get the cooking skill level for the recipe.
getDescription() - Get the description of the recipe.
getInstructionList() - Get the instructions for the recipe.
getLink() - Get the link for the recipe tutorial.
getVegetarian() - Get boolean flag if the recipe is a vegetarian recipe.
getCategoryList() - Get the list of filters for the recipe.
getBookmarked() - Get the bookmarking flag of the recipe.

Future:
Image of the recipe.
*/

public class Recipe implements Serializable {
    // Private member
    private String recipeID;
    private String name;
    private String nationality;
    private ArrayList<Ingredient> ingredientList;
    private int prepTime;
    private int cookTime;
    private String cookingSkillLevel;
    private String description;
    private String instructions;
    private String link;
    private ArrayList<String> categoryList;

    // Public method

    /* Recipe()
    Constructor to create an instance of recipe.
    */
    public Recipe(final String newRecipeID) {
        this.recipeID = newRecipeID;
        this.name = null;
        this.nationality = null;
        this.ingredientList = null;
        this.prepTime = 0;
        this.cookTime = 0;
        this.cookingSkillLevel = null;
        this.description = null;
        this.instructions = null;
        this.link = null;
        this.categoryList = null;
    }

    public Recipe(String recipeID, String name, String nationality, ArrayList<Ingredient> ingredientList,
                  int prepTime, int cookTime, String cookingSkillLevel, String description,
                  String instructions, String link, ArrayList<String> categoryList)
    {
        this(recipeID);
        this.name = name;
        this.nationality = nationality;
        this.ingredientList = ingredientList;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.cookingSkillLevel = cookingSkillLevel;
        this.description = description;
        this.instructions = instructions;
        this.link = link;
        this.categoryList = categoryList;
    }

    /* getRecipeID()
    Return:
    The recipe ID.
    */
    public String getRecipeID() { return this.recipeID; }

    /* getName()
    Return:
    The name of the recipe.
    */
    public String getName() { return this.name; }

    /* getNationality()
    Return:
    The nationality of the recipe.
    */
    public String getNationality() { return this.nationality; }

    /* getIngredientList()
    Return:
    The list of ingredients for the recipe.
    */
    public ArrayList<Ingredient> getIngredientList() {
        return this.ingredientList;
    }

    /* getPrepTime()
    Return:
    Prep time for the recipe.
    */
    public int getPrepTime() { return this.prepTime; }

    /* getCookTime()
    Return:
    The cooking time for the recipe.
    */
    public int getCookTime() { return this.cookTime; }

    /* getCookingSkillLevel()
    Return:
    The cooking skill level for the recipe.
    */
    public String getCookingSkillLevel() { return this.cookingSkillLevel; }

    /* getDescription()
    Return:
    The description of the recipe.
    */
    public String getDescription() { return this.description; }

    /* getInstructionList()
    Return:
    The instructions for the recipe.
    */
    public String getInstructions() { return this.instructions; }

    /* getLink()
    Return:
    The link for the recipe tutorial.
    */
    public String getLink() { return this.link; }


    /* getCategoryList()
    Return:
    The list of filters for the recipe.
    */
    public ArrayList<String> getCategoryList() { return this.categoryList; }

    /* toString()
    Return:
    Default string for the instance.
    */
    public String toString()
    {
        return this.getName();
    }

}
