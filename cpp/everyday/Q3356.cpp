class Solution {
public:
    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> delta(nums.size() + 1, 0);
        int operations = 0, k = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            operations += delta[i];
            while (k < queries.size() && operations < num) {
                int left = queries[k][0];
                int right = queries[k][1];
                int value = queries[k][2];
                if (i >= left && i <= right) {
                    operations += value;
                }
                delta[left] += value;
                delta[right + 1] -= value;
                k++;
            }
            if (operations < num) {
                return -1;
            }
        }
        return k;
    }
};