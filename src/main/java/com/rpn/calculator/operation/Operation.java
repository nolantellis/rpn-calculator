package com.rpn.calculator.operation;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.exception.NoOperationException;
import com.rpn.calculator.model.MyStack;

public abstract class Operation<T>
{
    MyStack<T> myStack;
    int inputPosition;

    public Operation(MyStack<T> myStack, int operatorPositon)
    {

        this.myStack = myStack;
        this.inputPosition=operatorPositon;
    }

    public MyStack<T> getMyStack()
    {
        return myStack;
    }

    public void setMyStack(MyStack<T> myStack)
    {
        this.myStack = myStack;
    }

    public static Operation getOperation(MyStack<Double> myStack, String operator,int inputPosition) throws NoOperationException
    {
        switch (operator.toLowerCase())
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                return new BinaryOperation(myStack, operator,inputPosition);

            case "sqrt":
                return new UnaryOperation(myStack,inputPosition);

            case "undo":
                return new UndoOperation(myStack,inputPosition);

            case "clear":
                return new ClearOperation(myStack,inputPosition);

            default:

                if (operator.matches("-?\\d+") || operator.matches("-?\\d+\\.\\d+"))
                {
                    return new PushOperation(myStack, operator,inputPosition);
                }
                throw new NoOperationException("No such operation exists");

        }
    }

    public void perform() throws InValidOperationException
    {
        myStack.saveMe();
        performOperation();
    }

    protected abstract void performOperation() throws InValidOperationException;

}
