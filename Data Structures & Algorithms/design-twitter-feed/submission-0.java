class Twitter {
    HashMap<Integer, List<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;
    int count;
    
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        count++;

        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> users = new ArrayList<>();
        List<Integer> feed = new ArrayList<>();
        users.add(userId);
        users.addAll(followMap.getOrDefault(userId, new ArrayList<>()));
        for(int user: users) {
            List<int[]> tweets = tweetMap.getOrDefault(user, new ArrayList<>());
            for(int[] tweet: tweets) {
                pq.add(tweet);
            }
        }
        while(!pq.isEmpty() && feed.size() < 10) {
            feed.add(pq.poll()[1]);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
       followMap.putIfAbsent(followerId, new ArrayList<>());

        if (followerId != followeeId &&
            !followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
        followMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}
