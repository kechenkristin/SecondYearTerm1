## Note
https://github.com/kechenkristin/SecondYearTerm1/blob/main/ECM2414/extra/EventListener/EventListener.pdf
### What & Why
- What
	- Irrespective of languages/paradigm
	- Two general options
		- polling for the event
		- event-driven programming
- Why - GUIs
react - button

### Java event model - delegation model
- Source
	- an object that **generates an event**
	- must register listeners 

- Listener
	- an object that is **notified** of an event **occurring**  
	- must
		- (1) have registered
		- (2) have methods to deal with these notifications

- Event
	- an object that contains **information** about a **state change** in a source.

```java
public class Beeper extends JPanel implements ActionListener {
	JButton button;		// source
	public Beeper () {
		super(new BorderLayout());
		button = new JButton("Click Me");
		button.setPreferredSize(new Dimension(200, 80));
		add(button, BorderLayout.CENTER);
		button.addActionListener(this); 	// Listener
	}
	
	// Event
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}
} 
```

## Exercise
1. Choose the correct statement(s) on event handling from the below. Select one or more:  
a. Events are not something based on Java only. They are a programming concept that is implemented over a variety of different languages.  
b. Polling and event-driven programming are two typical ways of monitoring an event.  
c. Events are included not only in software programming paradigm, but also used in other paradigms like web programming. Event handling happens in a range of environments.  
d. Event handling can only be used in Java.  
a, b, c  

2. Choose the correct statement(s) from the below. Select one or more:  
a. Events in Java use the delegation model.  
b. The delegation model comprises source, listener, and event.  
c. A listener is an object and this object is notified that something has happened.  
d. A source is an object that generates an event.  
e. An event is an object containing information about what has happened.   
a, b, c, d, e  

3. Choose the correct statement(s) about events and listeners in Java.  
(A) They can only be used by GUIs.  
(B) They are not restricted to GUIs.  
(C) Java uses the delegation model to handle events and listeners.  
(D) The delegation model comprises two objects: event and listener.  
B, C  
