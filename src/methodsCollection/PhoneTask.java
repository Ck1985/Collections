package methodsCollection;

/**
 * Created by anonymous on 2/23/2017.
 */
public final class PhoneTask extends Task{
    private final String name;
    private final String number;
    public PhoneTask(String name, String number){
        this.name = name;
        this.number = number;
    }
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.number;
    }
    public String toString(){
        return "phone " + this.name;
    }
}
