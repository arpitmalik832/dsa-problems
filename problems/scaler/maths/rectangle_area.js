/**
 * Q. Rectangle Area
 *
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 *
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 */
function soln(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2) {
  let tempArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
  if (bx2 <= ax1 || by2 <= ay1 || bx1 >= ax2 || by1 >= ay2) {
    return tempArea;
  }
  let tempX1 = Math.max(ax1, bx1);
  let tempX2 = Math.min(ax2, bx2);
  let tempY1 = Math.max(ay1, by1);
  let tempY2 = Math.min(ay2, by2);
  return tempArea - (tempX2 - tempX1) * (tempY2 - tempY1);
}
