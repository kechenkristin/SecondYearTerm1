## note
### The Internet(Overview)
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/internet.png)

### Transmission Control Protocol(TCP)
- analogous with a **telephone conversation**
- a **link** between two machine established
- point-to-point communication(which machine and which **port**)
- guarantees the **order** of data
- applications: HTTP, FTP, telnet

### User Datagram Protocol
- analogous with a **postal service**
- **not guarantee order and delivery**
- doesn't have a lot of **error checking** and **ordering overheads**
- not connection-based: sends independent data packets(datagrams)

### Ports
- Port is usually used to distinguish different applications running on the same machine
- Data passed over the Internet has an address and a port associated with it 
- 32 bits IP address, 16 bits port number
- Connection-based communication(TCP), a server application has a **socket bound** to a specific **port**
	- API(URL, URLConnection, Socket, ServerSocket)
- Datagram-based communication(UDP), the **datagram packet contains** the **port number**, and is routed
	- API(DatagramPacket, DatagramSocket, MulticastSocket)

### Sockets
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/socket.png)

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/socket-meaning.png)

### Reading from/writing to sockets
- open a socket
- open an input stream and output stream to the socket
- read from and write to the stream according to the server's protocol
- close the streams
- close the socket

## Exercise
### cf TCP&UDP
Choose the correct statements about the TCP and UDP from the below. Select one or more:  
a. UDP doesn’t have many error-checking and ordering overheads than TCP.  
b. Once the link is set up, TCP can guarantee the order of data delivery.  
c. For TCP, a link needs to be established between two machines before communication.  
d. No link is set up for the UDP communication.  
a, b, c, d  

### ports
Choose the correct statements about ports from the below. Select one or more:  
a. Data passed over the Internet has an address and a port associated with it.  
b. In connection-based TCP communication, a server application has a socket binding to a specific port, so that all the data of that application will go through that port.  
c. In datagram-base UDP communication, the datagram packet contains the port number and it’s routed based on that.  
d. Port is usually used to distinguish different applications running on the same machine.  
e. The destination computer has an IP address and a port number, in order to receive the data.  
a, b, c, d, e

### sockets
Choose the correct steps you need to read from or write to sockets from the below. Select one or more:  
a. Open a socket.   
b. Open an input stream and output stream to the socket.   
c. Close the socket.   
d. Read from and write to the stream according to the server’s protocol.   
e. Close the streams  
a, b, c, d, e  
