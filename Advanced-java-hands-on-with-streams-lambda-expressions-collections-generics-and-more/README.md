## Advanced-java-hands-on-with-streams-lambda-expressions-collections-generics-and-more

### Functional Programming:
1. Lambda expressions
2. Method references
3. Stream api

### Lambda expressions: Is a short, anonymous function that can be used to implement functional interfaces
whereas functional interface are interfaces with only one abstract method.

lambda syntax:
parameters list: (a,b)
Arrow Token: -> (separates arrow from body)
Body: {} (Single statement or block of code)

e.g.: sum of two numbers
(a,b)->{a+b}

E.g.: List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

Predicate Function: contains abstract method test (boolean test(T t))
``` e.g.: 
Predicate<Integer> evenNumber = n -> n % 2 == 0;
//The abstract method of predicate is boolean test(T t);
evenNumber.test(10);//true
or
numbers.stream().filter(evenNumber).collect(Collectors.toList);
```
Consumer Function: contains abstract method void accept(T t);
Consumer print = c -> System.out.println(c);
numbers.stream().filter(evenNumber).forEach(print);//2 4

### Method Reference:
Shorter way of writing a lambda
Can be used for existing methods.
syntax "::" (Two colons)

### Stream API:
Process and manipulate datasets using a functional programming approach.
Stream: A sequence of elements that can be processed sequentially or in parallel
streams can be created from various sources such as collections, arrays, string, or I/O channels.

e.g.:
Stream from collection:
List<String> names=Arrays.asList("abc","bcd","cde");
Stream<String> nameStream=names.stream();

Stream from array:
String[] namesArray={"abc","bcd","cde"};
Stream<String> namesArrayStream=Arrays.stream(namesArray);

Stream using of():
Stream<String> names=Stream.of("abc","bcd",cde");

Stream Operations:
1. Intermediate Operations: Chainable, return new version of stream. And are lazy, and do not execute until a terminal operation is called.
filter: applies predicate.
map: transforms elements.
flatmap: flattens transformed elements stream. transform each element into stream.

2. Terminal Operation: End stream, no other operations allowed.
forEach: applies action to each element in the stream.
collect: compiles stream elements into a collection.
reduce: condenses stream to a single value.

```
E.g.:
.flatMap(s->s.getGrades().values().stream())
.max(Integer::compareTo).orElseGet(()->0);
```

### Collections and Generics:
List of Interface and classes:
Interface: List, Set, Queue, Map, Dequeue, Sorted Set, Navigable Set, Sorted Map, Navigable map
Classes: ArrayList, LinkedList, HashSet, LinkedHashSet, TreeSet, TreeMap

List: Ordered collection that allows duplicates
Set: Unordered collection that store unique values
Map: Collection of key, value pairs

List:
ArrayList: resizable array-based implementation of list
LinkedList: Double linked list implementation of List

Set:
HashSet: hashtable based implementation of Set
TreeSet: balanced binary tree-based implementation of set

Map:
HashMap: Hashtable based implementation of map.
TreeMap: balanced binary tree-based implementation of map




### Generics:
Before Generics collections only support type object
Benefits:
Allows to specify the type of a collection.
Eliminate the need for casting.
Type Safety: Generics catch type safety errors at compile time.
reusable

Create a Generic class:
Define type parameter.

### Annotation:
Annotation allows to add metadata to pure code.
These metadata could be used at compile time or runtime.
Provide additional Information or behavior.


### Reflection API:
Inspect and manipulate code at runtime.
Dynamic code manipulation and annotation can achieve intriguing results

Uses:
Inspect the structure of a class and its methods, fields, and annotations.
create new instance of a class, invoke methods and access fields.
Modify behavior of class, field, method at runtime

Few Built in annotations:
@Override: method level annotation indented to override a method in a super class
@Deprecated: class, method or field level annotation as deprecated
@SuppressWarnings: Tells the compiler to suppress specific warnings

Use case:
Generating code
Enforce coding standard
providing additional context

### Concurrency and Multithreading:
Concurrency: The ability of a program to manage multiple tasks simultaneously.
This allows efficient utilization of system resources and can be achieved using various ways. One of them in multi-Threading.

Multithreading: A Specific form of concurrency that involves executing multiple threads simultaneously, where threads are light weight, independent units of execution
Synchronization and locks: When resources must be thread exclusive.
The Synchronized keyword allows one thread at a time.

e.g.:
```
public class SynchronizedExample {
  private int counter = 0;
  synchronized void incrementCount() {
    counter++;
  }
}
```
Executors: Used to create thread pools that can manage the execution of multiple tasks concurrently
```
public class ExecutorExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    Runnable task = () -> System.out.println(
        "Hello from Thread name : " + Thread.currentThread().getName() +
            " with id: " + Thread.currentThread().getId());

    for (int i = 0; i < 10; i++) {
      executorService.execute(task);
    }
    executorService.shutdown();
  }
}
```
### Concurrent Collections:
Designed for concurrent access and manipulation.
example: concurrentHashMap, ConcurrentLinkedQueue, ConcurrentSkipListSet

Future and Callable:
Callable: Like Runnable but return value
Future: represents pending computational result

### Singleton Design patterns: 
Creational design pattern which ensures there exists only one instance
via class, there is a global point of access to the instance.
useful: when we need to maintain a shared state or resource through your application.

Use case:
Database connection: Single Shared database connection management
Logger: accessible to multiple components of an application
Configuration setting: Have single configuration throughout its lifecycle

benefits:
Controller access to single instance
Lazy instantiation only created when its needed.
Shared resource management.

Implementation:
#### Eager Initialization:
public class SingletonEagerExample {
  private static SingletonEagerExample instance = new SingletonEagerExample();
  private SingletonEagerExample() {
  }
  public static SingletonEagerExample getInstance() {
    return instance;
  }
}
#### Lazy Initialization:
public class SingletonLazyExample {
  private static SingletonLazyExample instance;

  private SingletonLazyExample() {
    if (instance != null) {
      throw new IllegalStateException("Instance already created");
    }
  }

  public static SingletonLazyExample getInstance() {
    if (instance == null) {
      synchronized (SingletonLazyExample.class) {
        if (instance == null) {
          instance = new SingletonLazyExample();
        }
      }
    }
    return instance;
  }
}



#### Interview Question
- Collection:
	- Create a Custom Collection

- Annotation:
	- Create a Custom Annotation

- Generic:
	- Create a Generic Class
