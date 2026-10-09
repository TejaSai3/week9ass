public class TicketPriceSlotFinder {

    public static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                return mid; // Price found at index mid
            } else if (prices[mid] < newPrice) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        // When the loop ends without finding the price, 'low' sits exactly 
        // at the insertion position where the price belongs
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        // Sample 1
        System.out.println(findSlot(prices, 150)); // Output: 1

        // Sample 2
        System.out.println(findSlot(prices, 210)); // Output: 3

        // Sample 3
        System.out.println(findSlot(prices, 300)); // Output: 4
    }
}