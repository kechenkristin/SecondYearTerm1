## Note
### Unit testing
- Recap, Importance
- Preparing and planning tests
- Right-BICEP
	- Right: are the **boundary result** right?
	- B: are all the **boundary conditions** correct?
	- I: **inverse** relationships
	- C: **cross-check** using some other means
	- E: force **error conditions** to occur
	- P: are the **performance characteristics** within bounds
- Properties of good tests ATRIP
	- Automatic
	- Thorough
	- Repeatable
	- Independent
	- Professional
- Testing the tests

### Junit frameworks
- Structuring unit tests
	- naming conventions
	- set up
- Assertions
	- AssertEquals
	- floating point
		- representation limitations(finite memory)
		- floating point values are not exact
		- specify some tolerance


## Exercise
### Right-BICEP
1. With Right-BICEP, what questions you may ask yourself when you prepare unit tests? Select one or more:  
a. Are the boundary results correct?  
b. Is the inverse relationship correct?  
c. Can you cross-check the results using some other means?  
d. Are all the boundary conditions correct? Are they identified correctly?  
e. Are the performance characteristics within the performance bounds?  
f. Are the error conditions correct?  
a, b, c, d, e, f  

### Properties of good testing 
1. Choose the properties of good tests from the below. Select one or more:  
a. The test should be professional, so they should be written using the same standard as the shipped code.  
b. The test should be thorough, so they should be able to cover the entire possible test cases.  
c. The tests should be independent, so two tests should not rely on each other.   
d. The test should be repeatable, so they should produce the same results each time.  
e. The test should be automatic, so you don’t have to interact with them at all.  
a, b, c, d, e  

### floating point
1. Why should we be careful with assertEquals and floating point numbers in testing? Select one or more:  
a. The floating point numbers cannot be compared.  
b. We have restrictions on how we can represent floating point numbers due to the finite amount of memory in a computer.  
c. We need to have some kind of tolerance when comparing two floating point numbers.  
d. With different tolerance, the comparison results of two floating point numbers might be different.  
b, c, d  
