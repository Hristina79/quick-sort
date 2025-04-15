import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> queue = new DoubleLinkedList<>();
        queue.put(5);
        queue.put(2);
        queue.put(9);
        queue.put(1);
        queue.put(6);
        queue.put(4);

        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(queue, Comparator.naturalOrder());

        System.out.println("Sorted result: " + queue);
    }
}
