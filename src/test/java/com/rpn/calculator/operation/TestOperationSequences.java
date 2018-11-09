package com.rpn.calculator.operation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.exception.NoOperationException;
import com.rpn.calculator.model.ValueStack;
import com.rpn.calculator.model.StackSnapShot;

public class TestOperationSequences {

	ValueStack<Double> myStack;
	Operation op;

	@Before
	public void setUp() {
		myStack = new ValueStack<Double>(new StackSnapShot());
	}

	@Test
	public void testOperation1() throws NoOperationException, InValidOperationException {
		perform("12");
		perform("14");
		perform("2");
		perform("/");
		assertEquals("[12.0, 7.0]", myStack.toString());
		perform("-");
		assertEquals("[5.0]", myStack.toString());
		perform("clear");
		assertEquals("[]", myStack.toString());

		perform("undo");
		assertEquals("[5.0]", myStack.toString());

		perform("undo");
		assertEquals("[12.0, 7.0]", myStack.toString());

		perform("undo");
		assertEquals("[12.0, 14.0, 2.0]", myStack.toString());

		perform("undo");
		assertEquals("[12.0, 14.0]", myStack.toString());
		perform("undo");
		perform("undo");
		perform("undo");
		assertEquals("[]", myStack.toString());

	}

	@Test
	public void testOperation2() throws NoOperationException, InValidOperationException {
		perform("1");
		perform("2");
		perform("2");
		perform("^");
		assertEquals("[1.0, 4.0]", myStack.toString());
		perform("sqrt");
		assertEquals("[1.0, 2.0]", myStack.toString());
		perform("clear");
		assertEquals("[]", myStack.toString());
		perform("undo");
		assertEquals("[1.0, 2.0]", myStack.toString());

	}

	@Test(expected = InValidOperationException.class)
	public void testInvalidOperation1() throws NoOperationException, InValidOperationException {
		perform("1");
		perform("2");
		perform("2");
		perform("^");
		assertEquals("[1.0, 4.0]", myStack.toString());
		perform("-");
		assertEquals("[-3.0]", myStack.toString());
		perform("-");

	}

	@Test(expected = NoOperationException.class)
	public void testInvalidOperation2() throws NoOperationException, InValidOperationException {
		perform("1");
		perform("2");
		perform("2");
		perform("^^");

	}

	private void perform(String operator) throws NoOperationException, InValidOperationException {
		op = Operation.getOperation(myStack, operator, 1);
		op.perform();
	}

}
