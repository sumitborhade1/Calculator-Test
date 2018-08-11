# Project Title

Coding Test for Sumit Borhade

## Getting Started
After looking at the problem statement, I first invested time in preparing the design of the solution.

I've tried creating the solutions by applying the SOLID Design principles such as single responsibility, open close principle.

Project was implemented using TDD and refactoring was carried out as I made the progress.

Logic starts from the AdditionFlow class.

I've divided functionality in 5 main steps.
```
	1. Find delimiter and operational input
	2. Extract numbers
	3. Validating input
	4. Filtering the unwanted numbers
	5. Finding the sum 
```
Here for step 3, validation rule is currently only one. But in future there could be many validation rules. So approach was taken in such a way that existing logic should not be touched. The solution is written in such a way that it is closed for modification but open for extension.

Same thing is applied for step 4.

The functionality can be tested using the happy and negative path scenarios.

There is no use of Mocking framework, as all the scenarios are tested using junits.

I've still used EasyMock just to demonistrate it could be used while making an expensive object.

## Authors

* **Sumit Borhade** - [LinkedIn](https://www.linkedin.com/in/sumit-borhade-73b6a96a/)

Email id: borhadesumit58@gmail.com
