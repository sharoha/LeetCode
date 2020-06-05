/**
 * @param {number[]} w
 */
let arr;
var Solution = function (w) {
    arr = [];
    let sum = 0;
    for (let i = 0; i < w.length; i++) {
        sum += w[i];
        arr[i] = sum;
    }
};

/**
 * @return {number}
 */
Solution.prototype.pickIndex = function () {
    let num = Math.floor(Math.random() * arr[arr.length - 1]);
    let low = 0;
    let high = arr.length - 1;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if (arr[mid] > num) {
            high = mid - 1
        }
        else low = mid + 1

    }
    return low;

};

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */