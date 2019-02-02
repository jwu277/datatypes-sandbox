import java.util.Random;

/**
 *
 * @author James Wu
 * @date 02 February 2019
 *
 * Has and dynamically updates pseudorandom FIFO/LIFO bias
 * for every depop operation
 *
 */

public class RandomDynamicQuack<T> extends Quack<T> {

    Random generator = new Random();

    public RandomDynamicQuack() {
        super();
    }

    @Override
    public T depop() throws EmptyQuackException {
        setBias(generator.nextBoolean());
        return super.depop();
    }

}
