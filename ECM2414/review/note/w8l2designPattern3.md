## Note
### Decorator Pattern(Structural Pattern)
- features
Attaches **additional** behavioural responsibilities to an object dynamically. Decorators provide a flexible alternative to **subclassing** for **extending** functionality.

- example
	- First design 
	- Second design 
		- Boolean variable
	- Third Design: Decorators
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/decoratorP1.png)
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/decoratorP2.png)
	
- facts
	- **one or more decorators** to wrap an object
	- decorators have the **same supertype** as the objects they decorate
		- we can pass around a decorate object in place of the original object
	- Object can be decorated at any time, so we can perform **dynamic runtime decoration**
	- Behaviour comes through the **composition** of decorators with the base components 
	- Some liminations
		- takes time and effort
		- introduces new levels of abstraction

### The Command Pattern(Behavioral Pattern)
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/commandPattern.png)
- features
	- **encapsulate** a request as an object
	- GUI dedign
- component
	- Invoker
		- holds a command 
		- asking the Command to carry out a request by calling its execute() method
	- Command 
		- declears interface for all commands
	- ConcreteCommand
		- defines the binding between an action and Receiver
	- Receiver
		- performs the work required to carry out the request
	- Client
		- responsible for instantiating the ConcreteCommand
		- setting the Receiver

### Pattern Review
- Factory pattern 
constructs a complete object in one step
- Abstract factory pattern 
creates a family of related classes
- Builder pattern
constructs a complex object (with parts) step by step
- Singleton pattern 
creates just a single instance of a class
- Decorator pattern
dynamically attaches additional functionalities
- Command pattern 
encapsulates a request as an object

### OOD Principles
- **Encapsulate** what varies
- Identify the aspects of your application that vary and separate them from what stays the same (**separate vary and same**)
- Program to an **interface**, not an implementation
- Favor object **composition** over class inheritance
- Open-close principle, Class should be **open for extension** but close for modification
- Dependency inversion principle, Depend upon **abstrations**, don't depend on concrete classes

## Exercise
### Decorator Pattern Facts
1. Choose the correct statement(s) on the decorator design patter from the below. Select one or more:  
a. Decorators have the same supertype as the objects they decorate, so we can pass around a decorated object in place of the original object.  
b. The dynamic behaviour comes through the composition of decorators with the base components (and other decorators).  
c. You can use one or more decorators to wrap an object.  
d. Objects can be decorated at any time, so we can perform dynamic runtime decoration.  
a, b, c, d  

### When to use Decorator Pattern
When should a decorator pattern be used? Select one or more:  
a. The decorator pattern should not be used throughout the design but in areas that are most likely to change.  
b. When adding functionality to an individual object not to all objects at run-time.  
c. The decorator design pattern can substitute factory design pattern at any time.  
d. When subclassing becomes impractical and a large number of different possibilities is needed to make independent object or a number of combination for an object is required.  
a, b, d  

### Command Pattern
Choose the correct statement(s) on the command pattern from the below. Select one or more:  
a. The Client sets up the binding between a receiver and a ConcreteCommand.  
b. The command pattern encapsulates a request as an object, thereby letting you parameterise other objects with different requests, queue or log requests, and support undoable operations.  
c. The command pattern aims to let a command object encapsulate a request by binding together a set of actions on a specific receiver.  
d. The command pattern encapsulates method invocation.  
a, b, c, d
