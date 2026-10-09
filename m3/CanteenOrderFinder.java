import java.util.HashMap;
import java.util.Map;

public class CanteenOrderFinder {

    // Helper class to represent a tuple (item, count)
    public static class Result {
        public String item;
        public int count;

        public Result(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static Result mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return null;
        }

        Map<String, Integer> countMap = new HashMap<>();

        // Pass 1: Count frequency of each item using a Hash Map
        for (String item : orders) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        // Find the maximum frequency first
        int maxCount = 0;
        for (int count : countMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Pass 2: Iterate through original orders list to pick the first item with maxCount (tie breaker)
        for (String item : orders) {
            if (countMap.get(item) == maxCount) {
                return new Result(item, maxCount);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Sample 1
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(orders1)); 
        // Expected Output: ("dosa", 3)

        // Sample 2
        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(orders2)); 
        // Expected Output: ("tea", 2)
    }
}