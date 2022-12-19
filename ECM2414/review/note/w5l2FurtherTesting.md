## Note
### Mock objects
- use mock objects when the real object
	- has non-deterministic behaviour
	- is difficult to set up
	- has behaviour that is hard to trigger(eg. network error)
	- is slow
	- has(or is) a user interface
	- does not yet exist

### Test suites
- allow us to group multiple test classes to run as a single batch
- allow us to run a specific subset of unit tests from multiple test classes
```java
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({TestAccount.class, TestBank.class})
public class TestSuite {
	// empty , as the class is just a holder
	// for the annotations above
}
```

### Test-driven development
- help design code better
- see the code from **user's perspective**, not the develper's

### Invariants
- Invariants are assertions about classes/objects that should not change

## Exercise

