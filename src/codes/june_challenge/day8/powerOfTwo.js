/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if (n < 1) return false;
    let num = 1;
    while (num < n) {
        num = num * 2;
    }
    return num == n;
};