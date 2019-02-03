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

        System.out.println(data.size());

        if (isEmpty()) {
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
            return bias ? data.size() / 2 : data.size() / 2 - 1;
        }
        else {
            return (data.size() - 1) / 2;
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


    /**
     * Creates a shallow copy of the quack
     * @return a shallow copy, where the quack is independent
     *         but the elements are not necessarily so
     */
    public Quack<T> copy() {

        /*
         * Interestingly, copying it over thrice for FIFO bias and five times
         * for LIFO bias with enpush/depop also works, provided the bias
         * remains invariant.
         */

        Quack<T> quackCopy = new Quack<T>(bias);
        quackCopy.data = new ArrayList<T>(this.data);
        quackCopy.evenNumberOfElements = this.evenNumberOfElements;

        return quackCopy;

    }

}
