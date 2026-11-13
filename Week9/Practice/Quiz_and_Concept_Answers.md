# Week 9 Practice — Quiz and Concept Answers

## Part B — Quiz

| Question | Correct answer | Explanation |
|---|---|---|
| Q1 | **B — O(1)** | Accessing an array element by a known index is constant time. |
| Q2 | **C — Insertion** | Adding a new element is called insertion. |
| Q3 | **C** | Choose a structure by matching required operations and constraints to its strengths. |
| Q4 | **C — Time vs space trade-offs** | Extra memory is used to avoid recomputation and improve speed. |
| Q5 | **B — O(m + n)** | Two separate, non-nested loops add their running times. |
| Q6 | **C — Linear data structure** | Elements follow a sequence with predecessor/successor relationships. |
| Q7 | **C — O(n)** | Big-O ignores constant multipliers and lower-order constants. |
| Q8 | **D — Linked list** | A linked list is a non-primitive data structure. |
| Q9 | **B — O(m × n)** | Every cell in an m-by-n grid is visited once. |
| Q10 | **C** | Data structures organize, store, and provide efficient access to data for required operations. |

## Part C — Concept Questions

### 1. Searching an unsorted array versus a sorted array

In an unsorted array, there is no ordering information to guide the search, so a linear search may inspect every element. Its worst-case time complexity is O(n). In a sorted array, binary search compares the target with the middle element and discards half of the remaining search range each time, giving O(log n) time. The improvement comes from using the ordering to eliminate large portions of the array.

### 2. Why O(2n) becomes O(n)

Big-O describes how the growth rate changes as the input size increases, not the exact number of operations. The factor 2 is a fixed constant and does not change the linear growth pattern. Therefore, 2n operations are classified as O(n), just as 5n or 100n operations are O(n).

### 3. Traversal in linear and non-linear data structures

In a linear structure such as an array, elements are arranged in a sequence and are commonly visited one after another from the first element to the last. In a non-linear structure such as a tree, one element may connect to multiple child elements, creating branches. Traversal therefore follows a defined strategy such as preorder, inorder, postorder, or level-order traversal rather than one simple sequential path.