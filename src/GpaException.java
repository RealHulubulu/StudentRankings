/**
 * Created by karas_000 on 8/18/2016.
 */
public class GpaException extends Exception {

    private Integer errorCode;

    public Integer getErrorCode(){
        return errorCode;
    }

    public GpaException(){
        super("General Exception");
        this.errorCode = 100;

    }

    public GpaException(String s){
        super(s);
        this.errorCode= 200;
    }

    public GpaException(String s, Integer errorCode){
        super(s);
        this.errorCode = errorCode;
    }
}
