import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assert {
    public static void assertTrue(String s, boolean b) {
    }

    @Test
    void test()
    {
        String actual = "A";
        String expected = "A";
        Assertions.assertEquals(actual,expected,"String was not expected");
    }
}
