/**
 * Created by sunmit9 on 05/04/17.
 *
 * Solution to find the longest subsequence in two strings using dyamic programming.
 *
 */
public class LongestSubSequence {

    private static int[][] mat = null;

    public static void main(String[] args) {
        String s1 = "SABCDEFG";
        String s2 = "ADEFCADFOG";

        // Initialize the dp matrix
        // This matrix stores the longest possible subsequence for any strings s1 and s2.
        // mat[i][j] denotes the max possible subsequence for s1.substring(0,i) and s2.substring(0,j).
        mat = new int[s1.length()+1][s2.length()+1];
        printMatrix();
        System.out.println("\n\nLongest Subsequence = "+ longestSubsequence(s1, s2));
    }


    private static int longestSubsequence(String s1, String s2){
        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // If the two characters are the same, then the longest subsequence upto this point would be
                    // the longest substring till s1.substring(0,i-1) and s2.substring(0,j-1) and the current character (+1)
                    mat[i][j] = mat[i-1][j-1] + 1;
                    printMatrix();
                }else{
                    // else, the max from the matrix in the previous column or previous row.
                    // i.e. max of left or above.
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        return mat[s1.length()][s2.length()];
    }

    private static void printMatrix(){
        System.out.println("\n\n");
        for(int i = 0;i<mat.length;i++){
            System.out.println("");
            for(int j=0; j< mat[0].length;j++){
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}
