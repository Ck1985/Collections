package collection.methodsCollection;

/**
 * Created by anonymous.vn1985 on 2/22/2017.
 */
public abstract class Task implements Comparable<Task>{
    protected Task(){}
    public boolean equals(Object object){
        if(object instanceof Task){
            return this.toString().equals(object.toString());
        }else{
            return false;
        }
    }
    public int compareTo(Task task){
        return this.toString().compareTo(task.toString());
    }
    public int hashCode(){
        return this.toString().hashCode();
    }
    public abstract String toString();
}
