package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {

	private IntegerSet setA;
	private IntegerSet setB;
	private IntegerSet emptySet;

	/**
	 * Sets up test environment before each test by initializing both setA and setB
	 * and the empty set
	 */
	@BeforeEach
	public void setUp() {
		setA = new IntegerSet();
		setB = new IntegerSet();
		emptySet = new IntegerSet();

		setA.add(1);
		setA.add(2);
		setA.add(3);
		setA.add(4);
		setA.add(5);

		setB.add(3);
		setB.add(4);
		setB.add(5);
		setB.add(6);
		setB.add(7);

	}

	/**
	 * Tests the clear method by making sure length is 0 after calling clear()
	 */
	@Test
	@DisplayName("Test for clear method")
	public void testClear() {
		assertFalse(setA.isEmpty());
		setA.clear();
		assertTrue(setA.isEmpty());
		assertEquals(0, setA.length());

	}

	/**
	 * Tests the size method by making sure length is equal using assertEquals and
	 * verifying after adding another number to the set
	 */
	@Test
	@DisplayName("Test for length method")
	public void testSize() {
		assertEquals(5, setA.length());
		assertEquals(5, setB.length());

		setA.add(9);
		assertEquals(6, setA.length());

	}

	/**
	 * Testing the equals method to see if sets are equal to each other and testing
	 * empty set
	 */
	@Test
	@DisplayName("Test case for equals method")
	public void testEquals() {
		// Create two identical sets
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();

		set1.add(1);
		set1.add(2);
		set1.add(3);

		set2.add(1);
		set2.add(2);
		set2.add(3);

		// Test equality of identical sets
		assertTrue(set1.equals(set2));
		assertTrue(set2.equals(set1));

		// Test with empty set
		assertFalse(setA.equals(emptySet));
		assertTrue(emptySet.equals(new IntegerSet()));

	}

	/**
	 * Testing to see if both sets contain same number/numbers and tests the empty
	 * set as well
	 */
	@Test
	@DisplayName("Test case for contains method")
	public void testContains() {
		assertTrue(setA.contains(1));
		assertTrue(setA.contains(3));
		assertTrue(setA.contains(5));

		assertFalse(setA.contains(6));
		assertFalse(setA.contains(0));
		assertFalse(setA.contains(-1));

		assertFalse(emptySet.contains(1));
	}

	/**
	 * Testing the largest method by making sure the largest number in the set is
	 * returned and using negative numbers as well
	 */
	@Test
	@DisplayName("Test case for largest method")
	public void testLargest() {
		assertEquals(5, setA.largest());
		assertEquals(7, setB.largest());

		IntegerSet mixedSet = new IntegerSet();
		mixedSet.add(-5);
		mixedSet.add(0);
		mixedSet.add(10);
		mixedSet.add(-20);

		assertEquals(10, mixedSet.largest());
	}

	/**
	 * Testing the exception when the method is called on an empty set
	 */
	@Test
	@DisplayName("Test case for largest method exception")
	public void testLargestException() {
		// Test that an IllegalStateException is thrown when the set is empty
		IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
			emptySet.largest();
		});

		// Verify the exception message
		assertEquals("Set is empty", exception.getMessage());
	}

	/**
	 * Testing the smallest method by making sure the smallest number in the set is
	 * returned and using negative numbers as well
	 */
	@Test
	@DisplayName("Test case for smallest method")
	public void testSmallest() {
		assertEquals(1, setA.smallest());
		assertEquals(3, setB.smallest());

		IntegerSet mixedSet = new IntegerSet();
		mixedSet.add(-5);
		mixedSet.add(0);
		mixedSet.add(10);
		mixedSet.add(-20);

		assertEquals(-20, mixedSet.smallest());
	}

	/**
	 * Testing the exception when the method is called on an empty set
	 */
	@Test
	@DisplayName("Test case for smallest method exception")
	public void testSmallestException() {
		// Test that an IllegalStateException is thrown when the set is empty
		IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
			emptySet.smallest();
		});

		// Verify the exception message
		assertEquals("Set is empty", exception.getMessage());

	}

	/**
	 * Tests elements are added correctly to the set, tests duplicate elements
	 */
	@Test
	@DisplayName("Test case for add method")
	public void testAdd() {
		// Test adding new elements
		IntegerSet testSet = new IntegerSet();
		testSet.add(1);

		assertEquals(1, testSet.length());
		assertTrue(testSet.contains(1));

		// Test adding duplicate elements
		testSet.add(1);
		assertEquals(1, testSet.length()); // Length should not change

		// Test adding multiple elements
		testSet.add(2);
		testSet.add(3);
		assertEquals(3, testSet.length());
		assertTrue(testSet.contains(2));
		assertTrue(testSet.contains(3));

	}

	/**
	 * Tests the remove method and verifies elements are removed properly from the
	 * set, tries removing a non existent element and removing from an empty set
	 */
	@Test
	@DisplayName("Test case for remove method")
	public void testRemove() {
		// Test removing an existing element
		assertTrue(setA.contains(3));
		setA.remove(3);
		assertFalse(setA.contains(3));
		assertEquals(4, setA.length());

		// Test removing a non-existing element
		int initialLength = setA.length();
		setA.remove(10);
		assertEquals(initialLength, setA.length()); // Length should not change

		// Test removing from an empty set
		emptySet.remove(1);
		assertEquals(0, emptySet.length());
	}

	/**
	 * Testing union method combines setA and b and verifies length
	 */
	@Test
	@DisplayName("Test case for union method")
	public void testUnion() {
		// Original setA: [1, 2, 3, 4, 5]
		// Original setB: [3, 4, 5, 6, 7]

		IntegerSet expectedUnion = new IntegerSet();
		for (int i = 1; i <= 7; i++) {
			expectedUnion.add(i);
		}

		setA.union(setB);

		// Expected result: [1, 2, 3, 4, 5, 6, 7]
		assertEquals(7, setA.length());
		assertTrue(setA.equals(expectedUnion));

	}

	/**
	 * Testing intersect method which highlights elements shared between sets A and
	 * B
	 */
	@Test
	@DisplayName("Test case for intersect method")
	public void testIntersect() {
		// Original setA: [1, 2, 3, 4, 5]
		// Original setB: [3, 4, 5, 6, 7]

		IntegerSet expectedIntersection = new IntegerSet();
		expectedIntersection.add(3);
		expectedIntersection.add(4);
		expectedIntersection.add(5);

		setA.intersect(setB);

		// Expected result: [3, 4, 5]
		assertEquals(3, setA.length());
		assertTrue(setA.equals(expectedIntersection));

	}

	/**
	 * Testing diff method by highlighting elements unique to both sets
	 */
	@Test
	@DisplayName("Test case for diff method")
	public void testDiff() {
		// Original setA: [1, 2, 3, 4, 5]
		// Original setB: [3, 4, 5, 6, 7]

		IntegerSet expectedDiff = new IntegerSet();
		expectedDiff.add(1);
		expectedDiff.add(2);

		setA.diff(setB);

		// Expected result: [1, 2]
		assertEquals(2, setA.length());
		assertTrue(setA.equals(expectedDiff));

	}

	/**
	 * Test verifies which elements in setA are not in setB
	 */
	@Test
	@DisplayName("Test case for complement method")
	public void testComplement() {
		// Original setA: [1, 2, 3, 4, 5]
		// Original setB: [3, 4, 5, 6, 7]

		IntegerSet expectedComplement = new IntegerSet();
		expectedComplement.add(1);
		expectedComplement.add(2);

		setA.complement(setB);

		// Expected result: [1, 2]
		assertEquals(2, setA.length());
		assertTrue(setA.equals(expectedComplement));

	}

	/**
	 * Testing to verify set is empty are calling clear method
	 */
	@Test
	@DisplayName("Test case for isEmpty method")
	public void testIsEmpty() {
		assertFalse(setA.isEmpty());
		assertTrue(emptySet.isEmpty());

		setA.clear();
		assertTrue(setA.isEmpty());
	}

	/**
	 * Testing a string representation is produced
	 */
	@Test
	@DisplayName("Test case for toString method")
	public void testToString() {
		// Expected string representation
		assertEquals("[1, 2, 3, 4, 5]", setA.toString());
		assertEquals("[3, 4, 5, 6, 7]", setB.toString());
		assertEquals("[]", emptySet.toString());
	}

}
