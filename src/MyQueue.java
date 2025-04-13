public interface MyQueue<T> {
    void put(T node);       // place node in queue
    T remove();             // remove node in queue
    boolean isEmpty();
    int size();
    boolean contains(T node);   // check if node is there (mostly used for testing)
}
