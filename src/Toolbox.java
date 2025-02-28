import java.util.HashMap;
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
}


  /**
   * 
   * Counts the occurrences of values in a linked list.
   * 
   * 3 -> 8 -> 3 -> 9 -> 3
   * 
   * {
   * 3 : 3,
   * 8 : 1,
   * 9 : 1
   * }
   * 
   * occurances.get(3)
   * 

   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */
  public static Map<Integer, Integer> countOccurrences(SingleNode head) {
    if (head == null) {
        throw new IllegalArgumentException("Head cannot be null.");
    }
    /*
     - Map, occurances
     - while, head is not empty or null 
        - initilaze a variable, keep track of value, placed inside the map, increment occurance 
        - add to the occurances map 
        - traverse through the nodes
     - return occurances
     */

     Map<Integer, Integer> occurances = new HashMap<>();

     while(head != null) {
        int data = head.data;
        /*
          * if map contains the data as key:
          *   int count = occurances.get(data)
          * // find count current with data
          *    
          *   // increase count by 1
          *    count++;
          *   // put data and new count back in the map
          *    occurances.put(data, count)
          * else:
          *    occurances.put(data, 1)
          *
          * */
         // occurances.put(data, occurances.getOrDefault(data, 0) + 1);
        if(occurances.containsKey(data)) {
            int count = occurances.get(data);
            count++;
            occurances.put(data, count);
        }
        else {
            occurances.put(data, 1);
        }
        
        head = head.next;
     }
     return occurances;

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
    /*
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
    
  }
}