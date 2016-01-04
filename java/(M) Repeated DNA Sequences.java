/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i<=s.length()-10; i++) {
            String ss = s.substring(i, i+10);
            int code = encode(ss);
            if (!set.contains(code))
                set.add(code);
            else {
                if (!result.contains(ss))
                    result.add(ss);
            }
        }
        return result;
    }
    
    private int encode (String s) {
        int code = 0;
        for (int i=0; i<s.length(); i++) {
            code <<= 2;
            char c = s.charAt(i);
            if (c == 'A')
                code += 0;
            else if (c == 'C')
                code += 1;
            else if (c == 'G')
                code += 2;
            else if (c == 'T')
                code += 3;
        }
        return code;
    }
}
