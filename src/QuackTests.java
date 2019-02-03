import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class QuackTests {

    @Parameterized.Parameters
    public static AbstractQuack<Integer>[] quacks() {
        return new AbstractQuack[]{new QuackS<Integer>(), new QuackQ<Integer>()};
    }

    @Parameterized.Parameter
    public AbstractQuack<Integer> quack;

    @Test
    public void testEmpty() {
        assertTrue(quack.isEmpty());
    }

    @Test(expected = EmptyQuackException.class)
    public void testEmptyDepop() throws EmptyQuackException {
        quack.depop();
    }

    @Test
    public void testEnpush() {
        quack.enpush(3);
        quack.enpush(4);
        quack.enpush(3);
    }

    @Test
    public void testNonEmpty() {
        quack.enpush(2);
        assertTrue(!quack.isEmpty());
    }

    @Test
    public void testNonEmpty2() {
        quack.enpush(4);
        quack.enpush(4);
        quack.enpush(9);
        assertTrue(!quack.isEmpty());
    }

}
