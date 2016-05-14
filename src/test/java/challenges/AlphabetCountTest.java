package challenges;

import challenges.AlphabetCount;
import org.junit.Assert;
import org.junit.Test;

public class AlphabetCountTest
{
    @Test
    public void Test1()
    {
        String[] input = { "ABC", "CBZ", "CZC", "BZZ", "ZAA" };
        int length = 3;
        int expected = 7;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test2()
    {
        String[] input = { "AAAA", "AAAA", "AAAA" };
        int length = 1;
        int expected = 12;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test3()
    {
        String[] input = { "ABAB", "BABA", "ABAB", "BABA" };
        int length = 2;
        int expected = 24;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test4()
    {
        String[] input = { "HIJKLMNOPQZZZONMLKHIDZYQR", "GYXWVUTSRASTZZPSTUJGECPXS", "FZABCDEFARQPUQRAAAVWFBOWT", "EONMJIHGAJMNOVAAAAAYXANUV", "DCBLKDEFIEKLEDWAAAZFGHMLK", "UVAZYBCGHFDFCAYXNPQZEDIJA", "TSWXAKLZGCZBGZIJOMZRUTCBZ", "RQPONMJIHBAZZHZZKLZZSVWXY" };
        int length =26;
        int expected = 7;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test5()
    {
        String[] input = { "CZC", "ZBZ", "AZA" };
        int length = 3;
        int expected = 4;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test6()
    {
        String[] input = { "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ABCDEFGHIJKLMNOPQRSTUVWXYZ" };
        int length = 26;
        int expected = 1000000;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
    @Test
    public void Test7()
    {
        String[] input = { "BDBCBACABDDCCADCBDDCBDDDBCCCCABACADDDCCCBADDDBADCA", "DCBBBACBDBACCADABCCAABACDBADBCBBABACBCADADCBDABBBD" };
        int length = 4;
        int expected = 20;

        AlphabetCount counter = new AlphabetCount();
        int answer = counter.count(input, length);

        Assert.assertEquals(expected, answer);
    }
}
