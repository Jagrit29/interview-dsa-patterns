// Problem Link: https://leetcode.com/problems/longest-uploaded-prefix/
class LUPrefix {
    HashSet<Integer> uploaded;
    int counter;
    public LUPrefix(int n) {
        counter = 1;
        uploaded = new HashSet<>();
    }
    
    public void upload(int video) {
        uploaded.add(video);
        while(uploaded.contains(counter)) {
            counter++;
        }
    }
    
    public int longest() {
        return counter - 1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
