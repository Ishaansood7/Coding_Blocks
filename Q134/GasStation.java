class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int maxSum = 0;
        int runningSum = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            runningSum += diff;
            maxSum += diff;
            
            if(runningSum < 0) {
                runningSum = 0;
                start = i + 1; 
            }
        }
        if(maxSum < 0) return -1;
        return start;
    }
}