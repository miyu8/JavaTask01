/**
 * @author Лобанов Михаил
 */

import java.io.*;

/**
 * Класс-тест для класса FunctionSet
 */
public class DemoFunctionSet {
    private static FunctionSet functionSet;

    private static void outputSet(double[] arr) {
        for (double x : arr) {
            System.out.println(x);
        }
    }

    private static void outputSet(int[] arr) {
        for (int x : arr) {
            System.out.println(x);
        }
    }

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

    private static boolean outputArray(String str, char... ch) {
        int[] numberOccurrences;
        numberOccurrences = functionSet.numberCharacters(str, ch);
        outputSet(numberOccurrences);
        boolean noneError = true;
        if (numberOccurrences[0] != 1) {
            noneError = false;
        } else if (numberOccurrences[1] != 2) {
            noneError = false;
        } else if (numberOccurrences[2] != 3) {
            noneError = false;
        }
        return noneError;
    }

    public static boolean demoNumberCharacters() {
        char[] numberOccurrences = {'q', 'w', 'r'};
        String numberOccurrences2 = "qwr";
        System.out.println();
        boolean noneError = true;
        if (!outputArray("qwewerrr", numberOccurrences2.toCharArray())) {
            noneError = false;
        }
        if (!outputArray("qwewerrr", numberOccurrences)) {
            if (noneError) {
                noneError = false;
            }
        }
        if (!outputArray("qwewerrr", 'q', 'w', 'r')) {
            if (noneError) {
                noneError = false;
            }
        }
        return noneError;
    }

    public static boolean demohasSameElements() {
        String[] strs;
        boolean noneError;
        boolean noneErrorOut = true;
        System.out.println();
        strs = new String[]{""};
        noneError = functionSet.hasSameElements(strs);
        if (noneError) {
            noneErrorOut = false;
        }
        System.out.println(noneError);
        strs = new String[]{"a"};
        noneError = functionSet.hasSameElements(strs);
        if (noneError) {
            noneErrorOut = false;
        }
        System.out.println(noneError);
        strs = new String[]{"qwe", "ewq", "ret"};
        noneError = functionSet.hasSameElements(strs);
        if (noneError) {
            noneErrorOut = false;
        }
        System.out.println(noneError);
        strs = new String[]{"qwe", "ewq", "ret", "ret"};
        noneError = functionSet.hasSameElements(strs);
        if (!noneError) {
            noneErrorOut = false;
        }
        System.out.println(noneError);
        return noneErrorOut;
    }

    public static boolean demoGetMultiplicationMatrix() {
        boolean noneError = true;
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
        testMatrix = functionSet.getMultiplicationMatrix(matrix, matrix2);
        outputMatrix(testMatrix);
        if (Math.abs(testMatrix[0][0] - 24.2) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[0][1] - 16.94) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[1][0] - 67.76) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[1][1] - 49.61) > .005) {
            noneError = false;
        }
        testMatrix = functionSet.getMultiplicationMatrix(matrix2, matrix);
        outputMatrix(testMatrix);
        if (Math.abs(testMatrix[0][0] - 31.46) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[0][1] - 44.77) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[0][2] - 58.08) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[1][0] - 19.36) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[1][1] - 27.83) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[1][2] - 36.3) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[2][0] - 7.26) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[2][1] - 10.89) > .005) {
            noneError = false;
        } else if (Math.abs(testMatrix[2][2] - 14.52) > .005) {
            noneError = false;
        }
        testMatrix = functionSet.getMultiplicationMatrix(matrix, matrix);
        outputMatrix(testMatrix);
        if (testMatrix != null) {
            noneError = false;
        }
        return noneError;
    }

    public static boolean demoGetSortedIntersectionArrays() {
        boolean noneError = true;
        double[] testArray;
        System.out.println();
        double[] arr = {4, 3, 3, 2, 1, 0, 6, 7, 9};
        double[] arr2 = {5, 3, 1, 1, 4, 0, 6, 8};
        testArray = functionSet.getSortedIntersectionArrays(arr, arr2);
        outputSet(testArray);
        if (testArray[0] != 0) {
            noneError = false;
        } else if (testArray[1] != 1) {
            noneError = false;
        } else if (testArray[2] != 3) {
            noneError = false;
        } else if (testArray[3] != 4) {
            noneError = false;
        } else if (testArray[4] != 6) {
            noneError = false;
        }
        return noneError;
    }

    public static void main(String args[]) throws IOException {
        try {
            functionSet = new FunctionSet();
            if (demoNumberCharacters()) {
                System.out.println("Функция \"demoNumberCharacters\" отработала правильно");
            } else {
                System.out.println("Функция \"demoNumberCharacters\" отработала с ошибками");
            }
            if (demohasSameElements()) {
                System.out.println("Функция \"demohasSameElements\" отработала правильно");
            } else {
                System.out.println("Функция \"demohasSameElements\" отработала с ошибками");
            }
            if (demoGetMultiplicationMatrix()) {
                System.out.println("Функция \"demoGetMultiplicationMatrix\" отработала правильно");
            } else {
                System.out.println("Функция \"demoGetMultiplicationMatrix\" отработала с ошибками");
            }
            if (demoGetSortedIntersectionArrays()) {
                System.out.println("Функция \"demoGetSortedIntersectionArrays\" отработала правильно");
            } else {
                System.out.println("Функция \"demoGetSortedIntersectionArrays\" отработала с ошибками");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}