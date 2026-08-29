package com.dsa.problems.strings;

public class MinimumWindowSubstring {
    private static String solve(String A, String B) {
        int[] need = new int[128];
        int count = 0;

        for(char a: B.toCharArray()) {
            need[a]++;
            count++;
        }

        int s = 0, e = 0;
        int length = Integer.MAX_VALUE, start = 0;

        while(e < A.length()) {
            char eCh = A.charAt(e);
            if(need[eCh] > 0) {
                count--;
            }
            need[eCh]--;

            while(count == 0) {
                if (e - s + 1 < length) {
                    length = e - s + 1;
                    start = s;
                }

                char sCh = A.charAt(s);
                need[sCh]++;
                
                if(need[sCh] > 0) {
                    count++;
                }

                s++;
            }

            e++;
        }

        return length == Integer.MAX_VALUE ? "" : A.substring(start, start + length);
    }
    
    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        String result = solve(A, B);
        System.out.println(result);
    }
}
