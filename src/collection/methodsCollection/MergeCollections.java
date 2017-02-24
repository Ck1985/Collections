package collection.methodsCollection;
import java.util.*;

/**
 * Created by anonymous on 2/23/2017.
 */
public class MergeCollections {
    static <T extends Comparable<? super T>> List<T> merge(Collection<? extends T> c1, Collection<? extends T> c2){
        List<T> mergedList = new ArrayList<T>();
        Iterator<? extends T> it1 = c1.iterator();
        Iterator<? extends T> it2 = c2.iterator();
        T c1Element = getNextElement(it1);
        T c2Element = getNextElement(it2);
        while((c1Element != null) || (c2Element != null)){
            boolean usec1Element = ((c2Element == null) || (c1Element != null && c1Element.compareTo(c2Element) < 0));
            if(usec1Element){
                mergedList.add(c1Element);
                c1Element = getNextElement(it1);
            }else{
                mergedList.add(c2Element);
                c2Element = getNextElement(it2);
            }
        }
        return mergedList;
    }
    static <T> T getNextElement(Iterator<T> it){
        if(it.hasNext()){
            T nextElement = it.next();
            if(nextElement == null){
                throw new NullPointerException();
            }else{
                return nextElement;
            }
        }else{
            return null;
        }
    }
    public static void main(String[] args){
        PhoneTask maryPhone = new PhoneTask("Mary", "0969.555.007");
        PhoneTask mikePhone = new PhoneTask("Mike", "01698.777.555");
        CodingTask databaseCode = new CodingTask("database");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");

        Collection<PhoneTask> phoneTasks = new ArrayList<>();
        Collection<CodingTask> codingTasks = new ArrayList<>();
        Collection<Task> mondayTasks = new ArrayList<>();
        Collection<Task> tuesdayTasks = new ArrayList<>();

        Collections.addAll(phoneTasks,maryPhone,mikePhone);
        Collections.addAll(codingTasks,databaseCode,interfaceCode,logicCode);
        Collections.addAll(mondayTasks,databaseCode,maryPhone);
        Collections.addAll(tuesdayTasks,interfaceCode,logicCode,mikePhone);

        Collection<Task> mergeCollection = merge(mondayTasks,tuesdayTasks);
        System.out.println(mergeCollection);
    }
}
