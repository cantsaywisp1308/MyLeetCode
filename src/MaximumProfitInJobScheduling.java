package LeetCode;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
	
	public static class Job {
	    int start;
	    int end;
	    int profit;

	    public Job(int start, int end, int profit) {
	        this.start = start;
	        this.end = end;
	        this.profit = profit;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] startTime1 = {1, 2, 3, 3};
        int[] endTime1 = {3, 4, 5, 6};
        int[] profit1 = {50, 10, 40, 70};
        System.out.print(jobScheduling(startTime1, endTime1, profit1));
	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job[] jobs = new Job[n];
		for(int i = 0 ; i < n ; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		
		Arrays.sort(jobs, (a,b)-> a.end - b.end);
		int[] dp = new int[n];
		dp[0] = jobs[0].profit;
		for(int i = 1; i<n;i++) {
			int currentProfit = jobs[i].profit;
			int latestNonOverlapse = findLatestNonOverlap(jobs, i);
			
			if(latestNonOverlapse != -1) {
				currentProfit += dp[latestNonOverlapse];
			}
			
			dp[i] = Math.max(currentProfit, dp[i-1]);
		}
		return dp[n-1];
	}
	
	public static int findLatestNonOverlap(Job[] jobs, int currentJob) {
		for(int i = currentJob-1; i >=0; i--) {
			if(jobs[i].end <= jobs[currentJob].start) {
				return i;
			}
		}
		return -1;
	}
}
