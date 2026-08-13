import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int solve(String s){
        int n=s.length();

        int left=0,right=0;
        Map<Character,Integer>mp=new HashMap<>();
        int maxLen=0;
        int currLen=0;

        while(right<n){
            char ch=s.charAt(right);

            if(mp.containsKey(ch)){
                if(mp.get(ch)>=left){
                    left=mp.get(ch)+1;
                }
            }

            currLen=right-left+1;
            maxLen=Math.max(maxLen,currLen);

            mp.put(ch,right);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj=new LongestSubstringWithoutRepeatingCharacters();
        String s="abcabcbb";
        int ans=obj.solve(s);
        System.out.println(ans);
    }
}
