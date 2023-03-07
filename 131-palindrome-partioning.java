/* Given a string s, partition s such that every substring 
of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if(start >= s.length()) {
            result.add( new ArrayList<String>(currentList));
        }

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                //add curernt substring in the curerntList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                //backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}