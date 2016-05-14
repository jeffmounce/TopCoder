package challenges;

import challenges.AlphabetPath;
import org.junit.Assert;
import org.junit.Test;

public class AlphabetPathTest
{
    @Test
    public void Test1()
    {
        String[] input = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
        String expected = "YES";

        AlphabetPath path = new AlphabetPath();
        String answer = path.doesItExist(input);
        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test2()
    {
        String[] input = {"ADEHI..Z", "BCFGJK.Y", ".PONML.X", ".QRSTUVW"};
        String expected = "YES";

        AlphabetPath path = new AlphabetPath();
        String answer = path.doesItExist(input);
        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test3()
    {
        String[] input = {"ACBDEFGHIJKLMNOPQRSTUVWXYZ"};
        String expected = "NO";

        AlphabetPath path = new AlphabetPath();
        String answer = path.doesItExist(input);
        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test4()
    {
        String[] input = {"ABC.......", "...DEFGHIJ", "TSRQPONMLK", "UVWXYZ...."};
        String expected = "NO";

        AlphabetPath path = new AlphabetPath();
        String answer = path.doesItExist(input);
        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test5()
    {
        String[] input = {"..............", "..............", "..............", "...DEFGHIJK...", "...C......L...", "...B......M...", "...A......N...", "..........O...", "..ZY..TSRQP...", "...XWVU.......", ".............."};
        String expected = "YES";

        AlphabetPath path = new AlphabetPath();
        String answer = path.doesItExist(input);
        Assert.assertEquals(expected, answer);
    }
}
