## Note
### V-Model
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/V-Model.png)
- Concept of operations
- Requirements analysis
- Design
	- High-level design 
	- Detailed design
- Testing
	- Unit testing
	- Integration testing
	- System testing
	- User acceptance testing
- Advantages/disadvantages of the V model

### Testing categories
- Static testing
assessing documents(review, walkthroughs, ...)
- Dynamic testing
	- White box testing
		- internals are know
		- tests can be designed to test many paths through the program
		- test explicit paths through the system(code coverage)
		- bias
	- Black box testing
		- internal are not know
		- treats code as a "black box"
		- functionality
		- High probability that tests will only test a small number of paths through the program
	- Grey box testing
		- know both the functionality and implementation

### Code coverage
- Coverage types
	- Function/method/(sub)routine coverage
		- method
	- State coverage
		- each line of code has been processed 
	- Decision coverage
		- decision
		- if/else
	- Predicate coverage
		- condition
- EMMA

### Corner cases
### Limits of testing

## Exercise
### V-Model
1. Choose the correct statement(s) on the V-model from the below. Select one or more:  
a. The V-model is a highly structured model. It’s a good model if you know all the requirements upfront.  
b. The V-model is simple to understand and easy to manage.  
c. The V-model is a good choice for a large project with changing requirements.  
d. With the V-model, you don’t get a working software until very late of the cycle.  
a, b, d  

### Testing Categories
1. Choose the correct statement(s) on the dynamic testing from the below. Select one or more:  
a. With black box testing, you have no knowledge of the internals of the code, so you don’t have that programmer bias.  
b. The white box testing may end up with leading the tests to the direction of what it should be happening. It makes the tests harder to capture unexpected errors the system may have.  
c. The advantage of white box testing is that we know the code and we can design the tests to test many paths through the program.  
d. With black box testing, there are high probabilities that many number of paths through the program are not tested.   
a, b, c, d  

### Coverage 
Choose the correct statement(s) on the coverage types from the below. Select one or more:  
a. Method coverage is whether each method has had a test written on it. This includes constructors, objects, and private methods you may have.  
b. Statement coverage is whether every line of code has been processed by something in your tests.  
c. Decision coverage is whether every decision edge has been reached in your code.  
d. Predicate coverage is whether each Boolean sub-expression has been evaluated both to true and false.  
a, b, c, d  

