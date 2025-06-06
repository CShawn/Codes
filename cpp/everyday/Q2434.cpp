class Solution {
public:
    string robotWithString(string s) {
        unordered_map<char, int> cnt;
        for (char c : s) {
            cnt[c]++;
        }
        stack<char> stk;
        string ans;
        char minChar = 'a';
        for (char c : s) {
            stk.emplace(c);
            cnt[c]--;
            while (minChar != 'z' && cnt[minChar] == 0) {
                minChar++;
            }
            while (!stk.empty() && stk.top() <= minChar) {
                ans.push_back(stk.top());
                stk.pop();
            }
        }
        return ans;
    }
};