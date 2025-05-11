class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxVowelFreq = 0, maxConsonantFreq = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (vowels.contains(ch)) {
                maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }
}