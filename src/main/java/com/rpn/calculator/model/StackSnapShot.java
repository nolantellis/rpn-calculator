package com.rpn.calculator.model;

import java.text.DecimalFormat;
import java.util.Stack;

public class StackSnapShot<T>
{
    Stack<T>      snapShotList = new Stack<T>();
    Stack<T>      emptyStack   = new Stack<T>();

    DecimalFormat formatter    = new DecimalFormat();

    public void saveSnapShot(T stack)
    {
        snapShotList.push(stack);
    }

    public T removeLastSnapShot()
    {
        return snapShotList.isEmpty() ? (T) emptyStack : snapShotList.pop();
    }

}
