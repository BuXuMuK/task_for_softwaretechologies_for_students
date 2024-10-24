package org.softwaretechnologies;

public final class ArrayFunctions {

    private ArrayFunctions() {
    }

    /**
     * Функция, меняющая порядок элементов в массиве array на обратный.
     * @param array массив, который будет перевернут.
     */
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // Обмен элементов
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        // Проверка на квадратность
        for (int[] row : matrix) {
            if (row.length != n) {
                System.out.println("Матрица не квадратная");
                return;
            }
        }

        // Транспонирование матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}