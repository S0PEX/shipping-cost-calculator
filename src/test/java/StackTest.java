import ak.softwarequality.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(2);
    }

    @Test
    @DisplayName("size should return 0 on empty stack")
    void sizeWithEmptyStack() {
        // Stack is created for each test, so when the method execs the stack is fresh
        // and shouldn't have any elements => isEmpty should return true
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("size should return actual size on non empty stack")
    void sizeWithStack() {
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(1);
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("isEmpty should return true on empty stack")
    void isEmptyWithEmptyStack() {
        // Stack is created for each test, so when the method execs the stack is fresh
        // and shouldn't have any elements => isEmpty should return true
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("isEmpty should return false on non-empty stack")
    void isEmptyWithOneElementInStack() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Push negative number on stack should throw IllegalArgumentException")
    void pushNegativeNumberOnStack() {
        assertThrows(IllegalArgumentException.class, () -> {
            stack.push(-1);
        });
    }

    @Test
    @DisplayName("Push positive number on stack should succeed")
    void pushPositiveNumberOnStack() {
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(2);
        assertEquals(2, stack.top());
    }

    @Test
    @DisplayName("Push positive number on full stack should throw StackOverflowError")
    void pushPositiveNumberFullOnStack() {
        StackOverflowError e = assertThrows(StackOverflowError.class, () -> {
            stack.push(1);
            stack.push(0);
            stack.push(0);
        });
        assertEquals(e.getMessage(), "Stack is full");
    }

    @Test
    @DisplayName("Pop should remove top element from stack")
    void popElementOnNonEmptyStack() {
        // Init stack
        stack.push(2);
        assertEquals(2, stack.top());

        var item = stack.pop();
        assertEquals(2, item);
    }

    @Test
    @DisplayName("Pop should return -1 on empty stack")
    void popElementOnEmptyStack() {
        var item = stack.pop();
        assertEquals(-1, item);
    }

    @Test
    @DisplayName("Top should return -1 on empty stack")
    void topOnEmptyStack() {
        var element = stack.top();
        assertEquals(-1, element);
    }

    @Test
    @DisplayName("Top should top element on stack")
    void topOnInsertOnStack() {
        stack.push(1);
        assertEquals(1, stack.top());

        stack.push(2);
        assertEquals(2, stack.top());
    }
}
