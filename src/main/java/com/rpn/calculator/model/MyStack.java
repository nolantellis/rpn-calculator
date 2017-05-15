package com.rpn.calculator.model;

import java.util.Objects;
import java.util.Stack;

public class MyStack<T>
{

    StackSnapShot<Stack<T>> snapShot;
    Stack<T>                stack = new Stack();

    public MyStack(StackSnapShot<Stack<T>> snapShot)
    {
        super();
        this.snapShot = snapShot;
    }

    public void push(T element)
    {
        if (!Objects.isNull(element))
        {
            stack.push(element);
        }
    }

    public T pop()
    {
        return stack.isEmpty() ? null : stack.pop();
    }

    public void saveMe()
    {
        Stack<T> snapShotStack = new Stack<T>();

        snapShotStack.addAll(stack);

        snapShot.saveSnapShot(snapShotStack);

    }

    public void clearStack()
    {
        stack.clear();
    }

    public void setLastSnapShot()
    {
        stack = snapShot.removeLastSnapShot();
    }

    public String toString()
    {
        return stack.toString();
    }
}
