import java.util.LinkedList;

/**
 * A queue data structure is one that takes form First-In-First-Out.
 */
public class Queue {
    /**
     * The data structure used to store the queue.
     */
    private LinkedList<int[]> q = new LinkedList<int[]>();
    /**
     * Length of thee queue
     */
    private int length;

    public Queue() {};

    /**
     * Add an element to the queue, specifically to the back.
     * @param newElement The sublist of integer values (coords), e.g., [-2, -1]
     */
    public void enqueue(int[] newElement) {
        this.q.addLast(newElement);
        this.length++;
    }

    /**
     * Remove an element from the front of the queue.
     * @return the element at the front which has been removed.
     */
    public int[] dequeue() {
        int[] element = this.q.pollFirst();
        this.length--;
        return element;
    }

    /**
     * Get the size of the queue.
     * @return queue length.
     */
    public int size() {
        return this.length;
    }

    /**
     * Get whether the queue is empty.
     * @return boolean of if the queue is empty.
     */
    public boolean isEmpty() {
        if (this.length > 0) {
            return false;
        } else {
            return true;
        }
    }
}
