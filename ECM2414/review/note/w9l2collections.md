## Note
### Collection
A group of objects known as elements

### Set interface
- A Set contains no duplicate elements.
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/collection1.png)

![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/collection2.png)

- Two sets are treated equal if they contain the same elements (even if the containers are different).
- Concrete Set Implementation
	- HashSet<E>
		- fast
		- no order guarantees
		- a hash table(HashMap) behind it
	- TreeSet<E>
		- slower
		- ordered
		- a red-black tree structure
	- LinkedHashSet<E>
		- ordered
		- set insertion(stored in a hash table with a linked list running through it)

### List Interface
- An ordered collection of elements, may contain duplicate elements
- Two lists are treated equal if they contain the same elements in the same order.
- Concrete List Implementation
	- ArrayList<E> (dynamically resizing array)
	- LinkedList<E> (doubly linked list)

### Queue interface
- A collection of elements, stored for processing
- first in first out
```java
public interface Queue<E> extends Collection<E> {
	E element();
	boolean offer(E e);
	E peek();
	E poll();
	E remove();
} 
```
- note
	- *add* and *offer*
	- *remove* and *poll* 
	- *element* and *peek*

### Deque interface
![avatar](https://github.com/kechenkristin/imagesGitHub/blob/main/notes/uni/ecm2414/deque.png)

### Map interface
- generic type <K,V>
- map keys to values, each key mapping to at most one value
```java
public interface Map<K,V> {
	// Basic operations
	V put(K key, V value);
	V get(Object key);
	V remove(Object key);
	boolean containsKey(Object key);
	boolean containsValue(Object value);
	int size();
	boolean isEmpty();

	// Bulk operations
	void putAll(Map<? extends K, ? extends V> m);
	void clear();

	// Collection Views
	public Set<K> keySet();
	public Collection<V> values();
	public Set<Map.Entry<K,V>> entrySet();
}
```

- Concrete Map implementations
	- Hashmap<K, V>
	- Treemap<K, V>
	- LinkedHashMap<K,V>

## Exercise
### Set
Suppose s1 and s2 are sets, and choose the correct statement(s) from the below. Select one or more:  
a. s1.addAll(s2) transforms s1 into the union of s1 and s2.  
b. s1.containsAll(s2) returns true if s2 is a subset of s1.  
c. s1.removeAll(s2) transforms s1 into the set difference of s1 and s2.  
d. s1.retainAll(s2) transforms s1 into the intersection of s1 and s2.  

Choose the correct statement(s) on the Set implementations from the below. Select one or more:  
a. LinkedHashSet, which is implemented as a hash table with a linked list running through it, orders its elements based on the order in which they were inserted into the set (insertion-order).  
b. TreeSet, which stores its elements in a red-black tree, orders its elements based on their values; it is substantially slower than HashSet.  
c. HashSet, which stores its elements in a hash table, is the best-performing implementation; however it makes no guarantees concerning the order of iteration.  
a, b, c  

### java collection
Choose the correct statement(s) on Java Collections from the below. Select one or more:  
a. A Map has two generic type arguments, <K, V>, and is used to map keys to values, each key mapping to at most one value.  
b. A Queue is a collection of elements, stored for processing. Most concrete implementations of Queue use a first-in-first-out ordering.  
c. A Set contains no duplicate elements. Two sets are treated equal if they contain the same elements.  
d. A List is an ordered collection of elements, that may contain duplicate elements. Two lists are treated equal if they contain the same elements in the same order.  
a, b, c, d  
