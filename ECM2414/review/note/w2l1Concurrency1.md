### Currency
#### Def
To be able to perform multiple processes at the same time(parallelism)
#### Why
- Allowing programs to interact with other systems/users
- Multi-core systems

### Threads
#### Thread concepts
- light weight process
- exits within a process
- shared memory space
- in java 
	- extends Thread
	- implement Runnable
drawbacks of extend thread: handle complex inheritance  
#### cf multi-threading & multi-tasking
- multi-tasking
	- **own** local memory
- multi-threading
	- **share** memory

### New thing to worry about
#### Nondeterminism
why have this issue?  
- os will schedule thread running
- we don't have any control of which thread will be run and when

#### Liveness
- code performs **correctly in time**
- issues(pq 30)
	- race condition
	- deadlock
	- livelock
	- starvation

#### Race conditions	
- two threads try to access/change data at the same time

### Mechanism
#### Synchronisation
- add the synchronize keyword to the methods 
```java
public synchronized void addTwo() {
	count = count + 2;
}
```
- synchronize a lock
```java
public void doSomeSynchronisedStuff() {
	// everything out here before is not synchronized
	synchronized (this){
		// everything in here is synchronised
	}
	// everything out here afterwards is not synchronised either
}
```

#### Atomic actions(pq 9)
- can not be stopped in the middle

## Exercise
### Thread Concept
1. Choose the correct statement(s) about the thread in software development.  
(A) A thread is treated as a lightweight process.  
(B) Threads exist within a process.  
(C) Threads share the local memory of an instance of a program.  
(D) Threads don’t share the local memory of an instance of a program.   
a, b, c  

### cf multi-tasking & multi-threading
1. Choose the correct statement from the below.
Select one or more:  
a. In multi-tasking, all programs share the same local memory.  
b. In multi-tasking, each program has its own local memory.  
c. In multi-threading, all threads running the same program share the local memory of that program.  
d. In multi-threading, all threads running the same program have their own separate local memory.  
bc  

### non-deterministic behavious of thread
1. Why does a thread show non-deterministic behaviours?  
(A) It’s because different users running the threads.  
(B) It’s because the threads are scheduled by the operating system.  
(C) It’s because the thread scheduler has different implementations on different operating systems.  
(D) A thread usually behaves the same if it always runs on the same operating system.  
b, c  

2. Why does multi-threading have non-deterministic behaviours? Select one or more:  
a. That is because we don't have any control of which thread will be run at when.  
b. That is because the thread has it own control of when to run.  
c. That is because the operating system will schedule thread running.  
ac  

3. Choose the correct statements about race condition. Select one or more:  
a. The 'synchronized' keyword can be used to solve the issue caused by race condition.  
b. For multiple operations involved in a method, the race condition may cause the issue where the method running by one thread can be easily interrupted by another thread.  
c. Race condition is the situation of multiple threads racing.  
d. Race condition occurs when two or more threads try to access or change data at the same time.  
abd  


