## Note
### Dynamic code loading
- program can download a class definition and object reference 
- new types and behaviours can be introduced into a virtual machine
- the behaviours can be dynamically extended at runtime
- classes can be downloaded on demand during remote method invocation.

### Class loaders
- bootstrap: java lib
- extensions: system-wide, platform-specific extension directory
- system: the current directory and any specified in the CLASSPATH environment variable of a system

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/rmi1.png)

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/rmi2.png)

### cf distributed and non-distributed models
- similarities
	- Remote object can be **passed as an argument** or **returned as a result** in any method invocation by **reference**
	- remote object cast remote interface
	- The built-in **instanceof** operator can be used to test the remote interfaces supported by a remote object

- dissimilarities
	- Clients interact with **remote interface** rather than **class implementations**
	- Non-remote arguments to, and results from, passed by **copy**  
	cf A **remote object** is passed by **reference**, not by copying the actual remote implementation. 
	- Client handle **exception**(java.rmi.RemoteException)

## exercise
### Four layers of RMI
What are the four layers in the RMI architecture? Select one or more:  
a. The Stub & Skeleton layer  
b. The remote reference layer and the transport layer  
c. The application layer  
d. The device layer  
a, b, c   

### cf distributed and non-distributed models
#### similarities
Choose the correct statement(s) on RMI from the below. Select one or more:  
a. A stub for a remote object implements the same set of remote interfaces that the remote object implements. This property enables a stub to be cast to any of the interfaces that the remote object implements.  
b. The java instanceof operator is used to test whether the object is an instance of the specified type (class or subclass or interface).  
c. To use a remote object, we first must have a reference to it. An application can register its remote objects with RMI's simple naming facility, the rmiregistry, or the application can pass and return remote object references as part of its normal operation.  
a, b, c  

#### dissimilarities
Choose the correct statement(s) on RMI from the below. Select one or more:  
a. A nonremote object, that is passed as a parameter of a remote method invocation or returned as a result of a remote method invocation, is passed by copy. That is, when a nonremote object appears in a remote method invocation, the content of the nonremote object is copied before invoking the call on the remote object.   
b. When passing a remote object as a parameter, the stub which is the reference for the remote object is passed. A remote object passed as a parameter can only implement remote interfaces.  
c. Since remote methods include java.rmi.RemoteException in their signature, the caller must be prepared to handle those exceptions in addition to other application specific exceptions.   
d. Clients of remote objects interact with remote interfaces, never with the implementation classes of those interfaces.   
a, b, c, d
