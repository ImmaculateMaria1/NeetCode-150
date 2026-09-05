import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagramBetterSolution(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        Arrays.sort(schar);
        Arrays.sort(tchar);

        return Arrays.equals(schar,tchar);
    }
    
    public boolean isAnagramOptimalSolution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramGeneralized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
            hmap.put(t.charAt(i), hmap.getOrDefault(t.charAt(i), 0) - 1);

        }

        for (int num : hmap.values()) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
