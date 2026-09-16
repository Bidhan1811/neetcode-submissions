class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < speed.length; i++) {
            int[] temp = new int[2];
            temp[0] = position[i];
            temp[1] = speed[i];
            list.add(temp);
        }
        list.sort((a, b) -> Integer.compare(b[0], a[0]));
        Stack<Float> st = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            int[] elem = list.get(i);
            int pos = elem[0], sp = elem[1];
            float time = (float)(target - pos) / sp;
            if(!st.isEmpty() && time <= st.peek()) continue;
            st.push(time);
        }
        return st.size();
    }
}
