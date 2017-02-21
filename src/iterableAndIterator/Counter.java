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
            private int i = 0;
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
    public static void main(String[] args){
        int total = 0;
        for(Integer i : new Counter(3)){
            total += i;
        }
        assert total == 6;
    }
}
