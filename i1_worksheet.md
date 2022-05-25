Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Feature: [Manage Grocery List](https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/issues/2)

User story: [User Story](https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/issues/8)

How the feature was added:

- We created GraceryList class, in here we have an ArrayList to hold all ingredients.
- We then can add or remove items from the grocery list by function `addIngredients()` and `removeIngredients`

Exceptional code
----------------

The test of exceptional code can be found [here](https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/GroceryList/src/GroceryListTest.java).

The functions `getIngredient(int index)` and `removeIngredient(int index)` both throw `IndexOutOfBoundsException` as shown in the tests. These exceptions are thrown as there is the possibility of an improper value being passed into the functions.  They both access specific spots in a linked list so passing an index that is negative or too high will throw an `IndexOutOfBoundsException` which will allow a function that calls it to handle the issue.

Branching
----------

The branching strategy can be found [here](https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/Branching-Strategy.md).

SOLID
-----

Group 09 SOLID Violation can be found [here](https://code.cs.umanitoba.ca/winter-2022-a02/group-9/chefsnotes/-/issues/49).

Agile Planning
--------------

We actually planned to print recipes in our first iteration and then we changed the plan to shift it to iteration 2.
We specifically want to focus more one well implementation of a single feature. No, we did not change any description for feature or user stories. No links required
