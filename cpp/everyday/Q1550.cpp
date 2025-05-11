class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        const int N = 3;
        int num = 0;
        for (int& n : arr) {
            if (n & 1) {
                num++;
                if (num == N) {
                    return true;
                }
            } else {
                num = 0;
            }
        }
        return false;
    }
};