/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week6ca;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Bema Meite
 */
public class Task implements Comparable<Task>{
    public String owner;
    public String description;
    public LocalDate deadline;
    
    public Task(){
        
    }

    public Task(String owner, String description, LocalDate deadline) throws DuplicateElementException {
         if (deadline.compareTo(LocalDate.now()) <= 0) {
            throw new DuplicateElementException("Deadline cannot be before or the same as the current date");
        }
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) throws DuplicateElementException{
        if(deadline.isBefore(LocalDate.now())|| (deadline.isEqual(LocalDate.now()))){
            throw new DateTimeException("deadline has passed");
        
    }else{
            this.deadline = deadline;
        }
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.owner);
        hash = 11 * hash + Objects.hashCode(this.description);
        hash = 11 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "owner=" + owner + ", description=" + description + ", deadline=" + deadline + '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.deadline.compareTo(o.deadline);
    }
}
