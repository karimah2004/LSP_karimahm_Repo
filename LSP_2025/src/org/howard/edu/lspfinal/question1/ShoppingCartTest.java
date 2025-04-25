package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ShoppingCart. Contains j-unit tests to verify correct behavior
 * of methods including adding items, applying discounts and calculating total
 * cost.
 */
public class ShoppingCartTest {
	private ShoppingCart cart;

	/**
	 * Initializes a new ShoppingCart before each test.
	 */
	@BeforeEach
	public void setup() {
		cart = new ShoppingCart();
	}

	/**
	 * Tests adding a valid item with a positive price.
	 */
	@Test
	@DisplayName("Test Adding Valid Items")
	public void testAddValidItem() {
		assertDoesNotThrow(() -> cart.addItem("Apple", 1.99));
	}

	/**
	 * Tests that adding items with zero or negative price throws an exception.
	 */
	@Test
	@DisplayName("Test adding item with zero or negative price (expect exception)")
	public void testAddZeroOrNegativePriceItem() {
		Exception exZero = assertThrows(IllegalArgumentException.class, () -> cart.addItem("Banana", 0));
		assertEquals("Price cannot be zero or negative.", exZero.getMessage());

		Exception exNeg = assertThrows(IllegalArgumentException.class, () -> cart.addItem("Orange", -5.0));
		assertEquals("Price cannot be zero or negative.", exNeg.getMessage());
	}

	/**
	 * Tests removing an item in the cart.
	 */
	@Test
	@DisplayName("Test removing existing item")
	public void testRemoveExistingItem() {
		cart.addItem("Apple", 1.99);
		assertDoesNotThrow(() -> cart.removeItem("Apple")); 
	}

	/**
	 * Tests that removing a non existent item throws an exception
	 */
	@Test
	@DisplayName("Test removing non-existent item (expect exception)")
	public void testRemoveNonExistentItem() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cart.removeItem("Banana"));
		assertEquals("Item not found in cart.", exception.getMessage());
	}

	/**
	 * Tests applying the "SAVE10" discount code.
	 */
	@Test
	@DisplayName("Test applying \"SAVE10\"")
	public void testApplySave10() {
		cart.applyDiscountCode("SAVE10");
		assertEquals(10.0, cart.getDiscountPercentage());
	}

	/**
	 * Tests applying the "SAVE20" discount code.
	 */
	@Test
	@DisplayName("Test applying \"SAVE20\"")
	public void testApplySave20() {
		cart.applyDiscountCode("SAVE20");
		assertEquals(20.0, cart.getDiscountPercentage());
	}

	/**
	 * Tests that applying an invalid discount code throws an exception.
	 */
	@Test
	@DisplayName("Test applying invalid code (expect exception)")
	public void testApplyInvalidDiscountCode() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
		assertEquals("Invalid discount code.", exception.getMessage());
	}

	/**
	 * Tests total cost calculation without any discount applied.
	 */
	@Test
	@DisplayName("Test total cost without discount")
	public void testTotalCostWithoutDiscount() {
		cart.addItem("Item1", 10.0);
		cart.addItem("Item2", 5.0);
		assertEquals(15.0, cart.getTotalCost(), 0.01);
	}

	/**
	 * Tests total cost calculation after applying a discount code.
	 */
	@Test
	@DisplayName("Test total cost with discount")
	public void testTotalCostWithDiscount() {
		cart.addItem("Item1", 100.0);
		cart.applyDiscountCode("SAVE10");
		assertEquals(90.0, cart.getTotalCost(), 0.01);
	}

	/**
	 * Tests total cost calculation for an empty cart.
	 */
	@Test
	@DisplayName("Test total cost with empty cart")
	public void testTotalCostWithEmptyCart() {
		assertEquals(0.0, cart.getTotalCost(), 0.01);
	}
}
