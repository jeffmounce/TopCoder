package sort;

import org.junit.*;
import util.MyJUnitStopWatch;
import util.Utils;

import java.time.Instant;
import java.util.Random;

/**
 * Created by Jeff on 3/4/2016.
 */
public class SortTest
{
    private static Integer[] MyArray;

    @BeforeClass
    public static void before()
    {
        MyArray = Utils.GenerateNewArray(100000000);
    }

    @Rule
    public MyJUnitStopWatch sw = new MyJUnitStopWatch();

    @Test
    public void TestMergeSort()
    {
        Integer[] a = copyOf(MyArray);
        Assert.assertFalse("Initial array is sorted!", IsSorted(a));
        MergeSort.sort(a);
        Assert.assertTrue("Result array is unsorted!", IsSorted(a));
        System.out.format("# duplicates: %d", countDuplicatesIn(a));
        System.out.println();
    }

    @Test
    public void TestQuickSort()
    {
        Integer[] a = copyOf(MyArray);
        Assert.assertFalse("Initial array is sorted!", IsSorted(a));
        QuickSort.sort(a);
        Assert.assertTrue("Result array is unsorted!", IsSorted(a));
        System.out.format("# duplicates: %d", countDuplicatesIn(a));
        System.out.println();
    }

    @Test
    public void TestQuickSort3Way()
    {
        Integer[] a = copyOf(MyArray);
        Assert.assertFalse("Initial array is sorted!", IsSorted(a));
        QuickSort3Way.sort(a);
        Assert.assertTrue("Result array is unsorted!", IsSorted(a));
        System.out.format("# duplicates: %d", countDuplicatesIn(a));
        System.out.println();
    }

    private Integer[] copyOf(Integer[] a)
    {
        Integer[] retVal = new Integer[a.length];
        for(int i = 0; i < a.length; i++)
        {
            retVal[i] = a[i];
        }
        return retVal;
    }

    private int countDuplicatesIn(Integer[] a)
    {
        int retVal = 0;
        for(int i = 1; i < a.length; i++)
        {
            if( a[i-1] == a[i] )
                retVal++;
        }
        return retVal;
    }

    /**
     * Returns TRUE if the array is sorted, FALSE otherwise.
     * @param a
     * @return
     */
    private boolean IsSorted(Integer[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            if( a[i-1] > a[i] )
                return false;
        }

        return true;
    }
}
