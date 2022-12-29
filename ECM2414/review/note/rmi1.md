## Note
### RMI
- allowas an object on the virtual machine to invoke methods on another object in another virtual machine
- server and client
	- server
		- makes remote objects
		- generates accessible references
		- waits for ...
	- client
		- obtain a reference
		- invoke a method

### Distributed object applications
- remote object location
	- Server registers the remote objects in registry
	- Pass remote objects reference via invocations of methods on other objects
- remote object communication
	- Handled by the RMI framework
- accessing class definitions
	- RMI

### Components
- Registry
- Server
- Client

### Creating a distributed/remote service
- make a remote interface
- make a remote implementation
- use the java compiler to generate the client and servers helpers automatically(the skeletons and stubs)
- start the RMI registry
- start the remote service

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/rmi3.png)
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/rmi4.png)

## Exercise
### RMI
1. Choose the correct statement(s) on Java RMI from the below. Select one or more:  
a. It provides the mechanism by which the server and the client communicate and pass information back and forth.   
b. It has a typical server application creating a number of remote objects, making references to those remote objects accessible, and waiting for clients to invoke methods on those remote objects.   
c. It has a typical client application getting a remote reference to one or more remote objects in the server and then invoking methods on them.   
d. It can download the method from the server to the client to run.  
a, b, c  

### Components
1. Choose the basic component(s) in Java RMI from the below. Select one or more:  
a. Client  
b. Server  
c. Registry  
a, b, c  

### Creating a remote service
1. Choose the correct statement(s) on creating a remote service from the below. Select one or more:  
a. Start the RMI registry  
b. Make a remote interface  
c. Start the remote service   
d. Use the java compiler to generate the client and server helpers automatically  
e. Make a remote implementation  
b, e, d, a, c
