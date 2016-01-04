/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

public class Solution {
    public boolean isNumber(String s) {
        
        // trim the string and check if there are spaces in the middle
        s = s.trim();
        if (s.length() == 0)
            return false;
        String[] parts = s.split(" ");
        if (parts.length != 1)
            return false;

        // strip the sign
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1, s.length());
        if (s.length() == 0)
            return false;
        
        // test e
        int eNum = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'e')
                eNum++;
            if (eNum > 1)
                return false;
        }
        if (eNum == 1) {
            parts = s.split("e");
            if (parts.length != 2)
                return false;
            else {
                if (parts[0].equals("") || parts[1].equals(""))
                    return false;
                else {
                    for (int i=0; i<parts[1].length(); i++) {
                        if (parts[1].charAt(i) == '.')
                            return false;
                    }
                    return (isNumber(parts[0]) && isNumber(parts[1]));
                }
            }            
        }
        
        // check the point
        int pointNum = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (isNumChar(c))
                continue;
            if (c == '.') {
                pointNum++;
                if (pointNum > 1)
                    return false;
                continue;
            }
            return false;
        }

        parts = s.split(".");
        if (parts.length != 0)
            return true;
        else
            return (!s.equals("."));
    }
    
    private boolean isNumChar(char c) {
        return (c == '0' || 
                c == '1' ||
                c == '2' ||
                c == '3' ||
                c == '4' ||
                c == '5' ||
                c == '6' ||
                c == '7' ||
                c == '8' ||
                c == '9');
    }
}
