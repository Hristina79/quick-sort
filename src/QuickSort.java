import java.util.Comparator;

public class QuickSort<T extends Comparable<T>> {

    public MyQueue<T> sort(MyQueue<T> queue, Comparator<T> comparator) {

        // check if input is from a compatible type (of DoubleLinkedList)
        if(!(queue instanceof DoubleLinkedList<T> list)) {
            throw new IllegalArgumentException("The sorter only works with DoubleLinkedList!");
        }

        // Convert to array for easier indexing in QuickSort
        T[] array = (T[]) new Comparable[list.size()];
        DoubleLinkedList.Node<T> current = list.head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }

        // Perform QuickSort on the array
        quickSort(array, 0, array.length - 1, comparator);

        // Put sorted data back into the linked list
        list.head = null;
        list.tail = null;
        list.size = 0;
        for (T item : array) {
            list.put(item);
        }

        return list;
    }
    private void quickSort(T[] arr, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high, comparator);

            // Print current state of array after partition
            System.out.print("Iteration: ");
            printArray(arr);

            // sort the elements before the pivot
            quickSort(arr, low, pi - 1, comparator);
            // sort the elements after the pivot
            quickSort(arr, pi + 1, high, comparator);
        }
    }

    private int partition(T[] arr, int low, int high, Comparator<T> comparator) {
        // Select the last element as the pivot
        T pivot = arr[high];
        // Index of the smaller element
        int i = low - 1;

        // Traverse the array and rearrange elements based on the pivot
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (compare(arr[j], pivot, comparator) <= 0) {
                i++;
                // Swap element at i with element at j
                swap(arr, i, j);
            }
        }

        // Place the pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1; // Return the partition index
    }

    private void swap(T[] arr, int i, int j) {
        // Swap elements at indices i and j
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Computes two elements using the provided Comparator / if null it takes natural ordering
     */
    private int compare(T a, T b, Comparator<T> comparator) {
        return (comparator != null) ? comparator.compare(a, b) : a.compareTo(b);
    }

    private void printArray(T[] arr) {
        System.out.print("[");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
            if (k < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}