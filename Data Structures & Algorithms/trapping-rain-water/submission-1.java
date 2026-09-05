class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && height[i] > height[st.peek()]) {
                int bottom = st.pop();
                if(st.isEmpty()) break;
                int left = st.peek();
                int width = i - left - 1;
                int waterHeight = Math.min(height[i], height[left]) - height[bottom];
                ans += (width * waterHeight);
            }
            st.push(i);
        }
        return ans;
    }
}
