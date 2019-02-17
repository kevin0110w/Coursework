package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {
	NameController nameController;
	//  This example uses a simple static method, so no data is initialised here for the tests.
	//  In most cases, you'll need to setup some input data to test your methods, which is usually
	//  setup here before the @Test methods.  
	
	//  Use either @Before and @BeforeClass to setup data, or just instantiate objects here.  It is best practice
	//  to use the @Before and @BeforeClass flags, but both methods are acceptable.
	
	//  This test covers different edge cases (Integer.MAX_VALUE) as well as commonly used functions (negative/positive numbers)
	
	@Before
	public void setUp() {
		nameController = new NameControler
	}
	@Test
	public void testShortLength() {
		assertEquals("Validating words of length 2", false, Validator.isValid("Jo"));
		assertEquals("Validating words of length 2", false, Validator.isValid("Mo"));
		assertEquals("Validating words of length 3", true, Validator.isValid("Flo"));
	}
	
	@Test
	public void testLongLength() {
		assertEquals("Validating overlength words", false, Validator.isValid(""));
		assertEquals("Validating overlength words", false, Validator.isValid("Mo"));
		assertEquals("Validating overlength words", true, Validator.isValid("Flo"));
	}
}
