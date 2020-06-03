var twoCitySchedCost = function(costs) {
    let n = costs.length;
    costs.sort((a,b) => {
        return ((a[0] - a[1]) - (b[0] - b[1]));
    });
    let sum = 0;
    let m = Math.floor(n / 2);
    for (let i = 0; i < m; i++) {
        sum += costs[i][0] + costs[i + m][1];
    }
    return sum;
};