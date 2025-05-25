import java.util.Arrays;

public class MergeSort {
    public static void merge(int [] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;
        int [] mergedNumbers = new int[mergedSize];
        int mergePos;
        int leftPos;
        int rightPos;

        mergePos = 0;
        leftPos = i;
        rightPos = j + 1;

        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] < numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }

        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }
        System.out.println(Arrays.toString(mergedNumbers));
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void mergeSort(int [] numbers, int i, int k) {
        int j;

        if (i < k) {
            j = (i + k) / 2;

            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            merge(numbers, i, j, k);
        }
    }

    public static void main(String[] args) {
        int [] numbers = {6, 2, 3, 1, 5, 9, 8};

        System.out.println(Arrays.toString(numbers));
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println();
        System.out.println(Arrays.toString(numbers));
    }
}