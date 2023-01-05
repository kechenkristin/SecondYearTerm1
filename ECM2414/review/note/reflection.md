## Note
### Getting a class
- instance.getClass()
- 类名.class
- Class.forName

### Some Class instance methods
- getFields() / getConstructors() / getMethods()
	- public attributes
	- including inherited
- getDeclearedFields() / getDeclearedConstructors() / getDlearedMethods()
	- all attributes(private)
	- not including inherited

### Some Constructor instance methods
- Constructor.newInstance()
	- any numbers of parameters
	- private constructors

- Class.newInstance()
	- no-argument constructor
	- the constructor need to be visible

### Security
- Access to the Refection API is controlled via a **security manager**
- slower performance
- runtime permission
- unexpected side effects ==> code dysfunctionali and destory portability
- breaks abstractions ==> change behavior with upgrades of the platform

### Uses of Reflection
- Test programs by forcing specific states
- Insuring a high level of code coverage in a test suite
- By debuggers to inspect running programs


## Exercise
What a Java Class may include? Select one or more:  
a. Methods  
b. Constructors  
c. Functions  
d. Fields  
a, b, d  

Choose the correct statement(s) about class instance methods from the below. Select one or more:  
a. getMethods() returns an array of Method instances, containing details of all public methods associated with the class, including inherited ones.  
b. Class.newInstance() can only invoke the no-argument constructor, while Constructor.newInstance() may invoke any constructor, irrespective of the number of parameters.  
c. Class.newInstance() requires that the constructor be visible; Constructor.newInstance() may invoke private constructors (under certain circumstances).  
d. getDeclaredFields() returns an array of Field instances, containing details of all variables regardless of their access modifiers, not including inherited ones.  
a, b, c, d  

Choose the correct statement(s) about reflection from the below. Select one or more:  
a. Reflection has a way to get permission to access the private elements.  
b. Reflective operations have slower performance than their non-reflective counterparts, and should be avoided in sections of code which are called frequently in performance-sensitive applications.  
c. Test harnesses can make use of reflection to systematically call a discoverable set APIs defined on a class, to insure a high level of code coverage in a test suite.  
d. Reflection requires a runtime permission which may not be present when running under a security manager.  
a, b, c, d  
