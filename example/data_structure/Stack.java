import java.util.LinkedList;
import java.util.Queue;

public class Stack<T> {

    Queue<T> inQueue;
    Queue<T> outQueue;

    public Stack(){
        this.inQueue = new LinkedList<>();
        this.outQueue = new LinkedList<>();
    }

    public void push(T obj){
        this.outQueue.offer( obj );
    }

    public T pop(){
        while ( outQueue.size() != 1){
            inQueue.offer( outQueue.poll() );
        }
        T poll = outQueue.poll();
        while ( !inQueue.isEmpty() ){
            outQueue.offer( inQueue.poll() );
        }
        return poll;
    }

    public boolean isEmpty(){
        return outQueue.isEmpty();
    }

    public int size(){
        return outQueue.size();
    }

}
