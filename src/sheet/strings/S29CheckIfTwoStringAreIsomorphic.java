package sheet.strings;

import java.util.HashMap;

public class S29CheckIfTwoStringAreIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
       
        HashMap<Character,Character> map = new HashMap<>();
        char sChar, tChar;
        for(int i=0; i<s.length(); i++){
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if(map.containsKey(sChar)){
                if(map.get(sChar) != tChar) return false;
            }else{
                if(map.containsValue(tChar)) return false;
                map.put(sChar, tChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println("Are strings \"" + s + "\" and \"" + t + "\" isomorphic? " + isIsomorphic(s, t));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Are strings \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + isIsomorphic(s2, t2));
    }
}

