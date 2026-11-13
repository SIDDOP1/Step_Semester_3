# Week 7 — Abstraction & Interfaces

Solutions for both Week 7 PDFs:
- Assignment: Morning Wake-Up Circuit; Gallery Description Cards; Backyard Toolshed Routine; Digital Classroom Setup; Skyline Delivery Fleet.
- Practice: Talking Toy Box; Warehouse Label Printer; Orchestra Warm-Up Routine; Smart Kitchen Assistant; Package Drop-Off Log.

Each problem is a standalone Java source file with a matching public class. Compile/run example:

```bash
javac Week7/Practice/Problem5_PackageDropOffLog.java
java -cp Week7/Practice Problem5_PackageDropOffLog
```

Use Java 8 or newer.

**Source-specification note:** The Week 7 multilevel-inheritance exercises say the base class method is abstract while also requiring a subclass to call `super.method()`. Java does not allow a subclass to invoke an abstract superclass implementation. The supplied examples therefore keep the base method abstract, implement the first concrete behavior in the intermediate class, and call `super.method()` from the next subclass. This preserves the requested hierarchy and runnable expected output, while noting the impossible literal requirement.