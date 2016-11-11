/**
 * @author Лобанов Михаил
 */

import java.io.*;

/**
 * Класс-тест для класса FunctionSet
 */
public class DemoFunctionSet {
    private static FunctionSet functionSet;

    /**
     * Вывод элементов массива double на консоль
     */
    private static void outputSet(double[] set) {
        for (double x : set) {
            System.out.println(x);
        }
    }

    /**
     * Вывод элементов массива int на консоль
     */
    private static void outputSet(int[] set) {
        for (int x : set) {
            System.out.println(x);
        }
    }

    /**
     * Вывод матрицы на консоль
     */
    private static void outputMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Количество столбцов в первой матрице не совпадает с количеством строк во второй");
        } else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(((double) Math.round(matrix[i][j] * 100)) / 100 + "\t");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Проверка правильности метода numberCharacters
     * Вспомогательный метод для demoNumberCharacters
     */
    private static boolean outputArray(String str, char... ch) {
        int[] temp;
        temp = functionSet.numberCharacters(str, ch);
        outputSet(temp);
        boolean bool = true;
        if (temp[0] != 1) {
            bool = false;
        } else if (temp[1] != 2) {
            bool = false;
        } else if (temp[2] != 3) {
            bool = false;
        }
        return bool;
    }

    /**
     * Проверка правильности метода numberCharacters
     *
     * @return Правда, если нет ни одной ошибки, и ложь, в противном случае
     */
    public static boolean demoNumberCharacters() {
        char[] temp2 = {'q', 'w', 'r'};
        String temp3 = "qwr";
        System.out.println();
        boolean bool = true;
        if (!outputArray("qwewerrr", temp3.toCharArray())) {
            bool = false;
        }
        if (!outputArray("qwewerrr", temp2)) {
            if (bool) {
                bool = false;
            }
        }
        if (!outputArray("qwewerrr", 'q', 'w', 'r')) {
            if (bool) {
                bool = false;
            }
        }
        return bool;
    }

    /**
     * Проверка правильности метода sameElementIs
     *
     * @return Правда, если нет ни одной ошибки, и ложь, в противном случае
     */
    public static boolean demoSameElementIs() {
        String[] strs;
        boolean bool;
        boolean boolReturn = true;
        System.out.println();
        strs = new String[]{""};
        bool = functionSet.sameElementIs(strs);
        if (bool) {
            boolReturn = false;
        }
        System.out.println(bool);
        strs = new String[]{"a"};
        bool = functionSet.sameElementIs(strs);
        if (bool) {
            boolReturn = false;
        }
        System.out.println(bool);
        strs = new String[]{"qwe", "ewq", "ret"};
        bool = functionSet.sameElementIs(strs);
        if (bool) {
            boolReturn = false;
        }
        System.out.println(bool);
        strs = new String[]{"qwe", "ewq", "ret", "ret"};
        bool = functionSet.sameElementIs(strs);
        if (!bool) {
            boolReturn = false;
        }
        System.out.println(bool);
        return boolReturn;
    }

    /**
     * Проверка правильности метода matrixMultiplication
     *
     * @return Правда, если нет ни одной ошибки, и ложь, в противном случае
     */
    public static boolean demoMatrixMultiplication() {
        boolean bool = true;
        double[][] testMatrix;
        System.out.println();
        double[][] matrix = {
                {1.1, 2.2, 3.3},
                {4.4, 5.5, 6.6}
        };
        double[][] matrix2 = {
                {6.6, 5.5},
                {4.4, 3.3},
                {2.2, 1.1},
        };
        testMatrix = functionSet.matrixMultiplication(matrix, matrix2);
        outputMatrix(testMatrix);
        if (Math.abs(testMatrix[0][0] - 24.2) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[0][1] - 16.94) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[1][0] - 67.76) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[1][1] - 49.61) > .005) {
            bool = false;
        }
        testMatrix = functionSet.matrixMultiplication(matrix2, matrix);
        outputMatrix(testMatrix);
        if (Math.abs(testMatrix[0][0] - 31.46) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[0][1] - 44.77) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[0][2] - 58.08) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[1][0] - 19.36) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[1][1] - 27.83) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[1][2] - 36.3) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[2][0] - 7.26) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[2][1] - 10.89) > .005) {
            bool = false;
        } else if (Math.abs(testMatrix[2][2] - 14.52) > .005) {
            bool = false;
        }
        testMatrix = functionSet.matrixMultiplication(matrix, matrix);
        outputMatrix(testMatrix);
        if (testMatrix != null) {
            bool = false;
        }
        return bool;
    }

    /**
     * Проверка правильности метода intersecSortArr
     *
     * @return Правда, если нет ни одной ошибки, и ложь, в противном случае
     */
    public static boolean demoIntersecSortArr() {
        boolean bool = true;
        double[] testArray;
        System.out.println();
        double[] set = {4, 3, 3, 2, 1, 0, 6, 7, 9};
        double[] set2 = {5, 3, 1, 1, 4, 0, 6, 8};
        testArray = functionSet.intersecSortArr(set, set2);
        outputSet(testArray);
        if (testArray[0] != 0) {
            bool = false;
        } else if (testArray[1] != 1) {
            bool = false;
        } else if (testArray[2] != 3) {
            bool = false;
        } else if (testArray[3] != 4) {
            bool = false;
        } else if (testArray[4] != 6) {
            bool = false;
        }
        return bool;
    }

    /**
     * Запуск всех тестовых методов
     */
    public static void main(String args[]) throws IOException {
        try {
            functionSet = new FunctionSet();
            if (demoNumberCharacters()) {
                System.out.println("Функция \"demoNumberCharacters\" отработала правильно");
            } else {
                System.out.println("Функция \"demoNumberCharacters\" отработала с ошибками");
            }
            if (demoSameElementIs()) {
                System.out.println("Функция \"demoSameElementIs\" отработала правильно");
            } else {
                System.out.println("Функция \"demoSameElementIs\" отработала с ошибками");
            }
            if (demoMatrixMultiplication()) {
                System.out.println("Функция \"demoMatrixMultiplication\" отработала правильно");
            } else {
                System.out.println("Функция \"demoMatrixMultiplication\" отработала с ошибками");
            }
            if (demoIntersecSortArr()) {
                System.out.println("Функция \"demoIntersecSortArr\" отработала правильно");
            } else {
                System.out.println("Функция \"demoIntersecSortArr\" отработала с ошибками");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}