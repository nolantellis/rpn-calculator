package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.exception.NoOperationException;
import com.rpn.calculator.model.ValueStack;

public abstract class Operation<T> {
	ValueStack<T> valueStack;
	int inputPosition;

	public Operation(ValueStack<T> myStack, int operatorPositon) {

		this.valueStack = myStack;
		this.inputPosition = operatorPositon;
	}

	public ValueStack<T> getValueStack() {
		return valueStack;
	}

	public void setValueStack(ValueStack<T> myStack) {
		this.valueStack = myStack;
	}

	public static Operation getOperation(ValueStack<Double> valueStack, String operator, int inputPosition)
			throws NoOperationException {
		switch (operator.toLowerCase()) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":
			return new BinaryOperation(valueStack, operator, inputPosition);

		case "sqrt":
			return new UnaryOperation(valueStack, inputPosition);

		case "undo":
			return new UndoOperation(valueStack, inputPosition);

		case "clear":
			return new ClearOperation(valueStack, inputPosition);

		default:

			if (operator.matches("-?\\d+") || operator.matches("-?\\d+\\.\\d+")) {
				return new PushOperation(valueStack, operator, inputPosition);
			}
			throw new NoOperationException("No such operation exists");

		}
	}

	public void perform() throws InValidOperationException {
		valueStack.saveMe();
		performOperation();
	}

	protected abstract void performOperation() throws InValidOperationException;

}
