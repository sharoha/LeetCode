var invertTree = function(root) {
    if(!root) return root;
    let arr = [];
    arr.unshift(root);
    while (arr.length) {
        let cur = arr.shift();
        [cur.left, cur.right] = [cur.right, cur.left];  
        if (cur.left != null) arr.unshift(cur.left);
        if (cur.right != null) arr.unshift(cur.right);
    }
    return root;
};