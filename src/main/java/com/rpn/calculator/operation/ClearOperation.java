package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.MyStack;

public class ClearOperation extends Operation
{

    public ClearOperation(MyStack myStack, int inputPosition)
    {
        super(myStack,inputPosition);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void performOperation() throws InValidOperationException
    {
        getMyStack().clearStack();

    }

}
