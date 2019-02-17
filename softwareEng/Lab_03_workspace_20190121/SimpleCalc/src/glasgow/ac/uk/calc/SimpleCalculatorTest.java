package glasgow.ac.uk.calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleCalculatorTest {
	
	//  This example uses a simple static method, so no data is initialised here for the tests.
	//  In most cases, you'll need to setup some input data to test your methods, which is usually
	//  setup here before the @Test methods.  
	
	//  Use either @Before and @BeforeClass to setup data, or just instantiate objects here.  It is best practice
	//  to use the @Before and @BeforeClass flags, but both methods are acceptable.
	
	//  This test covers different edge cases (Integer.MAX_VALUE) as well as commonly used functions (negative/positive numbers)
	@Test
	public void testAddition() {
		assertEquals("Add Positive Integers", 3, SimpleCalculator.calculate(1,2, '+'));
		assertEquals("Add Negative Integers", -5, SimpleCalculator.calculate(-2,-3, '+'));
		assertEquals("Add Mixed Integers", -1, SimpleCalculator.calculate(1,-2, '+'));
		assertEquals("Maximum Legal Values", Integer.MAX_VALUE, SimpleCalculator.calculate(Integer.MAX_VALUE, 0, '+'));
	}
	
	//  For testing each pathway through the code, use a similar coverage to the above to test all possible uses of the function
	@Test
	public void testSubtraction() {
		assertEquals("Subtract Positive Integers", 5, SimpleCalculator.calculate(10,5,'-'));
	}
	
	@Test
	public void testMultiplication() {
		assertEquals("Multiply", 10, SimpleCalculator.calculate(2,5,'x'));
	}
	
	@Test
	public void testDivision() {
		assertEquals("Division", 5, SimpleCalculator.calculate(10,2,'/'));
	}
	
	//  Test for invalid inputs, and hopefully handle bad input elegantly (unlike this example that throws an exception!)
	@Test(expected=Exception.class)
	public void testInvalidOperators() {
		assertNull("invalid Charactor", SimpleCalculator.calculate(10,2,'c'));
	}
}
