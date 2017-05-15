package com.rpn.calculator.exception;

public class InValidOperationException extends Exception
{
    String message;

    public InValidOperationException(String message)
    {
        super(message);
        this.message = message;
    }

}
