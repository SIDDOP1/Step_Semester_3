# Week 8 Practice — Quiz & Concept Answers

## Multiple-choice quiz

| Question | Answer | Reason |
|---|---|---|
| 1 | **C — Polymorphism** | A common processor can handle different event implementations uniformly. |
| 2 | **C — Encapsulation** | Private state is changed only through a validating method. |
| 3 | **C — Author 1 — 1..* Book** | Each book has exactly one author; an author writes one or more books. Books survive author removal, so this is not composition. |
| 4 | **D — Composition** | Cart items have a lifecycle dependent on their owning cart. |
| 5 | **D — Generalization** | ProgrammingCourse and DesignCourse are specialized “is-a” types of Course. |
| 6 | **C — Realization** | PdfDocument and WordDocument implement the Printable interface contract. |
| 7 | **B — Association** | Customer and Order are related, but neither owns the other's lifecycle. |
| 8 | **C — State diagram** | It models states and permitted transitions over an object's lifecycle. |
| 9 | **B — Abstraction** | The interface exposes the generate() contract while hiding implementation details. |
| 10 | **C — Sequence diagram** | It shows time-ordered messages between AuthenticationService and UserRepository. |

## Concept answers

### 1. Encapsulation in the User email design

The User object should own and protect its email state. The email field should be private so external code cannot assign arbitrary values. A public changeEmail(newEmail) method validates the format and checks uniqueness before updating the field. Direct access could store malformed or duplicate addresses, leaving the object invalid. Encapsulation centralizes these rules, preserves invariants, and ensures every update follows the same validation process. A getter may expose the current email without allowing uncontrolled modification.

### 2. Inheritance versus composition for optional report capabilities

Inheritance is suitable when report types share a genuine is-a relationship and common behavior. It is less suitable for optional combinations such as export and visualization: a report may need export only, visualization only, both, or neither. A deep hierarchy for every combination creates many subclasses and makes changes difficult. Composition is more flexible: a ReportingService or report object can hold optional DataExport and DataVisualization strategy objects and delegate to them. New capabilities can be added as new implementations without changing existing report classes.

### 3. Abstraction, overriding, and runtime polymorphism in notifications

Define a Notification interface or abstract class with a common method such as send(). EmailNotification, SMSNotification, and PushNotification implement or override that method with channel-specific behavior. NotificationService depends on the abstraction and calls send() on a Notification reference. At runtime Java dispatches the call to the concrete implementation. Adding InAppNotification means creating another implementation; the service can use it without a new conditional branch, provided it receives the implementation through the same abstraction.

### 4. Composition and aggregation in the Organization scenario

Composition is strong ownership: the part's lifecycle depends on the whole. If an Organization ceases to exist and its Departments are dissolved with it, Organization–Department is composition. Aggregation is weaker ownership: the part can exist independently and be reassigned. Employees may survive a Department's dissolution and move elsewhere, so Department–Employee is aggregation. The distinction is about lifecycle dependency, not merely whether one object stores a collection of another.

### 5. Student–Course multiplicity and duplicate enrollment

The relationship is many-to-many: a Student can take many Courses, and a Course can have many Students. UML commonly shows 0..* at both ends (or * and *), depending on whether zero enrollments are allowed. Multiplicity describes how many instances may be related; it does not itself prevent the same student-course pair from being recorded twice. Enforce uniqueness through an Enrollment association class or an equivalent database/application constraint, such as a unique key on (studentId, courseId).