package threadSafety;

/**
 * Created by anonymous on 2/22/2017.
 */
public class SynchronizedWrapperArrayStack implements Stack{
    private final Stack stack;
    public SynchronizedWrapperArrayStack(Stack stack){
        this.stack = stack;
    }
    public synchronized void push(int elt){
        stack.push(elt);
    }
    public synchronized int pop(){
        return stack.pop();
    }
    public synchronized boolean isEmpty(){
        return stack.isEmpty();
    }
    public static void main(String[] args){
        Stack threadSafe = new SynchronizedWrapperArrayStack(new ArrayStack());
        Stack stack = new SynchronizedWrapperArrayStack(new ArrayStack());
        // Don't do this in multithread enviroment....
        /*if(!stack.isEmpty()){
            stack.pop(); // Maybe throw IllegalStateException....
        }*/
        // Test and action muest be automatic
        synchronized(stack){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }
    }
}
