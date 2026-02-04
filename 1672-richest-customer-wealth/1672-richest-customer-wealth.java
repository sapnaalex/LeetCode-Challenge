class Solution {
    public int maximumWealth(int[][] accounts) {
        int m  = accounts.length;
        int n = accounts[0].length;
        int i=0;
        int sum = 0;
        while(i<m){
            int ans=0;
            for(int j=0; j<n; j++){
                ans+=accounts[i][j];
                if(ans>sum) sum = ans;
            }
            i++;        

        }
        return sum;
    }
}