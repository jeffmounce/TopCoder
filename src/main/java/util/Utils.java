package util;

import sort.SortBase;

import java.time.Instant;
import java.util.Random;

/**
 * Created by Jeff on 3/5/2016.
 */
public class Utils
{
    public static final Random RANDOM = new Random(Instant.now().toEpochMilli());

    public static Integer[] GenerateNewArray(int n)
    {
        Integer[] retVal = new Integer[n];
        for (int i = 0; i < n; i++ )
        {
            retVal[i] = RANDOM.nextInt();
        }

        SortBase.shuffle(retVal);

        return retVal;
    }

    public static final boolean less(Comparable c1, Comparable c2)
    {
        return (c1.compareTo(c2) < 0);
    }

    public static int midpoint(int lo, int hi)
    {
        return lo + ((hi - lo) / 2);
    }
}
