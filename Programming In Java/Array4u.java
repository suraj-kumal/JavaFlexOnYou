public class Array4u {
    public static void main(String[] args) {
        int[] listOfNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int num : listOfNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[][] matrix = {{1, 0}, {0, 1}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
