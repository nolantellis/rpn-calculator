package com.rpn.calculator;

import java.util.Scanner;
import java.util.stream.Stream;

import com.rpn.calculator.exception.InValidOperationException;
import com.rpn.calculator.exception.NoOperationException;
import com.rpn.calculator.model.MyStack;
import com.rpn.calculator.model.StackSnapShot;
import com.rpn.calculator.operation.Operation;

public class CalculatorApplication
{
    public static void main(String[] args)
    {
        String input = null;
        Scanner sc = new Scanner(System.in);
        MyStack<Double> myStack = new MyStack<>(new StackSnapShot());
        do
        {
            System.out.println("* Enter bbye to quit");
            System.out.println("* Enter Postfix expression..Example 5 2 +");

            input = sc.nextLine();

            performOperationOnStack(input, myStack);

            System.out.println(myStack);
        } while (!"bbye".equals(input));
    }

    private static void performOperationOnStack(String input, MyStack<Double> myStack)
    {
        if (!"bbye".equals(input))
        {
            String []items=input.split(" ");
            for (int i=0;i<items.length ;i++)
            {
                try
                {
                    Operation<Double> op = Operation.getOperation(myStack, items[i],i);
                    op.perform();
                }
                catch (InValidOperationException | NoOperationException e)
                {
                    System.out.println(e.getMessage());
                    break;
                }
            }
        }
    }
}
