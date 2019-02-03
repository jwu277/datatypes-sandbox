import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class QuackTests {

    @Parameterized.Parameters
    public static Quack<Integer>[] quacks() {
        return new Quack[]{new QuackS<Integer>(), new QuackQ<Integer>()};
    }

    @Parameterized.Parameter
    public Quack<Integer> quack;

    @Before
    public void setup() {
        quack = quack.copy();
    }

    @Test
    public void testEmpty() {
        assertTrue(quack.isEmpty());
    }

    @Test
    public void testEmpty2() throws EmptyQuackException {
        quack.enpush(1);
        quack.depop();
        assertTrue(quack.isEmpty());
    }

    @Test
    public void testEmpty3() throws EmptyQuackException {

        quack.enpush(1);
        quack.enpush(2);
        quack.depop();
        quack.enpush(4);
        quack.depop();
        quack.depop();

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

    @Test
    public void testSimpleDepop() throws EmptyQuackException {
        quack.enpush(10);
        assertEquals(10, (int) quack.depop());
    }

    @Test(expected = EmptyQuackException.class)
    public void testSimpleTooMuchDepop() throws EmptyQuackException {
        quack.enpush(5);
        assertEquals(5, (int) quack.depop());
        quack.depop();
    }

}
