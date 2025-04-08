package org.howard.edu.lsp.assignment6;

/**
 * Driver class to test the IntegerSet class
 */
public class Driver {
    /**
     * Main method to demonstrate IntegerSet operations.
     * Demonstrates creation, manipulation, and various set operations.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
    	//Test set 1 operations 
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());
        System.out.println("Length of Set1 is: " + set1.length());
        System.out.println("Is Set1 empty? " + set1.isEmpty());

        //Test set 2 operations
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("\nValue of Set2 is: " + set2.toString());
        
        // Test union
        System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 before union: " + set1.toString());
        System.out.println("Value of Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("Value of Set1 after union: " + set1.toString());

        // Test intersection
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(4);
        set3.add(6);

        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        set4.add(4);
        set4.add(7);

        System.out.println("\nIntersection Test");
        System.out.println("Set3: " + set3.toString());
        System.out.println("Set4: " + set4.toString());
        set3.intersect(set4);
        System.out.println("Set3 after intersection: " + set3.toString());

        // Test difference
        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        set5.add(3);

        IntegerSet set6 = new IntegerSet();
        set6.add(3);
        set6.add(4);
        set6.add(5);

        System.out.println("\nDifference Test");
        System.out.println("Set5: " + set5.toString());
        System.out.println("Set6: " + set6.toString());
        set5.diff(set6);
        System.out.println("Set5 after difference: " + set5.toString());

        // Test complement
        IntegerSet set7 = new IntegerSet();
        set7.add(1);
        set7.add(2);
        set7.add(3);

        IntegerSet set8 = new IntegerSet();
        set8.add(3);
        set8.add(4);
        set8.add(5);

        System.out.println("\nComplement Test");
        System.out.println("Set7: " + set7.toString());
        System.out.println("Set8: " + set8.toString());
        set7.complement(set8);
        System.out.println("Set7 after complement: " + set7.toString());
    }
}