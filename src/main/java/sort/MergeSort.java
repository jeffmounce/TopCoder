package sort;

import util.Utils;

/**
 * Created by Jeff on 3/4/2016.
 */
public class MergeSort extends SortBase
{
    public static void sort(Comparable[] a)
    {
        // make an auxiliary array to store sorted halves
        Comparable[] aux = new Comparable[a.length];
        // sort the entire array recursively
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if( hi <= lo ) return;

        int mid = Utils.midpoint(lo, hi);

        // sort left half
        sort(a, aux, lo, mid);
        // sort right half
        sort(a, aux, mid+1, hi);
        // merge the two sorted halves
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        // copy original array to aux
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // make two pointers to keep track of position while evaluating each sorted half
        int i = lo, j = mid+1;

        // go through the entire array
        for(int k = lo; k <= hi; k++)
        {
            // if left is exhausted, copy rights into original array
            if(i > mid)
                a[k] = aux[j++];
            else
                // if right is exhausted, copy lefts into original array
                if(j > hi)
                    a[k] = aux[i++];
                else
                    // if left greater than right, copy right into original array
                    if(Utils.less(aux[j], aux[i]))
                        a[k] = aux[j++];
                    // if right greater than left, copy left into original array
                    else
                        a[k] = aux[i++];
        }
    }
}
