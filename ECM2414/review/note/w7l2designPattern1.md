## Note
### Design Patterns
- provide an architecture and general reusable solution

- OO Design Principles
	- Depend upon abstractions, not depend upon concrete classes
	- Identify the aspects of your application that vary and separate them from what stays the same
	- Program to an **interface**, not an implementation
	- **object composition** rather than inheritance

- types of design patterns
	- Creational Patterns(object creation)
		- Factory Pattern, Abstract Factory Pattern, Singleton Pattern, Prototype Pattern, Builder Pattern 
	- Structural Patterns(composition of classes and objects)
		- Adapter Pattern, Bridge Pattern, Composite Pattern, Decorator Pattern, Facade Pattern, Flyweight Pattern, Proxy Pattern
	- Behavioral Patterns(interaction between objects)
		- Chain Of Responsibility Pattern, Command Pattern, Interpreter Pattern, Iterator Pattern, Mediator Pattern, Memento Pattern, Observer Pattern, State Pattern, Strategy Pattern, Template Pattern, Visitor Pattern 

### Factory Pattern
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/factory1.png)

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/factory2.png)

```java
// Abstract Factory
public interface CoffeeFactory {
	Coffee createCoffee();
}

// Concrete Factory
public class LatteCoffeeFactory implements CoffeeFactory {
public Coffee createCoffee() {
	return new LatteCoffee();
	}
}
public class AmericanCoffeeFactory implements CoffeeFactory {
	public Coffee createCoffee() {
		return new AmericanCoffee();
	}
}

// Coffee Shop
public class CoffeeStore {
	private CoffeeFactory factory;
	public CoffeeStore(CoffeeFactory factory) {
		this.factory = factory;
	}
	public Coffee orderCoffee(String type) {
		Coffee coffee = factory.createCoffee();
		coffee.addMilk();
		coffee.addsugar();
		return coffee;
	}
}
```


### Abstract Factory Pattern
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/abstractFatory.png)

### Cf FP & AFP
- factory pattern
	- **inheritance**(extend a class and override a factory method)
	- gives a complete object in one slot
- abstract factory pattern
	- **composition**
	- returns a family of related classes

## Experience
### OO design principles
Choose the correct statements about OO design principles below. Select one or more:  
a. Depend upon abstractions. Do not depend upon concrete classes.  
b. Identify the aspects of your program that vary and separate them from what stays the same.  
c. Program using composition over inheritance.  
d. Program to an interface, not an implementation.  
a, b, c, d  

### design pattern concept
Choose the correct statement(s) about the design pattern from the below. Select one or more:  
a. The best way to use patterns is to load your brain with them and then recognise places in your designs and existing applications where you can apply them.  
b. I can always find a design pattern to solve the design issues in my application.  
c. Design patterns are not so much concerned about the code, so instead of code reuse, with patterns you get experience reuse.  
d. Design pattern is to use the knowledge from experienced object-oriented designers to avoid reinventing the wheel.  
e. A design pattern shall use all the OO design principles.  
a, c, d  

### cf fp & afp
Choose the correct statement(s) on the similarity and difference between a factory pattern and an abstract factory pattern. Select one or more:  
a. Both of these two design patterns are used for object creation.  
b. Abstract Factory Pattern uses composition and returns a family of related classes.  
c. Factory Pattern uses inheritance and gives you a complete object in one step.  
a, b, c  
