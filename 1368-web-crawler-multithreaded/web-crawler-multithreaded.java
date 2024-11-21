/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
  
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {        
        String hostname = getHostName(startUrl);
        List<String> ans = new ArrayList<>();
        Set<String> keySet = ConcurrentHashMap.newKeySet();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Deque<Future> tasks = new LinkedList<>();
        
        queue.add(startUrl);
        
        ExecutorService threadPool = Executors.newFixedThreadPool(4, r->{
            Thread t = new Thread(r); 
            t.setDaemon(true);
            return t;
        });
        
        while(true){
            String currUrl = queue.poll();
            if(currUrl != null){
                if(getHostName(currUrl).equals(hostname) && !keySet.contains(currUrl)){
                    ans.add(currUrl);
                    keySet.add(currUrl);
                    tasks.add(threadPool.submit(()->{
                        List<String> newUrls = htmlParser.getUrls(currUrl);
                        for(String newUrl : newUrls){
                            queue.add(newUrl);
                        }
                    }));
                }
            }else{
                if(!tasks.isEmpty()){
                    Future nextTask = tasks.poll();
                    try{
                        nextTask.get();
                    }catch(Exception e){
                        
                    }
                }else{
                    break;
                }
            }
        }
        
        return ans;
    }
    
    public String getHostName(String startUrl){
        String url = startUrl.substring(7);
        int separatorIndex = url.indexOf("/");
        String hostname = "";
        if(separatorIndex == -1){
            hostname = startUrl;
        }else{
            hostname = "http://" + url.substring(0, separatorIndex);
        }
        
        return hostname;
    }
}