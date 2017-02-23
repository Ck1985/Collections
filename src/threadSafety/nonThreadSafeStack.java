package threadSafety;

/**
 * Created by anonymous on 2/22/2017.
 */
interface Stack{
    void push(int elt);
    int pop();
    boolean isEmpty();
}
class ArrayStack implements Stack{
    private final int MAX_ELEMENTS = 10;
    private int[] stack;
    private int index;

    public ArrayStack(){
        this.stack = new int[this.MAX_ELEMENTS];
        this.index = -1;
    }
    // public void push(int elt){
    public synchronized void push(int elt){
        if(this.index < this.MAX_ELEMENTS - 1){
            stack[++index] = elt;
        }else{
            throw new IllegalStateException("stack overflow");
        }
    }
    public int pop(){
        if(this.index > -1){
            return stack[this.index--];
        }else{
            throw new IllegalStateException("stack underflow");
        }
    }
    public boolean isEmpty(){
        return (this.index == -1) ? true : false;
    }
}
public class nonThreadSafeStack {
    public static void main(String[] args){

    }
}
