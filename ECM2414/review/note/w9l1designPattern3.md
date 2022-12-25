## Note
### Decorator Pattern
- features
Attaches **additional** behavioural responsibilities to an object dynamically. Decorators provide a flexible alternative to **subclassing** for **extending** functionality.

- principles
	- open to for **extension**, but closed for modification
	- easy to extend to incorporate new behaviour, but without modify the existing code base

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
	- Behaviour comes through the **composition** of decorators with the base components (and other decorators)
	- Some liminations
		- takes time and effort
		- introduces new levels of abstraction

### The Command Pattern
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
- Program to an **interface**, not an implementation
- Favor **ojbect composition** over class inheritance
- Open-close principle, Class should be **open for extension** but close for modification
- Dependency inversion principle, Depend upon **abstrations**, don't depend on concrete classes
