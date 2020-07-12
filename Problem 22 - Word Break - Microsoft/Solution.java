import java.util.*;

class Solution
{
    private static HashMap<String, Boolean> hm = new HashMap<>();
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s,wordDict);
    }

    public static boolean wordBreakHelper(String s, List<String> wordDict)
    {
        if(s.equals(""))
        {
            return true;
        }
        String str = "";
        int n = s.length();
        String scopy = "";
        boolean cond = false;
        for(int i=0;i<n;i++)
        {
            str += s.charAt(i);
            if(wordDict.contains(str))
            {
                scopy = s.substring(i+1,n);
                if(hm.containsKey(scopy))
                {
                    cond = hm.get(scopy);
                }
                else
                {
                    cond = wordBreakHelper(scopy,wordDict);
                    hm.put(scopy,cond);
                }
                if(cond)
                {
                    break;
                }
            }
        }
        return cond;
    }

    public static void main(String [] args)
    {
        String s = "applepie";
        List<String> list = Arrays.asList(new String[]{"pie","pear","apple","peach"});
        System.out.println(wordBreak(s,list));
    }
}
