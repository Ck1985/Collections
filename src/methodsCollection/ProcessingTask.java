package methodsCollection;
import java.util.*;

/**
 * Created by anonymous on 2/23/2017.
 */
public class ProcessingTask {
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

        assert phoneTasks.toString().equals("[phone Mary, phone Mike]");
        assert codingTasks.toString().equals("[code database, code gui, code logic]");
        assert mondayTasks.toString().equals("[code database, phone Mary]");
        assert tuesdayTasks.toString().equals("[code gui, code logic, phone Mike]");

        // Add Elements:
        mondayTasks.add(new PhoneTask("Ruth","567 1234"));
        assert mondayTasks.toString().equals("[code database, phone Mary, phone Ruth]");
        Collection<Task> allTasks = new ArrayList<>(mondayTasks);
        allTasks.addAll(tuesdayTasks);
        assert allTasks.toString().equals("[code database, phone Mary, phone Ruth, code gui, code logic, phone Mike]");
        //System.out.println(allTasks);
        //System.out.println(mondayTasks);
        boolean wasPresent = mondayTasks.remove(maryPhone);
        assert wasPresent;
        //System.out.println(mondayTasks);
        // assert mondayTasks.toString().equals("[code database, phone ruth]");
        mondayTasks.clear();
        assert mondayTasks.toString().equals("[]");

        Collection<Task> nonPhoneTasks = new ArrayList<>(tuesdayTasks);
        //System.out.println("phonesTasks: " + phoneTasks);
        //System.out.println("tuesdayTasks: " + tuesdayTasks);
        nonPhoneTasks.removeAll(phoneTasks);
        //System.out.println("nonPhoneTasks: " + nonPhoneTasks);
        Collection<Task> phoneTuesdayTask = new ArrayList<>(tuesdayTasks);
        phoneTuesdayTask.retainAll(phoneTasks);
        //System.out.println("phoneTuesdayTask: " + phoneTuesdayTask);

        Collection<PhoneTask> tuesdayPhoneTask2 = new ArrayList<>(phoneTasks);
        tuesdayPhoneTask2.retainAll(tuesdayTasks);
        //System.out.println(tuesdayPhoneTask2);
        assert tuesdayPhoneTask2.toString().equals("[phone Mike]");
        // Querying operator:
        //System.out.println(phoneTuesdayTask);
        assert phoneTuesdayTask.contains(mikePhone);
        assert tuesdayTasks.containsAll(phoneTuesdayTask);
        assert mondayTasks.isEmpty();
        assert mondayTasks.size() == 0;
        // Making contents of Collection available for further processing
        System.out.println("TuesdayTask: " + tuesdayTasks);
        System.out.println("PhoneTask: " + phoneTasks);

        //Throw ConcurrentModificationException:
        /*for(Task t : tuesdayTasks){
            if(t instanceof PhoneTask){
                tuesdayTasks.remove(t);
            }
        }*/

        // Throw ConcurrentModificationException
        /*for(Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext(); ){
            Task t = it.next();
            if(t instanceof PhoneTask){
                tuesdayTasks.remove(t);
            }
        }*/
        for(Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext(); ){
            Task t = it.next();
            if(t instanceof PhoneTask){
                it.remove();
            }
        }
        System.out.println(tuesdayTasks );
    }
}
