import java.util.Queue;

public class DoubleLinkedList<T extends Comparable<T>> implements MyQueue<T> {

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    @Override
    public void put(T node) {
        Node<T> newNode = new Node<>(node);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override   // removes the head
    public T remove() {
        if (head == null) return null;

        T data = head.data;
        head = head.next;
        if (head == null) return null;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Helper function for Assert
    @Override
    public boolean contains(T node) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(node)) return true;
            else current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
