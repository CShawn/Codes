class Solution {
    public:
        vector<int> findEvenNumbers(vector<int>& digits) {
            const int N = 10;
            int nums[N];
            std::fill(nums, nums + 10, 0);
            for (int& digit : digits) {
                nums[digit]++;
            }
            vector<int> ans;
            for (int i = 1; i < N; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                nums[i]--;
                for (int j = 0; j < N; j++) {
                    if (nums[j] == 0) {
                        continue;
                    }
                    nums[j]--;
                    for (int k = 0; k < N; k+=2) {
                        if (nums[k] == 0) {
                            continue;
                        }
                        nums[k]--;
                        ans.push_back(i * 100 + j * 10 + k);
                        nums[k]++;
                    }
                    nums[j]++;
                }
                nums[i]++;
            }
            return ans;
        }
    };