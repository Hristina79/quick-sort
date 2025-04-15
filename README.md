## Quick Sort Implementation in Java
This repository contains an implementation of the Quick Sort algorithm in Java.

Quick sort: sorting algorithm that recursively partitions an array around a pivot, sorting elements smaller than the pivot to its left and larger to its right.

### Project Structure
- MyQueue.java

  Interface defining the basic queue operations (`put`, `remove`, `contains`, etc.).

- DoubleLinkedList.java

  Implements MyQueue<T> using a double linked list. Provides the queue functionality used by the sorting algorithm.

- QuickSort.java

  Implements the quick sort algorithm specifically made to work with DoubleLinkedList<T>. It supports custom sorting using a Comparator, or default to natural ordering.

- Main.java

  Contains an example where a DoubleLinkedList is filled with data, sorted using QuickSort, and results are printed.

- DoubleLinkedListTest.java

  Provides unit tests to ensure correctness on DoubleLinkedList implementation.

### How It Works
1. Covert DoubleLinkedList into array for easier access.
2. Performs QuickSort.
3. Return the sorted values into the list into correct order.
