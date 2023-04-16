import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class Queue<T>{
    Stack<T> inStack;
    Stack<T> outStack;

    public Queue () {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void offer(T obj){
        this.outStack.push( obj );
    }

    public T poll(){
        while(!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        T number = inStack.pop();
        while(!inStack.isEmpty()) {
            outStack.push( inStack.pop() );
        }
        return number;
    }

    public boolean isEmpty(){
        return outStack.isEmpty();
    }
}