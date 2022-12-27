## Note
### Why Java generics
- facilitates the generic programming
- type parameters re-use the same code with different inputs
- **compile time** detect **runtime** bug(本该出现在runtime的bug在compile时就被找到了)
- removes the requirement to cast objects

### Three types
- Generic types
```java
public class Container<T> {
	private T contents;
	public void add(T contents) {
		this.contents = contents;
	}
	public T get() {
		return contents;
	}
}

Container<Double> containedDouble;
//instantiation also needs the chevrons:
containedDouble = new Container<Double>(); 
```

- Generic methods
	- the type parameter in angular brackets is placed after all the modifiers and before the return type.
- Generic constructors
	- same as the normal one, don't repeat the type parameter specification <T> in the heading of thr constrctor definition

```java
public class MyClass<T> {
	// Generic constructors
	MyClass() {
		...
	}

	// Generic method
	public static <S> void genericMethod(S var) {
	// generic method body
	}
} 
```

```java
MyClass<Integer> object = new MyClass<Integer>();
String a = object.<String>genericMethod("Hello");
```

- ps naming conventions
single, uppercase letters

### other stuffs
- Bound types
```java
Public <S extends Number> void genericMethod(S input)
```
To legally compile, the genericMethod argument must be a Number or a subtype of it

- Subtyping
	- Double and Integer **are** subtypes of Number
	- Container<Double> and Container<Integer> **are not** subtypes of Container<Number>
	- Container<Double> and Container<Integer> **are** subtypes of Container<? extends Number>

- Type erasure  
To ensure backwards compatibility, the complier removes all type information from parameters and arguments within generic classes/methods during the compilation.

- Heap pollution  
a variable of a declared parameterised type refers to an instance that is not of that parameterised type

## Exercise
### Why generics
Choose the correct statement(s) on generics from the below. Select one or more:  
a. The use of generics can remove the requirement to cast objects.  
b. Type parameters provide a way for you to re-use the same code with different inputs.  
c. By using generics, programmers can implement generic algorithms that work on collections of different types, can be customised, and are type safe and easier to read.  
d. Generics allows the javac compiler to find errors during compilation, and helps to avoid exceptions at runtime.  
a, b, c, d  

### three types
Choose the correct statement(s) on generic types, generic methods and generic constructors from the below. Select one or more:  
a. For the generic constructor, you do not repeat the type parameter specification <T> in the heading of the constructor definition.   
b. For generic methods, the type parameter in angular brackets is placed after all the modifiers and before the return type.  
c. A generic type is a generic class or interface that is parameterised over types.  
d. Type parameter names are single, uppercase letters.   
a, b, c, d  

### other stuffs
Choose the correct statement(s) on generics from the below. Select one or more:  
a. Container<Double> and Container<Integer> are subtypes of Container<? extends Number>  
b. To ensure backwards compatibility, the complier removes all type information from parameters and arguments within generic classes/methods during the compilation.  
c. Double and Integer are subtypes of Number  
d. Container<Double> and Container<Integer> are subtypes of Container<Number>  
a, b, c
