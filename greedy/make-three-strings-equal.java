// Problem Link: https://leetcode.com/problems/make-three-strings-equal/
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<a && j<b && k<c) {
            if(s1.charAt(i) != s2.charAt(j) || s1.charAt(i) != s3.charAt(k)) {
                break;
            } else {
                i++;
                j++;
                k++;
            }
        }

        return (a+b+c) - i*3 == (a+b+c) ? -1 : (a+b+c) - i*3;
    }
}
