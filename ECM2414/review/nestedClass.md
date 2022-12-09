![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/accessControl.png)

## Nested classes

### Access control
- standard outer class  
public default
- nested class  
public private protected private

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
- does not have access to instance members
- Accessed using enclosing class name
```java
Car.Gearbox
```
- Construct  
Greates an object for the static nested class  
```java
Car.Gearbox nestedObject = new Car.Gearbox();
```

#### Inner class  
- code
```java
class Car {
	...
	class Engine {
		...
	}
}
```
- does have access to instance members
- Inner classes can be directly accessed by the enclosing instance
