public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        
        int len = 0;
        List<String> line = new ArrayList<String>();
        for (int i=0; i<words.length; i++) {
            int tempLen = len + words[i].length();
            if (line.size() > 0)
                tempLen += 1;

            if (tempLen > maxWidth) {
                String formatedLine = distributeSpaces(line, len, maxWidth);
                result.add(formatedLine);
                
                line.clear();
                line.add(words[i]);
                len = words[i].length();
            }
            else {
                line.add(words[i]);
                len = tempLen;
            }
        }

        if (line.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(line.get(0));
            for (int i=1; i<line.size(); i++) {
                sb.append(" ");
                sb.append(line.get(i));
            }
            int trailingSpaces = maxWidth - sb.length();
            for (int i=0; i<trailingSpaces; i++)
                sb.append(" ");
                
            result.add(sb.toString());
        }
        
        return result;
    }
    
    private String distributeSpaces(List<String> strList, int len, int maxLen) {

        if (strList.size() == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(strList.get(0));
            for (int k=0; k<maxLen-len; k++)
                sb.append(" ");
            return sb.toString();
        }

        int extraSpace = maxLen - len;
        int div = extraSpace / (strList.size() - 1);
        int res = extraSpace % (strList.size() - 1);
        if (extraSpace == 0)
            res = 0;
            
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<strList.size(); j++) {
            sb.append(strList.get(j));
            if (j != strList.size() - 1) {
                int space = div + 1;
                if (extraSpace > 0 && j < res)
                    space += 1;
                for (int k=0; k<space; k++)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }
}
