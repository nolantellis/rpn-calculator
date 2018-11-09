package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.ValueStack;

public class PushOperation extends Operation {

	String operand;

	public PushOperation(ValueStack myStack, String operand, int inputPosition) {
		super(myStack, inputPosition);
		this.operand = operand;
	}

	@Override
	protected void performOperation() throws InValidOperationException {

		getValueStack().push(Double.parseDouble(operand));
	}

}
