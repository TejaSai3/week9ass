public class HotWeatherAlerts {

    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k || k <= 0) {
            return 0;
        }

        int count = 0;
        long currentSum = 0;
        long targetSum = (long) k * threshold; // Compare sum >= k * threshold to prevent floating-point division issues

        // Compute sum of the first window of size k
        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        // Check the first window
        if (currentSum >= targetSum) {
            count++;
        }

        // Slide the window across the array
        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k]; // Add incoming element, subtract outgoing element
            if (currentSum >= targetSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        int result = countAlerts(readings, k, threshold);
        System.out.println("Qualifying blocks: " + result); 
        // Expected Output: 3 (blocks: [2, 5, 5], [5, 5, 5], [5, 5, 8])
    }
}