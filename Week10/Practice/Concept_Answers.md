# Week 10 — Category B Practice Concept Answers

## 1. Method overloading vs method overriding
Overloading defines methods with the same name but different parameter lists. The compiler selects the matching overload using the arguments, so resolution is at compile time. Overriding occurs when a subclass provides a compatible implementation of an inherited method. The implementation is selected at runtime according to the actual object's type (dynamic dispatch).

## 2. Constructor invocation in inheritance
When a derived object is created, its superclass constructor executes first, followed by the subclass constructor. In Java, a constructor passes values to its direct superclass using super(arguments) as its first statement. If no explicit superclass call is written, Java inserts super() when an accessible no-argument constructor exists.

## 3. Concrete classes, abstract classes, and interfaces
A concrete class can be instantiated and can hold instance state and implemented behavior. An abstract class cannot be instantiated directly; it can contain fields, constructors, concrete methods, and abstract methods, making it useful for related subclasses that share state or implementation. An interface defines a capability contract for classes, including unrelated classes. Java interfaces can have constants and default/static methods, but no per-object instance fields. Choose a concrete class for complete objects, an abstract class for a shared base, and an interface for a common capability.

## 4. Identical abstract methods from two interfaces
If two interfaces declare the same compatible abstract method signature, one public implementation in the implementing class satisfies both contracts. If their return types are incompatible, the class may be unable to implement both and compilation fails. This shows that a class can fulfill multiple interface contracts with one shared implementation.

## 5. Why override equals() and hashCode() together
equals() defines content equality, while hashCode() determines the hash bucket used by hash-based collections. Java requires equal objects to have equal hash codes. If equals() is overridden but hashCode() is not, objects considered equal may be placed in different buckets, causing HashSet and HashMap lookup or duplicate detection to fail. Both methods should use the same identity fields.

## 6. Shallow copy vs deep copy
A shallow copy duplicates the outer object but copies references to nested mutable objects, so the original and copy share those nested objects. For example, two copied Student objects might refer to the same mutable Address; changing the address through one affects the other. A deep copy duplicates the nested mutable objects too, giving the copy an independent object graph.

## 7. Inner class vs static nested class
A non-static inner class is associated with an instance of its enclosing class, is normally created through an enclosing object, and can access that object's instance members. A static nested class does not require an enclosing instance and can directly access only the enclosing class's static members. An inner class suits an object-specific helper such as an iterator tied to one collection; a static nested class suits a helper node that does not need an outer object.

## 8. Array operation complexities
Access by array index is O(1), because the element address is calculated directly from the base address and index. Inserting or deleting in the middle of a fixed-size array is O(n) in the worst case because later elements must be shifted to make or close a gap.

## 9. Uniform processing of derived objects
A base-type array can hold references to objects of different subclasses. A loop can call an overridden method through each base reference; dynamic dispatch selects the implementation belonging to the actual object at runtime. This is polymorphism and avoids explicit type checks.

## 10. Choosing inheritance or an interface
Use inheritance for a genuine IS-A relationship where a subtype can be treated as its base type and may share state or implementation. Use an interface for a CAN-DO capability shared by otherwise unrelated classes. For example, an ElectricBus and ElectricCar can both implement Chargeable even if they belong to different class hierarchies.
