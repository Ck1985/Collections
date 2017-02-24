package collection.methodsCollection;

/**
 * Created by anonymous on 2/23/2017.
 */
public final class CodingTask extends Task {
    private final String spec;
    public CodingTask(String spec){
        this.spec = spec;
    }
    public String getSpec(){
        return this.spec;
    }
    public String toString(){
        return "code " + this.spec;
    }
}
