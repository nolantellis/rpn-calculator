package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.ValueStack;

public class UndoOperation extends Operation {

	public UndoOperation(ValueStack myStack, int inputPosition) {
		super(myStack, inputPosition);

	}

	@Override
	protected void performOperation() throws InValidOperationException {
		getValueStack().setLastSnapShot();

	}

	@Override
	public void perform() throws InValidOperationException {
		//
		performOperation();
	}

}
