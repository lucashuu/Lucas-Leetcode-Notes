//the sky is blu
//blue_ is _ sky _ the
//
class Solution {
    public String reverseWords(String s) {
       if (s == null || s.trim().isEmpty()) {
            return "";
        }

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }

        return sb.substring(0, sb.length() - 1);
    }
}