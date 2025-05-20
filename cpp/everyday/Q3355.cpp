class Solution {
public:
    // 差分数组
    bool isZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> pre(nums.size() + 1, 0);
        pre[0] = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            pre[i] = nums[i] - nums[i - 1];
        }
        for (auto& query : queries) {
            pre[query[0]]--;
            pre[query[1] + 1]++;
        }
        if (pre[0] > 0) {
            return false;
        }
        for (int i = 1; i < nums.size(); i++) {
            pre[i] += pre[i - 1];
            if (pre[i] > 0) {
                return false;
            }
        }
        return true;
    }
};