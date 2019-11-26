package com.ad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * This class creates mocked objects using annotations and initMocks() method
 */
public class MathApp1Test {
	
	private MathApp1 mathApp;
	
	@Mock
	private Calc calcMock;

	@Before
	public void setUp() throws Exception {
		mathApp = new MathApp1();
		
		initMocks(this);
		
		mathApp.setCalc(calcMock);
	}

	@After
	public void tearDown() throws Exception {
		mathApp = null;
		calcMock = null;
	}

	@Test
	public void add_ShouldReturnCorrectSummationResult_WhenInputIsTwoNumbers() { //<method>_Should<expected>_When<condition>
		when(calcMock.add(25.0, 10.0)).thenReturn(35.0);
		//same as above --> doReturn(35.0).when(calcMock).add(25.0, 10.0);
		
		assertEquals(35.0, mathApp.add(25.0, 10.0), 0.0);
	}

	@Test
	public void add_ShouldReturnIncorrectSummationResult_WhenInputIsTwoNumbers() {
		when(calcMock.add(25.0, 10.0)).thenReturn(35.0);
		
		assertNotEquals(33.0, mathApp.add(25.0, 10.0), 0.0);
	}

	@Test(expected=ArithmeticException.class) //This unit test will fail, solution will be in stack trace
	public void divide_ShouldThrowArithmeticException_WhenDividedByZero() {
		when( calcMock.divide(anyDouble(), 0.0) ).thenThrow(ArithmeticException.class);
		//same as above --> doThrow(ArithmeticException.class).when(calcMock).divide(anyDouble(), eq(0.0));
		
		mathApp.divide(10.0, 0.0);
	}

}
