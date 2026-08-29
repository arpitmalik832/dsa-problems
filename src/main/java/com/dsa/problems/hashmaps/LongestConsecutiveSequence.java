package com.dsa.problems.hashmaps;

import java.util.HashSet;
import java.util.List;

/**
 * Longest Consecutive Sequence
 *
 *	Given:
 *	[100, 4, 200, 1, 3, 2]
 *
 * Return:
 *	4
 *
 *	because 1, 2, 3, 4 is the longest consecutive sequence.
 *
 *	Requirement: Expected O(n) time
 *
 *	Don't write code yet. Walk me through:
 *
 *	Why sorting is not ideal here.
 *	What data structure you'd use.
 *	How you'd ensure you don't repeatedly traverse the same sequence.
 */

public class LongestConsecutiveSequence {

	private static int solve(List<Integer> nums) {
		HashSet<Integer> set = new HashSet<>();
		set.addAll(nums);
		int rslt = 1;

		for(int n : nums) {
			int i = n;
			if(!set.contains(i - 1)) {
				int count = 1;
				while(set.contains(++i)) {
					count++;
				}
				rslt = Math.max(rslt, count);
			}
		}

		return rslt;
	}

	public static void main(String[] args) {
		List<Integer> nums = List.of(100, 4, 200, 1, 2, 3);

		int result = solve(nums);
		System.out.println(result);
	}
}
