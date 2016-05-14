package sort;

import java.time.Instant;
import java.util.Random;

/**
 * Created by Jeff on 3/4/2016.
 */
public class SortBase
{
    private static final Random r = new Random(Instant.now().toEpochMilli());

    public static final void shuffle(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
        {
            exchange(a, i, r.nextInt(i));
        }
    }
    protected static final void exchange(Comparable[] a, int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
