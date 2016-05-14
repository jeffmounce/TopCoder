package search;

import org.junit.Assert;
import org.junit.Test;
import sort.QuickSort;
import util.Utils;

/**
 * Created by Jeff on 3/5/2016.
 */
public class SearchTest
{
    @Test
    public void TestBinarySearch1()
    {
        int n = 0;
        Integer[] a = Utils.GenerateNewArray(n);
        Integer expected = 1;
        Comparable answer = BinarySearch.search(a, expected);
        Assert.assertNull("Empty array gave an answer!", answer);
    }

    @Test
    public void TestBinarySearch2()
    {
        int n = 1;
        Integer[] a = Utils.GenerateNewArray(n);
        Integer expected = 0;
        Comparable answer = BinarySearch.search(a, expected);
        Assert.assertNull("Answer was found!", answer);
    }

    @Test
    public void TestBinarySearch3()
    {
        int n = 1;
        Integer[] a = Utils.GenerateNewArray(n);
        Integer expected = a[Utils.RANDOM.nextInt(n)];
        Comparable answer = BinarySearch.search(a, expected);
        Assert.assertNotNull("Answer was not found", answer);
        Assert.assertEquals("Answer was not found", expected, answer);
    }

    @Test
    public void TestBinarySearch4()
    {
        int n = 100;
        Integer[] a = Utils.GenerateNewArray(n);
        QuickSort.sort(a);
        System.out.println("Sorting done.");
        Integer expected = a[Utils.RANDOM.nextInt(n)];
        Comparable answer = BinarySearch.search(a, expected);
        Assert.assertNotNull("Answer was not found", answer);
        Assert.assertEquals("Answer was not found", expected, answer);
    }

    @Test
    public void TestBinarySearch5()
    {
        int n = 10000000;
        Integer[] a = Utils.GenerateNewArray(n);
        QuickSort.sort(a);
        System.out.println("Sorting done.");
        Integer expected = a[Utils.RANDOM.nextInt(n)];
        Comparable answer = BinarySearch.search(a, expected);
        Assert.assertNotNull("Answer was not found", answer);
        Assert.assertEquals("Answer was not found", expected, answer);
    }
}
