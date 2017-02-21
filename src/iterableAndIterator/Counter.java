package iterableAndIterator;
import java.util.*;

/**
 * Created by anonymous.vn1985 on 2/21/2017.
 */
public class Counter implements Iterable<Integer>{
    private int counter;
    public Counter(int counter){
        this.counter = counter;
    }
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            int i;
            public boolean hasNext(){
                return i < counter;
            }
            public Integer next(){
                return ++i;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
