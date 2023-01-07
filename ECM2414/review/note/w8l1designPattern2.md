## Note
### Builder Pattern
#### How does Builder Pattern work?
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/builderPattern.png)

- Builder
	- **specifies** the **interface** for creating parts of the complex (Product) object.
- ConcreteBuilder Object
	- create and assemble the parts that make up the Product through the Builder interface
- Director Object
	- takes responsibility for the construction process of the complex (Product) object
	- delegates the actual creation and assembly to the Builder interface
- Product
	- represents the complex object that is created by the ConcreteBuilder object(s)
	- consists of multiple parts that are created separately by the ConcreteBuilder objects

#### Benefits
- **Encapsulate** the way a complex object is constructed
- object to be constructed in a **multistep** and **varying process**(step by step)
- Hides the **internal representation** of the product from the client

#### cf
- Factory pattern 
	- constructs a complete object in one shot
- Abstract Factory pattern
	- returns a family of related classes
- Builde pattern
	- constructs a complex object step by step

### Singleton Pattern
#### How to create a Singleton Pattern
- Static member(pq4)
	- a **private static variable**
	- the **only instance** of Singleton class
- Private constructor
	- a private constructor
	- make sure an outer class can NOT instantiate obj 
- Static publlic method
	- create a global point of access to get a Singleton instance

```java
/**
* 饿汉式
*
静态变量创建类的对象
*/

public class Singleton {
	//私有构造方法
	private Singleton() {}

	//在成员位置创建该类的对象
	private static Singleton instance = new Singleton();

	//对外提供静态方法获取该对象
	public static Singleton getInstance() {
		return instance;
	}
}
```

#### Issues
- resource hungry and not always used
Lazy Initialization
- thread safe singleton
synchronized & additional check
```java
public static MySingleton getInstance(){
	if(instance == null){
		synchronized (MySingleton.class) {
			if (instance == null){
				instance = new MySingleton();
			}
		}
	}
	return instance;
}
```

## Exercise
### Benefits of Builder Pattern
Choose the correct statements on builder design patterns from the below. Select one or more:  
a. Builder pattern is used to construct a complex object step by step and the final step will return the object.  
b. Builder Pattern is used to encapsulate the construction of a product and allow it to be constructed in steps.  
c. The builder pattern exposes the attributes the generated object should have, but hides how to set these attributes.  
d. In the builder patter, the process of constructing an object should be generic so that it can be used to create different representations of the same object.  
a, b, c, d

### How to build Builder Pattern
Choose the correct statement(s) on the different roles of the UML diagram in the builder design pattern from the below. Select one or more:  
a. The Product represents the complex object that is being built.  
b. The Director class constructs the complex object using the Builder interface.  
c. The ConcreteBuilder constructs and puts together parts of the product by implementing the Builder interface. It defines and keeps track of the representation it creates and provides an interface for saving the product.  
d. The Builder class specifies an abstract interface for creating parts of a Product object.  
a, b, c, d  

### Singleton Pattern
Choose the correct step(s) involved in creating a singleton design pattern from the below. Select one or more:  
a. You first need to create a private static variable of singleton class. That’s the only instance of singleton class.  
b. Next, you need to create a private constructor for making sure outer class can not instantiate object from singleton class.  
c. Finally, you need to create a global point of access to get singleton instance.  
a, b, c  
