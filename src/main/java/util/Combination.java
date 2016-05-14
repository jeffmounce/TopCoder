package util;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Jeff on 4/5/2016.
 */
public class Combination
{
    public static void main(String[] args){
        System.out.println(comb(3,5));
    }

    public static String bitprint(int u){
        StringBuffer s = new StringBuffer();
        for(int n= 0;u > 0;n++, u >>= 1)
            if((u & 1) > 0)
                s.append(String.format("%d ", n));
        return s.toString();
    }

    public static int bitcount(int u){
        int n;
        for(n= 0;u > 0;n++, u &= (u - 1));//Turn the last set bit to a 0
        return n;
    }

    public static LinkedList<String> comb(int c, int n){
        LinkedList<String> s= new LinkedList<String>();
        int end = 1 << n;
        for(int u = 0; u < end; u++)
        {
            int bitcount = bitcount(u);
            if (bitcount == c)
                s.push(bitprint(u));
        }
        Collections.sort(s);
        return s;
    }

}