# ARCHITECTURE.md

## Recipe.java

Recipe.java is the class file containing the information about the recipe as well as methods to get the information about the recipe. The static ArrayList will hold all the recipes retrieved from the database.

## GroceryList.java

GroceryList.java is the list of ingredients that the user wants for their recipes.

## GroceryListActivity.java

GroceryListActivity.java is used to list the list of ingredients added to the grocery list.

## HomeActivity.java

HomeActivity.java handle the activities for the home page.

## RecipeListActivity.java

RecipeListActivity.java is used to list all the recipes.

## RecipeViewerActivity.java

RecipeViewerActivity.java is used to view the details of the recipes.

## AccessRecipe.java

AccessRecipe.java is used to interact with the recipe presistence layer.

## RecipePresistenceHSQLDB.java

RecipePresistenceHSQLDB.java make query to the database to get the recipes and store the recipies into an array list.

## RecipePresistence.java

RecipePresistence.java is the interface for the recipe class.

## GroceryListPresistenceHSQLDB.java

GroceryListPresistenceHSQLDB.java make query to the database to get the list of grocery ingredients and store it to an array.

## GroceryListPresistence.java

GroceryListPresistence.java is the interface for the grocery list class.

## Ingredient.java

Ingredient.java is the class containing the information about the ingredient as well as methods to get the information about it.


## IngredientPersistence.java

GroceryListPresistence.java is the interface for the ingredient list class.

## IngredientPersistenceHSQLDB.java

GroceryListPresistenceHSQLDB.java make query to the database to get the list of ingredients and store it to an array.


## RecipeReturnInterface.java

RecipeReturnInterface.java is used to return a recipe from the add activity to the RecipeListActivity.

## RecipeAddActivity.java

RecipeAddActivity.java is used to add new recipes.


## IngredientAddFragment.java

IngredientAddFragment.java is used by RecipeAddActivity.java to add new ingredients to new recipes.


## The Architecture Flow chart

![Our architecture](/Architecture/Architecture.png)
