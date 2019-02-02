import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class QuackTests {

    @Parameterized.Parameters
    public static AbstractQuack<Integer>[] quacks() {
        return new AbstractQuack[]{new QuackS<Integer>(), new QuackQ<Integer>()};
    }

    @Parameterized.Parameter
    public AbstractQuack<Integer> quack;

    @Test(expected = EmptyQuackException.class)
    public void test0() throws EmptyQuackException {
        quack.depop();
    }

}
