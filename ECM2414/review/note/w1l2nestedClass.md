![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/accessControl.png)

## Nested classes

### Access control
- standard outer class  
	- public default
- nested class  
	- public private protected private

### two types
#### Static nested class  
- code
```java
class Car {
	...
	static class Gearbox {
		...
	}
}
```
- does **not** have access to **instance** members
- Accessed using enclosing **class** name
```java
Car.Gearbox
```
- Construct  
Greates an object for the static nested class  
```java
Car.Gearbox nestedObject = new Car.Gearbox();
```

## Inner class  
- code
```java
class Car {
	...
	class Engine {
		...
	}
}
```
- does **have** access to **instance** members
- Inner classes can be directly accessed by the enclosing **instance**
- construct
	- from inside class
```java
Engine AudiEngine = new Engine();
```
	- from outside class
```java
Car Audi = new Car();
Car.Engine AudiEngine = Audi.new Engine();
```

## Local class
- code
```java
public class LocalClassExample {
	static String regularExpression = "[^0-9]";

	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
		final int numberLength = 10;

	class PhoneNumber {
		String formattedPhoneNumber = null;
		PhoneNumber(String phoneNumber) {
			String currentNumber = phoneNumber.replaceAll(regularExpression, "");
			if (currentNumber.length() == numberLength)
				formattedPhoneNumber = currentNumber;
			else
				formattedPhoneNumber = null;
			}
		}
	}
}
```
- Local classes are defined and exist solely within a block (use ally a method) 在方法里面的class  

- Local class declaration cannot contain public, protected, private, or static access modifiers. 

- Cannot access method local variables (unless passed as arguments) unless they are declared as **final**.

- Can access all the members of the outer class instance **like standard inner class members.**  

## Anonymous class
- code
```java
HelloWorld frenchGreeting = new HelloWorld() {
	String name = "tout le monde";
	public void greet() {
		greetSomeone("tout le monde");
	}
	public void greetSomeone(String someone) {
		name = someone;
		System.out.println("Salut " + name);
	}
};
```
- new keyword
- The name of an interface to implement or a class to extend. In this example, the anonymous class is implementing the interface HelloWorld.

## Enumerated classes

## Exercise
### inner class and static class
1. Why do we usually say "inner classes are more useful than static nested classes"?
Select one or more:  
a. Inner classes can access the instance members.  
b. Inner classes provide a way for the coders to do packing of multiple classes only, and don't offer much more for the way of interactions between these classes.  
c. Static nested classes cannot access the instance members.  
d. Inner classes are easier to access than static nested classes.  
ac  

2. Choose the correct statement(s) about the inner class and static nested class.  
(A) An inner class can be accessed using the name of the enclosing class.  
(B) A static nested class can be accessed using the instance of the enclosing class.  
(C) A static nested class can access the instance members of the enclosing class.  
(D) An inner class can access the instance members of the enclsing class.  
d  

### local class
3. Choose the correct statements from the below.  
Select one or more:  
a. The local class cannot access method local variables.  
b. The local class can access all the members of the outer class   
c. The local class cannot access method local variables unless they are declared as final.  
d. The local class can access method local variables even  they are not declared as final.  
bc

### nested class
4. What are the benefits of nested classes?  
Select one or more:  
a. It can lead to more readable and maintainable code  
b. It increases encapsulation  
c. It is a way of logically grouping classes that are only used in one place   
abc
