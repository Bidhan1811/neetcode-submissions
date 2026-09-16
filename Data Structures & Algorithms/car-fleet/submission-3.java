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
        float prevTime = Float.MAX_VALUE;
        int fleetCnt = 0;
        for(int i = 0; i < list.size(); i++) {
            float time = (float)(target - list.get(i)[0]) / list.get(i)[1];
            if(time <= prevTime) {
                if(i == 0) {
                    fleetCnt++;
                    prevTime = time;
                }
                else continue;
            }
            else {
                fleetCnt++;
                prevTime = time;
            }
        }
        return fleetCnt;
    }
}
