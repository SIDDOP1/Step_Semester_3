# Week 10 — Category B Solutions

Solutions for the four linked-list assignments and all five coding problems, quiz questions, and concept questions in the uploaded Week 10 PDFs.

## Assignment — Linked Lists
1. Priority Token Insertion — Assignment/Problem1_PriorityTokenInsertion.java
2. Cancelled Orders Cleanup — Assignment/Problem2_CancelledOrdersCleanup.java
3. Reverse the Queue — Assignment/Problem3_ReverseTheQueue.java
4. Train Coaches Both Ways — Assignment/Problem4_TrainCoachesBothWays.java

## Practice — OOP and Java
1. Bank Account Withdrawal System
2. Campus Vehicle Pass System
3. Student Club Registration Management
4. Class Marks Grid Analysis
5. Payroll Register System

Practice programs are in Practice/. Quiz and concept answers are in Quiz_Answers.md and Concept_Answers.md.

## Compile and run
Use Java 8 or later. Compile an individual program from the repository root, for example:

    javac Week10/Assignment/Problem1_PriorityTokenInsertion.java
    java -cp Week10/Assignment Problem1_PriorityTokenInsertion

For scanner-based practice programs, enter operations exactly as specified in the worksheet. For example, the bank program accepts Savings S1 5000 and WITHDRAW S1 4500. End input with EOF (Ctrl+Z then Enter on Windows, Ctrl+D on macOS/Linux).

## Complexity highlights
- Singly linked list front insertion: O(1); tail insertion and indexed insertion without a tail reference: O(n).
- Remove all matching nodes: O(n) time and O(1) extra space.
- Reverse a singly linked list in place: O(n) time and O(1) extra space.
- Doubly linked list coach search: O(n); unlink after locating: O(1); append with head/tail: O(1).
- Hash-based registration and account/vehicle lookup: O(1) average per operation.
- Marks analysis and payroll summary: O(n) time.

Each Java source file is self-contained and does not use java.util.LinkedList for the linked-list assignment solutions.
