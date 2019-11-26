package com.ad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * This class creates mocked objects using annotations and MockitoJUnitRunner
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApp2Test {
	
	//@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@InjectMocks
	private MathApp2 mathApp;
	
	@Mock
	private Calc calcMock;
	
	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void add_ShouldReturnCorrectSummationResult_WhenInputIsTwoNumbers() { //<method>_Should<expected>_When<condition>
		when(calcMock.add(25.0, 10.0)).thenReturn(35.0);
		
		assertEquals(35.0, mathApp.add(25.0, 10.0), 0.0);
		
		verify(calcMock).add(25.0, 11.0); //verifies the mock service is called with these arguments 
	}

	@Test
	public void add_ShouldReturnIncorrectSummationResult_WhenInputIsTwoNumbers() {
		when(calcMock.add(25.0, 10.0)).thenReturn(35.0);
		
		assertNotEquals(33.0, mathApp.add(25.0, 10.0), 0.0);
		
		verify(calcMock, times(2)).add(25.0, 10.0); //verifies the mock service is called 2 times with these arguments
	}

	@Test(expected=ArithmeticException.class)
	public void divide_ShouldThrowArithmeticException_WhenDividedByZero() {
		when( calcMock.divide(anyDouble(), eq(0.0)) ).thenThrow(ArithmeticException.class);

		mathApp.divide(10.0, 0.0);
	}

}
