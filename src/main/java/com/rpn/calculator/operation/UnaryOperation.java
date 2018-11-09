package com.rpn.calculator.operation;

import java.util.Objects;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.ValueStack;

public class UnaryOperation extends Operation {

	public UnaryOperation(ValueStack myStack, int inputPosition) {
		super(myStack, inputPosition);
	}

	@Override
	protected void performOperation() throws InValidOperationException {
		Double operand1 = (Double) getValueStack().pop();
		if (Objects.isNull(operand1)) {
			getValueStack().push(operand1);
			throw new InValidOperationException(
					"operation sqrt at (position)" + inputPosition + " has insufficent parameters");
		}
		getValueStack().push(Math.sqrt(operand1));

	}

}
