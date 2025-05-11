class Solution {
    public int minDeletion(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int freq=map.get(s.charAt(i));
                map.put(s.charAt(i),freq+1);
            }
            else map.put(s.charAt(i),1);
        }
        int distinct = map.size();
        
        // Store all frequencies in a list
        List<Integer> frequencies = new ArrayList<>(map.values());
        // Sort frequencies in ascending order
        Collections.sort(frequencies);

        int deletions = 0;
        int toRemove = distinct - k;

        for (int i = 0; i < toRemove; i++) {
            deletions += frequencies.get(i);
        }

        return deletions;
    }
}