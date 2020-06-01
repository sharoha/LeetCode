var invertTree = function(root) {
    if(!root) return root;
    let arr = [];
    arr.unshift(root);
    while (arr.length != 0) {
        let cur = arr.shift();
        let temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        if (cur.left != null) arr.unshift(cur.left);
        if (cur.right != null) arr.unshift(cur.right);
    }
    return root;
};