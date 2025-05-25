class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        int ans = 0;
        bool mid = false;
        unordered_map<string, int> freq;
        for (auto& word : words) {
            ++freq[word];
        }
        for (const auto& [word, cnt] : freq) {
            if (word[0] == word[1]) {
                if (cnt & 1) {
                    mid = true;
                }
                ans += cnt >> 1 << 2;
            } else if (word[0] > word[1]) {
                ans += min(freq[word], freq[string(1, word[1]) + word[0]]) << 2;
            }
        }
        if (mid) {
            ans += 2;
        }
        return ans;
    }
};