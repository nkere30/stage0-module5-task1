package com.epam.mjc.stage0;

import java.util.Arrays;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(seasonsArray()));
        System.out.println(Arrays.toString(generateNumbers(7)));
        int [] totalSumArr = {1, 2, 3, 4, 5};
        System.out.println(totalSum(totalSumArr));
        int[] indexArr = {1, 2, 3, 5, 9};
        System.out.println(findIndexOfNumber(indexArr, 9));
        String[] strArr = {"Bob", "Nick"};
        System.out.println(Arrays.toString(reverseArray(strArr)));
        int[] positivesArr = {1, -8, 0, 5, -13, 1000, -213};
        System.out.println(Arrays.toString(getOnlyPositiveNumbers(positivesArr)));
        int[][] sortRagged = {{3, 1, 2,}, {3,2}, {1, 4, 9, 3, 15, 7}};
        System.out.println(Arrays.deepToString(sortRaggedArray(sortRagged)));
    }

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public static String[] seasonsArray() {
        String[]  seasons = {"Winter", "Spring", "Summer", "Autumn"};
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public static int[] generateNumbers(int length) {
        int[] numbers = new int[length];
        for(int i = 0; i < length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public static int totalSum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public static int findIndexOfNumber(int[] arr, int number) {
        int index = 0;
        boolean numberInArr = false;
        while(index < arr.length) {
            if(arr[index] == number) {
                numberInArr = !numberInArr;
                break;
            }
            index++;
        }
        if(!numberInArr) {
            index = -1;
        }
        return index;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public static String[] reverseArray(String[] arr) {
        String[] reversed = new String[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - i - 1];
        }
        return reversed;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public static int[] getOnlyPositiveNumbers(int[] arr) {
        int[] positives = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                positives[i] = -arr[i];
            } else {
                positives[i] = arr[i];
            }
        }
        return positives;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public static int[][] sortRaggedArray(int[][] arr) {
        int[][] sortedRagged = new int[arr.length][arr[0].length];
        for(int r = 0; r < arr.length; r++) {
            for(int r1 = r; r1 < arr.length; r1++) {
                if(arr[r].length > arr[r1].length) {
                    int[] temp = arr[r];
                    arr[r] = arr[r1];
                    arr[r1] = temp;
                }
            }
        }
        for(int r = 0; r < arr.length; r++) {
            int[] colArr = arr[r];
            for(int c = 0; c < arr[r].length; c++) {
                for(int c1 = c; c1 < arr[r].length; c1++) {
                    if(colArr[c] > colArr[c1]) {
                        int temp = colArr[c];
                        colArr[c] = colArr[c1];
                        colArr[c1] = temp;
                    }
                }
                arr[r] = colArr;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            sortedRagged[i] = arr[i];
        }
        return sortedRagged;
    }
}
