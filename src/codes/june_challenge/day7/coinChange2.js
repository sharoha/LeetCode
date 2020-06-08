/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    let dp = new Array(amount + 1).fill(0);
    dp[0] = 1;
    for (let c of coins) {
        for (let i = c; i <= amount; i++) {
            dp[i] += dp[i - c];
        }
    }
    return dp[amount];
};