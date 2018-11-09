package com.rpn.calculator.model;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class CalculatorStackTest {

	ValueStack<Double> stackInstance;

	@Before
	public void setUp() {
		stackInstance = new ValueStack(new StackSnapShot());
	}

	@Test
	public void testStackPush() {

		stackInstance.push(12.3d);
		stackInstance.push(12.4d);
		assertEquals("[12.3, 12.4]", stackInstance.toString());

	}

	@Test
	public void testStackPushUndo() {
		stackInstance.push(12.3d);
		stackInstance.push(12.4d);
		assertEquals("[12.3, 12.4]", stackInstance.toString());

		stackInstance.saveMe();
		assertEquals("[12.3, 12.4]", stackInstance.toString());

		stackInstance.push(12d);
		assertEquals("[12.3, 12.4, 12.0]", stackInstance.toString());

		stackInstance.setLastSnapShot();
		assertEquals("[12.3, 12.4]", stackInstance.toString());

	}

	@Test
	public void testStackPushUndo2() {
		stackInstance.push(12.3d);
		stackInstance.push(12.4d);
		assertEquals("[12.3, 12.4]", stackInstance.toString());

		stackInstance.saveMe();
		assertEquals("[12.3, 12.4]", stackInstance.toString());

		stackInstance.push(12d);
		assertEquals("[12.3, 12.4, 12.0]", stackInstance.toString());
		stackInstance.saveMe();

		stackInstance.setLastSnapShot();
		assertEquals("[12.3, 12.4, 12.0]", stackInstance.toString());

		stackInstance.setLastSnapShot();
		assertEquals("[12.3, 12.4]", stackInstance.toString());

	}

}
