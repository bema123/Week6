/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week6ca;

import java.util.NoSuchElementException;

/**
 *
 * @author Bema Meite
 */
public class BoundedPriorityQueue extends Task{
    private int maxSize;
    private int size;
    private Node head;
    public BoundedPriorityQueue(){
        this.maxSize=10;
    }
    public BoundedPriorityQueue(int maxSize){
        this.maxSize=maxSize;
       
    }
    public int size(){
        return size;
                
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
      return size==maxSize;
    }
 public int add(Task task) {
        if (task == null) {
            throw new NullPointerException("Task cannot be null");
        }

        if (contains(task)) {
            throw new DuplicateElementException("Task already exists in queue");
        }

        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        Node newNode = new Node(task);
        if (isEmpty()) {
            head = newNode;
            size++;
            return 1;
        }

        Node current = head;
        Node previous = null;
        int position = 1;

        while (current != null && current.task.getDeadline().compareTo(task.getDeadline()) <= 0) {
            previous = current;
            current = current.next;
            position++;
        }

        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = current;
            previous.next = newNode;
        }

        size++;
        return position;
    }

    public Task peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return head.task;
    }

    public Task remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Task task = head.task;
        head = head.next;
        size--;

        return task;
    }

    public boolean contains(Task task) {
        Node current = head;
        while (current != null) {
            if (current.task.equals(task)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    private static class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            next = null;
        }
    }
    
}
