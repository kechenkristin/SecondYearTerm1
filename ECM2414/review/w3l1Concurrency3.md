## Note
### Data issues with threads
https://www.yuque.com/mo_ming/gl7b70/cpzl3l  

JMM 即 Java Memory Model，它定义了主存、工作内存抽象概念，底层对应着 CPU 寄存器、缓存、硬件内存、CPU 指令优化等。 
JMM 体现在以下几个方面   
● 原子性 - 保证指令不会受到线程上下文切换的影响   
● 可见性 - 保证指令不会受 cpu 缓存的影响   
● 有序性 - 保证指令不会受 cpu 指令并行优化的影响  

#### Visibility
- Data is up to date
- **Stale data**(陈旧的数据) can lead to large issues

#### Atomic 
- Atomic Variable
- Atomic access functions

#### Volatile
- tells compiler not to optimise 
- force the next read to see the last write

### Publishing & Escape
#### Publishing
- make an object available outside its current scope
- need to confirm the **thread-safe** nature of the publishing
#### Escape
An object published when it should not have been is said to have escaped (e.g. accessing an initialised state variable)  
```java
class UnsafeStates {
	private String [] states = new String [] {"AK", "AL", ...};
	public String[] getStates () {
		return states;
	}
}
```

### Thread confinement(监禁)
- an element of the program's design
- ensure thread-safety
- If the data doesn't need to be shared, confine it to a single thread

### Lambda Expressions
https://github.com/Matty-GCU/Note/blob/master/JavaSE/Java8%20Lambda%E8%A1%A8%E8%BE%BE%E5%BC%8F.2021.11.08.md  
- **zero or more** arguments
- argument types can be **decleared** and **inferred**

## Exercise
### Visibility
What can stale data cause in multi-threading applications?  
(A) Unexpected exceptions  
(B) Inaccurate computations  
(C) Infinite loops  
(D) Corrupted data structures  
a, b c, d  
### Volatile
1. What are the benefits of using the volatile keyword? Select one or more:  
a. Volatile gives you visibility guarantees. Each read of a volatile will see the last write to that volatile by any other thread; without volatile, there's no guarantee as to when the last write would be visible.  
b. If you declare a variable as volatile, then any write to that variable will be atomic - another thread cannot see a partial write.  
a, b  

### Publishing
Publishing an object is when you make it available outside its current scope. Which example(s) below show a publishing example? Select one or more:  
a. By storing a reference to it where other code can find it.  
b. Returning it from a non-private method.  
c. Passing it to a method in another class.  
d. Storing it in a private method.  
a, b, c  

### lambda expression
1. Choose the correct statement about lambda expression from the below. Select one or more:  
a. A lambda expression allows you to pass a block of code around between objects.  
b. A lambda expression can have zero or more arguments.  
c. In a lambda expression, a body with a single expression does not require curly brackets.  
d. A lambda expression allows argument type to be declared or inferred.  
a, b, c, d

2. Choose the correct statement(s) about lambda expression.  
(A) A lambda expression allows you to pass a block of code around between
objects.  
(B) A lambda expression must have one or more arguments.  
(C) A lambda expression allows argument type to be declared or inferred.  
(D) In a lambda expression, a body with a single expression does not require curly brackets.  
a, c, d

3. Choose the correct statement(s) about lambda expressions in Java.  
(A) It cannot have zero argument.  
(B) It can have zero argument.  
(C) Argument types cannot be inferred.  
(D) Argument types can be inferred.  
b, d
