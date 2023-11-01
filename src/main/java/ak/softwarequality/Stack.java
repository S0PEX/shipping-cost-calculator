package ak.softwarequality;

/**
 * The Stack class represents a basic stack data structure with a fixed maximum size.
 */
public class Stack {
    /**
     * Index of the position in the stackArr
     */
    int pos = -1;
    /**
     * Array storing stack items
     */
    int[] stackArr = null;
    /**
     * Max size of the stack
     */
    private int maxSize = 0;

    /**
     * Constructs a stack with the specified maximum size.
     *
     * @param size The maximum size of the stack.
     */
    public Stack(int size) {
        maxSize = size;
        stackArr = new int[size];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return The top element of the stack. Returns -1 if the stack is empty.
     */
    public int pop() {
        if (pos == -1)
            return -1;
        int element = stackArr[pos];
        stackArr[pos] = -1;
        pos--;
        return element;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element The element to be pushed.
     * @throws StackOverflowError       If the stack is full.
     * @throws IllegalArgumentException If the element is negative.
     */
    public void push(int element) throws StackOverflowError, IllegalArgumentException {
        if (element < 0)
            throw new IllegalArgumentException();
        int npos = pos + 1;
        if (npos == maxSize)
            throw new StackOverflowError("Stack is full");
        pos = npos;
        stackArr[pos] = element;
    }

    /**
     * Returns the current number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size() {
        return pos + 1;
    }

    /**
     * Returns the top element of the stack.
     *
     * @return The top element of the stack. Returns -1 if the stack is empty.
     */
    public int top() {
        return isEmpty() ? -1 : stackArr[pos];
    }
}