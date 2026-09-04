class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n-1;
        int max = Integer.MIN_VALUE;
        while(l < r) {
            int width = r-l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;
            max = Math.max(area, max);
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return max;
    }
}
