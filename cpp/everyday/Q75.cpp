class Solution {
public:
    void sortColors(vector<int>& nums) {
        int left = 0, right = nums.size() - 1, mid = 0;
        while (mid <= right) {
            while (mid <= right && nums[mid] == 2) {
                swap(nums[right--], nums[mid]);
            }
            if (nums[mid] == 0) {
                swap(nums[left++], nums[mid]);
            }
            mid++;
        }
    }
};