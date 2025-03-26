package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet is a set of integers with various set operations.
 * Does not allow duplicate elements
 */
public class IntegerSet {
    // Store the set elements in an ArrayList
    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor creates an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set with a pre-existing ArrayList.
     * 
     * @param set ArrayList of integers to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        // Create a new ArrayList to avoid direct reference modification
        this.set = new ArrayList<>(set);
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal.
     * 
     * @param o Object to compare with this set
     * @return true if sets are equal, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        
        IntegerSet otherSet = (IntegerSet) o;
        
        // Check if sets have same size
        if (this.length() != otherSet.length()) return false;
        
        // Create copies to avoid modifying original sets
        List<Integer> thisSetCopy = new ArrayList<>(this.set);
        List<Integer> otherSetCopy = new ArrayList<>(otherSet.set);
        
        // Sort and compare
        thisSetCopy.sort(null);
        otherSetCopy.sort(null);
        
        return thisSetCopy.equals(otherSetCopy);
    }

    /**
     * Checks if the set contains a specific value.
     * 
     * @param value integer to search for
     * @return true if value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set
     * 
     * @return largest element
     * @throws IllegalStateException if set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return set.stream().max(Integer::compare).get();
    }

    /**
     * Returns the smallest element in the set.
     * 
     * @return smallest element
     * @throws IllegalStateException if set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return set.stream().min(Integer::compare).get();
    }

    /**
     * Adds an item to the set or does nothing if its already there
     * 
     * @param item integer to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if its already there
     * 
     * @param item integer to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs a union operation with another set.
     * Adds all elements from the other set that are not already present.
     * 
     * @param intSetb set to perform union with
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Performs an intersection operation with another set.
     * Keeps only elements that are present in both sets.
     * 
     * @param intSetb set to perform intersection with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs a set difference operation (this set - input set).
     * @param intSetb set to subtract from this set
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs a complement operation.
     * Keeps only elements that are not in the input set.
     * 
     * @param intSetb set to use for complement operation
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>();
        for (Integer item : this.set) {
            if (!intSetb.set.contains(item)) {
                complementSet.add(item);
            }
        }
        this.set = complementSet;
    }

    /**
     * Checks if the set is empty.
     * 
     * @return true if set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return string in format [element1, element2, ...]
     */
    @Override
    public String toString() {
        return set.toString();
    }
}