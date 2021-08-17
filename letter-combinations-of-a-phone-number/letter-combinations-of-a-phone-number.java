class Solution {
    public String[] map = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> res;
    
    public List<String> letterCombinations(String digits) {
        //回溯的打印combination
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(digits,sb, 0);
        return res;
    }
    public void dfs(String digit, StringBuilder sb, int index){
        //termination case
        
        if(index == digit.length()){
            res.add(sb.toString());
            return;
        }
        String letters = map[digit.charAt(index) - '0'];
        //For every choice 
         for(int i = 0; i < letters.length(); i++){
             sb.append(letters.charAt(i));
            dfs(digit, sb, index + 1);
             sb.deleteCharAt(sb.length() - 1);
        }
    }
}