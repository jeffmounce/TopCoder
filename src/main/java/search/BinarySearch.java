package search;

import util.Utils;

/**
 * Created by Jeff on 3/5/2016.
 */
public class BinarySearch
{
    public static Comparable search(Comparable[] a, Comparable value)
    {
        if( a == null ) return null;

        int lo = 0, hi = a.length - 1;
        while( lo <= hi )
        {
            int mid = Utils.midpoint(lo, hi);
            Comparable valueMid = a[mid];

            if( valueMid.equals(value) ) return valueMid;

            if( Utils.less(valueMid, value) )
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return null;
    }

}
