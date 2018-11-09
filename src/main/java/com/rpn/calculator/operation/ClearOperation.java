package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.ValueStack;

public class ClearOperation extends Operation {

	public ClearOperation(ValueStack myStack, int inputPosition) {
		super(myStack, inputPosition);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performOperation() throws InValidOperationException {
		getValueStack().clearStack();

	}

}
