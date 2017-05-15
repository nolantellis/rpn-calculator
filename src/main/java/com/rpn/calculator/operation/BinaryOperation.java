package com.rpn.calculator.operation;

import java.util.Objects;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.model.MyStack;

public class BinaryOperation extends Operation
{

    String operator;

    public BinaryOperation(MyStack<Double> myStack, String operator,int inputPosition)
    {
        super(myStack,inputPosition);
        this.operator = operator;

    }

    @Override
    protected void performOperation() throws InValidOperationException
    {

        Double operand2 = (Double) getMyStack().pop();
        Double operand1 = (Double) getMyStack().pop();
        Double result = null;
        if (Objects.isNull(operand2) || Objects.isNull(operand1))
        {
            getMyStack().push(operand1);
            getMyStack().push(operand2);
            throw new InValidOperationException("operation " + operator + " at (position)"+inputPosition+" has insufficent parameters");
        }

        switch (operator)
        {
            case "+":
                result = operand1 + operand2;
                break;

            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;

            case "/":
                result = operand1 / operand2;
                break;

            case "^":
                result = Math.pow(operand1, operand2);
                break;
        }
        getMyStack().push(result);

    }

}
