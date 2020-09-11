**Programmer:** Marco Galdi

**Class:** CS245

**Date:** 09/11/2020

### Functions
The program consist of 2 functions excluding `main`.

The function `binSearch` takes two parameters, `sequence` and `toFind`, returns the index of the first encountered element.

The function `twoSum` takes two parameters, `sequence` and `target`, returns the indexes of the pair if any number reaches the target. It returns -1 if the target is not reached.

### Complexity
Assuming that the sorting algorithm used has a complexity of `O(nlogn)`, it can be safely assumed that the complexity of `2SUM` with the given circumstances is also `O(nlogn)`.

Given that the currently inspected element is the first of the pair, the value of second one is calculated by subtracting the value of the current element to the target.
Since the sequence is sorted increasingly, a binary search is used to find the position of the complementary element in the sequence, which requires time `O(logn)`.
This is executed, in the worst case scenario, for the first `n - 1` elements in the sequence, which is approximated to `n`, thus giving `O(nlogn)` time.

The last element in the sequence is skipped because, in the hypothesis that it has a complementary value in the sequence, it would have already been inspected by the algorithm when analyzing a previous element. If it weren't, then there is no point in running the algorithm on it since it would mean that it has no complementary value in the sequence.

A similar optimization is also being made: given the element in the sequence currently being inspected, if its value is smaller than its complementary value, then the algorithm has already been executed past any possible value that could reach the target for both the currently inspected element and all subsequent ones.

In conclusion, the algorithm requires `O(nlogn)` time for the sorting of the sequence, and `O(nlogn)` to find the pair that when summed reaches the target. So the overall complexity is `O(nlogn + nlogn)`, or simply `O(nlogn)`.
If the sorting algorithm being used were to be changed for one with a higher complexity, then the overall complexity would change accordingly.