package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.MyStack;

public class PushOperation extends Operation
{

    String operand;

    public PushOperation(MyStack myStack, String operand, int inputPosition)
    {
        super(myStack,inputPosition);
        this.operand = operand;
    }

    @Override
    protected void performOperation() throws InValidOperationException
    {

        getMyStack().push(Double.parseDouble(operand));
    }

}
