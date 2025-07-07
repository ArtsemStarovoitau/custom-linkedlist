# Custom LinkedList Implementation

This project is a from-scratch implementation of a singly linked list data structure in Java. The goal is to demonstrate a fundamental understanding of data structures and their operations.

The project is built with Gradle and is fully covered by unit tests using JUnit 5.

---

## Implemented Operations

* `size()`: Returns the number of elements in the list.
* `addFirst(el)`: Adds an element to the beginning of the list.
* `addLast(el)`: Adds an element to the end of the list.
* `add(index, el)`: Adds an element at the specified index.
* `getFirst()`: Returns the first element.
* `getLast()`: Returns the last element.
* `get(index)`: Returns the element at the specified index.
* `removeFirst()`: Removes and returns the first element.
* `removeLast()`: Removes and returns the last element.
* `remove(index)`: Removes and returns the element at the specified index.

---

## Tech Stack

* **Language:** Java 17
* **Build Tool:** Gradle
* **Testing:** JUnit 5

---

## Requirements

To build and run the project, you need **JDK 17** or higher.

---

## Usage

This project uses the Gradle Wrapper, so you don't need a system-wide Gradle installation. All commands should be run from the project's root directory.

### Run Tests

To execute all unit tests:
```bash
./gradlew test