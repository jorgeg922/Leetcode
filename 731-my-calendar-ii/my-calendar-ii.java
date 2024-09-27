class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlapBookings;
    
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] booking : overlapBookings){
            if(doesOverlap(booking[0], booking[1], start, end)){
                return false;
            }
        }
        
        for(int[] bookings : bookings){
            if(doesOverlap(bookings[0], bookings[1], start, end)){
                overlapBookings.add(getOverlap(bookings[0], bookings[1], start, end));
            }
        }
        
        bookings.add(new int[]{start,end});
        return true;
    }
    
    private int[] getOverlap(int start1, int end1, int start2, int end2){
        return new int[]{Math.max(start1, start2), Math.min(end1,end2)};
    }
    
    private boolean doesOverlap(int start1, int end1, int start2, int end2){
        return Math.max(start1,start2) < Math.min(end1,end2);
    }
    
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */