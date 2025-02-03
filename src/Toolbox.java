import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Toolbox {

 /**
   * Removes an element from an array of strings at the specified index, padding with nulls at the end.
   *
   * @param array the array of strings to modify
   * @param index the index of the element to remove
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void removeElementInPlace(String[] array, int index) {
    // Check if the array is null or the index is out of bounds
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }

    // Shift elements to the left starting from the given index
    // This will overwrite the element at the specified index
    for (int i = index; i < array.length - 1; i++) {
        array[i] = array[i + 1]; // Move element at i + 1 to position i
    }

    // Set the last element to null to pad the array after removal
    array[array.length - 1] = null; // Now the last element is null
}

  /**
   * Adds an element to an array of strings at a specified location in-place, evicting the last value.
   *
   * @param array the array of strings to modify
   * @param index the index at which to add the new element
   * @param value the value to add
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void addElementInPlace(String[] array, int index, String value) {
    // Check if the array is null or the index is out of bounds
    if (array == null || index < 0 || index >= array.length) {
        throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }

    // Shift elements to the right starting from the last element
    // This will make room for the new element at the specified index
    for (int i = array.length - 1; i > index; i--) {
        array[i] = array[i - 1]; // Move element at i-1 to position i
    }

    // Insert the new value at the specified index
    array[index] = value;

    // The last element is evicted automatically because the array size remains constant
}

  /**
   * Finds the tail of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the tail node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode findTail(SingleNode head) {
    // Check if the head is null (empty list)
    if (head == null) {
        throw new IllegalArgumentException("Head cannot be null.");
    }

    // Traverse the list until reaching the last node (tail)
    SingleNode current = head;
    while (current.next != null) {
        current = current.next; // Move to the next node
    }

    // Once we reach the last node, return it
    return current;
}


  /**
   * Finds the head of a doubly linked list given the tail.
   *
   * @param tail the tail node of the doubly linked list
   * @return the head node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the tail is null
   */
  public static DoubleNode findHead(DoubleNode tail) {
    // Check if the tail is null (empty list)
    if (tail == null) {
        throw new IllegalArgumentException("Tail cannot be null.");
    }

    // Start at the tail and move backward until we find the head
    DoubleNode current = tail;
    while (current.prev != null) {
        current = current.prev; // Move to the previous node
    }

    // Once we reach the head, return it
    return current;
}


  /**
   * Counts the occurrences of values in a linked list.
   *
   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */
  public static Map<Integer, Integer> countOccurrences(SingleNode head) {
    if (head == null) {
        throw new IllegalArgumentException("Head cannot be null.");
    }

    // Initialize a LinkedHashMap to preserve insertion order
    Map<Integer, Integer> occurrences = new LinkedHashMap<>();

    // Traverse the linked list and update counts in the map
    SingleNode current = head;
    while (current != null) {
        int value = current.data;

        // Update the count in the map
        occurrences.put(value, occurrences.getOrDefault(value, 0) + 1);

        current = current.next;
    }

    return occurrences;
}

  /**
   * Removes a node from a doubly linked list.
   *
   * @param node the node to remove
   * @throws IllegalArgumentException if the node is null
   */
  public static void removeNode(DoubleNode node) {
    if (node == null) {
        throw new IllegalArgumentException("Node cannot be null.");
    }

    // If the node has a previous node, adjust its next pointer
    if (node.prev != null) {
        node.prev.next = node.next;
    }

    // If the node has a next node, adjust its previous pointer
    if (node.next != null) {
        node.next.prev = node.prev;
    }

    // In case the node is the head, we would need to adjust the head pointer (handled outside this method)
    // In case the node is the tail, we would need to adjust the tail pointer (handled outside this method)
}

  /**
   * Finds the nth element in a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @param n the index of the element to find (0-based)
   * @return the nth node, or null if the index is out of bounds
   * @throws IllegalArgumentException if the head is null or n is negative
   */
  public static SingleNode findNthElement(SingleNode head, int n) {
    // Check if the head is null or if n is negative
    if (head == null || n < 0) {
        throw new IllegalArgumentException("Head cannot be null and n cannot be negative.");
    }

    // Traverse the list to find the nth node
    SingleNode current = head;
    int index = 0;

    // Move through the list until we reach the nth node
    while (current != null && index < n) {
        current = current.next;  // Move to the next node
        index++;  // Increment the index
    }

    // If we reached the nth node, return it, otherwise return null (if n is out of bounds)
    return current;
}

  /**
   * Inserts a new node into a singly linked list given a pointer to a node in the middle of the list.
   *
   * @param node the node before which the new node is to be inserted
   * @param newNode the new node to insert
   * @throws IllegalArgumentException if either node or newNode is null
   */
  public static void insertNode(SingleNode node, SingleNode newNode) {
    // Check if either node or newNode is null
    if (node == null || newNode == null) {
        throw new IllegalArgumentException("Node and newNode cannot be null.");
    }

    // The new node should point to the current node
    newNode.next = node.next;
    
    // Now update the current node's next pointer to point to the new node
    node.next = newNode;
}

  /**
   * Rotates a queue to the left by the specified number of positions in-place.
   * 
   * The first k elements of the queue are moved to the end, preserving the order
   * of all elements.
   *
   * Example:
   * Given a queue [1, 2, 3, 4, 5] and k = 2, the result will be [3, 4, 5, 1, 2].
   *
   * @param queue the queue to rotate
   * @param k the number of positions to rotate to the left
   * @throws IllegalArgumentException if the queue is null or k is negative
   */
  public static void rotateQueueLeft(Queue<Integer> queue, int k) {
    // Check if the queue is null or if k is negative
    if (queue == null || k < 0) {
        throw new IllegalArgumentException("Queue cannot be null and k cannot be negative.");
    }

    int size = queue.size();
    // If the queue is empty or k is 0, no rotation is needed
    if (size == 0 || k == 0) {
        return;
    }

    // Normalize k to be within the range of the queue size
    k = k % size;
    
    // Rotate the queue by dequeuing the first k elements and enqueuing them back
    for (int i = 0; i < k; i++) {
        int front = queue.poll();  // Remove the front element
        queue.offer(front);        // Add it back to the end of the queue
    }
  }
  /**
   * Checks if a string has balanced parentheses using a stack.
   * 
   * A string is considered to have balanced parentheses if each opening parenthesis
   * '(' has a corresponding closing parenthesis ')', and the parentheses are correctly nested.
   *
   * Example:
   * - Input: "(()())" -> Returns true
   * - Input: "(()" -> Returns false
   * - Input: ")" -> Returns false
   *
   * @param input the string to check
   * @return true if the string has balanced parentheses, false otherwise
   * @throws IllegalArgumentException if the input string is null
   */
  public static boolean hasBalancedParentheses(String input) {
    // Check if the input is null
    if (input == null) {
        throw new IllegalArgumentException("Input string cannot be null.");
    }

    // Create a stack to keep track of opening parentheses
    Stack<Character> stack = new Stack<>();

    // Traverse each character in the string
    for (char ch : input.toCharArray()) {
        if (ch == '(') {
            // If the character is '(', push it onto the stack
            stack.push(ch);
        } else if (ch == ')') {
            // If the character is ')', check if there's a matching '(' in the stack
            if (stack.isEmpty()) {
                return false;  // Unbalanced: No matching '(' for this ')'
            }
            stack.pop();  // Pop the matching '(' from the stack
        }
    }

    // If the stack is empty, all parentheses are balanced
    return stack.isEmpty();
  }
}