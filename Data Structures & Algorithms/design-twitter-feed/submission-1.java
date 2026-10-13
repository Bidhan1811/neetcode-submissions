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
            List<int[]> tweets = tweetMap.get(user);
            if(tweets != null && !tweets.isEmpty()) {
                int index = tweets.size() - 1;
                pq.offer(new int[]{tweets.get(index)[0], tweets.get(index)[1], user, index});
            }
        }
        while(!pq.isEmpty() && feed.size() < 10) {
            int[] curr = pq.poll();

            feed.add(curr[1]);

            int user = curr[2];
            int index = curr[3];

            // Insert the next older tweet from the same user
            if (index > 0) {
                int[] previousTweet = tweetMap.get(user).get(index - 1);

                pq.offer(new int[]{
                    previousTweet[0],
                    previousTweet[1],
                    user,
                    index - 1
                });
            }
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
