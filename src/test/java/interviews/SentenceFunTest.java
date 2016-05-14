package interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jeff on 3/15/2016.
 */
public class SentenceFunTest
{
    @Test
    public void TestReverseString1()
    {
        String test1 = "This is fun!";
        String expected = "!nuf si sihT";

        SentenceFun fun = new SentenceFun();
        String result = fun.reverseString(test1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestReverseWords1()
    {
        String test1 = "This is fun!";
        String expected = "fun! is This";

        SentenceFun fun = new SentenceFun();
        String result = fun.reverseWords(test1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestReverseWords2()
    {
        String test1 = "This is fun! ";
        String expected = " fun! is This";

        SentenceFun fun = new SentenceFun();
        String result = fun.reverseWords(test1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestReverseWords3()
    {
        String test1 = " This is fun!";
        String expected = "fun! is This ";

        SentenceFun fun = new SentenceFun();
        String result = fun.reverseWords(test1);

        Assert.assertEquals(expected, result);
    }
}
