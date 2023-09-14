class Twitter {
    class Pair{
        int time;
        int tweetId;
        public Pair(int time, int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    HashMap<Integer,Set<Integer>> relationships; //user -> people user follows
    HashMap<Integer,List<Pair>> tweetsByUser;
    int limit;
    int time;
    public Twitter() {
        relationships = new HashMap<>();
        tweetsByUser = new HashMap<>();
        limit = 10;
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!relationships.containsKey(userId)){
            relationships.put(userId, new HashSet<Integer>());
            tweetsByUser.put(userId, new ArrayList<Pair>());
        }
        
        tweetsByUser.get(userId).add(new Pair(time,tweetId));
        time += 1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> usersInFeed = new ArrayList<>();
        usersInFeed.add(userId);
        if(relationships.containsKey(userId)){
            for(int following : relationships.get(userId)){
            usersInFeed.add(following);
        }
        
        PriorityQueue<Pair> recentTweets = new PriorityQueue<Pair>((a,b) -> b.time - a.time);
        
        for(int user : usersInFeed){
            for(Pair tweet : tweetsByUser.get(user)){
                recentTweets.add(tweet);        
            }
        }
        
        List<Integer> recent10 = new ArrayList<>();
        int limitTweets = limit;
        while(!recentTweets.isEmpty() && limitTweets > 0){
            recent10.add(recentTweets.poll().tweetId);
            limitTweets--;
        }
        
        return recent10;
        }
        
        return new ArrayList<Integer>();
        
    }
    
    public void follow(int followerId, int followeeId) {
         if(!relationships.containsKey(followerId)){
            relationships.put(followerId, new HashSet<Integer>()); 
            tweetsByUser.put(followerId, new ArrayList<Pair>());
        }
        if(!relationships.containsKey(followeeId)){
            relationships.put(followeeId, new HashSet<Integer>());
            tweetsByUser.put(followeeId, new ArrayList<Pair>());
        }
        
        relationships.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        relationships.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */