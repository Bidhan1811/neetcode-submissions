class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < n) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) {
                left[i] = 0;
            }
            else left[i] = st.peek() + 1;
            st.push(i);
            i++;
        }
        while(!st.isEmpty()) st.pop();
        i = n-1;
        while(i >= 0) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) {
                right[i] = n-1;
            }
            else right[i] = st.peek() - 1;
            st.push(i);
            i--;
        }
        int max = Integer.MIN_VALUE;
        for(i = 0; i < n; i++) {
            int width = right[i] - left[i] + 1;
            max = Math.max(max, heights[i] * width);
        }
        return max;
    }
}
