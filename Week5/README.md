# Week 5 — Access Modifiers, Encapsulation & Object Modeling

Solutions for both uploaded Week 6 PDFs, organized under the requested `week5` branch.

## Folder structure

- `Assignment/` — five individual homework problems:
  1. Membership Field Reach Checker
  2. Reference Desk Subclass Reach
  3. Book Copy Circulation Guard
  4. LibraryMember JavaBean & Security Answer
  5. Immutable Loan Receipt & Nightly Circulation Ledger
- `Practice/` — five Category B practice problems:
  1. Movie Ticket Field Visibility Checker
  2. Subclass Ticket Access
  3. Seat Booking Encapsulation Guard
  4. MovieBookingProfile JavaBean & OTP
  5. Immutable Booking Receipt & Nightly Settlement

## Compile and run

Each source file is self-contained and has a public class with a matching filename. From the repository root, for example:

```bash
javac Week5/Assignment/Problem1_MembershipFieldReachChecker.java
java -cp Week5/Assignment Problem1_MembershipFieldReachChecker
```

Use the corresponding filename and public class for the other problems. Java 8 or newer is recommended.

## Important Java specification conflict in Problem 5

Both PDFs ask for the receipt base class to be `final` and also require a subclass to extend it. Java forbids extending a final class. To keep the requested inheritance and make the examples compile, the two receipt base classes are non-final, while their fields are final, arrays are defensively copied, and all public operations preserve immutable state. This is the only practical way to satisfy the inheritance examples as written.
