class Solution {
int canCompleteCircuit(int[] gas, int[] cost) {
    // Calculate total gas and total cost
    int totalGas=0,totalCost=0;
    for (int i = 0; i < gas.length; i++) {
        totalGas += gas[i];
        totalCost += cost[i];
    }

    // If total gas is less than total cost, return -1
    if (totalGas < totalCost) {
        return -1;
    }

    int currentGas = 0, startIndex = 0;
    // Iterate through the gas stations
    for (int i = 0; i < gas.length; i++) {
        currentGas += gas[i] - cost[i];

        // If current gas is negative, reset start index
        if (currentGas < 0) {
            startIndex = i + 1;
            currentGas = 0;
        }
    }

    // Return the starting index if a valid circuit is found
    return startIndex;
}
}