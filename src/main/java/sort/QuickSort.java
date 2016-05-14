package sort;

import util.Utils;

/**
 * Created by Jeff on 3/4/2016.
 */
public final class QuickSort extends SortBase
{
    public static void sort(Comparable[] a)
    {
        // sort the entire array
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if( hi <= lo ) return;

        // partition the array
        int j = partition(a, lo, hi);
        // sort the lower half around j
        sort(a, lo, j-1);
        // sort the upper half around j
        sort(a, j+1, hi);
    }


    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;

        while(true)
        {
            // move i right as long as it is less than the leftmost element...
            while(Utils.less(a[++i], a[lo]))
                // ... and not crossing j
                if(i == hi) break;

            // move j left as long as it is greater than the leftmost element...
            while(Utils.less(a[lo], a[--j]))
                // ... and not crossing i
                if(j == lo) break;

            // check if pointers cross
            if(i >= j) break;
            // exchange a higher i with a lower j
            exchange(a, i ,j);
        }

        // exchange the eventual j with the leftmost element since j is in the 'lesser' space now
        exchange(a, lo, j);

        return j;
    }
}
