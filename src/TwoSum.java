import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] sequence = new int[] {2, 12, 24, -55, 28, 61, 12, 33, 32, -1, 5};
        int target = -56;
        Arrays.sort(sequence);
        int[] indexes = twoSum(sequence, target);
        System.out.println("Sorted array " + Arrays.toString(sequence));
        if (indexes != null)
            System.out.printf("Target %d reached using values pair (%d, %d)\n",
                    target, indexes[0], indexes[1]);
        else
            System.out.printf("Target %d not reached in given sequence\n", target);
    }

    private static int[] twoSum(int[] sequence, int target) {
        int currentIndex = 0;
        /* given that the sequence is sorted in increasing order, if the last element has a complementary value in
        the series, the algorithm has already analyzed it by the time the last value is reached, thus it is skipped */
        while (currentIndex < sequence.length - 1) {
            int currentValue = sequence[currentIndex];
            int complementValue = target - currentValue;
            /* if the complementary value for the current number in the sequence is smaller than than the
            current value, since  the series is sorted in increasing order then the algorithm has already
            been executed past any possible complementary value of the current and following elements in
            the sequence and thus it is concluded that the target can't be reached */
            if (complementValue < currentValue)
                return null;
            int complementIndex = binSearch(sequence, complementValue);
            if (complementIndex != -1 && complementIndex != currentIndex)
                return new int[] {currentIndex, complementIndex};
            currentIndex++;
        }
        return null;
    }

    private static int binSearch(int[] sequence, int toFind) {
        int left = 0, right = sequence.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sequence[mid] < toFind)
                left = mid + 1;
            else if (sequence[mid] > toFind)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }

}

