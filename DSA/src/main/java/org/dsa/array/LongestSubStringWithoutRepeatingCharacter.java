package org.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int nonDuplicateIndex = -1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int ind = map.get(s.charAt(i));
                if(ind > nonDuplicateIndex){
                    nonDuplicateIndex = ind;
                }
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans,i-nonDuplicateIndex);
        }
        return ans;
    }
}
