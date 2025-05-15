class Solution {
    public:
        vector<string> getLongestSubsequence1(vector<string>& words, vector<int>& groups) {
            vector<string> ans;
            int pre = -1;
            for (int i = 0; i < groups.size(); i++) {
                if (groups[i] != pre) {
                    ans.push_back(words[i]);
                    pre = groups[i];
                }
            }
            return ans;
        }
    
        vector<string> getLongestSubsequence(vector<string>& words, vector<int>& groups) {
            vector<string> ans;
            ans.push_back(words[0]);
            for (int i = 1; i < groups.size(); i++) {
                if (groups[i] != groups[i - 1]) {
                    ans.push_back(words[i]);
                }
            }
            return ans;
        }
    };