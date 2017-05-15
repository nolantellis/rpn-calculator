package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.MyStack;

public class UndoOperation extends Operation
{

    public UndoOperation(MyStack myStack, int inputPosition)
    {
        super(myStack,inputPosition);

    }

    @Override
    protected void performOperation() throws InValidOperationException
    {
        getMyStack().setLastSnapShot();

    }

    @Override
    public void perform() throws InValidOperationException
    {
        //
        performOperation();
    }

}
