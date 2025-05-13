class Solution {
    public:
        int lengthAfterTransformations(string s, int t) {
            const int N = 26;
            vector<int> map(N);
            for (char& c : s) {
                map[c - 'a']++;
            }
            for (int i = 0; i < t; i++) {
                vector<int> next(N);
                next[0] = map[N - 1];
                next[1] = (map[N - 1] + map[0]) % mod;
                for (int j = 2; j < N; j++) {
                    next[j] = map[j - 1];
                }
                map = move(next);
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                ans = (ans + map[i]) % mod;
            }
            return ans;
        }
    private:
        static constexpr int mod = 1000000007;
    };