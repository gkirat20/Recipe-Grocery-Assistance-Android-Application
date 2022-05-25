Iteration 2 Worksheet
=====================

Paying off technical debt
-------------------------

Show two instances of your group paying off technical debt. For these two instances:

Explain how your are paying off the technical debt.
Show commits, links to lines in your commit where you paid off technical debt.
Classify the debt, and justify why you chose that classification with 1-3 sentences.

*Instance 1:* In the first iteration, we structured our code wrong, so we restructured our code to fix that in this iteration.  
We would classify this as inadvertant reckless technical debt.

https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/commit/2ce0dc9c9278427a632e1626c7b92440d4382ffc

*Instance 2:* In thhe first iteration, we did not implement a interface for our database.  We corrected this debt by 
implementing the interface for our database.

https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/commit/e84be15c62de5b78211e762da23e39b0bc885f94

SOLID
-----

Find a SOLID violation in the project of group with group number n-1 in the same section of the course as you (group 1 does group 16). Open an issue in their project with the violation, clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure your links in the issues are to specific commits (not to main, or develop as those will be changed).

We found a violation in Group 7's ImageManager.java file.  We decided that their saveImage() method does not uphold the single responsibility issue.
We figure that the directory should be passed as a parameter, and should not be determined within the saveImage() method.  We also noted that they did not
utilize the use of any interfaces.  We determined this to be in violation of the Lyskov Substitution Principle

https://code.cs.umanitoba.ca/winter-2022-a02/group-7/digital-cookbook/-/issues/67



Retrospective
-------------

Describe how the retrospective has changed the way you are doing your project. Is there evidence of the change in estimating/committing/peer review/timelines/testing? Provide those links and evidence here - or explain why there is not evidence.

In our retrospective, we as a team decided we needed to check into discord more often to stray in the loop with what was going on in our group.
While there was some improvement, prior commitmentsd and other classes required lots of our time during this iteration so communication was still
not 100%.

Design patterns
---------------

Show links to your project where you use a well-known design pattern. Which pattern is it? Provide links to the design pattern that you used.

**Note**: Though Dependency Injection is a programming pattern, we would like to see a programming pattern other than Dependency Injections.

We decided to not implement any design patterns in this iteration.

Iteration 1 Feedback fixes
--------------------------

Provide a link to an issue opened by the grader.

Explain what the issue was, and why it was flagged. Explain what you did to refactor or fix your code to address the issue. Provide links to the commits where you fixed the issue.

This issue was opened by group 7 last iteration.
https://code.cs.umanitoba.ca/winter-2022-a02/group-8/recipe-app/-/issues/19

The issue stated that our persistence layer and domain-specific object were in the same folder.  We corrected this
issue by refactoring our project and placing these in separate folders.
