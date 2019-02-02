/**
 *
 * @author James Wu
 * @date 02 February 2019
 *
 * A MIFO (Middle In First Out) data structure.
 *
 * Elements are added with enpush() and removed with depop()
 *
 */

public interface AbstractQuack<T> {

    /**
     * Adds an element onto the Quack. *MUTATES*
     * @param elt -- the element to be added
     * @return true iff the operation was successful
     */
    boolean enpush(T elt);

    /**
     * Removes and returns the middle element in the quack. *MUTATES*
     * In the case of a tie, either element can be removed.
     *
     * @return a middle element of the quack (if non-empty).
     * @throws EmptyQuackException if the quack is empty
     */
    T depop() throws EmptyQuackException;

}
