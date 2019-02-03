import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James Wu
 * @date 02 February 2019
 *
 * A MIFO (Middle In First Out) data structure.
 * Can be FIFO or LIFO biased in the case of ties.
 *
 * Elements are added with enpush() and removed with depop()
 *
 */

public class Quack<T> implements AbstractQuack<T> {

    private List<T> data = new ArrayList<T>();

    /* false for FIFO bais, true for LIFO bias */
    private boolean bias;
    private boolean evenNumberOfElements = true;

    /**
     * Initializes an empty quack with an arbitrary bias
     */
    public Quack() {
        this.bias = false;
    }

    /**
     * Initializes an empty quack with the specified bias
     * @param bias -- the initial FIFO/LIFO bias
     */
    public Quack(boolean bias) {
        this.bias = bias;
    }

    @Override
    public boolean enpush(T elt) {

        try {
            data.add(elt);
            evenNumberOfElements = !evenNumberOfElements;
            return true;
        } catch(UnsupportedOperationException | ClassCastException |
                NullPointerException | IllegalArgumentException e) {
            return false;
        }

    }

    @Override
    public T depop() throws EmptyQuackException {

        if (data.isEmpty()) {
            throw new EmptyQuackException("Cannot depop: quack is empty");
        }

        return depopNonEmpty();

    }

    /**
     * Precondition: quack is non-empty
     * @return depops the middle element, biased as specified
     */
    private T depopNonEmpty() {

        int midIndex = getMidIndex();

        T elt = data.get(midIndex);

        data.remove(midIndex);
        return elt;

    }

    /**
     * Precondition: quack is non-empty
     * @return the middle index, biased as specified
     */
    private int getMidIndex() {

        if (evenNumberOfElements) {
            /* bias ? LIFO : FIFO */
            return bias ? (data.size() + 1) / 2 : (data.size() - 1) / 2;
        }
        else {
            return data.size() / 2;
        }

    }

    /**
     * Obtains the current bias for the quack
     * @return false for FIFO bias, true for LIFO bias
     */
    boolean getBias() {
        return bias;
    }

    /**
     * Sets the bias for the quack
     * @param bias -- false for FIFO bias, true for LIFO bias
     */
    void setBias(boolean bias) {
        this.bias = bias;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

}
