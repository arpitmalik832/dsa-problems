package com.dsa.problems.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Intervals + Greedy Thinking
Let's change the pattern completely.
You are given an array of intervals:
[[1,3], [2,6], [8,10], [15,18]]
Merge all overlapping intervals.

Expected:
[[1,6], [8,10], [15,18]]

Now here's the interviewer twist: don't code immediately.
Walk me through:
What assumptions or questions would you clarify about the intervals?
Your brute-force thought process.
Your optimized approach and complexity.
Why sorting helps here, even though we rejected sorting in the previous problem.
 */

public class MergeIntervals {
    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(List.of(1, 3)));
        intervals.add(new ArrayList<>(List.of(2, 6)));
        intervals.add(new ArrayList<>(List.of(8, 10)));
        intervals.add(new ArrayList<>(List.of(15, 18)));

        intervals.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> A, List<Integer> B) {
                return Integer.compare(A.get(0), B.get(0));
            }
        });

        List<Integer> curr = new ArrayList<>(List.of(intervals.get(0).get(0), intervals.get(0).get(1)));
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 1; i < intervals.size(); i++) {
            if (curr.get(1) >= intervals.get(i).get(0)) {
                curr.set(1, Math.max(curr.get(1), intervals.get(i).get(1)));
            } else {
                result.add(curr);
                curr = intervals.get(i);
            }
        }

        result.add(curr);
        System.out.println(result);
    }
}
