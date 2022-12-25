## Note
### Collection
A group of objects known as elements

### Set interface
- A Set contains no duplicate elements.
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

