/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bema Meite
 */
//import com.mycompany.Task;
import com.mycompany.week6ca.BoundedPriorityQueue;
import com.mycompany.week6ca.Task;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author michelle
 */
public class BoundedPriorityQueueTest {
    
    public BoundedPriorityQueueTest() {
    }

    /**
     * Test of size method, of class BoundedPriorityQueue.
     */
    @Test
    public void testSize() {
        System.out.println("Testing the size() method with nothing in the queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of size method, of class BoundedPriorityQueue, with one element in queue.
     */
    @Test
    public void testSize_OneElement() {
        System.out.println("Testing the size() method with one element in the queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2021, 3, 15));
        instance.add(t1);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class BoundedPriorityQueue.
     */
    @Test
    public void testIsEmpty_EmptyList() {
        System.out.println("Testing isEmpty() with empty queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
        
    /**
     * Test of isEmpty method, of class BoundedPriorityQueue.
     */
    @Test
    public void testIsEmpty_OneElementInList() {
        System.out.println("Testing isEmpty() with occupied queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2021, 3, 15));
        instance.add(t1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method, of class BoundedPriorityQueue, with non-full queue.
     */
    @Test
    public void testIsFull_NonFullQueue() {
        System.out.println("Testing isFull() with non-full queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2021, 3, 15));
        instance.add(t1);
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isFull method, of class BoundedPriorityQueue, with full queue.
     */
    @Test
    public void testIsFull_FullQueue() {
        System.out.println("Testing isFull() with full queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        for(int i = 0; i < 10; i++){
            instance.add(new Task("Owner", "My Task", LocalDate.of(2021, 3, 15)));
        }
        boolean expResult = true;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class BoundedPriorityQueue, with an occupied queue.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing peek() with an occupied queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        Task expResult = new Task("Owner5", "My Fifth Task", LocalDate.of(2021, 3, 12));
        instance.add(expResult);
        
        // Confirm the method returns the expected value
        Task result = instance.peek();
        assertEquals(expResult, result);
        
        // Confirm the queue's size has not been changed
        int expSize = 1;
        assertEquals(expSize, instance.size());
        
        // Confirm the value is still present in the queue
        result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class BoundedPriorityQueue, with an empty queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testPeek_EmptyQueue() {
        System.out.println("Testing peek() with an empty queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        Task result = instance.peek();
    }    

    /**
     * Test of add method, of class BoundedPriorityQueue, adding first element.
     */
    @Test
    public void testAdd_FirstElement() {
        System.out.println("Testing add() to add first element");
        Task t = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        
        // Confirm queue is empty
        assertEquals(0, instance.size());
        
        // Call method and confirm the position at which it was added is correct
        int expResult = 0;
        int result = instance.add(t);
        assertEquals(expResult, result);
        
        // Confirm that value was added to the start of the queue
        Task resultTask = instance.remove();
        assertEquals(t, resultTask);
    }
    
    /**
     * Test of add method, of class BoundedPriorityQueue, adding element to start of queue.
     */
    @Test
    public void testAdd_StartOfQueue() {
        System.out.println("Testing add() to add element to start of queue");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner1", "My First Task", LocalDate.of(2024, 3, 15));
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        // Add element to queue
        instance.add(t1);
        
        // Call method and confirm second Task was added at position 0
        int expResult = 0;
        int result = instance.add(t2);
        assertEquals(expResult, result);
        
        // Confirm that value was added to the start of the queue
        Task resultTask = instance.remove();
        assertEquals(t2, resultTask);
    }    
       
    /**
     * Test of add method, of class BoundedPriorityQueue, adding element to end of queue.
     */
    @Test
    public void testAdd_EndOfQueue_DeadlineAfter() {
        System.out.println("Testing add() to add element to end of queue");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 16));
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        // Add element to queue
        instance.add(t1);
        
        // Call method and confirm second Task was added at position 1
        int expResult = 1;
        int result = instance.add(t2);
        assertEquals(expResult, result);
        
        // Confirm that value was NOT added to the start of the queue
        Task resultTask = instance.remove();
        assertEquals(t1, resultTask);
    } 
    
    /**
     * Test of add method, of class BoundedPriorityQueue, adding element to middle of queue.
     */
    @Test
    public void testAdd_MiddleOfQueue() {
        System.out.println("Testing add() to add element to middle of queue");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner2", "My First Task", LocalDate.of(2025, 3, 16));
        Task t3 = new Task("Owner3", "My First Task", LocalDate.of(2025, 3, 17));
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        // Add element to queue
        instance.add(t1);
        instance.add(t3);
        
        // Call method and confirm second Task was added at position 1
        int expResult = 1;
        int result = instance.add(t2);
        assertEquals(expResult, result);
        
        // Confirm that value was added at that positoin
        instance.remove();
        Task resultTask = instance.remove();
        assertEquals(t2, resultTask);
    }     
    
    /**
     * Test of add method, of class BoundedPriorityQueue, adding element to end of queue (where the deadlines are equal).
     */
    @Test
    public void testAdd_EndOfQueue_DeadlineEqual() {
        System.out.println("Testing add() to add element to end of queue");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        // Add element to queue
        instance.add(t1);
        
        // Call method and confirm second Task was added at position 1
        int expResult = 1;
        int result = instance.add(t2);
        assertEquals(expResult, result);
        
        // Confirm that value was NOT added to the start of the queue
        Task resultTask = instance.remove();
        assertEquals(t1, resultTask);
    } 
    
    /**
     * Test of add method, of class BoundedPriorityQueue, where the queue is already full.
     */
    @Test(expected = IllegalStateException.class)
    public void testAdd_FullQueue_Default() {
        System.out.println("Testing add() to add to a full queue (with size set as default)");
        Task t = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        for(int i = 0; i < 10; i++) {
            instance.add(t);
        }
        instance.add(t);
    }

    /**
     * Test of add method, of class BoundedPriorityQueue, where the queue is already full (size set with parameterized constructor).
     */
    @Test(expected = IllegalStateException.class)
    public void testAdd_FullQueue_Parameterized() {
        System.out.println("Testing add() to add to a full queue (with size set as default)");
        Task t = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueue instance = new BoundedPriorityQueue(5);
        for(int i = 0; i < 5; i++) {
            instance.add(t);
        }
        instance.add(t);
    }    
    
    /**
     * Test of remove method, of class BoundedPriorityQueue, where the queue contains information.
     */
    @Test
    public void testRemove() {
        System.out.println("Testing remove() on a populated queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner2", "My Second Task", LocalDate.of(2025, 3, 16));
        instance.add(t1);
        instance.add(t2);
        instance.add(new Task("Owner3", "My Third Task", LocalDate.of(2025, 3, 17)));
        instance.add(new Task("Owner4", "My Fourth Task", LocalDate.of(2025, 3, 18)));
        instance.add(new Task("Owner5", "My Fifth Task", LocalDate.of(2025, 3, 19)));
        
        // Remove first item in queue and confirm it's the right one
        Task expResult = t1;
        Task result = instance.remove();
        assertEquals(expResult, result);
        
        // Confirm the size changes appropriately
        int expSize = 4;
        assertEquals(expSize, instance.size());
        
        // Confirm the next thing in the list is also correct 
        // (to confirm the item was actually removed)
        expResult = t2;
        result = instance.remove();
        assertEquals(expResult, result);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testRemove_EmptyQueue() {
        System.out.println("Testing remove() on an empty queue");
        BoundedPriorityQueue instance = new BoundedPriorityQueue();
        
        Task result = instance.remove();
    }
}
