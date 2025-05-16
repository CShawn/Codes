class Solution {
public:
    vector<string> getWordsInLongestSubsequence(vector<string>& words, vector<int>& groups) {
        int n = words.size();
        vector<int> dp(n, 1);
        vector<int> pre(n, -1);
        int end = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0;j < i; j++ ) {
                if (groups[i] != groups[j] && dp[j] + 1 > dp[i] && check(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[end]) {
                end = i;
            }
        }
        vector<string> ans;
        for (int i = end; i >= 0; i = pre[i]) {
            ans.emplace_back(words[i]);
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
private:
    bool check(string &s1, string &s2) {
        if (s1.size() != s2.size()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.size(); i++) {
            diff += s1[i] != s2[i];
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
};