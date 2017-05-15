package com.rpn.calculator.operation;

import java.util.Objects;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.MyStack;

public class UnaryOperation extends Operation
{

    public UnaryOperation(MyStack myStack, int inputPosition)
    {
        super(myStack,inputPosition);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void performOperation() throws InValidOperationException
    {
        Double operand1 = (Double) getMyStack().pop();
        if (Objects.isNull(operand1))
        {
            getMyStack().push(operand1);
            throw new InValidOperationException("operation sqrt at (position)"+inputPosition+" has insufficent parameters");
        }

        getMyStack().push(Math.sqrt(operand1));

    }

}
