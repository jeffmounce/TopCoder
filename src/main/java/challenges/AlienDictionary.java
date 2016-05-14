package challenges;

import java.util.ArrayList;
import java.util.HashSet;

public class AlienDictionary
{
    public static String[] getWords(int wordLength, String[] forbiddenSubstrings, int[] wordNumbers)
    {
        ArrayList<String> retVal = new ArrayList<>();
        HashSet<String> forbiddenSubstringsResolved = new HashSet<>();

        for (String forbiddenSubstring : forbiddenSubstrings)
        {
            ArrayList<Integer> questionMarkIndicies = new ArrayList<>();

            for (int i = 0; i < forbiddenSubstring.length(); i++)
            {
                if(forbiddenSubstring.charAt(i) == '?')
                {
                    questionMarkIndicies.add(i);
                }
            }
            if( questionMarkIndicies.isEmpty() )
            {
                forbiddenSubstringsResolved.add(forbiddenSubstring);
            }
            else
            {
                ArrayList<String> substitutions = generateAllCombinations(questionMarkIndicies.size());
                for (String substitution : substitutions)
                {
                    int subIdx = 0;
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < forbiddenSubstring.length(); i++)
                    {
                        char c = forbiddenSubstring.charAt(i);
                        if( c == '?' )
                        {
                            c = substitution.charAt(subIdx++);
                        }
                        sb.append(c);
                    }
                    forbiddenSubstringsResolved.add(sb.toString());
                }
            }
        }

        ArrayList<String> all = new ArrayList<>();
        int offset = Integer.SIZE - wordLength;

        for(int i = 0; i < Math.pow(2, wordLength); i++)
        {
            String sbin = Integer.toBinaryString(i);
            String entry = String.format("%32s", sbin)
                    .replace(' ', '0')
                    .substring(offset)
                    .replace('0', 'A')
                    .replace('1', 'B');

            boolean isForbidden = false;
            for (String forbidden : forbiddenSubstringsResolved)
            {
                if( entry.contains(forbidden) )
                {
                    isForbidden = true;
                    break;
                }
            }
            if( !isForbidden )
                all.add(entry);
        }

        for (int page : wordNumbers)
        {
            if( page < 0 || (page > all.size()-1) )
            {
                retVal.add("NO PAGE");
            }
            else
            {
                retVal.add(all.get(page));
            }
        }

        String[] a = new String[0];
        return retVal.toArray(a);
    }

    public static ArrayList<String> generateAllCombinations(int numberOfLetters)
    {
        ArrayList<String> retVal = new ArrayList<>();

        int offset = Integer.SIZE - numberOfLetters;

        for(int i = 0; i < Math.pow(2, numberOfLetters); i++)
        {
            String sbin = Integer.toBinaryString(i);
            String entry = String.format("%32s", sbin)
                    .replace(' ', '0')
                    .substring(offset)
                    .replace('0', 'A')
                    .replace('1', 'B');

            retVal.add(entry);
        }

        return retVal;
    }
}
