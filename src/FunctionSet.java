/**
 * @author Лобанов Михаил
 */

/**
 * 1-ое ДЗ
 */
public class FunctionSet {
    /**
     * Подсчёт количества элементов массива без учёта дублей
     *
     * @param arr Массив с возможно повторяющимися элементами
     * @return Число элементов массива без учёта дублей
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
     *
     * @param items Массив для сортировки
     */
    private void qsort(double[] items) {
        qs(items, 0, items.length - 1);
    }

    /**
     * Быстрая рекурсивная сортировка Хоара
     *
     * @param items Массив для сортировки
     * @param left  Левая граница
     * @param right Правая граница
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
     * @return Количество вхождений каждого символа соответственно
     */
    public int[] numberCharacters(String str, char... ch) {
        int[] temp = new int[ch.length];
        int count;
        for (int i = 0; i < ch.length; i++) {
            count = 0;
            for (char charStr : str.toCharArray()) {
                if (ch[i] == charStr) {
                    count++;
                }
            }
            temp[i] = count;
        }
        return temp;
    }

    /**
     * Определяет, что в массиве строк есть одинаковые элементы
     *
     * @param strs Массив строк
     * @return Правда, если есть одинаковые строки, и ложь, если все строки разные
     */
    public boolean sameElementIs(String[] strs) {
        boolean bool = false;
        if (strs.length > 1) {
            int lengthMinus1 = strs.length - 1;
            for (int i = 0; i < lengthMinus1; i++) {
                for (int j = i + 1; j < strs.length; j++) {
                    if (strs[i].equals(strs[j])) {
                        bool = true;
                        break;
                    }
                }
            }
        }
        return bool;
    }

    /**
     * Возвращает перемножение двух матриц
     *
     * @param matrix  Левая матрица
     * @param matrix2 Правая матрица
     * @return Произведение матриц, если это возможно, и null, если нет
     */
    public double[][] matrixMultiplication(double[][] matrix, double[][] matrix2) {
        double[][] result;
        int m = matrix.length;
        int n = matrix[0].length;
        int k = matrix2.length;
        int l = matrix2[0].length;
        if (n == k) {
            result = new double[m][l];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < l; j++) {
                    result[i][j] = 0;
                    for (int s = 0; s < n; s++) {
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
     *
     * @param arr  Первый массив
     * @param arr2 Второй массив
     * @return Пересечение массивов
     */
    public double[] intersecSortArr(double[] arr, double[] arr2) {
        int k = 0;
        int a = 0;
        int b = 0;
        qsort(arr);
        qsort(arr2);
        int m = shift(arr);
        int n = shift(arr2);
        double[] result = new double[(m < n) ? n : m];
        while (a < m && b < n) {
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