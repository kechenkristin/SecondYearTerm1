## Note
### Mock objects
- use mock objects when the real object
	- has non-deterministic behaviour
	- is difficult to set up
	- has behaviour that is hard to trigger(eg. network error)
	- is slow
	- has(or is) a user interface
	- does not yet exist

### Test suites
- allow us to group multiple test classes to run as a single batch
- allow us to run a specific subset of unit tests from multiple test classes
```java
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({TestAccount.class, TestBank.class})
public class TestSuite {
	// empty , as the class is just a holder
	// for the annotations above
}
```

### Test-driven development
- help **design** code **better**
- see the code from **user's perspective**, not the develper's
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/testdriven.png)

### Invariants
- Invariants are assertions about classes/objects that should not change

### PS annotations
- @Before
- @After
- @Test
- @RunWith
- @Suite.SuiteClasses
- @Category
- @IncludeCategory

## Exercise
### mock objects
1. When shall we consider to use mock objects in testing? Select one or more:  
a. When the real object does not yet exist.  
b. When the real object has non-deterministic behaviour.  
c. When the real object is slow to run.  
d. When the real object is difficult to set up.  
e. When the real object has a user interface.  
f. When the real object has behaviour that is hard to trigger  
a, b, c, d, e, f  

2. When should you consider to use mock objects in software testing?  
(A) When the real object is difficult to set up.  
(B) When the real object is slow to run.  
(C) When the real object doesn’t exist.  
(D) When the real object has a user interface.  
a, b, c, d  

### annotations
1. Choose the correct statement(s) about annotations from the below. Select one or more:  
a. When a class is annotated with @RunWith or extends a class annotated with @RunWith, JUnit will invoke the class it references to run the tests in that class.  
b. The @Test annotation tells JUnit that the method to which it is attached can be run as a test case.   
c. The @BeforeClass and @AfterClass annotations run once before and after the entire test fixture.  
d. The @Before and @After annotations run before and after each test.  
e. The @SuiteClasses annotation specifies the classes to be run when a class annotated with @RunWith(Suite.class) is run.  
a, b, c, d, e  

### test-driven development
1. What is/are the advantage(s) of using test-driven development? Select one or more:  
a. It can enable you to have a better design of your system.  
b. You can write your code from user’s perspective, rather than from a developer’s perspective.  
c. The developed system is easier to be tested.  
a, b, c  

2. What is/are the benefit(s) of test-driven development?  
(A) It makes the code easier to test.  
(B) It designs the code from the user’s point of view.  
(C) It designs the code from the developer’s point of view.  
(D) It allows to write better programs.  
A, B, D  
