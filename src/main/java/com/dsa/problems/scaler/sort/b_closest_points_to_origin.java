package com.dsa.problems.scaler.sort;

import java.util.*;

public class b_closest_points_to_origin {
  /**
   * Q. B Closest Points to Origin
   *
   * You are developing a feature for Zomato that helps users find the nearest restaurants to their current location. It uses GPS to determine the user's location and has access to a database of restaurants, each with its own set of coordinates in a two-dimensional space representing their geographical location on a map. The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.
   *
   * Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map), and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).
   *
   * Here, the distance between two points on a plane is the Euclidean distance.
   *
   * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
   *
   * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).
   */
  private static ArrayList<ArrayList<Integer>> bClosestPointsToOrigin(ArrayList<ArrayList<Integer>> A, int B) {
    A.sort(new Comparator<ArrayList<Integer>>() {
      @Override
      public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        int distA = (int)(Math.pow(a.get(0), 2) + Math.pow(a.get(1), 2));
        int distB = (int)(Math.pow(b.get(0), 2) + Math.pow(b.get(1), 2));

        if(distA <= distB) {
          return -1;
        } else {
          return 1;
        }
      }
    });

    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
    for(int i = 0; i < B; i++) {
      rslt.add(A.get(i));
    }

    return rslt;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    A.add(new ArrayList<>(Arrays.asList(-2,2)));
    A.add(new ArrayList<>(Arrays.asList(1,2)));
    System.out.println(bClosestPointsToOrigin(A, 1));
  }
}
