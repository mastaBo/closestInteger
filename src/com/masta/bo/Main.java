package com.masta.bo;

import java.util.Arrays;

public class Main {

    // Returns the distance between the two closest numbers the naive way having O(n^2)
    static int naiveDistClosestNumbers(int[] numbers) {
        // try to implement it!
        int res=Integer.MAX_VALUE;
        for (int i=0; i < numbers.length; i++ ) {
            for (int j=0; j < numbers.length; j++) {
                if (i != j) {
                    if (res == 0) {
                        return res;
                    }
                    int premRes = Math.abs(numbers[i] - numbers[j]);
                    if (premRes <= res) {
                        res = premRes;
                    }
                }
            }
        }
        return res;
    }

    // Returns the distance between the two closest numbers the sorted way having O(n*log(n))
    static int sortedDistClosestNumbers(int[] numbers) {
        // try to implement it!
        Arrays.sort(numbers);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.length; i++) {
            if (res == 0) {
                return res;
            }
            int premRes = Math.abs(numbers[i] - numbers[i - 1]);
            if (premRes <= res) {
                res = premRes;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
        int result = naiveDistClosestNumbers(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)

        int sortedResult = sortedDistClosestNumbers(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)

        int[] testArray2 = {15, 9, 7, 3 , 1};
        int result2 = naiveDistClosestNumbers(testArray2);
        System.out.println(result2); // Expected result is 2

        int sortedResult2 = sortedDistClosestNumbers(testArray2);
        System.out.println(sortedResult2); // Expected result is 2
    }
}