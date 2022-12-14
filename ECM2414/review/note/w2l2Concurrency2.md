## Note
https://www.yuque.com/mo_ming/gl7b70/gw2xt5
### three liveness issues with multi-threading
- Deadlock
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/deadlock.png)  
- Starvation
- Livelock  
two threads are too busy responding to one another to do work  
活锁出现在两个线程互相改变对方的结束条件，最后谁也无法结束，例如  
```java
public class TestLiveLock {
    static volatile int count = 10;
    static final Object lock = new Object();
    
    public static void main(String[] args) {
        new Thread(() -> {
            // 期望减到 0 退出循环
            while (count > 0) {
                sleep(0.2);
                count--;
                log.debug("count: {}", count);
            }
        }, "t1").start();
        
        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                sleep(0.2);
                count++;
                log.debug("count: {}", count);
            }
        }, "t2").start();
        
    }
}
```
### Thread Lifecycle
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/lifecycle.png)

### Some further tools/methods to help design better threaded applications
- wait() notify() 
```java
public synchronized void announceBob() {
	while(!bob) {
		try {
			wait();
		} catch (InterruptedException e) {}
	}
}
public synchronized notifyBob() {
	bob = true ;
	notifyAll ();
	//notify();
}
```
- sleep()
	- cf sleep() and wait()
		- sleep 是 Thread 方法，而 wait 是 Object 的方法 
		- sleep 不需要强制和 synchronized 配合使用，但 wait 需要和 synchronized 一起用 
		- sleep 在睡眠的同时，不会释放对象锁的，但 wait 在等待的时候会释放对象锁 
		- 它们状态 TIMED_WAITING

|    | wait | sleep |
|---- | ---- | ---- |
| occur in a synchronised block | needs | doesn't need|
| monitor(lock) | releases | retains |
| the remainder of its timeslice | doesn’t sacrifice | sacrifices |
| wake up | notify call | interruption |

- yield()
	- current thread pause, other thread execute
	- running ==> runnable
	- stops a thread for unpredictable time
- join()
	- wait for the thread which calls join() method
	- 哪个线程调用join()就等待哪个线程
```java
t.join()
```
wait for t thread finishes  
- explicit locking

### Extra notes
- notify() & notifyAll() (pq21)
- yield() & sleep() (pq22)
	- sleep 
		- 调用 sleep 会让当前线程从 Running进入 Timed Waiting 状态（阻塞） 
		- 其它线程可以使用 interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException 
		- 睡眠结束后的线程未必会立刻得到执行 
		- 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性 
	- yield 
		- 调用 yield 会让当前线程从 Running 进入 Runnable就绪状态，然后调度执行其它线程 
		- 具体的实现依赖于操作系统的任务调度器 
- run() & start() (pq23)
	- 直接调用 run 是在主线程中执行了 run，没有启动新的线程 
	- 使用 start 是启动新的线程，通过新的线程间接执行 run 中的代码


## exercise
### deadlock, starvation, livelock
1. Choose the correct statement(s) from the below. Select one or more:  
a. Starvation describes a situation where a thread is unable to gain regular access to shared resources and is unable to make a progress. This happens when shared resources are made unavailable for long periods by "greedy" threads.  
b. Livelock describes a situation where a thread often acts in response to the action of another thread. If the other thread's action is also a response to the action of the first thread.  
c. Deadlock, starvation and livelock are the liveness issues of multi-threading.  
d. Deadlock can occur in a situation when a thread is waiting for an object lock that is acquired by another thread, and the second thread is waiting for an object lock that is acquired by the first thread. Both threads are waiting for each other to release the lock, and this condition is called deadlock.  
a, b, c, d

### thread lifecycle
1. Choose the correct the statement(s) about the thread lifecycle from the below. Select one or more:  
a. A thread is considered dead when its run() method completes.  
b. When the start() method is called on a thread it enters the runnable state.   
c. Thread scheduler selects a thread to go from the runnable state to the running state. In the running state, the thread starts executing by entering the run() method.  
d. When the instance of a thread is created using the new operator it is in the new state, but the start() method has not been invoked on the thread yet, thread is not eligible to run yet.  
a, b, c, d  

2. Choose the correct statement(s) about the thread lifecycle.  
(A) When the start() method is called, the thread enters the New state.  
(B) When the start() method is called, the thread enters the Running state.  
(C) When the start() method is called, the thread enters the Runnable state.  
(D) When the sleep() method is called, the thread enters the Sleep state.  
c, d  

### cf wait() and sleep()
1. Choose the correct statement(s) about the wait() and sleep() methods from the below. Select one or more:  
a. Sleep() method does not need to occur in a synchronised block.  
b. Wait() method releases the lock when called and doesn’t sacrifice the remainder of its timeslice.  
c. Sleep() method retains the lock when called and sacrifices the remainder of its timeslice.  
d. Wait() method must occur in a block synchronised on the monitor object.  
a, b, c, d

2. Choose the correct statement(s) about the difference between the wait() and
sleep() methods in Java.  
(A) wait() doesn’t need to occur in a synchronised block.  
(B) sleep() must occur in a synchronised block.  
(C) wait() releases the lock when called.  
(D) sleep() releases the lock when called.  
c  

### join()
1. Given that there are two threads created, namely thread1 and thread2, choose the
correct statement(s) about thread behaviours in the code snippet below
```java
thread1.start();
thread1.join();
thread2.start();
```
(A) Thread2 will start only after thread1 finishes.  
(B) Thread1 will start only after thread2 finishes.  
(C) Thread1 can start during the running of thread2.  
(D) Thread2 can start during the running of thread1.  
a  
