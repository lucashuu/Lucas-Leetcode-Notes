class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if(map.containsKey(s)){
                List<String> alist = map.get(s);
                alist.add(str);
            }else{
                List<String> alist = new ArrayList<>();
                alist.add(str);
                map.put(s, alist);
            }
        }
        Set<String> keySet = map.keySet();
        for(String s : keySet){
            List<String> list = map.get(s);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}