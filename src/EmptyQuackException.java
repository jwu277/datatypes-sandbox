/**
 * An exception for attempting to depop() from an empty quack
 */
public class EmptyQuackException extends Exception {

    public EmptyQuackException(String msg) {
        super(msg);
    }

}
