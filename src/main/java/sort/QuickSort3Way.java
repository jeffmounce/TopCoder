package sort;

/**
 * Created by Jeff on 3/4/2016.
 */
public final class QuickSort3Way extends SortBase
{
    public static void sort(Comparable[] a)
    {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if( hi <= lo ) return;
        int i = lo, lt = lo, gt = hi;
        Comparable v = a[lo];

        while( i <= gt )
        {
            int cmp = a[i].compareTo(v);
            if(cmp < 0)
                exchange(a, lt++, i++);
            else
                if(cmp > 0)
                    exchange(a, i, gt--);
                else
                    i++;
        }

        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
}
