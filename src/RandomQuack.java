import java.util.Random;

/**
 *
 * @author James Wu
 * @date 02 February 2019
 *
 * Has and maintains pseudorandom FIFO/LIFO bias
 *
 */

public class RandomQuack<T> extends Quack<T> {

    public RandomQuack() {
        super();
        setBias(new Random().nextBoolean());
    }

}
