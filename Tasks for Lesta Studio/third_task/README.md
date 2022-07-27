In this task, I implemented a merge sorting algorithm

This sorting is a good example of using the principle of "divide and conquer". First, the task is divided into several smaller subtasks. Then these tasks are solved using a recursive call or directly if their size is small enough. Finally, their solutions are combined, and a solution to the original problem is obtained.

Advantages

1. Works even on sequential access data structures.
2. It goes well with memory paging and caching.
3. It works well in parallel: it is easy to split tasks equally between processors, but it is difficult to make other processors take over the work if one processor is delayed.
4. Has no "difficult" input data.
5. Stable - preserves the order of equal elements (belonging to the same equivalence class in comparison).

Disadvantages:

1. It works on "almost sorted" arrays for as long as on chaotic ones. There is a merge sort option that works faster on partially sorted data, but it requires additional memory, in addition to the temporary buffer that is used directly for sorting.
2. Requires additional memory for the size of the original array.