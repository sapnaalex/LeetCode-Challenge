class Solution {
    public int scoreDifference(int[] nums) {

        int score1 = 0;
        int score2 = 0;

        int active = 0; // 0 = player1, 1 = player2

        for (int i = 0; i < nums.length; i++) {

            // Rule 1: If odd, swap
            if (nums[i] % 2 == 1) {
                active = 1 - active;
            }

            // Rule 2: Every 6th game (index 5, 11, 17...)
            if (i % 6 == 5) {
                active = 1 - active;
            }

            // Give points to active player
            if (active == 0) {
                score1 += nums[i];
            } else {
                score2 += nums[i];
            }
        }

        return score1 - score2;
    }
}