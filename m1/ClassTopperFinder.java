public class ClassTopperFinder {

    public static int[] findTopper(int[][] marks) {
        int maxTotal = -1;
        int topperIndex = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }

            // Strictly greater ensures tie-breaking goes to the smallest row index
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                topperIndex = i;
            }
        }

        return new int[]{topperIndex, maxTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] result = findTopper(marks);
        System.out.println("Row Index: " + result[0] + ", Total: " + result[1]);
    }
}