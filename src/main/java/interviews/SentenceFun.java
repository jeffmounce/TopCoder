package interviews;

/**
 * Created by Jeff on 3/15/2016.
 */
public class SentenceFun
{
    public String reverseString(String toReverse)
    {
        char[] arr = toReverse.toCharArray();
        reverseStringInternal(arr);
        return new String(arr);
    }

    private void reverseStringInternal(char[] toReverse)
    {
        for (int i = 0; i < toReverse.length / 2; i++)
        {
            int j = toReverse.length - 1 - i;
            char buf = toReverse[i];
            toReverse[i] = toReverse[j];
            toReverse[j] = buf;
        }
    }

    public String reverseWords(String toReverse)
    {
        char[] arr = toReverse.toCharArray();
        reverseStringInternal(arr);
        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            boolean isAtEnd = (i == (arr.length - 1)) && arr[i] != ' ';

            if(isAtEnd || arr[i] == ' ')
            {
                if(j < i)
                {
                    int end = isAtEnd ? i : i-1;

                    char[] wordToReverse = new char[end-j+1];
                    for (int k = j, m = 0; k <= end; k++, m++)
                    {
                        wordToReverse[m] = arr[k];
                    }
                    reverseStringInternal(wordToReverse);
                    for (int k = j, m = 0; k <= end; k++, m++)
                    {
                        arr[k] = wordToReverse[m];
                    }
                }

                j = i+1;
            }
        }
        return new String(arr);
    }
}
