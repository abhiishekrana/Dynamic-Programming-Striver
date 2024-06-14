1. Fibonacci Series
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++){
		    dp[i]=dp[i-1]+dp[i-2];
		}
		for(int val:dp){
		    System.out.print(val+" ");
		}
		System.out.print(dp[n]);
	}
}

2.Climbing Stairs:
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

3.Frog Jump
class Solution{
    public int minimumEnergy(int arr[],int n){
        //code here
        int[] dp = new int[n];
        dp[0]=0;
        int minJump = 0;
        for(int i=1;i<n;i++){
            int jumpOne=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int jumpTwo = Integer.MAX_VALUE;
            if(i>1){
                jumpTwo=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
           dp[i]=Math.min(jumpOne,jumpTwo); 
        }
        return dp[n-1];
        
    }
}

4.Frog jump k times
class Solution{
    public int minimizeCost(int arr[],int N,int k){
        //code here
        
        int[] dp = new int[N];
        dp[0]=0;
        for(int i=1;i<N;i++){
           int miniCost = Integer.MAX_VALUE;
           for(int j=1;j<=k;j++){
               if(i-j>=0){
                   int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                   miniCost = Math.min(jump,miniCost);
               }
               
           }
           dp[i]=miniCost;
        }
        return dp[N-1];
    }
}

// 5.This solution is inefficient becoze of the large recursion call so we can using dp here
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int ans  = recursion(n-1,nums);
        return ans;
    }
    public int recursion(int ind,int[] nums){
        int maxCount =0;
        if(ind==0){
            return nums[0];
        }
        if(ind<0){
            return 0;
        }
        
        int pick = nums[ind]+recursion(ind-2,nums);
        

        int not_pick = 0+recursion(ind-1,nums);
        int max = Math.max(pick,not_pick);
        maxCount+=max;
        return maxCount;
        
    }
}

//dp

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans  = rec(n-1,dp,nums);
        return ans;
    }
    public int rec(int ind,int[] dp,int[] nums){

        int maxCount =0;
        if(ind==0){
            return nums[0];
        }
        if(ind<0){
            return 0;
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        int pick = nums[ind]+rec(ind-2,dp,nums);
        

        int not_pick = 0+rec(ind-1,dp,nums);
        dp[ind] = Math.max(pick,not_pick);
        
        return dp[ind];
        
    }
}

//Simple top to bottom path
class Solution {
    public int f(int i,int j,int[][] dp){
        if(i==0&&j==0)return 1;
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = f(i-1,j,dp);
        int left = f(i,j-1,dp);
        return dp[i][j] = up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp);
    }
}

//Top to bottom with obstaces
class Solution {
     public int f(int i,int j,int[][] dp,int[][] obstacleGrid){
        if (obstacleGrid[0][0] == 1) return 0;
        if(i==0&&j==0)return 1;
        if(i<0||j<0)return 0;
        
        if(i>=0&&j>=0&&obstacleGrid[i][j]==1)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = f(i-1,j,dp,obstacleGrid);
        int left = f(i,j-1,dp,obstacleGrid);
        return dp[i][j] = up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
         int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp,obstacleGrid);
    }
}

