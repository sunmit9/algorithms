/**
 * Created by sunmit9 on 03/04/17.
 *
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println("\n\nLongest Palindrome substring is : " + longestPalindromeString("avdscbbd"));

    }

    private static String longestPalindromeString(String s){
        String longest = null;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        // dp[i][j] denotes that there is a palindrome from S(i) to s(j).

        // i moves from start of the string to the end.
        for(int i = n-1; i >= 0 ; i--){

            // j moves from end of string to current position of i.
            for(int j = i; j < n ; j++){

                // if character at i and j are same,
                // and there is a palindrome from i+1 to j-1
                // (i+1>=n || j<=0) is just a boundary condition to avoid ArrayIndexOutOfBound.
                // the (i+1)>(j-1) condition checks a special condition, which avoids calling dp[p][q] such that p>q.
                // i.e. sub palindrome from character at right to char at left
                // we always find palindrome from a character from left to right.

                if(i==j){
                    dp[i][j]=true;
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && ( i+1>=n || j<=0  || (i+1)>(j-1) || dp[i+1][j-1]));
                    if(i+1<n && j>0){
                        System.out.print("\n\ni = " + i + ", j = " + j + ", dp[" + (i+1)+ "][" + (j-1) + "] = " + dp[i+1][j-1]);
                    }
                }

                if(dp[i][j] && (longest == null || longest.length() <= j+1-i)){
                    longest = s.substring(i, j+1);
                }
                printMatrix(dp);
                System.out.println("\nlongest : " + longest);
            }

        }

        return longest;
    }

    private static void printMatrix(boolean mat[][]){
        System.out.println("\n\n");
        for(int i = 0;i<mat.length;i++){
            System.out.println("");
            for(int j=0; j< mat[0].length;j++){
                System.out.print(" " + (mat[i][j]?1:0) );
            }
        }
    }
}
