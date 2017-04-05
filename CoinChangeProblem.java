/**
 * Created by sunmit9 on 03/04/17.
 *
 * https://leetcode.com/problems/coin-change-2
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 */
public class CoinChangeProblem {


    // The matrix contains the list of coins in the y-axis and the amount in x-axis.
    private static int[][] mat = null;

    public static void main(String[] args) {
        System.out.println("\n\nPossible ways = " + calculateChange(5, new int[]{1,2,5}));
    }

    private static int calculateChange(int amount, int[] coins) {
        mat = new int[amount + 1][coins.length + 1];
        printMatrix();

        if(amount == 0){
            return 1;
        }
        if(coins.length == 0){
            return 0;
        }

        for(int j = 1; j<=coins.length ; j++){
            // for each coin 'j', calculate the number of ways the amount 'i' can be calculated
            for(int i=0; i<=amount; i++){
                //initial values
                if(i==0){
                    mat[i][j] = 1;
                }else if(i<coins[j-1]){
                    // if the value is less than the current coin, the solution is same as the solution with the previous coin.
                    mat[i][j] = mat[i][j-1];
                }else{
                    // if the value is equal or greater than the current coin,
                    // the solution is the solution for same number with previous coin PLUS
                    // the solution for (current value - current coin)
                    mat[i][j] = mat[i][j-1] + mat[i-coins[j-1]][j];
                }
                printMatrix();
            }
        }
        return mat[amount][coins.length];
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
