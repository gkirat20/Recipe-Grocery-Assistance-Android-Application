What technical debt has been cleaned up
========================================
A technical debt that got clean up was the GroceryList, it was not using the persistence layer before.

Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/commit/3504065f0020ba8c92b821f615c9cf95b1240b3b
The debt was paid is the structural debt, we could have structured it in the beginning but due to time constraints, we were not able to do so.

What technical debt did you leave?
==================================
In the recipe, we instead of a list of instruction, we save the instructions as one long string. We replaced every newline with '$' to push it into the database.

What one item would you like to fix, and can't? Anything you write will not
be marked negatively. Classify this debt.
This was a prudent-inadvertent, we could have linked the items in the database but we did not do that in the beginning.

Discuss a Feature or User Story that was cut/re-prioritized
============================================
Video tutorial was completely cut from the feature list for our last iteration. This is because due to time constraints.

When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any
iteration.
We changed it on the last iteration when there is a clear time constraints in our planning.

Acceptance test/end-to-end
The user should be able to interact with the grocery list.
The user should be able to add a new ingredient to the grocery list.
The user should be able to modify an ingredient in the grocery list.
The user should be able to remove an ingredient from the grocery list.

The user should be able to interact with the recipe database.
The user should be able to look up the recipes in categories.
The user should be able to add their own recipe.
The user should be able to modify the recipes.
The user should be able to delete a recipe from the database.
==========================

Write a discussion about an end-to-end test that you wrote. What did you test,
how did you set up the test so it was not flaky? Provide a link to that test.
Based on the user story, the acceptance test is a reflection on the end user.

There are two sides to our Android application: GroceryList and RecipeList.

We did a basic home screen test to ensure that both of these options are present.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/HomeActivityTest.java

Adding an ingredient to the grocery list.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/GroceryAddAcceptanceTest.java

Remoce an ingredient from the grocery list.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/GroceryListRemoveIngredientAcceptance.java

Update an ingredient in the grocery list.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/GroceryListUpdateIngredientAcceptance.java

Ensure the layout of the RecipeList side is as expected.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/RecipeListAcceptance.java

Add new recipe into the recipe list.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/RecipeListAddAcceptance.java

Check the catagory of the Recipe List.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/blob/main/app/src/androidTest/java/presentation/RecipeListCategoryAcceptance.java


Acceptance test, untestable
===============
The majority of the time it took to wrote the acceptance test was to figure out the dependency and use Expresso.
We have considered to use other libraries but Expresso seems to be the most straightforward one.
We did not separate our database acceptance test from the normal applicaiton, this is the reason why the device might need be wipe before starting.
The acceptance test was very straightforward once we know what to do.

What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?
When deleting the ingredent from the GroceryList or recipe from the RecipeList, it was not possible to find the element to check that it doesnt exist.

Velocity/teamwork
=================
9/14 issues complete for iteration 3.

We have definitely noticed an improvement in our velocity as we are able to push more issues through. However, our estimate is still not accurate since our team members are getting other school course loads and it is unpredictable.

Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.
We estimated to spent 3 days and 6 hours and we ended up spending 4 days and 2 hours.
This is different is high and it is evidence that we need to work on time management.

