/**
 * @author Лобанов Михаил
 */

/**
 * 1-ое ДЗ
 */
public class FunctionSet {
    /**
     * Подсчёт количества элементов массива без учёта дублей
     */
    private int shift(double[] arr) {
        int arrlen = arr.length;
        int i;
        int m = 1;
        double t;
        for (i = 1, t = arr[0]; i < arrlen; i++) {
            if (arr[i] != t) {
                arr[m++] = arr[i];
                t = arr[i];
            }
        }
        return m;
    }

    /**
     * Настройка начальных параметров для сортировки Хоара
     */
    private void qsort(double[] items) {

        qs(items, 0, items.length - 1);
    }

    /**
     * Быстрая рекурсивная сортировка Хоара
     */
    private void qs(double[] items, int left, int right) {
        int i, j;
        double x, y;

        i = left;
        j = right;
        x = items[(left + right) / 2];

        do {
            while ((items[i] < x) && (i < right)) i++;
            while ((x < items[j]) && (j > left)) j--;

            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }

    /**
     * Возвращает количество заданных символов в строке
     *
     * @param str Строка для поиска
     * @param ch  Массив символов, количество вхождений которых нужно искать
     */
    public int[] numberCharacters(String str, char... ch) {
        int[] numberOccurrences = new int[ch.length];
        int count;
        for (int i = 0; i < ch.length; i++) {
            count = 0;
            for (char charStr : str.toCharArray()) {
                if (ch[i] == charStr) {
                    count++;
                }
            }
            numberOccurrences[i] = count;
        }
        return numberOccurrences;
    }

    /**
     * Определяет, что в массиве строк есть одинаковые элементы
     */
    public boolean hasSameElements(String[] strs) {
        boolean sameLine = false;
        if (strs.length > 1) {
            done:
            for (int i = 0; i < strs.length - 1; i++) {
                for (int j = i + 1; j < strs.length; j++) {
                    if (strs[i].equals(strs[j])) {
                        sameLine = true;
                        break done;
                    }
                }
            }
        }
        return sameLine;
    }

    /**
     * Возвращает перемножение двух матриц, если это возможно, и null, если нет
     */
    public double[][] getMultiplicationMatrix(double[][] matrix, double[][] matrix2) {
        double[][] result;
        int rowCountFirstMatrix = matrix.length;
        int columnCountFirstMatrix = matrix[0].length;
        int rowCountSecondMatrix = matrix2.length;
        int columnCountSecondMatrix = matrix2[0].length;
        if (columnCountFirstMatrix == rowCountSecondMatrix) {
            result = new double[rowCountFirstMatrix][columnCountSecondMatrix];
            for (int i = 0; i < rowCountFirstMatrix; i++) {
                for (int j = 0; j < columnCountSecondMatrix; j++) {
                    result[i][j] = 0;
                    for (int s = 0; s < columnCountFirstMatrix; s++) {
                        result[i][j] += matrix[i][s] * matrix2[s][j];
                    }
                }
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Возвращает пересечение массивов double
     */
    public double[] getSortedIntersectionArrays(double[] arr, double[] arr2) {
        qsort(arr);
        qsort(arr2);
        int numberUniqueValuesFirstArray = shift(arr);
        int numberUniqueValuesSecondArray = shift(arr2);
        double[] result = new double[(numberUniqueValuesFirstArray < numberUniqueValuesSecondArray)
                ? numberUniqueValuesSecondArray : numberUniqueValuesFirstArray];
        int k = 0;
        int a = 0;
        int b = 0;
        while (a < numberUniqueValuesFirstArray && b < numberUniqueValuesSecondArray) {
            if (arr[a] < arr2[b]) {
                a++;
            } else if (arr[a] > arr2[b]) {
                b++;
            } else {
                result[k++] = arr[a++];
            }
        }
        double[] total = new double[k];
        System.arraycopy(result, 0, total, 0, k);
        return total;
    }
}