package com.rpn.calculator.operation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rpn.calculator.exception.NoOperationException;
import com.rpn.calculator.model.MyStack;
import com.rpn.calculator.model.StackSnapShot;

public class TestOperationGenerator
{
    MyStack<Double> myStack;

    @Before
    public void setUp()
    {
        myStack = new MyStack<Double>(new StackSnapShot());
    }

    @Test
    public void testBinaryOperationGenerator() throws NoOperationException
    {
        String operator = "+";
        Operation op = Operation.getOperation(myStack, operator,1);
        assertEquals(BinaryOperation.class, op.getClass());
    }

    @Test
    public void testBinaryOperationGenerator2() throws NoOperationException
    {
        String operator = "-";
        Operation op = Operation.getOperation(myStack, operator,1);
        assertEquals(BinaryOperation.class, op.getClass());
    }

    @Test
    public void testUndoOperationGenerator() throws NoOperationException
    {
        String operator = "UnDo";
        Operation op = Operation.getOperation(myStack, operator,1);
        assertEquals(UndoOperation.class, op.getClass());
    }

    @Test
    public void testClearOperationGenerator() throws NoOperationException
    {
        String operator = "clear";
        Operation op = Operation.getOperation(myStack, operator,1);
        assertEquals(ClearOperation.class, op.getClass());
    }

    @Test(expected = NoOperationException.class)
    public void testBinaryOperationGenerator3() throws NoOperationException
    {

        String operator = "a";
        Operation op = Operation.getOperation(myStack, operator,1);
        assertEquals(BinaryOperation.class, op.getClass());
    }

}
