package challenges;

import challenges.AlienDictionary;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class AlienDictionaryTest
{
    @Test
    public void TestGenerator()
    {
        ArrayList<String> result = AlienDictionary.generateAllCombinations(3);
        System.out.println(result);

        Assert.assertEquals(8, result.size());
    }

    @Test
    public void Test1()
    {
        String[] answer = AlienDictionary.getWords(5, new String[]{"?AA", "ABB"}, new int[]{4,12,0,6,9});
        String[] expected = new String[]{"BBBAB", "NO PAGE", "AABAB", "BBBBB", "NO PAGE"};

        Assert.assertArrayEquals(expected, answer);
    }

    @Test
    public void Test2()
    {
        String[] answer = AlienDictionary.getWords(3, new String[]{}, new int[]{1,4,7,5,1});
        String[] expected = new String[]{"AAB", "BAA", "BBB", "BAB", "AAB"};

        Assert.assertArrayEquals(expected, answer);
    }

    @Test
    public void Test3()
    {
        String[] answer = AlienDictionary.getWords(4, new String[]{"AA"}, new int[]{2,6,11,4,8});
        String[] expected = new String[]{"ABBB", "BBBA", "NO PAGE", "BABB", "NO PAGE"};

        Assert.assertArrayEquals(expected, answer);
    }

    @Test
    public void Test4()
    {
        String[] answer = AlienDictionary.getWords(10, new String[]{"BABB?","??A?B","A?AAA","A??AB","?A??A"}, new int[]{0, 1});
        String[] expected = new String[]{"AABBBABABA", "AABBBBABAB"};

        Assert.assertArrayEquals(expected, answer);
    }
}
