# Week 10 — Category B Practice Quiz Answers

| Q | Answer | Explanation |
|---|---|---|
| 1 | **B** | Student can access protected age and public getName(), but not private name. |
| 2 | **C** | Diagram 3 attempts to let S extend both Q and R, which violates single class inheritance. |
| 3 | **B** | Constructor order is Person, Employee, Manager: superclass constructors run first. |
| 4 | **C** | A subclass can directly access a protected field. It cannot directly access private fields or override final methods. |
| 5 | **B** | Runtime dispatch invokes Bus.fare() for a Bus object. |
| 6 | **B** | Different parameter lists are overloading; same-signature subclass redefinition is overriding. |
| 7 | **A** | A Shape reference exposes members declared by Shape, not Circle-only members such as radius. |
| 8 | **C** | Circle.area() and Square.area() are called according to each object's runtime type. |
| 9 | **B** | The object is Current, so Current cast succeeds and Savings cast fails. |
| 10 | **B** | Polymorphism processes derived objects through a base reference without type-specific conditionals. |
| 11 | **A** | printDocument() is the exposed behavior; buffer and helper methods are hidden implementation details. |
| 12 | **B** | Vehicle is abstract, but a Vehicle reference can refer to a concrete Car object. |
| 13 | **B** | A subclass that does not implement an inherited abstract method must itself be abstract. |
| 14 | **B** | A concrete MonthlyReport must implement generateBody(), or be declared abstract. |
| 15 | **A** | An interface defines operations a type promises to provide, not per-object state. Java interfaces can also have constants and default/static methods. |
| 16 | **B** | Interface methods without bodies are implicitly public abstract; interface fields are public static final. |
| 17 | **C** | DataProcessor must implement both serialize() and reset(), unless it is abstract. |
| 18 | **C** | An interface defines a shared capability contract for unrelated classes. |
| 19 | **B** | Dog IS-A Animal (generalization); Eagle CAN-DO Flyable (realization). |
| 20 | **A** | equals(), hashCode(), and toString() are inherited from Java's Object class. |

**Clarification for Q15:** A is the best available answer, but modern Java interfaces may contain default and static method implementations and constants. They still cannot hold per-instance fields.
