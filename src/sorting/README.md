# Sorting Algorithms

## Selection sort 

- sorts by finding a min to the right of current position and swap with current element.

### Time complexiety

* N^2 /2 compares and N swaps.
* Quadratic time irrespective of input.

## Insertion sort 
- starting from current element every consecutive element to it's left is compared. If any is less than previous one, they are swapped. If not, move the current element pointer to right and continue.

### Time Complexiety
* Worst case: ~N^2/2 compares and swaps if array is sorted in reverse order. Otherwise, its less than quadratic time.
* Best case: Already sorted takes N-1 compares and 0 swaps. 

Better in best and random cases when compared to Selection sort, but not in worst case. Better suited for partially sorted input.

## Shell sort

- It's idea is to move elements more than one position using an incremental sequence like powers of 2 minus 1, 3x+1, etc. Element at position i is compared with element at i+h, where is 7 in case of 7-sort and swapped if out of order. 
- 1-sort is like a insertion sort. Instead of comparing with element left of it, we compare with elements at distance in multiples of h left of element i.

![Shell Sort example](https://raw.githubusercontent.com/apoorvam/algorithms/master/assets/shell_sort_example.png)

### Time Complexiety
* Worst case: N^(3/2). But very fast for smaller input size and less code footprint. Average case complexiety cannot be easily defined(linearithmetic).