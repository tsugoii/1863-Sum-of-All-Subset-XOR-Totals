class Solution {
    public int subsetXORSum(int[] nums) {
        int TotalSum = 0;
        int n = nums.length;

        // Iterate through all possible subnets (2^n)
        // Apply a bitmask where each integer represents a unique subset
        // i.e. [6, 9], 01 = 6, 10 = 9, 11 = 6 & 9
        for (int i = 0; i < (1 << n); i++) {
            // Sum for current subnet
            int currentSum = 0;
            // Iterate through each element
            for (int j = 0; j < n; j++) {
                // If the current element is within our bitmask,
                // shift our bitmask back and check the least significant bit
                if ((i >> j) % 2 == 1) {
                    // XOR the element with the sum of the subnet
                    currentSum ^= nums[j];
                }
            }
            TotalSum += currentSum;
        }
        return TotalSum;
    }
}
